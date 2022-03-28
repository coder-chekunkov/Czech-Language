package com.example.czech_language.static_worker;

import java.util.Calendar;

public class TimeWorker implements Runnable{

    long hours, minutes, seconds;

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                Calendar c = Calendar.getInstance();
                hours = 24 - c.get(Calendar.HOUR_OF_DAY);
                minutes = 60 - c.get(Calendar.MINUTE);
                seconds = 60 - c.get(Calendar.SECOND);
                System.out.println(createTimeString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    // Создание строки с оставшимся временем до получения новых игр:
    public String createTimeString(){
        String timeString = "";

        if (hours < 10) timeString += "0" + hours + ":";
        else timeString += hours + ":";

        if (minutes < 10) timeString += "0" + minutes + ":";
        else timeString += minutes + ":";

        if (seconds < 10) timeString += "0";
        else timeString += seconds;

        return timeString;
    }


}
