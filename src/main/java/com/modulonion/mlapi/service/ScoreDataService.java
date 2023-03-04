package com.modulonion.mlapi.service;

import com.modulonion.mlapi.model.Score;
import com.modulonion.mlapi.repository.ScoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreDataService {
    ScoreRepository scoreRepository;

    ScoreDataService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    /**
     * Saves the provided {@link Score} to the database
     * @param score to be saved
     * @return whether the saved {@link Score} is the same one as the provided
     */
    public boolean saveScoreToDatabase(Score score) {
        return score.equals(scoreRepository.save(score));
    }

    /**
     *
     * @param gameId of the game we're retrieving the scores of
     * @return 
     */
    public List<Score> getFirstTen(int gameId) {
        return scoreRepository.findFirstTen(gameId);
    }
}
