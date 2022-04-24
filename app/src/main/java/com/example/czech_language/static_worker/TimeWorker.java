package com.example.czech_language.static_worker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import com.example.czech_language.statistic_worker.StatisticCreator;
import com.example.czech_language.tabs_worker.GameOver;
import com.example.czech_language.tabs_worker.Information;
import com.example.czech_language.tabs_worker.Shop;
import java.util.Locale;

import static android.content.Context.MODE_PRIVATE;

public class TimeWorker {

    // Переменные для работы с таймером:
    CountDownTimer mCountDownTimer;
    public static final String APP_PREFERENCES = "time";
    private static long mTimeLeftInMillis = 86400000;
    private boolean mTimerRunning;
    private long mEndTime;

    Information informationWorker;
    Shop shopWorker;
    GameOver gameOverWorker;
    StatisticCreator statisticCreator;
    ProgressBarWorker progressBarWorker;
    Context context;

    public TimeWorker(Context context, Information informationWorker, Shop shopWorker, GameOver gameOverWorker,
                      StatisticCreator statisticCreator, ProgressBarWorker progressBarWorker) {
        this.context = context;
        this.informationWorker = informationWorker;
        this.shopWorker = shopWorker;
        this.gameOverWorker = gameOverWorker;
        this.statisticCreator = statisticCreator;
        this.progressBarWorker = progressBarWorker;
    }

    // Запуск работы таймера с отсчетом времени для получения новых игр:
    public void startTimer(Context context) {
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis;
        mTimerRunning = true;

        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;

                String lastTime = createStringWithTime(millisUntilFinished);
                informationWorker.setTextWithTime(lastTime);
                shopWorker.setTextWithTime(lastTime);
                gameOverWorker.setTextWithTime(lastTime);
            }

            @Override
            public void onFinish() {
                statisticCreator.getNewEverydayGames(context);
                progressBarWorker.setProgress();

                mTimeLeftInMillis = 86400000;
                startTimer(context);
            }

        }.start();
    }

    // Метод записи переменных для работы с таймером в файл:
    public void setTimerPreferences() {
        SharedPreferences prefs = context.getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putBoolean("timerRunning", mTimerRunning);
        editor.putLong("millisLeft", mTimeLeftInMillis);
        editor.putLong("endTime", mEndTime);
        editor.apply();
    }

    // Метод получения переменных для работы с таймером из файла:
    public void getTimerPreferences() {
        SharedPreferences prefs = context.getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);

        mTimeLeftInMillis = prefs.getLong("millisLeft", 86400000);
        mTimerRunning = prefs.getBoolean("timerRunning", false);
        mEndTime = prefs.getLong("endTime", 0);

        if (mTimerRunning) {
            mTimeLeftInMillis = mEndTime - System.currentTimeMillis();

            if (mTimeLeftInMillis < 0) {
                statisticCreator.getNewEverydayGames(context);
                progressBarWorker.setProgress();

                mTimeLeftInMillis = 86400000;
            }
        }

        startTimer(context);
    }

    // Создание строки со временем:
    public static String createStringWithTime(long lastTime) {
        int hours = (int) (lastTime / 3600000);
        int minutes = (int) lastTime / 60000 % 60;
        int seconds = (int) lastTime / 1000 % 60;

        return String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);
    }

}
