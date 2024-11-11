package com.algoriant.UserDetail.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_Id")
    private int userId;
    @Column(name = "f_name")
    private String firstName;
    @Column(name = "l_name")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "p_no")
    private Long phoneNo;
    @Column(name = "email")
    private String email;
    public UserModel(){}
    public UserModel(String firstName, String lastName, String address, Long phoneNo, String email){

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
    }
    public int getUserId(){
        return userId;
    }
    public void setUserId(int userId){
        this.userId = userId;
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
    @Override
    public String toString(){
        return "user {" + "userId = " +userId
                +", firstName = "+ firstName+
                ", lastName = " + lastName+
                ", address = " +address+
                ", phoneNo = "+phoneNo+
                ", email = "+email+ "}";
    }

    public static UserModel toEntity(UserRequest customerRequest) {

        UserModel userModel = new UserModel();
        userModel.setFirstName(customerRequest.getFirstName());
        userModel.setLastName(customerRequest.getLastName());
        userModel.setAddress(customerRequest.getAddress());
        userModel.setPhoneNo(customerRequest.getPhoneNo());
        userModel.setEmail(customerRequest.getEmail());
        return userModel;
    }
}
