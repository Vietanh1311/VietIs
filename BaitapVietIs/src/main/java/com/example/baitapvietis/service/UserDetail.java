package com.example.baitapvietis.service;

import com.example.baitapvietis.model.entity.UserEntity;
import com.example.baitapvietis.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetail implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetail(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(username);
        System.out.println(user);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
//        return new CustomUserDetails(user);
<<<<<<< HEAD
        return  user;
=======
        return user;
>>>>>>> origin/main
    }
}
