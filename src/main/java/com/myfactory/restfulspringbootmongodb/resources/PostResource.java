package com.myfactory.restfulspringbootmongodb.resources;

import com.myfactory.restfulspringbootmongodb.domain.Post;
import com.myfactory.restfulspringbootmongodb.domain.User;
import com.myfactory.restfulspringbootmongodb.dto.UserDTO;
import com.myfactory.restfulspringbootmongodb.resources.util.URL;
import com.myfactory.restfulspringbootmongodb.services.PostService;
import com.myfactory.restfulspringbootmongodb.services.UserService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
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

    @GetMapping(value = "/titleSearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> posts = postService.findByTitleContaining(text);
        return ResponseEntity.ok().body(posts);
    }
//    @GetMapping(value = "/searchTitleDate")
//    public ResponseEntity<List<Post>> findByTextAndDate(
//            @RequestParam(value = "text", defaultValue = "") String text,
//            @RequestParam(value = "min", defaultValue = "") String min,
//            @RequestParam(value = "max", defaultValue = "") String max) {
//        text = URL.decodeParam(text);
//        LocalDate minDate = URL.convertLocalDate(min, LocalDate.now());
//        LocalDate maxDate = URL.convertLocalDate(max, LocalDate.now());
//        List<Post> posts = postService.findPostsByTextAndDate(text, minDate, maxDate);
//        return ResponseEntity.ok().body(posts);
//    }

}