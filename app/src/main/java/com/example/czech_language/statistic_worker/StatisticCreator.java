package com.example.czech_language.statistic_worker;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.czech_language.MenuActivity;

public class StatisticCreator extends MenuActivity {

    public static final String APP_PREFERENCES = "statistic";

    // Получение статистики пользователя:
    public GameStatistic getStatistic(Context context) {

        SharedPreferences mStatistic = context.getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);

        GameStatistic statistic = new GameStatistic();
        statistic.setGoodAnswers(mStatistic.getInt("good_answers", 0));
        statistic.setBadAnswers(mStatistic.getInt("bas_answers", 0));
        statistic.setAllGames(mStatistic.getInt("all_games", 0));
        statistic.setLastGames(mStatistic.getInt("last_games", 80));

        return statistic;
    }

    // Сброс статистики пользователя:
    public void restartStatistic(Context context) {
        SharedPreferences mStatistic = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mStatistic.edit();
        editor.putInt("good_answers", 0);
        editor.putInt("bas_answers", 0);
        editor.putInt("all_games", 0);
        editor.apply();
    }
}
