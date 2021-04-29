package com.advprog2021.b15.rekrUIt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.advprog2021.b15.rekrUIt.model.UserModel;

import java.util.Optional;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByEmail(String email);

}
