package com.viettel.admin.service;

import com.viettel.domain.Category;
import com.viettel.repository.CategoryRepository;
import com.viettel.repository.dao.AdminCategoryDAO;
import com.viettel.service.dto.BaseResponse;
import com.viettel.service.dto.CategoryDTO;
import com.viettel.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class AdminCategoryService {
    private final Logger log = LoggerFactory.getLogger(AdminCategoryService.class);

    @Autowired
    private AdminCategoryDAO categoryDAO;
    @Autowired
    private CategoryRepository categoryRepository;

    public BaseResponse<List<CategoryDTO>> searchCategory(String code, String name) {
        return ResponseUtil.buildSuccessResponse(categoryDAO.searchCategory(code, name));
    }

    public BaseResponse<Category> createUpdateCategory(Category category) {
        if (category.getId() == null) {
            // Tao moi
            Category oldCatByCode = categoryRepository.findCatByCode(category.getCode());
            if (oldCatByCode != null) {
                return ResponseUtil.buildResponse("CAT_ERR_DUPLICATE_CODE");
            }
            category.setCode(category.getCode().trim().toUpperCase());
            categoryRepository.save(category);
            return ResponseUtil.buildSuccessResponse(null);
        } else {
            Category cat = categoryRepository.findById(category.getId()).get();
            cat.setName(category.getName());
            cat.setDes(category.getDes());
            categoryRepository.save(cat);
            return ResponseUtil.buildSuccessResponse(null);
        }
    }

    public BaseResponse<Category> deleteCategory(Long catId) {
        categoryRepository.deleteById(catId);
        return ResponseUtil.buildSuccessResponse(null);
    }
}
