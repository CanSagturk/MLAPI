package com.modulonion.mlapi.controller;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.modulonion.mlapi.model.Score;
import com.modulonion.mlapi.repository.ScoreRepository;
import com.modulonion.mlapi.service.ScoreDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("leaderboards")
public class LeaderboardsController {
    ScoreDataService scoreDataService;

    LeaderboardsController(final ScoreDataService scoreDataService) {
        this.scoreDataService = scoreDataService;
    }

    @PostMapping("/")
    public ResponseEntity<List<Score>> postScore(@RequestParam("scoreName") String scoreName,
                                                 @RequestParam("scoreValue") int scoreValue,
                                                 @RequestParam("gameId") int gameId) {
        Score newScore = new Score(gameId, scoreValue, Uuids.timeBased(), scoreName);
        scoreDataService.saveScoreToDatabase(newScore);
        List<Score> firstTen = scoreDataService.getFirstTen(gameId);
        return ResponseEntity.ok(firstTen);
    }

    @GetMapping("/")
    public ResponseEntity<List<Score>> getLeaderboards(@RequestParam("gameId") int gameId) {
        List<Score> firstTen = scoreDataService.getFirstTen(gameId);
        return ResponseEntity.ok(firstTen);
    }
}
