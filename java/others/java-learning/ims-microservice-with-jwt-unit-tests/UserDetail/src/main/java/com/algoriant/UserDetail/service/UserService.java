package com.algoriant.UserDetail.service;

import com.algoriant.UserDetail.model.UserDTO;
import com.algoriant.UserDetail.model.UserRequest;
import com.algoriant.UserDetail.repository.UserRepository;
import com.algoriant.UserDetail.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public UserModel createUser(UserRequest userRequest){
        return userRepository.save(UserModel.toEntity(userRequest));
    }
    public UserModel modifyUser(int userId, UserRequest userRequest){
        UserModel userModel = new UserModel();
        Optional<UserDTO> optionalUserDTO = Optional.of(UserDTO.toDTO(userRepository.findById(userId).get()));
        if (optionalUserDTO.isPresent()) {
            userModel.setUserId(userId);
            userModel.setFirstName(userRequest.getFirstName());
            userModel.setLastName(userRequest.getLastName());
            userModel.setAddress(userRequest.getAddress());
            userModel.setPhoneNo(userRequest.getPhoneNo());
            userModel.setEmail(userRequest.getEmail());
            return userRepository.save(userModel);
        }
        return userModel;
    }

    public  void removeUser(int userId) {
        userRepository.deleteById(userId);
    }
    public UserDTO findUserById(int userId){
        Optional<UserDTO> optionalUserDTO = Optional.of(UserDTO.toDTO(userRepository.findById(userId).get()));
        if (optionalUserDTO.isPresent()) {
            return optionalUserDTO.get();
        }
        return null;
    }
    public List<UserDTO> findAllUser(){
        List<UserModel> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return UserDTO.toListDTO(users);
    }
}
