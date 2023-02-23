package com.modulonion.mlapi.controller;

import com.modulonion.mlapi.model.Score;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("leaderboards")
public class LeaderboardsController {
    @PostMapping("/")
    public ResponseEntity<List<Score>> postScore(@RequestParam("scoreName") String scoreName,
                                                 @RequestParam("scoreValue") int scoreValue) {
        List<Score> tempList = new ArrayList<>();
        tempList.add(new Score("Player 1", 100));
        tempList.add(new Score("Player 2", 120));
        tempList.add(new Score(scoreName, scoreValue));
        return ResponseEntity.ok(tempList);
    }

    @GetMapping("/")
    public void GetLeaderboards() {
        System.out.println("Hello, World!");
    }
}
