package com.algoriant.UserDetail.controller;

import com.algoriant.UserDetail.model.UserModel;
import com.algoriant.UserDetail.model.UserDTO;
import com.algoriant.UserDetail.model.ImsException;
import com.algoriant.UserDetail.model.UserRequest;
import com.algoriant.UserDetail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class    UserController {

    @Autowired
    private UserService userService;
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/createUser")
    public ResponseEntity<UserModel> createUser(@RequestBody UserRequest userRequest){
        return new ResponseEntity<>(userService.createUser(userRequest),HttpStatus.CREATED);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/modifyUser/{userId}")
    public ResponseEntity<UserModel> modifyUser(@PathVariable("userId") int userId, @RequestBody UserRequest userRequest){
        return new ResponseEntity<>(userService.modifyUser(userId,userRequest),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/removeUser/{userId}")
    public ResponseEntity<String> removeUser(@PathVariable("userId") int userId){
        userService.removeUser(userId);
        return new ResponseEntity<>("deleted user",HttpStatus.OK);
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/findUserById/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("userId") int userId) {
        return new ResponseEntity<>(userService.findUserById(userId),HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/findAllUser")
    public ResponseEntity<List<UserDTO>> getAllUser(){
        return new ResponseEntity<>(userService.findAllUser(),HttpStatus.OK);
    }

    @GetMapping("/sendUserById/{userId}")
    public ResponseEntity<UserDTO> sendUser(@PathVariable("userId") int userId) throws ImsException {
        try{
            return new ResponseEntity<>(userService.findUserById(userId),HttpStatus.OK);
        } catch (Exception e) {
            throw new ImsException("There is some unexpected error occurring");
        }

    }
}
