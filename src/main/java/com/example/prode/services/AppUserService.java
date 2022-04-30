package com.example.prode.services;

import com.example.prode.dtos.AppUserDTO;
import com.example.prode.entities.AppUser;
import com.example.prode.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserService {

    private AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AppUserDTO save(AppUserDTO appUserDTO) {
        AppUser appUser = appUserDTO.toAppUser();
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        this.appUserRepository.save(appUser);
        return appUser.toAppUserDTO();
    }

    public List<AppUserDTO> getAllAppUsers() {
        return this.appUserRepository
                .findAll()
                .stream()
                .map(appUser -> appUser.toAppUserDTO())
                .collect(Collectors.toList());
    }

    public AppUser findByUsername(String username) {
        return this.appUserRepository.findByUsername(username);
    }
}
