package com.algoriant.jwtLogin.service;

import com.algoriant.jwtLogin.model.JwtAuthUser;
import com.algoriant.jwtLogin.model.JwtUserDto;
import com.algoriant.jwtLogin.repository.JwtAuthUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class JwtUserService implements UserDetailsService {

    @Autowired
    private JwtAuthUserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        JwtAuthUser jwtAuthUser = new JwtAuthUser();
        Optional<JwtAuthUser> optionalJwtAuthUser = userRepository.findByUsername(userName);
        if(optionalJwtAuthUser.isPresent()){
            jwtAuthUser = optionalJwtAuthUser.get();
        }
        return jwtAuthUser;
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public JwtAuthUser saveUser(JwtUserDto jwtUserDto) {
        String rawPassword = jwtUserDto.getPassword();
        String encodedPassword = bCryptPasswordEncoder.encode(rawPassword);
        jwtUserDto.setPassword(encodedPassword);

        return userRepository.save(JwtAuthUser.toEntity(jwtUserDto));
    }

}