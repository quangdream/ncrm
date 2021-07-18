package com.viettel.utils;

import com.viettel.service.dto.FileInfoDTO;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Service
public class FilesStorageServiceImpl {
    public String save(String folder, FileInfoDTO fileInfo) {
        String fullPathRs = "";
        try {
            // Tao folder neu khong ton tai
            new File(folder).mkdirs();

            String fileName = fileInfo.getFileName() + "." + FilenameUtils.getExtension(fileInfo.getData().getOriginalFilename());
            Path folderPath = Paths.get(folder);
            Files.copy(fileInfo.getData().getInputStream(), folderPath.resolve(fileName));

            fullPathRs = folder + "/" + fileName;
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }

        return fullPathRs;
    }

    public Resource loadByEncryptPath(String path) {
        try {
            Path file = Paths.get(decodePath(path));
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    public boolean deleteFileByEncryptPath(String encodePath) {
        File file = new File(decodePath(encodePath));
        return file.delete();
    }

    public String decodePath(String encodePath) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodePath);
        return new String(decodedBytes);
    }

    public String encodePath(String realPath) {
        return Base64.getEncoder().encodeToString(realPath.getBytes());
    }
}
