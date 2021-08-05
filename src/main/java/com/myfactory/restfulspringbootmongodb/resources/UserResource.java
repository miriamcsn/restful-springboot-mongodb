package com.myfactory.restfulspringbootmongodb.resources;

import com.myfactory.restfulspringbootmongodb.domain.User;
import com.myfactory.restfulspringbootmongodb.dto.UserDTO;
import com.myfactory.restfulspringbootmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userService.findAll();
        List<UserDTO> userDTOList = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(userDTOList);

//        User maria = new User("1", "Maria Brown", "maria@gmail.com");
//        User alex = new User("2", "Alex Green", "alex@gmail.com");
//        List<User> list = new ArrayList<>();
//        list.addAll(Arrays.asList(maria, alex));
//        return ResponseEntity.ok().body(list);

    }

}
