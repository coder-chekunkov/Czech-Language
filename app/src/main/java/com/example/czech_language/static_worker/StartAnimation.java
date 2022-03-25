package com.example.czech_language.static_worker;

import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageButton;

public class StartAnimation {

    ImageButton buttonPlay, buttonShop, buttonInformation;

    public StartAnimation(ImageButton buttonPlay, ImageButton buttonShop, ImageButton buttonInformation) {
        this.buttonPlay = buttonPlay;
        this.buttonShop = buttonShop;
        this.buttonInformation = buttonInformation;
    }

    public void startAnimation() {
        // Запуск анимации кнопки "Играть":
        AnimationDrawable animationDrawablePlay = (AnimationDrawable) buttonPlay.getBackground();
        animationDrawablePlay.setEnterFadeDuration(500);
        animationDrawablePlay.setExitFadeDuration(1000);
        animationDrawablePlay.start();

        // Запуск анимации кнопки "Магазин":
        AnimationDrawable animationDrawableShop = (AnimationDrawable) buttonShop.getBackground();
        animationDrawableShop.setEnterFadeDuration(500);
        animationDrawableShop.setExitFadeDuration(1000);
        animationDrawableShop.start();

        // Запуск анимации кнопки "Информация":
        AnimationDrawable animationDrawableInformation = (AnimationDrawable) buttonInformation.getBackground();
        animationDrawableInformation.setEnterFadeDuration(500);
        animationDrawableInformation.setExitFadeDuration(1000);
        animationDrawableInformation.start();
    }

}
