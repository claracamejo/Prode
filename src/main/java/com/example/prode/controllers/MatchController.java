package com.example.prode.controllers;

import com.example.prode.dtos.MatchDTO;
import com.example.prode.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping
    @ResponseBody
    public String getMatches() {
        return "matches";
    }

    @PostMapping
    @ResponseBody
    public MatchDTO saveMatch(@RequestBody  MatchDTO match) {
        return matchService.saveMatch(match);
    }
}
