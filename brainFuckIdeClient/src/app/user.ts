export class User {
    idUser: number;
    password: string;
    email: string;
    username: string; 

    constructor(idUser: number, password: string, email: string, username: string){
        this.idUser = idUser;
        this.password = password;
        this.email = email;
        this.username = username;
    }
}
