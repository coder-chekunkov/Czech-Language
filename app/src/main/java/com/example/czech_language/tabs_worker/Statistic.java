package com.example.czech_language.tabs_worker;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.czech_language.MenuActivity;
import com.example.czech_language.R;
import com.example.czech_language.json_worker.statistic.ReadJSONStatistic;
import com.example.czech_language.json_worker.statistic.StatisticFromJSON;
import org.json.JSONException;

import java.io.IOException;

public class Statistic extends MenuActivity implements View.OnClickListener {

    Dialog alertDialogStatistic;
    ImageView buttonCloseStatistic;
    TextView countGoodAnswers, countBadAnswers, countAllGames, countLastGames;
    Context context;

    public Statistic(Context context, Dialog alertDialogStatistic) {
        this.alertDialogStatistic = alertDialogStatistic;
        alertDialogStatistic.setContentView(R.layout.statisitc_tab);
        this.context = context;

        // Регистрация кнопки "Закрыть":
        buttonCloseStatistic = alertDialogStatistic.findViewById(R.id.close_alert_dialog_statistic);
        buttonCloseStatistic.setOnClickListener(this);

        // Регистрация надписей для вывода статистики:
        countGoodAnswers = alertDialogStatistic.findViewById(R.id.count_good_answers);
        countBadAnswers = alertDialogStatistic.findViewById(R.id.count_bad_answers);
        countAllGames = alertDialogStatistic.findViewById(R.id.text_count_all_answers);
        countLastGames = alertDialogStatistic.findViewById(R.id.count_last_questions);
    }

    // Метод вывода окна с "Статистика":
    public void showStatistic() {
        alertDialogStatistic.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialogStatistic.show();

        // Вывод статистических данных:
        try {
            // Получение данных:
            StatisticFromJSON statistic = ReadJSONStatistic.readStatisticJSONFile(context);
            String goodAnswers, badAnswers, allGames, lastGames;

            // Проверка данных:
            if (statistic.getGoodAnswers() > 999) goodAnswers = "999+";
            else goodAnswers = String.valueOf(statistic.getGoodAnswers());

            if (statistic.getBadAnswers() > 999) badAnswers = "999+";
            else badAnswers = String.valueOf(statistic.getBadAnswers());

            if (statistic.getAllGames() > 999) allGames = "999+";
            else allGames = String.valueOf(statistic.getAllGames());

            if (statistic.getLastGames() > 999) lastGames = "999+";
            else lastGames = String.valueOf(statistic.getLastGames());

            // Вывод данных:
            countGoodAnswers.setText(goodAnswers);
            countBadAnswers.setText(badAnswers);
            countAllGames.setText(allGames);
            countLastGames.setText(lastGames);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.close_alert_dialog_statistic)
            alertDialogStatistic.dismiss();
    }
}
