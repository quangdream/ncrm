import {Component, OnInit, ViewChild} from '@angular/core';
import {DataStateChangeEvent, GridDataResult} from '@progress/kendo-angular-grid';
import {State} from '@progress/kendo-data-query';
import * as moment from 'moment';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {ToastrService} from 'ngx-toastr';
import {FormBuilder} from '@angular/forms';
import {TooltipDirective} from '@progress/kendo-angular-tooltip';
import {CategoryManagementService} from './category-management.service';
import {CategoryManagementFormComponent} from './popup/category-management-form.component';
import {PAGEABLE_CONFIG} from '../../core/config/pageable.config';
import {AlertService} from '../../shared/dialogs/sweet-alert/alert.service';
import {CategoryModel} from './category.model';

@Component({
    selector: 'smart-category',
    templateUrl: './category-management.component.html'
})
export class CategoryManagementComponent implements OnInit {

    moment = moment;
    isCollapsed = true;
    public gridView: GridDataResult;
    state: State = {
        skip: 0,
        take: 10
    };
    pageableConfig = PAGEABLE_CONFIG;
    private items: CategoryModel[] = [];
    selectedItems = [];
    // end grid data

    // search form
    public searchForm = this.fb.group({
        code: [],
        name: []
    });
    // end search form

    // tooltip
    @ViewChild(TooltipDirective, {static: true})
    public tooltipDir: TooltipDirective;

    // end tooltip
    constructor(
        private modal: NgbModal,
        private toastr: ToastrService,
        private alertService: AlertService,
        private fb: FormBuilder,
        private categoryService: CategoryManagementService,
    ) {
    }

    ngOnInit() {
        this.doSearch();
    }

    public doSearch() {
        const params = {
            code: this.searchForm.get('code').value ? this.searchForm.get('code').value : '',
            name: this.searchForm.get('name').value ? this.searchForm.get('name').value : ''
        };
        this.categoryService.searchCategory(params).subscribe(
            response => {
                this.items = response.data;
                this.loadItems();
            }
        );
    }

    public dataStateChange(state: DataStateChangeEvent): void {
        this.state = state;
        this.loadItems();
    }

    private loadItems(): void {
        this.gridView = {
            data: this.items.slice(this.state.skip, this.state.skip + this.state.take),
            total: this.items.length
        };
    }

    public add() {
        const modalRef = this.modal.open(CategoryManagementFormComponent, {windowClass: 'popup-with-600'});
        modalRef.componentInstance.entity = {};
        modalRef.result.then(
            (result) => {
                this.doSearch();
            });
    }

    public editItem(event, dataItem) {
        event.preventDefault();
        const modalRef = this.modal.open(CategoryManagementFormComponent, {windowClass: 'popup-with-600'});
        modalRef.componentInstance.entity = dataItem;
        modalRef.result.then(
            (result) => {
                this.doSearch();
            });
    }

    public removeItem(event, dataItem: CategoryModel) {
        event.preventDefault();
        console.log(dataItem);
        this.alertService.fire({
            showCancelButton: true,
            title: 'Xác nhận',
            text: 'Bạn có muốn xóa bản ghi không?',
        }).then((result) => {
            console.log(result);
            if (result.value) {
                this.categoryService.deleteCategory(dataItem.id).subscribe(response => {
                    this.doSearch();
                    this.toastr.success('Xóa bản ghi thành công', 'Thành công');
                });
            } else {
                console.log('Cancel');
            }
        });
    }

    public showTooltip(e: MouseEvent): void {
        const element = e.target as HTMLElement;
        if (
            (element.nodeName === 'TD' || element.nodeName === 'TH' || element.nodeName === 'A')
            && element.offsetWidth < element.scrollWidth
            && element.innerText
        ) {
            this.tooltipDir.toggle(element);
        } else {
            this.tooltipDir.hide();
        }
    }

}
