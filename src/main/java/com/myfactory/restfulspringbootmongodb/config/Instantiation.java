package com.myfactory.restfulspringbootmongodb.config;

import com.myfactory.restfulspringbootmongodb.domain.Post;
import com.myfactory.restfulspringbootmongodb.domain.User;
import com.myfactory.restfulspringbootmongodb.dto.AuthorDTO;
import com.myfactory.restfulspringbootmongodb.dto.CommentDTO;
import com.myfactory.restfulspringbootmongodb.repositories.PostRepository;
import com.myfactory.restfulspringbootmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    @Override
    public void run(String... args) throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        userRepository.deleteAll(); // limpa a coleção que está no banco de dados
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(
                null,
                "Partiu viagem!",
                "Vou viajar para SP, abraços",
                LocalDate.parse("21/03/2018", formatter), new AuthorDTO(maria));

        Post post2 = new Post(
                null,
                "Bom dia!",
                "Acordei feliz hoje",
                LocalDate.parse("23/03/2018", formatter), new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO(
                "Boa viagem mano!",
                LocalDate.parse("21/03/2018", formatter),
                new AuthorDTO(alex)
                );

        CommentDTO c2 = new CommentDTO(
                "Aproveite!",
                LocalDate.parse("22/03/2018", formatter),
                new AuthorDTO(bob)
        );

        CommentDTO c3 = new CommentDTO(
                "Tenha um ótimo dia!",
                LocalDate.parse("23/03/2018", formatter),
                new AuthorDTO(alex)
        );

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);

    }
}
