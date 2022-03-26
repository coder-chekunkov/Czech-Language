package com.example.czech_language.tabs_worker;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.example.czech_language.R;

public class Shop implements View.OnClickListener {

    Dialog alertDialogShop;
    ImageView buttonCloseShop, buttonGetReward;

    public Shop(Dialog alertDialogShop) {
        this.alertDialogShop = alertDialogShop;
        alertDialogShop.setContentView(R.layout.shop_tab);

        // Регистрация кнопки "Закрыть":
        buttonCloseShop = alertDialogShop.findViewById(R.id.close_alert_dialog_shop);
        buttonCloseShop.setOnClickListener(this);

        // Регистрация кнопки "Награждение":
        buttonGetReward = alertDialogShop.findViewById(R.id.button_shop_reward);
        buttonGetReward.setOnClickListener(this);
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
                System.out.println("Pushed Button-Get-Rewards");
                break;
        }
    }
}
