package com.viettel.service.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileInfoDTO {
    private String fileName;
    private MultipartFile data;

    public FileInfoDTO() {
    }

    public FileInfoDTO(String fileName, MultipartFile data) {
        this.fileName = fileName;
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public MultipartFile getData() {
        return data;
    }

    public void setData(MultipartFile data) {
        this.data = data;
    }
}
