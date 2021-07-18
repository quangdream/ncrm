package com.viettel.service.dto;

/**
 * A DTO representing a user, with his authorities.
 */
public class CategoryDTO {

    private Long id;

    private String code;

    private String name;

    private String des;

    private Long parentId;

    private boolean hasSubCategory;

    private Long prodAmount;

    public CategoryDTO(Long id, String name, String des, Long parentId, boolean hasSubCategory) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.parentId = parentId;
        this.hasSubCategory = hasSubCategory;
    }

    public CategoryDTO(Long id, String code, String name, String des, Long prodAmount) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.des = des;
        this.prodAmount = prodAmount;
    }

    public CategoryDTO(Long id, String code, String name, String des) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.des = des;
    }

    public CategoryDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public boolean isHasSubCategory() {
        return hasSubCategory;
    }

    public void setHasSubCategory(boolean hasSubCategory) {
        this.hasSubCategory = hasSubCategory;
    }

    public Long getProdAmount() {
        return prodAmount;
    }

    public void setProdAmount(Long prodAmount) {
        this.prodAmount = prodAmount;
    }
}
