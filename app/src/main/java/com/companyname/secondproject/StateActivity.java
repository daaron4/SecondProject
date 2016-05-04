package com.companyname.secondproject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class StateActivity extends AppCompatActivity {

    private ImageView trumpImageView;
    private TextView quote;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);
        int votingStatus = DataBaseHelper.getInstance(StateActivity.this).getStateVotingStatusAtIndex(id + 1);
        // didn't vote for trump
        if (votingStatus == 0) {
            layoutGoodState();
        }
        // voted for trump
        else if (votingStatus == 1) {
            layoutBadState();
        }
        // hasn't voted yet
        else {
            layoutNeutralState();
        }

    }

    private void layoutGoodState() {
        info = (TextView) findViewById(R.id.info);
        info.setText(R.string.not_trump_state);

        quote = (TextView) findViewById(R.id.quote);
        quote.setText("No trump quote needed");
    }

    private void layoutBadState() {
        info = (TextView) findViewById(R.id.info);
        info.setText(R.string.trump_state);

        // HEY, MAKE SURE THAT THERE ARE THE SAME AMOUNT OF IMAGES AND QUOTES, AND THAT NONE ARE NULL FOR THIS LOGIC TO WORK!

        // gets size of trump table:
        int size = DataBaseHelper.getInstance(StateActivity.this).getTrumpTableSize();
        // makes random number inside the size of the table:
        Random random = new Random();
        int randNum = random.nextInt(size) + 1;
        // gets quote at that index
        String quoteString = DataBaseHelper.getInstance(StateActivity.this).getTrumpQuoteAtIndex(randNum);
        // displays quote
        quote = (TextView) findViewById(R.id.quote);
        quote.setText("\"" + quoteString + "\"");

        // same stuff for trump image:
        randNum = random.nextInt(size) + 1;
        String trumpImgString = DataBaseHelper.getInstance(StateActivity.this).getImagePathAtIndex(randNum);

        trumpImageView = (ImageView) findViewById(R.id.trump_img);
        trumpImageView.setImageResource(UtilityHelper.getDrawableValue(trumpImgString));
    }

    private void layoutNeutralState() {
        info = (TextView) findViewById(R.id.info);
        info.setText(R.string.no_vote_yet);

        quote = (TextView) findViewById(R.id.quote);
        quote.setText("No trump quote needed");
    }
}
