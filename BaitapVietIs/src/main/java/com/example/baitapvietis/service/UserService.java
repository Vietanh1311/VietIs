package com.example.baitapvietis.service;

import com.example.baitapvietis.model.dto.UserDto;
import com.example.baitapvietis.model.entity.UserEntity;
import com.example.baitapvietis.model.respone.Data;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public interface UserService {
    Data getById(Long id);

    Data getByName(String username);

    void add(UserEntity userDto);

    void getAll();

    void update(Principal principal, UserEntity user);

    Data deleteById(Long id);
}
