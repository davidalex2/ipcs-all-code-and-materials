package com.algoriant.UserDetail.model;

public class UserRequest {

    private String firstName;
    private String lastName;
    private String address;
    private Long phoneNo;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    public static UserRequest toDto(UserModel userModel){
        UserRequest userRequest = new UserRequest();
        userRequest.setFirstName(userModel.getFirstName());
        userRequest.setLastName(userModel.getLastName());
        userRequest.setAddress(userModel.getAddress());
        userRequest.setEmail(userModel.getEmail());
        userRequest.setPhoneNo(userModel.getPhoneNo());
        return userRequest;
    }
}
