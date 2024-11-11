package com.algoriant.UserDetail.model;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private int userId;
    private String firstName;
    private String lastName;
    private String address;
    private Long phoneNo;
    private String email;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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

    public static UserDTO toDTO(UserModel userModel) {

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userModel.getUserId());
        userDTO.setFirstName(userModel.getFirstName());
        userDTO.setLastName(userModel.getLastName());
        userDTO.setAddress(userModel.getAddress());
        userDTO.setPhoneNo(userModel.getPhoneNo());
        userDTO.setEmail(userModel.getEmail());
        return userDTO;
    }

    public static List<UserDTO> toListDTO(List<UserModel> userModels) {

        List<UserDTO> userDTOList = new ArrayList<>();
        for (UserModel userModel : userModels) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(userModel.getUserId());
            userDTO.setFirstName(userModel.getFirstName());
            userDTO.setLastName(userModel.getLastName());
            userDTO.setAddress(userModel.getAddress());
            userDTO.setPhoneNo(userModel.getPhoneNo());
            userDTO.setEmail(userModel.getEmail());
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

}
