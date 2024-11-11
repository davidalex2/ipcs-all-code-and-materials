package com.algoriant.order.model;

public class Customer {

    private int customerId;
    private String firstName;
    private String lastName;
    private String address;
    private int phoneNo;
    private String email;
    public Customer(){}
    public Customer(String firstName, String lastName, String address, int phoneNo, String email){

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
    }
    public int getCustomerId(){
        return customerId;
    }
    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getAddress(){
        return  address;
    }
    public void setAddress(String  address){
        this.address = address;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString(){
        return "customer {" + "customerId = " +customerId
                +", firstName = "+ firstName+
                ", lastName = " + lastName+
                ", address = " +address+
                ", phoneNo = "+phoneNo+
                ", email = "+email+ "}";
    }
}
