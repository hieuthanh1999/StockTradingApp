package com.doan.companypluscrypto.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
// Xác định một entity là một class được ánh xạ vào một bảng trong cơ sở dữ liệu
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String website;
    private String description;
    private String stockCode;
    private String pic;
    private String sector;
    private long charterCapital;
    private String establishmentInfo;
    private long marketCap;


    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Events> events;  

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Events> getEvents() {
        return events;
    }

    public void setEvents(List<Events> events) {
        this.events = events;
    }

    public long getCharterCapital() {
        return charterCapital;
    }

    public void setCharterCapital(int charterCapital) {
        this.charterCapital = charterCapital;
    }

    public String getEstablishmentInfo() {
        return establishmentInfo;
    }

    public void setEstablishmentInfo(String establishmentInfo) {
        this.establishmentInfo = establishmentInfo;
    }

    public long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(int marketCap) {
        this.marketCap = marketCap;
    }
}


