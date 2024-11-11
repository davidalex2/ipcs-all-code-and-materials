package com.algoriant.jwtLogin.controller;

import com.algoriant.jwtLogin.config.JwtRequestFilter;
import com.algoriant.jwtLogin.config.JwtTokenUtil;
import com.algoriant.jwtLogin.model.JwtAuthUser;
import com.algoriant.jwtLogin.model.JwtResponse;
import com.algoriant.jwtLogin.model.JwtToken;
import com.algoriant.jwtLogin.service.JwtService;
import com.algoriant.jwtLogin.service.JwtUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserService userService;
    @Autowired
    JwtRequestFilter jwtFilter;
    @Autowired
    JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody JwtToken request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(), request.getPassword()));

            JwtAuthUser user = (JwtAuthUser) authentication.getPrincipal();
            String accessToken = jwtTokenUtil.generateAccessToken(user);
            JwtResponse response = new JwtResponse(user.getUsername(), accessToken,user.getRoles());

            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    @GetMapping("/validateToken")
    public ResponseEntity<String> validateToken(@RequestParam("token") String token) {
        try {
            return new ResponseEntity<>(jwtService.validateToken(token),HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/getUserDetail")
    public ResponseEntity<UserDetails> getUserDetail(@RequestParam("token") String token) {
        try {
            return new ResponseEntity<UserDetails>(jwtFilter.getUserDetails(token),HttpStatus.OK);
        } catch ( Exception ex) {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }
}
