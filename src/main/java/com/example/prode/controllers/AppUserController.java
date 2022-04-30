package com.example.prode.controllers;

import com.example.prode.dtos.AppUserDTO;
import com.example.prode.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app_users")
public class AppUserController {

    private final AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping
    @ResponseBody
    public List<AppUserDTO> getAppUsers() {
        return this.appUserService.getAllAppUsers();
    }

    @PostMapping
    @ResponseBody
    public AppUserDTO saveAppUser(@RequestBody AppUserDTO match) {
        return appUserService.save(match);
    }
}
