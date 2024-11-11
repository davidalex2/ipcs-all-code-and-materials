package com.algoriant.jwtLogin.service;

import com.algoriant.jwtLogin.model.JwtRole;
import com.algoriant.jwtLogin.repository.JwtRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JwtRoleService {

    @Autowired
    private JwtRoleRepository roleRepository;

    public JwtRole saveRole(JwtRole role) {
        return roleRepository.save(role);
    }
}
