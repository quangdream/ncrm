export class BaseResponseModel<T> {
    code: string;
    message: string;
    data: T;
}
