package com.example.czech_language.tabs_worker;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.example.czech_language.R;

public class Information implements View.OnClickListener {

    Dialog alertDialogInformation;
    ImageView buttonCloseInfo;

    public Information(Dialog alertDialogInformation) {
        this.alertDialogInformation = alertDialogInformation;
        alertDialogInformation.setContentView(R.layout.information_tab);

        // Регистрация кнопки "Закрыть":
        buttonCloseInfo = alertDialogInformation.findViewById(R.id.close_alert_dialog_information);
        buttonCloseInfo.setOnClickListener(this);
    }

    // Метод вывода окна с "Информация":
    public void showInformation() {
        alertDialogInformation.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialogInformation.show();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.close_alert_dialog_information)
            alertDialogInformation.dismiss();
    }
}
