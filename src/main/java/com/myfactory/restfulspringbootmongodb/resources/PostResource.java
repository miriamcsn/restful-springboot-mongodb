package com.myfactory.restfulspringbootmongodb.resources;

import com.myfactory.restfulspringbootmongodb.domain.Post;
import com.myfactory.restfulspringbootmongodb.domain.User;
import com.myfactory.restfulspringbootmongodb.dto.UserDTO;
import com.myfactory.restfulspringbootmongodb.services.PostService;
import com.myfactory.restfulspringbootmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}