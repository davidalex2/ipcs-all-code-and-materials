package com.algoriant.product.model;


public class Supplier {

    private int supplierId;
    private String supplierName;
    private Long phoneNo;
    private String email;
    private String address;

    public Supplier() {
    }

    public Supplier(int supplierId, String supplierName, Long phoneNo, String email, String address) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = address;
    }

    public int getSupplierId(int id) {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", phoneNo=" + phoneNo +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
