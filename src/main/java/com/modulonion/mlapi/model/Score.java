package com.modulonion.mlapi.model;

public class Score {
    private String name;
    private int value;
    private int gameId;

    public Score(String name, int score, int gameId) {
        this.name = name;
        this.value = score;
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return value;
    }

    public int getGameId() {
        return gameId;
    }
}
