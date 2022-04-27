package com.example.czech_language.static_worker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.czech_language.statistic_worker.StatisticCreator;

public class ProgressBarWorker {

    TextView twAllSolutionProblems, twTodaySolutionProblems;
    ProgressBar pbAllSolutionProblems, pbTodaySolutionProblems;
    Context context;

    int allProblems = 315, todayMaxProblems = 80;

    public ProgressBarWorker(Context context, ProgressBar pbAllSolutionProblems, ProgressBar pbTodaySolutionProblems,
                             TextView twAllSolutionProblems, TextView twTodaySolutionProblems) {
        this.context = context;
        this.pbAllSolutionProblems = pbAllSolutionProblems;
        this.pbTodaySolutionProblems = pbTodaySolutionProblems;
        this.twAllSolutionProblems = twAllSolutionProblems;
        this.twTodaySolutionProblems = twTodaySolutionProblems;

        this.pbAllSolutionProblems.setMax(allProblems);
        this.pbTodaySolutionProblems.setMax(todayMaxProblems);
    }

    // Уствновка прогресса в шкалы:
    @SuppressLint("SetTextI18n")
    public void setProgress() {
        int allSolutionProblems = StatisticCreator.getGoodGames(context);
        int todaySolutionProblems = 80 - StatisticCreator.getLastGames(context);
        pbAllSolutionProblems.setProgress(allSolutionProblems);
        pbTodaySolutionProblems.setProgress(todaySolutionProblems);

        twAllSolutionProblems.setText(allSolutionProblems + "/" + allProblems);
        twTodaySolutionProblems.setText(todaySolutionProblems + "/" + todayMaxProblems);
    }
}
