package com.example.czech_language.game_worker;

import android.content.Context;
import com.example.czech_language.R;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class ReadJSONDictionary {

    public static DictionaryWord readDictionaryJSONFile(Context context, int numberWord) throws IOException, JSONException {

        // Чтение контента с JSON-файла:
        String jsonText = readText(context, R.raw.dictionary);
        JSONObject jsonRoot = new JSONObject(jsonText);
        JSONObject jsonWord = jsonRoot.getJSONObject(String.valueOf(numberWord));

        DictionaryWord word = new DictionaryWord();
        word.setCzWord(jsonWord.getString("cz_word"));
        word.setRuWord(jsonWord.getString("ru_word"));
        word.setRuWordWrong(jsonWord.getString("ru_word_wrong"));

        return word;
    }

    // Чтение JSON-файла:
    private static String readText(Context context, int resId) throws IOException {
        InputStream inputStream = context.getResources().openRawResource(resId);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder file = new StringBuilder();
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            file.append(s);
            file.append("\n");
        }
        return file.toString();
    }
}
