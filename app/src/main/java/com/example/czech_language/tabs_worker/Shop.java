package com.example.czech_language.tabs_worker;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.czech_language.R;
import com.example.czech_language.static_worker.ProgressBarWorker;
import com.example.czech_language.statistic_worker.StatisticCreator;

public class Shop implements View.OnClickListener {

    Dialog alertDialogShop;
    ImageView buttonCloseShop, buttonGetReward;
    TextView textWithTime;
    Context context;
    ProgressBarWorker progressBarWorker;

    public Shop(Context context, Dialog alertDialogShop, ProgressBarWorker progressBarWorker) {
        this.alertDialogShop = alertDialogShop;
        alertDialogShop.setContentView(R.layout.shop_tab);

        // Регистрация кнопки "Закрыть":
        buttonCloseShop = alertDialogShop.findViewById(R.id.close_alert_dialog_shop);
        buttonCloseShop.setOnClickListener(this);

        // Регистрация кнопки "Награждение":
        buttonGetReward = alertDialogShop.findViewById(R.id.button_shop_reward);
        buttonGetReward.setOnClickListener(this);

        // Регистрация строки с оставшимся временем до получения игр:
        textWithTime = alertDialogShop.findViewById(R.id.shop_text_timer);

        this.progressBarWorker = progressBarWorker;
        this.context = context;
    }

    // Метод вывода окна с "Магазином":
    public void showShop() {
        alertDialogShop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialogShop.show();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close_alert_dialog_shop:
                alertDialogShop.dismiss();
                break;
            case R.id.button_shop_reward:
                getReward();
                break;
        }
    }

    // Запрос рекламы для получения дополнительных игр:
    public void getReward() {
        if (isConnectedInternet()) {
            Toast toastNoInternet = Toast.makeText(context.getApplicationContext(), "Получено 10 дополнительных игр!", Toast.LENGTH_SHORT);
            toastNoInternet.show();
            StatisticCreator.addRewardGames(context, progressBarWorker);
        } else {
            Toast toastNoInternet = Toast.makeText(context.getApplicationContext(), "Проверьте подключение к интернету!", Toast.LENGTH_SHORT);
            toastNoInternet.show();
        }
    }

    // Проверка наличия интернет-соединения на устройстве:
    public boolean isConnectedInternet() {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) return false;

        NetworkInfo[] info = connectivity.getAllNetworkInfo();
        if (info != null)
            for (NetworkInfo networkInfo : info) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) return true;
            }

        return false;
    }

    // Метод установки текста с оставшимся временем до получения игр:
    public void setTextWithTime(String lastTime) {
        textWithTime.setText(lastTime);
    }
}
