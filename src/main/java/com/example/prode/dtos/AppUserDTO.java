package com.example.prode.dtos;

import com.example.prode.entities.AppUser;
import lombok.Data;

@Data
public class AppUserDTO {

    private Long id;
    private String username;
    private String password;
    private String role;
    private Integer points;

    public AppUser toAppUser() {
        AppUser appUser = new AppUser();
        appUser.setId(id);
        appUser.setPassword(password);
        appUser.setRole(role);
        appUser.setPoints(points);
        appUser.setUsername(username);
        return appUser;
    }
}
