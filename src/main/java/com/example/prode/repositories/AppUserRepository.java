package com.example.prode.repositories;

import com.example.prode.entities.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {

    List<AppUser> findAll();

    AppUser findByUsername(String username);
}
