package com.algoriant.UserDetail.repository;

import com.algoriant.UserDetail.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel,Integer> {

}
