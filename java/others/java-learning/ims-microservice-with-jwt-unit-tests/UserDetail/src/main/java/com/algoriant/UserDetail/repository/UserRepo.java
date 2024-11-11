package com.algoriant.UserDetail.repository;

import com.algoriant.UserDetail.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
@EnableJpaRepositories
@Repository

public interface UserRepo extends JpaRepository<User, String> {

}
