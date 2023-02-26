package com.modulonion.mlapi.repository;

import com.modulonion.mlapi.model.Score;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ScoreRepository extends CassandraRepository<Score, UUID> {
    @Query("SELECT * FROM scores_db.score WHERE gameid = ?0 LIMIT 10")
    List<Score> findFirstTen(Integer gameId);
}
