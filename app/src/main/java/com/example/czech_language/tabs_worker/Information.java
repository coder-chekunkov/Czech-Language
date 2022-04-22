package com.example.czech_language.tabs_worker;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.example.czech_language.R;

public class Information implements View.OnClickListener {

    Dialog alertDialogInformation;
    ImageView buttonCloseInfo;
    TextView textWithTime;

    public Information(Dialog alertDialogInformation) {
        this.alertDialogInformation = alertDialogInformation;
        alertDialogInformation.setContentView(R.layout.information_tab);

        // Регистрация кнопки "Закрыть":
        buttonCloseInfo = alertDialogInformation.findViewById(R.id.close_alert_dialog_information);
        buttonCloseInfo.setOnClickListener(this);

        // Регистрация строки с оставшимся временем до получения игр:
        textWithTime = alertDialogInformation.findViewById(R.id.information_text_timer);

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

    // Метод установки текста с оставшимся временем до получения игр:
    public void setTextWithTime(String lastTime) {
        textWithTime.setText(lastTime);
    }
}
