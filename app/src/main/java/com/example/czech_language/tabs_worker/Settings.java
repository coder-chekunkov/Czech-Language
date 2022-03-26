package com.example.czech_language.tabs_worker;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.example.czech_language.R;

public class Settings implements View.OnClickListener {

    Dialog alertDialogSettings;
    ImageView buttonCloseSettings, buttonCallDevelop, buttonReview, buttonRestart;

    public Settings(Dialog alertDialogSettings) {
        this.alertDialogSettings = alertDialogSettings;
        alertDialogSettings.setContentView(R.layout.settings_tab);

        // Регистрация кнопки "Закрыть":
        buttonCloseSettings = alertDialogSettings.findViewById(R.id.close_alert_dialog_settings);
        buttonCloseSettings.setOnClickListener(this);

        // Регистрация кнопки "Связь с разработчиками":
        buttonCallDevelop = alertDialogSettings.findViewById(R.id.button_settings_call);
        buttonCallDevelop.setOnClickListener(this);

        // Регистрация кнопки "Отзыв":
        buttonReview = alertDialogSettings.findViewById(R.id.button_settings_review);
        buttonReview.setOnClickListener(this);

        // Регистрация кнопки "Сбросить статистику":
        buttonRestart = alertDialogSettings.findViewById(R.id.button_settings_restart);
        buttonRestart.setOnClickListener(this);
    }

    // Метод вывода окна с "Настройки":
    public void showSettings() {
        alertDialogSettings.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialogSettings.show();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close_alert_dialog_settings:
                alertDialogSettings.dismiss();
                break;
            case R.id.button_settings_call:
                System.out.println("Pushed Button-Call-Develop");
                break;
            case R.id.button_settings_review:
                System.out.println("Pushed Button-Review");
                break;
            case R.id.button_settings_restart:
                System.out.println("Pushed Button-Restart");
                break;
        }
    }
}
