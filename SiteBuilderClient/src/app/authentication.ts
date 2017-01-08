export class Authentication {
    email:string;
    password:string;
    isAuthenticate:boolean;

    constructor(email:string, password:string, isAuthenticate:boolean){
        this.email = email;
        this.password = password;
        this.isAuthenticate = isAuthenticate;
    }
}
