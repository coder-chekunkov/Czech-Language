package com.example.czech_language.game_worker;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.czech_language.R;
import com.example.czech_language.static_worker.StartAnimation;
import org.json.JSONException;
import java.io.IOException;

public class GameCreator implements View.OnClickListener {

    TextView czWord, ruWord;
    ImageButton buttonAnswerYes, buttonAnswerNo, firstSmile, secondSmile;
    Context context;

    DictionaryWord word;
    boolean isWrongWord;

    public GameCreator(Context context, TextView czWord, TextView ruWord,
                       ImageButton buttonAnswerYes, ImageButton buttonAnswerNo,
                       ImageButton firstSmile, ImageButton secondSmile) {
        this.context = context;
        this.czWord = czWord;
        this.ruWord = ruWord;
        this.buttonAnswerYes = buttonAnswerYes;
        this.buttonAnswerNo = buttonAnswerNo;
        this.firstSmile = firstSmile;
        this.secondSmile = secondSmile;
        buttonAnswerYes.setOnClickListener(this);
        buttonAnswerNo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_answer_yes) checkAnswer(true);
        if (v.getId() == R.id.button_answer_no) checkAnswer(false);
    }

    // Метод вывода слов на экран:
    public void createWordGame() {

        int numberWord = (int) (Math.random() * (5)) + 1;
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
        } else {
            Toast toastMistake = Toast.makeText(context.getApplicationContext(), "Ошибка! " + rightAnswer, Toast.LENGTH_SHORT);
            toastMistake.show();
            StartAnimation.animationImgResult(context, false, firstSmile, secondSmile);
        }

        createWordGame();
    }
}
