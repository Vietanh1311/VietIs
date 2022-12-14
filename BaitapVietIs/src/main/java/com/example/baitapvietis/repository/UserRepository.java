package com.example.baitapvietis.repository;

import com.example.baitapvietis.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
//    UserEntity findByUserName(String username);
    UserEntity findByUsername(String username);
}
