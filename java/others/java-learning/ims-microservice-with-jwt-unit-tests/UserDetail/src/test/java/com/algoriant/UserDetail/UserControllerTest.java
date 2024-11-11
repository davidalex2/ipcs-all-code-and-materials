package com.algoriant.UserDetail;

import com.algoriant.UserDetail.controller.UserController;
import com.algoriant.UserDetail.model.UserModel;
import com.algoriant.UserDetail.model.UserDTO;
import com.algoriant.UserDetail.model.UserRequest;
import com.algoriant.UserDetail.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest
public class UserControllerTest {

    @Mock
    private UserService userService;
    @InjectMocks
    UserController userController;
    @Test
    public void saveUser(){
        try{
            UserModel userModel = new UserModel();
            userModel.setFirstName("Raj");
            userModel.setLastName("Kumar");
            userModel.setAddress("Villupuram");
            userModel.setEmail("raj@gmail.com");
            userModel.setPhoneNo(97876987L);
            when(userService.createUser(UserRequest.toDto(userModel))).thenReturn(userModel);
            ResponseEntity<UserModel> userModelResponseEntity = userController.createUser(UserRequest.toDto(userModel));
            assertEquals(HttpStatus.CREATED,userModelResponseEntity.getStatusCode());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing SaveUser method",th);
        }
    }
    @Test
    public void findUserById(){
        try{
            UserModel userModel = new UserModel();
            userModel.setFirstName("Raj");
            userModel.setLastName("Kumar");
            userModel.setAddress("Villupuram");
            userModel.setEmail("raj@gmail.com");
            userModel.setPhoneNo(97876987L);
            when(userService.findUserById(userModel.getUserId())).thenReturn(UserDTO.toDTO(userModel));
            ResponseEntity<UserDTO> customerDTOResponseEntity = userController.getUser(userModel.getUserId());
            assertEquals(HttpStatus.OK,customerDTOResponseEntity.getStatusCode());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing findUserById method",th);
        }
    }
    @Test
    public void getAllUser(){
        try{
            UserModel userModel = new UserModel();
            userModel.setFirstName("Raj");
            userModel.setLastName("Kumar");
            userModel.setAddress("Villupuram");
            userModel.setEmail("raj@gmail.com");
            userModel.setPhoneNo(97876987L);
            userService.createUser(UserRequest.toDto(userModel));
            UserModel userModel1 = new UserModel();
            userModel1.setFirstName("Raj");
            userModel1.setLastName("Kumar");
            userModel1.setAddress("Villupuram");
            userModel1.setEmail("raj@gmail.com");
            userModel1.setPhoneNo(97876987L);
            userService.createUser(UserRequest.toDto(userModel1));
            List<UserModel> list = new ArrayList<>();
            list.add(userModel);
            list.add(userModel1);
            when(userService.findAllUser()).thenReturn(UserDTO.toListDTO(list));
            ResponseEntity<List<UserDTO>> listResponseEntity = userController.getAllUser();
            assertEquals(HttpStatus.OK,listResponseEntity.getStatusCode());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing getAllUser method",th);
        }
    }
    @Test
    public void deleteUserTest(){
        try{
            UserModel userModel = new UserModel();
            userModel.setFirstName("Raj");
            userModel.setLastName("Kumar");
            userModel.setAddress("Villupuram");
            userModel.setEmail("raj@gmail.com");
            userModel.setPhoneNo(97876987L);
            userService.createUser(UserRequest.toDto(userModel));
            userService.removeUser(userModel.getUserId());
            ResponseEntity<String> responseEntity = userController.removeUser(userModel.getUserId());
            assertEquals(HttpStatus.OK,responseEntity.getStatusCode());

        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing deleteUserTest method",th);
        }
    }
    @Test
    public void modifyUserTest(){
        try{
            UserModel userModel = new UserModel();
            userModel.setFirstName("Raj");
            userModel.setLastName("Kumar");
            userModel.setAddress("Villupuram");
            userModel.setEmail("raj@gmail.com");
            userModel.setPhoneNo(97876987L);
            UserRequest userRequest = UserRequest.toDto(userModel);
            when(userService.modifyUser(userModel.getUserId(),userRequest)).thenReturn(userModel);
            ResponseEntity<UserModel> userModelResponseEntity = userController.modifyUser(userModel.getUserId(),userRequest);
            assertEquals(HttpStatus.OK,userModelResponseEntity.getStatusCode());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing modifyUserTest method",th);
        }
    }
}
