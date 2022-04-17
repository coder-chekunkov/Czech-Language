package com.example.czech_language.game_worker;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.czech_language.MenuActivity;
import com.example.czech_language.R;
import com.example.czech_language.static_worker.CardChanger;
import com.example.czech_language.static_worker.ProgressBarWorker;
import com.example.czech_language.static_worker.StartAnimation;
import com.example.czech_language.statistic_worker.StatisticCreator;
import com.example.czech_language.tabs_worker.GameOver;
import org.json.JSONException;

import java.io.IOException;

public class GameCreator extends MenuActivity implements View.OnClickListener {

    TextView czWord, ruWord;
    ImageButton buttonAnswerYes, buttonAnswerNo, firstSmile, secondSmile;
    Context context;

    DictionaryWord word;
    ProgressBarWorker progressBarWorker;
    GameOver gameOverWorker;
    CardChanger cardChangerWorker;
    boolean isWrongWord;

    public GameCreator(Context context, TextView czWord, TextView ruWord,
                       ImageButton buttonAnswerYes, ImageButton buttonAnswerNo,
                       ImageButton firstSmile, ImageButton secondSmile,
                       ProgressBarWorker progressBarWorker, GameOver gameOverWorker,
                       CardChanger cardChangerWorker) {
        this.context = context;
        this.czWord = czWord;
        this.ruWord = ruWord;
        this.buttonAnswerYes = buttonAnswerYes;
        this.buttonAnswerNo = buttonAnswerNo;
        this.firstSmile = firstSmile;
        this.secondSmile = secondSmile;
        this.buttonAnswerYes.setOnClickListener(this);
        this.buttonAnswerNo.setOnClickListener(this);
        this.progressBarWorker = progressBarWorker;
        this.gameOverWorker = gameOverWorker;
        this.cardChangerWorker = cardChangerWorker;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_answer_yes) checkAnswer(true);
        if (v.getId() == R.id.button_answer_no) checkAnswer(false);
    }

    // Метод вывода слов на экран:
    public void createWordGame() {

        int numberWord = (int) (Math.random() * 140) + 1;
        int buff = (int) (Math.random() * (10)) + 1;
        isWrongWord = buff % 2 == 0;

        // Получение слова из JSON-файла:
        word = new DictionaryWord();
        try {
            word = ReadJSONDictionary.readDictionaryJSONFile(context, numberWord);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String firstWord = "\"" + word.getCzWord() + "\"";
        String secondWord;
        if (isWrongWord) secondWord = "\"" + word.getRuWord() + "\"";
        else secondWord = "\"" + word.getRuWordWrong() + "\"";

        czWord.setText(firstWord);
        ruWord.setText(secondWord);
        StartAnimation.startAppearText(context, czWord, ruWord);
    }

    // Метод проверки ответа пользователя:
    public void checkAnswer(boolean answer) {
        String rightAnswer = "\"" + word.getCzWord() + "\" = \"" + word.getRuWord() + "\"";

        if (answer == isWrongWord) {
            Toast toastRight = Toast.makeText(context.getApplicationContext(), "Верно! " + rightAnswer, Toast.LENGTH_SHORT);
            toastRight.show();
            StartAnimation.animationImgResult(context, true, firstSmile, secondSmile);
            StatisticCreator.increaseStatistic(context, 1, 0);
        } else {
            Toast toastMistake = Toast.makeText(context.getApplicationContext(), "Ошибка! " + rightAnswer, Toast.LENGTH_SHORT);
            toastMistake.show();
            StartAnimation.animationImgResult(context, false, firstSmile, secondSmile);
            StatisticCreator.increaseStatistic(context, 0, 1);
        }

        progressBarWorker.setProgress();

        int lastGames = StatisticCreator.getLastGames(context);

        if (lastGames != 0) createWordGame();
        else {
            gameOverWorker.showGameOver();
            cardChangerWorker.startChanger();
        }
    }
}
