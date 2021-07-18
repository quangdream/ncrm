package com.viettel.web.rest;

import com.viettel.utils.FilesStorageServiceImpl;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class ImageResource {
    @Autowired
    private FilesStorageServiceImpl storageService;


    @RequestMapping(value = "/image/{path}", method = RequestMethod.GET)
    public void  getImageAsByteArray(HttpServletResponse response, @PathVariable("path") String path) throws IOException {
        Resource file = storageService.loadByEncryptPath(path);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(file.getInputStream(), response.getOutputStream());
    }

}
