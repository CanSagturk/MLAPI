package com.modulonion.mlapi.controller;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.modulonion.mlapi.model.Score;
import com.modulonion.mlapi.repository.ScoreRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("leaderboards")
public class LeaderboardsController {
    ScoreRepository scoreRepository;

    LeaderboardsController(final ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @PostMapping("/")
    public ResponseEntity<List<Score>> postScore(@RequestParam("scoreName") String scoreName,
                                                 @RequestParam("scoreValue") int scoreValue,
                                                 @RequestParam("gameId") int gameId) {
        Score newScore = new Score(gameId, scoreValue, Uuids.timeBased(), scoreName);
        scoreRepository.save(newScore);
        List<Score> firstTen = scoreRepository.findFirstTen(gameId);
        return ResponseEntity.ok(firstTen);
    }

    @GetMapping("/")
    public ResponseEntity<List<Score>> getLeaderboards(@RequestParam("gameId") int gameId) {
        List<Score> firstTen = scoreRepository.findFirstTen(gameId);
        return ResponseEntity.ok(firstTen);
    }
}
