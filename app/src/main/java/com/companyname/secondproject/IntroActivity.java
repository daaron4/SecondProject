package com.companyname.secondproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    public void clickedSearchByState(View view) {
        Intent intent = new Intent(IntroActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void clickedFilterByTrumpSupport(View view) {
        Intent intent = new Intent(IntroActivity.this, TrumpStatesActivity.class);
        startActivity(intent);
    }

    public void clickedAssholeSearch(View view) {
        Intent intent = new Intent(IntroActivity.this, DensityActivity.class);
        startActivity(intent);
    }

    public void clickedUpdate(View view) {
        Intent intent = new Intent(IntroActivity.this, UpdateActivity.class);
        startActivity(intent);
    }
}
