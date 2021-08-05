package com.myfactory.restfulspringbootmongodb.services;

import com.myfactory.restfulspringbootmongodb.domain.Post;
import com.myfactory.restfulspringbootmongodb.repositories.PostRepository;
import com.myfactory.restfulspringbootmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found. "));
    }

    public List<Post> findByTitleContaining(String text) {
//        return postRepository.findByTitleContainingIgnoreCase(text);
        // a linha de cima funciona normalmente - para funcionar, descomentar e comentar essa de baixo
        return postRepository.searchTitle(text);
    }
}
