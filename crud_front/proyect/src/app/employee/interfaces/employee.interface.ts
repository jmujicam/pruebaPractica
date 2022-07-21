export interface EmployeeI {
    name:string;
    lastname:string;
    user:string;
    password:string;
    salary: number;
    rol_id: number;
}


export interface ResponseApiEmployeeI {
    data: string,
    message: string,
    status: number,
}