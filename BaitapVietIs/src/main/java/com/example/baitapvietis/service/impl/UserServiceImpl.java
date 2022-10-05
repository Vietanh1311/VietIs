package com.example.baitapvietis.service.impl;

import com.example.baitapvietis.model.dto.UserDto;
import com.example.baitapvietis.model.entity.UserEntity;
import com.example.baitapvietis.model.respone.Data;
import com.example.baitapvietis.repository.UserRepository;
import com.example.baitapvietis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import javax.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper mapper;
    private final UserRepository userRepository;

    public UserServiceImpl(ModelMapper mapper, UserRepository userRepository) {
        this.mapper = mapper;
        this.userRepository = userRepository;
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
        userRepository.save(userDto);
    }

    @Override
    public Data update(UserDto userDto, Long id) {
        return null;
    }

    @Override
    public Data deleteById(Long id) {
        return null;
    }
}
