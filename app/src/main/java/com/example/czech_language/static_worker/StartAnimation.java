package com.example.czech_language.static_worker;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageButton;

public class StartAnimation {

    ImageButton buttonPlay, buttonShop, buttonInformation, buttonCardViewDescription;
    View firstLine, secondLine, thirdLine;

    public StartAnimation(ImageButton buttonPlay, ImageButton buttonShop, ImageButton buttonInformation,
                          ImageButton buttonCardViewDescription, View firstLine, View secondLine, View thirdLine) {
        this.buttonPlay = buttonPlay;
        this.buttonShop = buttonShop;
        this.buttonInformation = buttonInformation;
        this.buttonCardViewDescription = buttonCardViewDescription;
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.thirdLine = thirdLine;
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

        // Запуск анимации "Картинки":
        AnimationDrawable animationDrawableButtonCardViewDescription = (AnimationDrawable) buttonCardViewDescription.getBackground();
        animationDrawableButtonCardViewDescription.setEnterFadeDuration(100);
        animationDrawableButtonCardViewDescription.setExitFadeDuration(500);
        animationDrawableButtonCardViewDescription.start();

        // Запуск анимации "Первой линии":
        AnimationDrawable animationDrawableFirstLine = (AnimationDrawable) firstLine.getBackground();
        animationDrawableFirstLine.setEnterFadeDuration(100);
        animationDrawableFirstLine.setExitFadeDuration(500);
        animationDrawableFirstLine.start();

        // Запуск анимации "Второй линии":
        AnimationDrawable animationDrawableSecondLine = (AnimationDrawable) secondLine.getBackground();
        animationDrawableSecondLine.setEnterFadeDuration(100);
        animationDrawableSecondLine.setExitFadeDuration(500);
        animationDrawableSecondLine.start();

        // Запуск анимации "Третьей линии":
        AnimationDrawable animationDrawableThirdLine = (AnimationDrawable) thirdLine.getBackground();
        animationDrawableThirdLine.setEnterFadeDuration(100);
        animationDrawableThirdLine.setExitFadeDuration(500);
        animationDrawableThirdLine.start();

    }

}
