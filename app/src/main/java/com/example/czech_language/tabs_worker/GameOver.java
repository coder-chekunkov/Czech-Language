package com.example.czech_language.tabs_worker;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import com.example.czech_language.R;

public class GameOver implements View.OnClickListener {

    Dialog alertDialogGameOver;
    ImageView buttonCloseGameOver;

    public GameOver(Dialog alertDialogGameOver) {
        this.alertDialogGameOver = alertDialogGameOver;
        alertDialogGameOver.setContentView(R.layout.gameower_tab);

        // Регистрация кнопки "Закрыть":
        buttonCloseGameOver = alertDialogGameOver.findViewById(R.id.close_alert_dialog_no_game_more);
        buttonCloseGameOver.setOnClickListener(this);
    }

    // Метод вывода окна с "Конец Игры":
    public void showGameOver() {
        alertDialogGameOver.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialogGameOver.show();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.close_alert_dialog_no_game_more)
            alertDialogGameOver.dismiss();
    }
}
