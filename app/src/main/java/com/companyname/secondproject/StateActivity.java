package com.companyname.secondproject;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class StateActivity extends AppCompatActivity {

    // This activity displays the detail view for any state

    private ImageView trumpImageView;
    private TextView quote;
    private TextView info;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        int votingStatus = DataBaseHelper.getInstance(StateActivity.this).getStateVotingStatusAtIndex(id + 1);
        // didn't vote for trump
        if (votingStatus == 0) {
            layoutTedState();
        }
        // voted for trump
        else if (votingStatus == 1) {
            layoutTrumpState();
        }
        // voted for other guys
        else if (votingStatus == 3) {
            layoutJohnState();
        }
        // hasn't voted yet
        else {
            layoutNeutralState();
        }

    }

    private void layoutTedState() {
        info = (TextView) findViewById(R.id.info);
        info.setText(R.string.not_trump_state);

        quote = (TextView) findViewById(R.id.quote);
        quote.setText(R.string.ted);

        trumpImageView = (ImageView) findViewById(R.id.trump_img);
        trumpImageView.setImageResource(R.drawable.ted);
    }

    private void layoutJohnState() {
        info = (TextView) findViewById(R.id.info);
        info.setText(R.string.not_trump_state);

        quote = (TextView) findViewById(R.id.quote);
        quote.setText(R.string.john);

        trumpImageView = (ImageView) findViewById(R.id.trump_img);
        trumpImageView.setImageResource(R.drawable.john);
    }

    private void layoutTrumpState() {
        info = (TextView) findViewById(R.id.info);
        info.setText(R.string.trump_state);

        // gets size of trump table:
        int size = DataBaseHelper.getInstance(StateActivity.this).getTrumpTableSize();
        // makes random number inside the size of the table:
        Random random = new Random();
        int randNum = random.nextInt(size) + 1;
        // gets quote at that index:
        String quoteString = DataBaseHelper.getInstance(StateActivity.this).getTrumpQuoteAtIndex(randNum);
        // displays quote:
        quote = (TextView) findViewById(R.id.quote);
        quote.setText("\"" + quoteString + "\"");

        // same logic for trump image:
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

        // creates state image:
        Cursor cursor = DataBaseHelper.getInstance(StateActivity.this).getStateData();
        cursor.moveToPosition(id);
        String imgString = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_IMG_NAME));
        cursor.close();

        trumpImageView = (ImageView) findViewById(R.id.trump_img);
        trumpImageView.setImageResource(UtilityHelper.getDrawableValue(imgString));

    }
}
