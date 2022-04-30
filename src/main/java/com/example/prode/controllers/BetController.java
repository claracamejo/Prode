package com.example.prode.controllers;

import com.example.prode.dtos.BetDTO;
import com.example.prode.services.BetService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/bets", consumes = {"application/json"})
public class BetController {

    private BetService betService;

    public BetController(BetService betService) {
        this.betService = betService;
    }

    @PostMapping(consumes = {"application/json"})
    @ResponseBody
    public BetDTO save(@RequestBody BetDTO betDTO) {
        return betService.save(betDTO);
    }
}
