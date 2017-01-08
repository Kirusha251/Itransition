export class CompileResultWithChangeMemory {
    idProject:number;
    compileResult:string;
    memory:string[];
    date:string;
    constructor(idProject:number, compileResult:string, memory:string[] ,date:string){
        this.idProject = idProject;
        this.compileResult = compileResult;
        this.memory = memory;
        this.date = date;
    }
}
