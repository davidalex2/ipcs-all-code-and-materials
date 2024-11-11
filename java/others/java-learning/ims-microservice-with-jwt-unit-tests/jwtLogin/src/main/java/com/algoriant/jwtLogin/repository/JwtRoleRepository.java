package com.algoriant.jwtLogin.repository;


import com.algoriant.jwtLogin.model.JwtRole;
import org.springframework.data.repository.CrudRepository;

public interface JwtRoleRepository extends CrudRepository<JwtRole, Integer> {
}
