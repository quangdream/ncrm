import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {API_ENDPOINT_URL} from '../../app-config.service';
import {BaseResponseModel} from '../../core/service/base-response.model';
import {CategoryModel} from './category.model';

@Injectable({
    providedIn: 'root'
})
export class CategoryManagementService {
    constructor(
        private http: HttpClient
    ) {
    }

    searchCategory(searchObj: any): Observable<BaseResponseModel<CategoryModel[]>> {
        return this.http.get<BaseResponseModel<CategoryModel[]>>(`${API_ENDPOINT_URL}/search-category?code=${searchObj.code}&name=${searchObj.name}`);
    }

    createUpdateCategory(dataObj: CategoryModel): Observable<BaseResponseModel<CategoryModel>> {
        return this.http.post<BaseResponseModel<CategoryModel>>(`${API_ENDPOINT_URL}/create-update-category`, dataObj);
    }

    deleteCategory(catId: number): Observable<BaseResponseModel<CategoryModel>> {
        return this.http.delete<BaseResponseModel<CategoryModel>>(`${API_ENDPOINT_URL}/delete-category?catId=${catId}`);
    }
}
