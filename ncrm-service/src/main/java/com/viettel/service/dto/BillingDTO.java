package com.viettel.service.dto;


import java.math.BigDecimal;

/**
 * A DTO representing a user, with his authorities.
 */
public class BillingDTO {

    private Long id;

    private Long status;

    private String code;

    private String createDate;

    private String custName;

    private String address;

    private String postCode;

    private String phone;

    private String email;

    private BigDecimal totalPrice;

    private String des;

    private Long totalItem;

    public BillingDTO(Long id, Long status, String code, String createDate, String custName, String address, String postCode, String phone, String email, BigDecimal totalPrice, String des, Long totalItem) {
        this.id = id;
        this.status = status;
        this.code = code;
        this.createDate = createDate;
        this.custName = custName;
        this.address = address;
        this.postCode = postCode;
        this.phone = phone;
        this.email = email;
        this.totalPrice = totalPrice;
        this.des = des;
        this.totalItem = totalItem;
    }

    public BillingDTO() {
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Long totalItem) {
        this.totalItem = totalItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}

