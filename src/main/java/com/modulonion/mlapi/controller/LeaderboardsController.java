package com.modulonion.mlapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("leaderboards")
public class LeaderboardsController {
    @GetMapping("/")
    public void GetLeaderboards() {
        System.out.println("Hello, World!");
    }
}
