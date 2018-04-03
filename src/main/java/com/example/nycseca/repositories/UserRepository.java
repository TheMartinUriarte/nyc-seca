package com.example.nycseca.repositories;

import com.example.nycseca.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}