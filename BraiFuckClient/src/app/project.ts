export class Project {
    idProject: number;
    idUser: number;
    projectName: string;
    projectContent: string;
    compileResult: string;
    isLastOpened: number;


    constructor(idProject: number, idUser: number, projectName: string,
     projectContent: string, compileResult: string, isLastOpened: number ){
        this.idProject = idProject;
        this.idUser = idUser;
        this.projectName = projectName;
        this.projectContent = projectContent;
        this.compileResult = compileResult;
        this.isLastOpened = isLastOpened;     
    }
}

