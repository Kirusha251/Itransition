export class CompileMemory {
    idProject:number;
    content:string;
    memory:string;
    date:string;
    constructor(idProject:number, content:string, memory:string, date:string){
        this.idProject = idProject;
        this.content = content;
        this.date = date;
        this.memory = memory;
    }
}

