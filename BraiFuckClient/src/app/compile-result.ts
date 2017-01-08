export class CompileResult {
    idProject:number;
    compileResult:string;
    date:string;
    constructor(idProject:number, compileResult:string, date:string){
        this.idProject = idProject;
        this.compileResult = compileResult;
        this.date = date;
    }
}
