package com.example.prode.entities;

import com.example.prode.dtos.AppUserDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String role;
    private Integer points;

    @OneToMany(mappedBy="appUser", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Bet> bets;

    public AppUserDTO toAppUserDTO() {
        AppUserDTO appUserDTO = new AppUserDTO();
        appUserDTO.setId(id);
        appUserDTO.setPassword(password);
        appUserDTO.setRole(role);
        appUserDTO.setPoints(points);
        appUserDTO.setUsername(username);
        return appUserDTO;
    }
}
