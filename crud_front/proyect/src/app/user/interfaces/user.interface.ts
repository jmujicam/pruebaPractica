export interface UserI {
    user: string;
    pasword: string;
}


export interface ResponseApiUserI {
    data: string,
    message: string,
    status: Int16Array,
}