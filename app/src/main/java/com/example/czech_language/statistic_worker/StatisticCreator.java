package com.example.czech_language.statistic_worker;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.czech_language.MenuActivity;
import com.example.czech_language.static_worker.ProgressBarWorker;

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

    // Изменение статистики после игры:
    public static void increaseStatistic(Context context, int good, int bad) {
        SharedPreferences mStatistic = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mStatistic.edit();

        int goodAnswers = mStatistic.getInt("good_answers", 0);
        int badAnswers = mStatistic.getInt("bas_answers", 0);
        int allAnswers = mStatistic.getInt("all_games", 0);
        int lastAnswers = mStatistic.getInt("last_games", 80);

        editor.putInt("good_answers", goodAnswers + good);
        editor.putInt("bas_answers", badAnswers + bad);
        editor.putInt("all_games", allAnswers + 1);
        editor.putInt("last_games", lastAnswers - 1);
        editor.apply();
    }

    // Сброс статистики пользователя:
    public void restartStatistic(Context context) {
        SharedPreferences mStatistic = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mStatistic.edit();

        editor.putInt("good_answers", 0);
        editor.putInt("bas_answers", 0);
        editor.putInt("all_games", 0);
        editor.putInt("last_games", 80);
        editor.apply();
    }

    // Получение количетсва всех сыгранных игр:
    public static int getGoodGames(Context context) {
        SharedPreferences mStatistic = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        return mStatistic.getInt("good_answers", 0);
    }

    // Получение количетсва отставшихся игр:
    public static int getLastGames(Context context) {
        SharedPreferences mStatistic = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        return mStatistic.getInt("last_games", 0);
    }
}
