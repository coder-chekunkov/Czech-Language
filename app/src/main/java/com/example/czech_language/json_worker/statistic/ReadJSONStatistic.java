package com.example.czech_language.json_worker.statistic;

import android.content.Context;
import com.example.czech_language.R;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class ReadJSONStatistic {

    public static StatisticFromJSON readStatisticJSONFile(Context context) throws IOException, JSONException {

        // Чтение контента с JSON-файла:
        String jsonText = readText(context, R.raw.stat);
        JSONObject jsonRoot = new JSONObject(jsonText);

        int goodAnswers = jsonRoot.getInt("good_answers");
        int badAnswers = jsonRoot.getInt("bas_answers");
        int allGames = jsonRoot.getInt("all_games");
        int lastGames = jsonRoot.getInt("last_games");

        // Создание объекта со статистикой:
        StatisticFromJSON statistic = new StatisticFromJSON();
        statistic.setGoodAnswers(goodAnswers);
        statistic.setBadAnswers(badAnswers);
        statistic.setAllGames(allGames);
        statistic.setLastGames(lastGames);

        return statistic;
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
