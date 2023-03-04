package com.modulonion.mlapi.controller;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.modulonion.mlapi.model.NameScorePair;
import com.modulonion.mlapi.model.Score;
import com.modulonion.mlapi.service.ScoreDataService;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("leaderboards")
public class LeaderboardsController {
    ScoreDataService scoreDataService;

    LeaderboardsController(final ScoreDataService scoreDataService) {
        this.scoreDataService = scoreDataService;
    }

    @PostMapping("/")
    public ResponseEntity<Integer> postScore(@RequestParam("scoreName") String scoreName,
                                                          @RequestParam("scoreValue") int scoreValue,
                                                          @RequestParam("gameId") int gameId) {
        Score newScore = new Score(gameId, scoreValue, Uuids.timeBased(), scoreName);
        if (scoreDataService.saveScoreToDatabase(newScore)) {
            int scorePosition = scoreDataService.getScorePosition(newScore);
            return ResponseEntity.ok(scorePosition);
        }
        else {
            return ResponseEntity.internalServerError()
                    .header("message", "Failed to save the provided score")
                    .build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<NameScorePair>> getLeaderboards(@RequestParam("gameId") int gameId) {
        List<NameScorePair> firstTen = scoreDataService.getFirstTen(gameId);
        return ResponseEntity.ok(firstTen);
    }
}
