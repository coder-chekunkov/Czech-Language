package com.example.czech_language.tabs_worker;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.example.czech_language.R;

public class Statistic implements View.OnClickListener {

    Dialog alertDialogStatistic;
    ImageView buttonCloseStatistic;

    public Statistic(Dialog alertDialogStatistic) {
        this.alertDialogStatistic = alertDialogStatistic;
        alertDialogStatistic.setContentView(R.layout.statisitc_tab);

        // Регистрация кнопки "Закрыть":
        buttonCloseStatistic = alertDialogStatistic.findViewById(R.id.close_alert_dialog_statistic);
        buttonCloseStatistic.setOnClickListener(this);
    }

    // Метод вывода окна с "Статистика":
    public void showStatistic(){
        alertDialogStatistic.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialogStatistic.show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.close_alert_dialog_statistic)
            alertDialogStatistic.dismiss();
    }
}
