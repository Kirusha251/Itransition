import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import {Project} from '../Project';
import {Compile} from '../Compile';
import {CompileResult} from '../Compile-Result';
import {CompileMemory} from '../Compile-Memory';
import {CompileService} from '../compile.service';
import {CompileResultWithBreakPoint} from '../Compile-Result-With-Break-Point';
import {CompileResultWithChangeMemory} from '../Compile-Result-With-Change-Memory';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css'],
  providers:[CompileService, ProjectService]
})
export class ContentComponent implements OnInit {
  @Input()currentProject:Project;
  @Input()currentContent:string;
  @Output() projectDeleted = new EventEmitter();
  debugPosition = 0;
  compileResult:CompileResult;
  compileMemory:CompileResultWithChangeMemory;
  outPutString:string;
  memoryOutPut:string;
  debugResult:CompileResultWithBreakPoint;
  isChange = false;
  isDebugStart = false;
  index = 0;
  constructor(private compileService: CompileService, private projectService:ProjectService) { }

  ngOnInit() {
  
  }
  valueChange(event){
    console.log("3darova");
    this.isChange = true;
  }
  onUpdateButtonClick(event){
    if(this.currentProject){
      this.currentProject.projectContent = this.currentContent;
      this.projectService.updateProject(this.currentProject)
      .subscribe(result=> this.currentProject = result);
    }
  }
  
  onStopButtonClick(event){
    if(this.isDebugStart && this.currentProject)
    this.currentContent = this.currentProject.projectContent;
    this.isDebugStart = false;
    this.memoryOutPut = "";
    this.index = 0;
    this.debugPosition = 0;
  }
  onDeleteButtonClick(){
    if(this.currentProject){
      this.projectDeleted.emit(this.currentProject);
    }
  }

  onCompileButtonClick(){
    if(this.currentProject){
      this.memoryOutPut = "";
      this.outPutString = "";
      this.currentProject.projectContent = this.currentContent;
      this.compileService.compileProject(new Compile(this.currentProject.idProject,
      this.currentContent,new Date().toString()))
      .subscribe((result: CompileResult) =>  {
        this.compileResult = result;
        this.outPutString = this.compileResult.compileResult;
      console.log("compile finished");
    }, error => console.log(error),
    ()=> console.log("Finished")); 
      
    }
    
  }
  onBreakPointButtonClick(event){
    if(!this.isDebugStart && this.currentProject){
        this.isDebugStart = true;
        this.currentProject.projectContent = this.currentContent;
        this.compileService.withBreakPointProject(new Compile(this.currentProject.idProject,
        this.currentContent,new Date().toString()))
        .subscribe((result:CompileResultWithBreakPoint)=> {
          this.debugResult = result;
          this.outPutString = this.debugResult.compileResult[this.index];
        }, error => console.log(error),
        ()=> console.log("Finished"));
        
    }
  }

  onDebugButtonClick(event){
    if(!this.isDebugStart && this.currentProject){
      this.isDebugStart = true;
    this.currentProject.projectContent = this.currentContent;
    this.index = 0;
    console.log("start debug");
    this.compileService.debugProject(new Compile(this.currentProject.idProject,
    this.currentContent,new Date().toString()))
    .subscribe((result: CompileResultWithBreakPoint )=> {
      this.debugResult = result;
      this.memoryOutPut = this.debugResult.compileResult[this.index];
    },error => console.log(error),
        ()=> console.log("Finished") );

    this.currentContent = this.currentProject.projectContent.
    substring(0,this.index) +"$"+this.currentProject.projectContent.
    substring(this.index);
    }
    
  }
  onNextStepButtonClick(event){
    if(this.isDebugStart){
      if(this.isChange){
        console.log("start");
        this.debugPosition = this.currentContent.indexOf("$");
        this.compileService.compileProjectWithMemory(new CompileMemory(this.currentProject.idProject,
        this.currentContent,this.memoryOutPut,new Date().toString()))
        .subscribe((result: CompileResultWithChangeMemory) => {
          this.compileMemory = result;
          this.debugResult.compileResult = this.compileMemory.memory;
          this.memoryOutPut = this.debugResult.compileResult[0];
          },error => console.log(error),
        ()=> console.log("Finished" + this.compileMemory.memory.toString()) );
        
      }

      this.index++;
      this.currentContent = this.currentProject.projectContent.
      substring(0,this.index) +"$"+this.currentProject.projectContent.
      substring(this.index);
      this.isChange = false;
      this.memoryOutPut = this.debugResult.compileResult[(this.index-1)-this.debugPosition];
      if(this.index == this.currentProject.projectContent.length){
      this.currentContent = this.currentProject.projectContent;
      this.isDebugStart = false;
      this.debugPosition = 0;
      }

    }
    
  }
  

}
