package com.viettel.admin.rest;

import com.viettel.admin.service.AdminCategoryService;
import com.viettel.domain.Category;
import com.viettel.service.dto.BaseResponse;
import com.viettel.service.dto.CategoryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * REST controller for managing {@link Category}.
 */
@RestController
@RequestMapping("/api/admin")
@Transactional
public class AdminCategoryResource {
    private final Logger log = LoggerFactory.getLogger(AdminCategoryResource.class);

    @Autowired
    private AdminCategoryService categoryService;

    @GetMapping("/search-category")
    public BaseResponse<List<CategoryDTO>> searchCategory(@RequestParam(required = false) String code, @RequestParam(required = false) String name) {
        log.debug("REST request to search category");
        return categoryService.searchCategory(code, name);
    }

    @PostMapping("/create-update-category")
    public BaseResponse<Category> createUpdateCategory(@Valid @RequestBody Category category) {
        log.debug("REST request to save Category : {}", category);
        return categoryService.createUpdateCategory(category);
    }

    @DeleteMapping("/delete-category")
    public BaseResponse<Category> deleteCategory(@RequestParam Long catId) {
        log.debug("REST request to delete Category : {}", catId);
        return categoryService.deleteCategory(catId);
    }
}
