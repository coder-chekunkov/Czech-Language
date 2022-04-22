package com.example.czech_language.static_worker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import com.example.czech_language.MenuActivity;

import java.util.Locale;

public class TimeWorker extends MenuActivity {


    // Создание строки со временем:
    public static String createStringWithTime(long lastTime) {
        int hours = (int) (lastTime / 3600000);
        int minutes = (int) lastTime / 60000 % 60;
        int seconds = (int) lastTime / 1000 % 60;

        return String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);
    }

    // Метод записи переменных для работы с таймером в файл:
    public static void setTimerPreferences(Context context, long mTimeLeftInMillis,
                                           boolean mTimerRunning, long mEndTime,
                                           CountDownTimer mCountDownTimer) {

    }

    public static void getTimerPreferences(Context context){

    }


}
