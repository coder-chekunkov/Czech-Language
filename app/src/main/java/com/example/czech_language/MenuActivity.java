package com.example.czech_language;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.czech_language.static_worker.StartAnimation;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton buttonNetwork, buttonSettings,
            buttonShop, buttonInformation, buttonPlay;
    ProgressBar pbAllSolutionProblems, pbTodaySolutionProblems;
    TextView twAllSolutionProblems, twTodaySolutionProblems;

    int allProblems = 250, todayMaxProblems = 80;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Регистрация прогресс-баров:
        pbAllSolutionProblems = findViewById(R.id.progressBar_decided_questions);
        pbAllSolutionProblems.setMax(allProblems);
        pbTodaySolutionProblems = findViewById(R.id.progressBar_last_questions);
        pbAllSolutionProblems.setMax(todayMaxProblems);

        // Регистрация надписей с решенными вопросами:
        twAllSolutionProblems = findViewById(R.id.text_decided_questions);
        twAllSolutionProblems.setText("0/" + allProblems);
        twTodaySolutionProblems = findViewById(R.id.text_last_questions);
        twTodaySolutionProblems.setText("0/" + todayMaxProblems);

        // Регистрация кнопки "Сеть":
        buttonNetwork = findViewById(R.id.button_network);
        buttonNetwork.setOnClickListener(this);

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

        // Запуск анимации всех кнопок:
        StartAnimation startAnimation = new StartAnimation(buttonPlay, buttonShop, buttonInformation);
        startAnimation.startAnimation();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // Нажатие на кнопку "Сеть":
            case R.id.button_network:
                Toast toastNetwork = Toast.makeText(getApplicationContext(), "Network push.", Toast.LENGTH_SHORT);
                toastNetwork.show();
                break;
            // Нажатие на кнопку "Настройки":
            case R.id.button_settings:
                Toast toastSettings = Toast.makeText(getApplicationContext(), "Settings push.", Toast.LENGTH_SHORT);
                toastSettings.show();
                break;
            // Нажатие на кнопку "Магазин":
            case R.id.button_shop:
                Toast toastShop = Toast.makeText(getApplicationContext(), "Shop push.", Toast.LENGTH_SHORT);
                toastShop.show();
                break;
            // Нажатие на кнопку "Информация":
            case R.id.button_information:
                Toast toastInfo = Toast.makeText(getApplicationContext(), "Information push.", Toast.LENGTH_SHORT);
                toastInfo.show();
                break;
            // Нажатие на кнопку "Играть":
            case R.id.button_play_game:
                Toast toastStart = Toast.makeText(getApplicationContext(), "Start push.", Toast.LENGTH_SHORT);
                toastStart.show();
                break;
        }
    }
}
