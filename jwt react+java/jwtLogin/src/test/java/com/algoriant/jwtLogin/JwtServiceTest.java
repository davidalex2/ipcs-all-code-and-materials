package com.algoriant.jwtLogin;

import com.algoriant.jwtLogin.model.JwtRequest;
import com.algoriant.jwtLogin.model.JwtResponse;
import com.algoriant.jwtLogin.service.JwtService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class JwtServiceTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    JwtService jwtService;

    @Test
    void login() {
        try {
            JwtRequest jwtRequest = new JwtRequest();
            jwtRequest.setUserName("antony");
            jwtRequest.setPassword("123");

            JwtResponse jwtResponse = jwtService.login(jwtRequest);
            assertEquals(jwtResponse.getUsername(), jwtRequest.getUserName());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
