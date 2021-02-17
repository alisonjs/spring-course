package com.springcourse.service;

import com.springcourse.domain.User;
import com.springcourse.repository.UserRepository;
import com.springcourse.service.util.HashUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user){
        String hash = HashUtil.getSecureHash(user.getPassword());
        user.setPassword(hash);
        return userRepository.save(user);
    }

    public User getById(Long id){
        Optional<User> result =  userRepository.findById(id);
        return result.orElse(null);
    }

    public List<User> listAll(){
        return userRepository.findAll();
    }

    public User login(String email, String password){
        Optional<User> result =  userRepository.login(email, HashUtil.getSecureHash(password));
        return result.orElse(null);
    }
}
