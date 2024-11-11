package com.algoriant.jwtLogin;

import com.algoriant.jwtLogin.model.JwtRole;
import com.algoriant.jwtLogin.repository.JwtRoleRepository;
import com.algoriant.jwtLogin.service.JwtRoleService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class JwtRoleServiceTest {

    @Mock
    private JwtRoleRepository repository;

    @InjectMocks
    JwtRoleService jwtRoleService;

    @Test
    void saveRole() {
        try {
            JwtRole jwtRole = new JwtRole();
            jwtRole.setRole("admin");
            jwtRole.setRoleDesc("for admin");

            when(repository.save(jwtRole)).thenReturn(jwtRole);
            JwtRole jwtRole1 = jwtRoleService.saveRole(jwtRole);
            assertEquals(jwtRole1.getRole(), jwtRole.getRole());
        } catch (Throwable th) {
            throw new RuntimeException("Error occurring while testing the saveRole method !", th);
        }
    }
}
