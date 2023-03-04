package com.modulonion.mlapi.model;

public class NameScorePair {
    private String name;
    private int score;

    public NameScorePair(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
