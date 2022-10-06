package com.example.baitapvietis.service.impl;

import com.example.baitapvietis.model.dto.UserDto;
import com.example.baitapvietis.model.entity.UserEntity;
import com.example.baitapvietis.model.respone.Data;
import com.example.baitapvietis.repository.UserRepository;
import com.example.baitapvietis.service.UserService;
import org.apache.catalina.User;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.security.Principal;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper;
    private final UserRepository userRepository;

    public UserServiceImpl(ModelMapper mapper, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Data getById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return new Data(true, "success", mapper.map(userEntity, UserDto.class));
    }

    @Override
    public Data getByName(String username) {
        return null;
    }



    @Override
    public void add(UserEntity userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(userDto);
    }

    @Override
    public void getAll() {
        List<UserEntity> user = userRepository.findAll();
    }

    @Override
    public void update(Principal principal,UserEntity userUpdate) {
        UserEntity user = (UserEntity) ((Authentication) principal).getPrincipal();
        user.setName(userUpdate.getName());
        user.setPosition(userUpdate.getPosition());
        user.setDateOfBirth(userUpdate.getDateOfBirth());
    }

    @Override
    public Data deleteById(Long id) {
        return null;
    }
}
