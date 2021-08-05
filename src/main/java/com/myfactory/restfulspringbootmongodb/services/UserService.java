package com.myfactory.restfulspringbootmongodb.services;

import com.myfactory.restfulspringbootmongodb.domain.User;
import com.myfactory.restfulspringbootmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
