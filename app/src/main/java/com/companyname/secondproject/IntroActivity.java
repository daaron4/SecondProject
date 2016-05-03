package com.companyname.secondproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
        Intent intent = new Intent(IntroActivity.this, FilterButtonResultsActivity.class);
        startActivity(intent);
    }

    public void clickedTbd(View view) {
        Toast.makeText(IntroActivity.this, "TBD dude", Toast.LENGTH_LONG).show();
    }
}