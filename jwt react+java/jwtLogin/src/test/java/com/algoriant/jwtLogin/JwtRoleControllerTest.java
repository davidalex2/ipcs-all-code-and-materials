package com.algoriant.jwtLogin;

import com.algoriant.jwtLogin.controller.JwtRoleController;
import com.algoriant.jwtLogin.model.JwtRole;
import com.algoriant.jwtLogin.service.JwtRoleService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class JwtRoleControllerTest {

    @Mock
    private JwtRoleService roleService;

    @InjectMocks
    JwtRoleController jwtRoleController;

    @Test
    void saveRole() {
        try {
            JwtRole jwtRole = new JwtRole();
            jwtRole.setRole("admin");
            jwtRole.setRoleDesc("for admin");

            when(roleService.saveRole(jwtRole)).thenReturn(jwtRole);
            ResponseEntity<JwtRole> roleResponseEntity = jwtRoleController.saveRole(jwtRole);
            assertEquals(HttpStatus.CREATED, roleResponseEntity.getStatusCode());
        } catch (Throwable th) {
            throw new RuntimeException("Error occurring while testing the saveRole method !", th);
        }
    }
}
