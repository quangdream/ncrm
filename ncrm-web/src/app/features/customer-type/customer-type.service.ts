import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {API_ENDPOINT_URL} from '../../app-config.service';
import {BaseResponseModel} from '../../core/service/base-response.model';
import {CustomerTypeModel} from './customerType.model';

@Injectable({
    providedIn: 'root'
})
export class CustomerTypeService {
    constructor(
        private http: HttpClient
    ) {
    }
    doSearch(obj: any): Observable<BaseResponseModel<CustomerTypeModel[]>> {
        return this.http.post<BaseResponseModel<CustomerTypeModel[]>>(`${API_ENDPOINT_URL}/customerType/doSearch`, obj);
    }
    saveUpdate(obj: any): Observable<BaseResponseModel<CustomerTypeModel>> {
        return this.http.post<BaseResponseModel<CustomerTypeModel>>(`${API_ENDPOINT_URL}/customerType/saveUpdate`, obj);
    }
    delete(customerTypeId: number): Observable<BaseResponseModel<CustomerTypeModel>> {
        return this.http.delete<BaseResponseModel<CustomerTypeModel>>(`${API_ENDPOINT_URL}/customerType/delete?customerTypeId=${customerTypeId}`);
    }
    // searchCategory(searchObj: any): Observable<BaseResponseModel<CustomerTypeModel[]>> {
    //     return this.http.get<BaseResponseModel<CustomerTypeModel[]>>(`${API_ENDPOINT_URL}/search-category?code=${searchObj.code}&name=${searchObj.name}`);
    // }
    //
    // createUpdateCategory(dataObj: CustomerTypeModel): Observable<BaseResponseModel<CustomerTypeModel>> {
    //     return this.http.post<BaseResponseModel<CustomerTypeModel>>(`${API_ENDPOINT_URL}/create-update-category`, dataObj);
    // }
    //
    // deleteCategory(catId: number): Observable<BaseResponseModel<CustomerTypeModel>> {
    //     return this.http.delete<BaseResponseModel<CustomerTypeModel>>(`${API_ENDPOINT_URL}/delete-category?catId=${catId}`);
    // }
}
