package com.algoriant.jwtLogin.repository;
import com.algoriant.jwtLogin.model.JwtAuthUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface JwtAuthUserRepository extends CrudRepository<JwtAuthUser, Integer> {

    Optional<JwtAuthUser> findByUsername(String username);
}
