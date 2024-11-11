package com.algoriant.jwtLogin;

import com.algoriant.jwtLogin.controller.JwtUserController;
import com.algoriant.jwtLogin.model.JwtAuthUser;
import com.algoriant.jwtLogin.model.JwtRole;
import com.algoriant.jwtLogin.model.JwtUserDto;
import com.algoriant.jwtLogin.service.JwtUserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class JwtUserControllerTest {

    @Mock
    private JwtUserService  jwtUserService;

    @InjectMocks
    JwtUserController jwtUserController;

    @Test
    void saveUser() {
        try {
            JwtUserDto userDto = new JwtUserDto();
            Set<JwtRole> roles = new HashSet<>();
            JwtRole jwtRole = new JwtRole();
            jwtRole.setRole("admin");
            jwtRole.setRoleDesc("for admin");
            roles.add(jwtRole);

            userDto.setUsername("antonny");
            userDto.setPassword("123");
            userDto.setRoles(roles);
            JwtAuthUser user = JwtAuthUser.toEntity(userDto);

            when(jwtUserService.saveUser(userDto)).thenReturn(user);
            ResponseEntity<JwtAuthUser> userResponseEntity = jwtUserController.saveUser(userDto);
            assertEquals(HttpStatus.CREATED, userResponseEntity.getStatusCode());
        } catch (Throwable th) {
            throw new RuntimeException("Error occurring while testing the saveRole method !", th);
        }
    }
}
