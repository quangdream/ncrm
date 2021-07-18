export class AppParamsModel {
    constructor(
        public id?: number,
        public appType?: string,
        public appCode?: string,
        public appName?: string,
    ) {
    }
}

export class BannersModel {
    constructor(
        public id?: number,
        public name?: string,
        public subtitle?: string,
        public bannerImagePath?: string,
        public attachFileLibraryDTOS?: AttachFileLibraryDTO[],
    ) {
    }
}

export class FeedbackModel {
    constructor(
        public id?: number,
        public name?: string,
        public feedbackImagePath?: string,
        public attachFileLibraryDTOS?: AttachFileLibraryDTO[],
    ) {
    }
}


export class AttachFileLibraryDTO {
    constructor(
        public id?: number,
        public parentObject?: number,
        public url?: string,
        public data?: string,
    ) {
    }
}
