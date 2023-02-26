package com.modulonion.mlapi.model;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
public class Score {
    @PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private UUID id;
    @Column
    private String name;
    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private int value;
    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private int gameid;

    public Score(int gameid, int value, UUID id, String name) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.gameid = gameid;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return value;
    }

    public int getGameId() {
        return gameid;
    }
}
