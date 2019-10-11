package com.catering.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class MerchantProfile implements Serializable {
    private Integer merchantId;

    private String merchantName;

    private String merchantPrincipal;

    private String merchantNumber;

    private String merchartEmail;

    private String phone;

    private String createtime;

    private String level;

    private Integer point;

    private String lastupdatetime;

    private Integer type;

    private Integer commendCount;

    private Integer collectCount;

    private Integer heat;

    private String bussinesstime;

    private String merchantAddress;

    private Integer countryId;


    private Integer provinceId;

    private Integer cityId;

    private String memberid;

    private int personPrice;



    private MerchantFeature merchantFeature;


    private static final long serialVersionUID = 1L;

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    public String getMerchantPrincipal() {
        return merchantPrincipal;
    }

    public void setMerchantPrincipal(String merchantPrincipal) {
        this.merchantPrincipal = merchantPrincipal == null ? null : merchantPrincipal.trim();
    }

    public String getMerchantNumber() {
        return merchantNumber;
    }

    public void setMerchantNumber(String merchantNumber) {
        this.merchantNumber = merchantNumber == null ? null : merchantNumber.trim();
    }

    public String getMerchartEmail() {
        return merchartEmail;
    }

    public void setMerchartEmail(String merchartEmail) {
        this.merchartEmail = merchartEmail == null ? null : merchartEmail.trim();
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(String lastupdatetime) {
        this.lastupdatetime = lastupdatetime == null ? null : lastupdatetime.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCommendCount() {
        return commendCount;
    }

    public void setCommendCount(Integer commendCount) {
        this.commendCount = commendCount;
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    public Integer getHeat() {
        return heat;
    }

    public void setHeat(Integer heat) {
        this.heat = heat;
    }

    public String getBussinesstime() {
        return bussinesstime;
    }

    public void setBussinesstime(String bussinesstime) {
        this.bussinesstime = bussinesstime == null ? null : bussinesstime.trim();
    }

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress == null ? null : merchantAddress.trim();
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public MerchantFeature getMerchantFeature() {
        return merchantFeature;
    }

    public void setMerchantFeature(MerchantFeature merchantFeature) {
        this.merchantFeature = merchantFeature;
    }

    public int getPersonPrice() {
        return personPrice;
    }

    public void setPersonPrice(int personPrice) {
        this.personPrice = personPrice;
    }

}