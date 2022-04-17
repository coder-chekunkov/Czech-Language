package com.example.czech_language.static_worker;

import android.widget.ImageButton;
import android.widget.ViewFlipper;
import com.example.czech_language.R;

public class CardChanger {

    ViewFlipper vf;
    ImageButton buttonPlay;
    boolean isGame = false;

    public CardChanger(ViewFlipper vf, ImageButton buttonPlay){
        this.vf = vf;
        this.buttonPlay = buttonPlay;
    }

    // Метод смены карточек "Описание" -> "Игра":
    public void changeCard(int vfNumber){
        vf.setDisplayedChild(vfNumber);
        if (vfNumber == 1){
            buttonPlay.setImageResource(R.drawable.icon_button_stop);
        } else {
            buttonPlay.setImageResource(R.drawable.icon_button_start);
        }
    }

    // Метод для смены карточек игры:
    public void startChanger() {
        int buffGame;
        if (!isGame) {
            buffGame = 1;
            isGame = true;
        } else {
            buffGame = 2;
            isGame = false;
        }
       changeCard(buffGame);
    }

}
