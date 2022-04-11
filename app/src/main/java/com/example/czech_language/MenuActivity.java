package com.example.czech_language;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.czech_language.game_worker.GameCreator;
import com.example.czech_language.static_worker.CardChanger;
import com.example.czech_language.static_worker.ProgressBarWorker;
import com.example.czech_language.static_worker.StartAnimation;
import com.example.czech_language.tabs_worker.*;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton buttonStatistic, buttonSettings, buttonShop, buttonInformation, buttonPlay,
            buttonCardViewDescription, buttonCardViewGame, buttonAnswerYes, buttonAnswerNo,
            firstSmile, secondSmile;
    ProgressBar pbAllSolutionProblems, pbTodaySolutionProblems;
    TextView twAllSolutionProblems, twTodaySolutionProblems, czWord, ruWord;

    Dialog alertDialogShop, alertDialogInformation, alertDialogSettings, alertDialogStatistic, alertDialogGameOver;
    Shop shopWorker;
    Information informationWorker;
    Settings settingsWorker;
    Statistic statisticWorker;
    GameOver gameOverWorker;
    GameCreator gameCreator;
    ProgressBarWorker progressBarWorker;

    View firstLine, secondLine, thirdLine;

    RelativeLayout layoutDescription;
    ViewFlipper vf;
    CardChanger cardChanger;
    boolean isGame = false;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Регистрация надписей со словами игры:
        czWord = findViewById(R.id.text_game_one);
        ruWord = findViewById(R.id.text_game_two);

        // Регистрация кнопок "Да" и "Нет" для игры:
        buttonAnswerYes = findViewById(R.id.button_answer_yes);
        buttonAnswerNo = findViewById(R.id.button_answer_no);

        // Регистрация изображений с результатом ответа:
        firstSmile = findViewById(R.id.smile_one);
        firstSmile.setVisibility(View.INVISIBLE);
        secondSmile = findViewById(R.id.smile_two);
        secondSmile.setVisibility(View.INVISIBLE);

        // Регистрация прогресс-баров:
        pbAllSolutionProblems = findViewById(R.id.progressBar_decided_questions);
        pbTodaySolutionProblems = findViewById(R.id.progressBar_last_questions);

        // Регистрация надписей с решенными вопросами:
        twAllSolutionProblems = findViewById(R.id.text_decided_questions);
        twTodaySolutionProblems = findViewById(R.id.text_last_questions);

        // Регистрация кнопки "Статистика":
        buttonStatistic = findViewById(R.id.button_network);
        buttonStatistic.setOnClickListener(this);

        // Регистрация кнопки "Настройки":
        buttonSettings = findViewById(R.id.button_settings);
        buttonSettings.setOnClickListener(this);

        // Регистрация кнопки "Магазин":
        buttonShop = findViewById(R.id.button_shop);
        buttonShop.setOnClickListener(this);

        // Регистрация кнопки "Информация":
        buttonInformation = findViewById(R.id.button_information);
        buttonInformation.setOnClickListener(this);

        // Регистрация кнопки "Играть":
        buttonPlay = findViewById(R.id.button_play_game);
        buttonPlay.setOnClickListener(this);

        // Регистрация объектов на карточке "Описание":
        firstLine = findViewById(R.id.card_view_view_one);
        secondLine = findViewById(R.id.card_view_view_two);
        thirdLine = findViewById(R.id.card_view_game_one);
        buttonCardViewDescription = findViewById(R.id.image_button_card_view_start);
        buttonCardViewGame = findViewById(R.id.image_view_card_view_game_play);

        // Регистрация "смены карточкек":
        vf = findViewById(R.id.vf);
        cardChanger = new CardChanger(vf, buttonPlay);
        layoutDescription = findViewById(R.id.relative_layout_game);
        layoutDescription.setOnClickListener(this);

        // Запуск анимации всех кнопок:
        StartAnimation startAnimation = new StartAnimation(buttonPlay, buttonShop, buttonInformation,
                buttonCardViewDescription, buttonCardViewGame, firstLine, secondLine, thirdLine);
        startAnimation.startAnimation();

        // Устновка значений в шкалы:
        progressBarWorker = new ProgressBarWorker(this, pbAllSolutionProblems, pbTodaySolutionProblems,
                twAllSolutionProblems, twTodaySolutionProblems);
        progressBarWorker.setProgress();

        gameCreator = new GameCreator(this, czWord, ruWord, buttonAnswerYes, buttonAnswerNo,
                firstSmile, secondSmile, progressBarWorker);

        // Регистрастрация "Магазина":
        alertDialogShop = new Dialog(this);
        shopWorker = new Shop(this, alertDialogShop);

        // Регистрастрация "Информации":
        alertDialogInformation = new Dialog(this);
        informationWorker = new Information(alertDialogInformation);

        // Регистрастрация "Настройки":
        alertDialogSettings = new Dialog(this);
        settingsWorker = new Settings(this, alertDialogSettings, progressBarWorker);

        // Регистрастрация "Статистика":
        alertDialogStatistic = new Dialog(this);
        statisticWorker = new Statistic(this, alertDialogStatistic);

        // Регистрастрация "Конец игры":
        alertDialogGameOver = new Dialog(this);
        gameOverWorker = new GameOver(alertDialogGameOver);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // Нажатие на кнопку "Статистика":
            case R.id.button_network:
                statisticWorker.showStatistic();
                break;
            // Нажатие на кнопку "Настройки":
            case R.id.button_settings:
                settingsWorker.showSettings();
                break;
            // Нажатие на кнопку "Магазин":
            case R.id.button_shop:
                shopWorker.showShop();
                break;
            // Нажатие на кнопку "Информация":
            case R.id.button_information:
                informationWorker.showInformation();
                break;
            // Нажатие на кнопку "Играть":
            case R.id.button_play_game:
            case R.id.relative_layout_game:
                startChanger();
                gameCreator.createWordGame();
                break;
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
        cardChanger.changeCard(buffGame);
    }
}
