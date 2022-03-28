package com.example.czech_language.json_worker.statistic;

public class StatisticFromJSON {

    // Все статистические данные:
    int goodAnswers, badAnswers, allGames, lastGames;

    public void setGoodAnswers(int goodAnswers) {
        this.goodAnswers = goodAnswers;
    }

    public void setBadAnswers(int badAnswers) {
        this.badAnswers = badAnswers;
    }

    public void setAllGames(int allGames) {
        this.allGames = allGames;
    }

    public void setLastGames(int lastGames) {
        this.lastGames = lastGames;
    }

    public int getGoodAnswers() {
        return goodAnswers;
    }

    public int getBadAnswers() {
        return badAnswers;
    }

    public int getAllGames() {
        return allGames;
    }

    public int getLastGames() {
        return lastGames;
    }
}
