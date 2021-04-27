package com.advprog2021.b15.rekrUIt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.advprog2021.b15.rekrUIt.model.UserModel;

@Repository
public interface UserDb extends JpaRepository<UserModel, Long> {
    
    UserModel findByEmail(String email);

}