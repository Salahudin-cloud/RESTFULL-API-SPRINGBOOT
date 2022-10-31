package com.example.learnapi.demo.Repository;

import com.example.learnapi.demo.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User , Long> {
}
