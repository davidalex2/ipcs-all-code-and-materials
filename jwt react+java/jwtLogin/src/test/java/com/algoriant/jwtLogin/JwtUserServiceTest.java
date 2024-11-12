package com.algoriant.jwtLogin;

import com.algoriant.jwtLogin.model.JwtAuthUser;
import com.algoriant.jwtLogin.model.JwtRole;
import com.algoriant.jwtLogin.model.JwtUserDto;
import com.algoriant.jwtLogin.repository.JwtAuthUserRepository;
import com.algoriant.jwtLogin.service.JwtUserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class JwtUserServiceTest {

    @Mock
    private JwtAuthUserRepository repository;

    @InjectMocks
    JwtUserService jwtUserService;

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

            when(repository.save(user)).thenReturn(user);
            JwtAuthUser jwtAuthUser = jwtUserService.saveUser(userDto);
            assertEquals(jwtAuthUser.getUsername(), user.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
