package com.myfactory.restfulspringbootmongodb.repositories;

import com.myfactory.restfulspringbootmongodb.domain.Post;
import com.myfactory.restfulspringbootmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
    //esse metodo faz a msma coisa do de baixo, mas é mais simples

    @Query("{ 'title' : { $regex: ?0, $options: 'i' } }")  // ?0 primeiro parametro do metodo; i = case insensitive
    List<Post> searchTitle(String text);

//    @Query("{ $and: [ { date: { $gte: ?1 } }, { date: { $lte: ?2 } }, { $or: [ { ’title' : { $regex: ?0, $options: 'i' } }, {‘body' : { $regex: ?0, $options: 'i' } }, { ‘comments.text' : { $regex: ?0, $options: 'i' } } ] } ] }")
//    List<Post> findPostsByTextAndDate(String text, LocalDate min, LocalDate max);
}
