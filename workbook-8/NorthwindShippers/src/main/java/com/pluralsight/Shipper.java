package com.pluralsight;

public class Shipper {
    private int id;
    private String companyName;
    private String phone;

    public Shipper(int id, String companyName, String phone) {
        this.id = id;
        this.companyName = companyName;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "\tShipper\n" +
                "ID :\t" + id + '\n'+
                "Company Name :\t" + companyName + '\n' +
                "Phone :\t" + phone + '\n' +
                "--------------------\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
