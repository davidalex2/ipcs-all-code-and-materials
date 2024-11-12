package com.algoriant.jwtLogin.controller;

import com.algoriant.jwtLogin.model.JwtAuthUser;
import com.algoriant.jwtLogin.model.JwtUserDto;
import com.algoriant.jwtLogin.service.JwtUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/userController")
public class JwtUserController {
    @Autowired
    private JwtUserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<JwtAuthUser> saveUser(@RequestBody JwtUserDto jwtUserDto) {
        return  new ResponseEntity<>(userService.saveUser(jwtUserDto), HttpStatus.CREATED);
    }
}
