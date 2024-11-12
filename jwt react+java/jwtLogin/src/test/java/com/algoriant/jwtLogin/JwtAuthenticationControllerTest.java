package com.algoriant.jwtLogin;

import com.algoriant.jwtLogin.controller.JwtAuthenticationController;
import com.algoriant.jwtLogin.model.JwtRequest;
import com.algoriant.jwtLogin.model.JwtResponse;
import com.algoriant.jwtLogin.model.JwtToken;
import com.algoriant.jwtLogin.service.JwtService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class JwtAuthenticationControllerTest {

    @Mock
    private JwtService jwtService;

    @InjectMocks
    JwtAuthenticationController controller;

    @Test
    void login() {
        try {
            JwtRequest jwtRequest = new JwtRequest();
            jwtRequest.setUserName("antony");
            jwtRequest.setPassword("123");

            JwtToken jwtToken = new JwtToken();
            jwtToken.setUsername("antony");
            jwtToken.setPassword("123");

            when(jwtService.login(jwtRequest)).thenReturn(new JwtResponse<>());
            ResponseEntity<?> responseEntity = controller.login(jwtToken);
            assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
