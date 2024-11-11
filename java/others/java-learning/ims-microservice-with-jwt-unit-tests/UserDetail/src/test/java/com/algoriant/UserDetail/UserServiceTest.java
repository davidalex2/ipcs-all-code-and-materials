package com.algoriant.UserDetail;

import com.algoriant.UserDetail.model.UserModel;
import com.algoriant.UserDetail.model.UserDTO;
import com.algoriant.UserDetail.model.UserRequest;
import com.algoriant.UserDetail.repository.UserRepository;
import com.algoriant.UserDetail.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    UserService userService;
    @Test
    public void saveUser(){
        try{
            UserModel userModel = new UserModel();
            userModel.setUserId(1);
            userModel.setFirstName("Raj");
            userModel.setLastName("Kumar");
            userModel.setAddress("Villupuram");
            userModel.setEmail("raj@gmail.com");
            userModel.setPhoneNo(97876987L);
            UserModel userModel1 = userRepository.save(userModel);
            when(userRepository.save(userModel)).thenReturn(userModel);
            assertEquals(userModel1, userService.createUser(UserRequest.toDto(userModel)));
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing saveUser method",th);
        }
    }
    @Test
    public  void findAllUser(){
        try{
            UserModel userModel = new UserModel();
            userModel.setFirstName("Raj");
            userModel.setLastName("Kumar");
            userModel.setAddress("Villupuram");
            userModel.setEmail("raj@gmail.com");
            userModel.setPhoneNo(97876987L);
            userRepository.save(userModel);
            UserModel userModel1 = new UserModel();
            userModel1.setFirstName("Raj");
            userModel1.setLastName("Kumar");
            userModel1.setAddress("Villupuram");
            userModel1.setEmail("raj@gmail.com");
            userModel1.setPhoneNo(97876987L);
            userRepository.save(userModel1);
            List<UserModel> list = new ArrayList<>();
            list.add(userModel);
            list.add(userModel1);
            when(userRepository.findAll()).thenReturn(list);
            assertEquals(list, userRepository.findAll());
        }catch (Throwable th) {
            throw new RuntimeException("Error occurring while testing findAllCustomer method", th);
        }
    }
    @Test
    public void findCustomerById(){
        try{
            UserModel userModel = new UserModel();
            userModel.setFirstName("Raj");
            userModel.setLastName("Kumar");
            userModel.setAddress("Villupuram");
            userModel.setEmail("raj@gmail.com");
            userModel.setPhoneNo(97876987L);
            userRepository.save(userModel);
            when(userRepository.findById(userModel.getUserId())).thenReturn(Optional.of(userModel));
            UserDTO userDTO = userService.findUserById(userModel.getUserId());
            assertEquals(userModel.getUserId(),userDTO.getUserId());
        }catch (Throwable th) {
            throw new RuntimeException("Error occurring while testing findUserById method", th);
        }
    }
    @Test
    public void deleteUserById(){
        try{
            UserModel userModel = new UserModel();
            userModel.setFirstName("Raj");
            userModel.setLastName("Kumar");
            userModel.setAddress("Villupuram");
            userModel.setEmail("raj@gmail.com");
            userModel.setPhoneNo(97876987L);
            userRepository.save(userModel);
            userService.removeUser(userModel.getUserId());
            verify(userRepository,times(1)).deleteById(userModel.getUserId());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing deleteUserById method",th);
        }
    }@Test
    public void modifyUser(){
        try{
            UserModel userModel = new UserModel();
            userModel.setFirstName("Raj");
            userModel.setLastName("Kumar");
            userModel.setAddress("Villupuram");
            userModel.setEmail("raj@gmail.com");
            userModel.setPhoneNo(97876987L);
            when(userRepository.findById(userModel.getUserId())).thenReturn(Optional.of(userModel));
            when(userRepository.save(any())).thenReturn(userModel);
            UserModel userModel1 = userService.modifyUser(userModel.getUserId(), UserRequest.toDto(userModel));
            assertEquals(userModel.getUserId(),userModel1.getUserId());
        }catch (Throwable th){
            throw new RuntimeException("Error occurring while testing modifyUser method",th);
        }
    }

}
