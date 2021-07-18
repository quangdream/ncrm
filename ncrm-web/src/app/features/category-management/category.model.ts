export class CategoryModel {
    constructor(
        public id?: number,
        public code?: string,
        public name?: string,
        public des?: string,
        public prodAmount?: number,
        public billingDtlDTOs?: any[]
    ) {
    }
}
