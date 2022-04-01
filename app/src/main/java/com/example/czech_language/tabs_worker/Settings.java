package com.example.czech_language.tabs_worker;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.czech_language.MenuActivity;
import com.example.czech_language.R;
import com.example.czech_language.statistic_worker.StatisticCreator;

public class Settings extends MenuActivity implements View.OnClickListener {

    Dialog alertDialogSettings;
    ImageView buttonCloseSettings, buttonCallDevelop, buttonReview, buttonRestart;
    Context context;

    public Settings(Context context, Dialog alertDialogSettings) {
        this.alertDialogSettings = alertDialogSettings;
        alertDialogSettings.setContentView(R.layout.settings_tab);
        this.context = context;

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
                sendMessageToDevelop();
                break;
            case R.id.button_settings_review:
                leaveReview();
                break;
            case R.id.button_settings_restart:
                restartGame();
                break;
        }
    }

    // Метод перехода на страницу приложения в Google PlayMarket:
    public void leaveReview() {
        Intent browserReview = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=acproject_czechlanguage.czech_language"));
        context.startActivity(browserReview);
        alertDialogSettings.dismiss();
    }

    // Метод отправки сообщения разрботчикам:
    public void sendMessageToDevelop() {
        Intent intent_call_us = new Intent(Intent.ACTION_SEND);
        intent_call_us.putExtra(Intent.EXTRA_EMAIL, "czech.language@yandex.ru");
        intent_call_us.putExtra(Intent.EXTRA_TEXT, "Здравствуйте, команада разработчиков приложения \"Чешский Язык\",");
        intent_call_us.setType("message/rfc822");
        context.startActivity(Intent.createChooser(intent_call_us, "Выберите Приложение:"));
    }

    // Метод сброса статистики пользователя:
    public void restartGame() {
        StatisticCreator statisticCreator = new StatisticCreator();
        statisticCreator.restartStatistic(context);

        Toast toastRestartGame = Toast.makeText(context.getApplicationContext(), "Статистика сброшена!", Toast.LENGTH_SHORT);
        toastRestartGame.show();

        alertDialogSettings.dismiss();
    }
}
