package com.example.czech_language;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        img = findViewById(R.id.imageView2);
        img.setOnClickListener(this);

//        TimeWorker timeWorker = new TimeWorker();
//        Thread time = new Thread(timeWorker);
//        time.start();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imageView2) {
            Intent goToHome = new Intent(StartActivity.this, MenuActivity.class);
            startActivity(goToHome);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            finish();
        }
    }

}