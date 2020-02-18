package com.example.servicecompanyinfo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class company {
    @Id
    @GenericGenerator(name = "jpa-uuid",strategy = "uuid")
    @GeneratedValue(generator = "jpa-uuid")
    private String id; //企业ID （自动生成）
    private String name; //企业名称 （输入）
    private String legalRepresentative; //法定代表人 （输入）
    @Column(unique = true, updatable = false)
    private String businessRegisNo; //工商注册号 （输入）
    @Column(unique = true, updatable = false)
    private String uscCode; //统一社会信用代码 （输入）
    private String address; //企业地址 （输入）
    private String nature; //企业性质 （输入）
    private String type; //企业类型 （输入
    private String businessScope; //经营范围 （输入）
    private String email; //邮箱  （输入）
    private String tel; //联系方式 （输入）

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getBusinessRegisNo() {
        return businessRegisNo;
    }

    public void setBusinessRegisNo(String businessRegisNo) {
        this.businessRegisNo = businessRegisNo;
    }

    public String getUscCode() {
        return uscCode;
    }

    public void setUscCode(String uscCode) {
        this.uscCode = uscCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", legalRepresentative='" + legalRepresentative + '\'' +
                ", businessRegisNo='" + businessRegisNo + '\'' +
                ", uscCode='" + uscCode + '\'' +
                ", address='" + address + '\'' +
                ", nature='" + nature + '\'' +
                ", type='" + type + '\'' +
                ", businessScope='" + businessScope + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
