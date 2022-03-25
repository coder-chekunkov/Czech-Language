package com.example.czech_language.static_worker;

import android.widget.ProgressBar;

public class ProgressBarWorker {

    int allSolutionProblems, todaySolutionProblems;
    ProgressBar pbAllSolutionProblems, pbTodaySolutionProblems;

    public ProgressBarWorker(int allSolutionProblems, int todaySolutionProblems,
                             ProgressBar pbAllSolutionProblems, ProgressBar pbTodaySolutionProblems) {
        this.allSolutionProblems = allSolutionProblems;
        this.todaySolutionProblems = todaySolutionProblems;
        this.pbAllSolutionProblems = pbAllSolutionProblems;
        this.pbTodaySolutionProblems = pbTodaySolutionProblems;
    }

    public void setProgress(){
        pbAllSolutionProblems.setProgress(allSolutionProblems);
        pbTodaySolutionProblems.setProgress(todaySolutionProblems);
    }


}
