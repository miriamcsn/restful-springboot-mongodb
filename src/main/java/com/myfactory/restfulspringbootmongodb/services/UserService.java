package com.myfactory.restfulspringbootmongodb.services;

import com.myfactory.restfulspringbootmongodb.domain.User;
import com.myfactory.restfulspringbootmongodb.repositories.UserRepository;
import com.myfactory.restfulspringbootmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found. "));
    }

}
