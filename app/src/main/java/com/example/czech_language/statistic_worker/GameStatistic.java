package com.example.czech_language.statistic_worker;

public class GameStatistic {

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
