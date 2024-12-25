package com.doan.companypluscrypto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Company {
    @Id
    public String name;
    public String address;
    public String phone;
    public String email;
    public String website;
    public String description;
    public String stockCode;
    public String pic;
    public String sector;

    public Company() {
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
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
    
    public String getWebsite() {
        return website;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getStockCode() {
        return stockCode;
    }
    
    public void setStockCode(String stock_code) {
        this.stockCode = stock_code;
    }
    
    public String getPic() {
        return pic;
    }
    
    public void setPic(String pic) {
        this.pic = pic;
    }
    
    public String getSector() {
        return sector;
    }
    
    public void setSector(String major) {
        this.sector = major;
    }
}


