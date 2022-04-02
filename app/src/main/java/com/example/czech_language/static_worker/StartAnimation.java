package com.example.czech_language.static_worker;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.czech_language.R;

public class StartAnimation {

    ImageButton buttonPlay, buttonShop, buttonInformation, buttonCardViewDescription, buttonCardViewGame;
    View firstLine, secondLine, thirdLine;

    public StartAnimation(ImageButton buttonPlay, ImageButton buttonShop, ImageButton buttonInformation,
                          ImageButton buttonCardViewDescription, ImageButton buttonCardViewGame,
                          View firstLine, View secondLine, View thirdLine) {
        this.buttonPlay = buttonPlay;
        this.buttonShop = buttonShop;
        this.buttonInformation = buttonInformation;
        this.buttonCardViewDescription = buttonCardViewDescription;
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.thirdLine = thirdLine;
        this.buttonCardViewGame = buttonCardViewGame;
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

        // Запуск анимации "Картинки":
        AnimationDrawable animationDrawableButtonCardViewGame = (AnimationDrawable) buttonCardViewGame.getBackground();
        animationDrawableButtonCardViewGame.setEnterFadeDuration(100);
        animationDrawableButtonCardViewGame.setExitFadeDuration(500);
        animationDrawableButtonCardViewGame.start();

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

    // Метод появления текста игры:
    public static void startAppearText(Context context, TextView czWord, TextView ruWord) {
        final Animation animTextAppear = AnimationUtils.loadAnimation(context, R.anim.anim_text_start);

        czWord.startAnimation(animTextAppear);
        ruWord.startAnimation(animTextAppear);
    }

    // Метод создания и показ изображений с результатом ответа:
    public static void animationImgResult(Context context, boolean answer, ImageButton firstSmile, ImageButton secondSmile) {
        final Animation animImgAppear = AnimationUtils.loadAnimation(context, R.anim.anim_img);
        if (answer) {
            firstSmile.setImageResource(R.drawable.good_smile);
            secondSmile.setImageResource(R.drawable.good_smile);
        } else {
            firstSmile.setImageResource(R.drawable.wrong_smile);
            secondSmile.setImageResource(R.drawable.wrong_smile);
        }
        firstSmile.setVisibility(View.VISIBLE);
        secondSmile.setVisibility(View.VISIBLE);
        firstSmile.startAnimation(animImgAppear);
        secondSmile.startAnimation(animImgAppear);
        firstSmile.setVisibility(View.INVISIBLE);
        secondSmile.setVisibility(View.INVISIBLE);
    }
}
