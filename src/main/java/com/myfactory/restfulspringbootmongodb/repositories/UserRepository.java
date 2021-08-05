package com.myfactory.restfulspringbootmongodb.repositories;

import com.myfactory.restfulspringbootmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
