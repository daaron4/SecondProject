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

    private ImageView stateImageView;
    private ImageView trumpImageView;
    private TextView quote;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);

        // creates state image:
        Cursor cursor = DataBaseHelper.getInstance(StateActivity.this).getStateData();
        cursor.moveToPosition(id);
        String imgString = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_IMG_NAME));
        stateImageView = (ImageView) findViewById(R.id.img_view);
        stateImageView.setImageResource(getDrawableValue(imgString));
        cursor.close();

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
        quote.setText("trump quote here: " + quoteString);

        // same stuff for trump image:
        randNum = random.nextInt(size) + 1;
        String trumpImgString = DataBaseHelper.getInstance(StateActivity.this).getImagePathAtIndex(randNum);

        trumpImageView = (ImageView) findViewById(R.id.trump_img);
        trumpImageView.setImageResource(getDrawableValue(trumpImgString));
    }

    private void layoutNeutralState() {
        info = (TextView) findViewById(R.id.info);
        info.setText(R.string.no_vote_yet);

        quote = (TextView) findViewById(R.id.quote);
        quote.setText("No trump quote needed");
    }

    private int getDrawableValue(String image){
        switch(image){
            case "state_alabama.png":
                return R.drawable.state_alabama;
            case "state_alaska.png":
                return R.drawable.state_alaska;
            case "state_arizona.png":
                return R.drawable.state_arizona;
            case "state_arkansas.png":
                return R.drawable.state_arkansas;
            case "state_california.png":
                return R.drawable.state_california;
            case "state_colorado.png":
                return R.drawable.state_colorado;
            case "state_connecticut.png":
                return R.drawable.state_connecticut;
            case "state_delaware.png":
                return R.drawable.state_delaware;
            case "state_florida.png":
                return R.drawable.state_florida;
            case "state_georgia.png":
                return R.drawable.state_georgia;
            case "state_hawaii.png":
                return R.drawable.state_hawaii;
            case "state_idaho.png":
                return R.drawable.state_idaho;
            case "state_illinois.png":
                return R.drawable.state_illinois;
            case "state_indiana.png":
                return R.drawable.state_indiana;
            case "state_iowa.png":
                return R.drawable.state_iowa;
            case "state_kansas.png":
                return R.drawable.state_kansas;
            case "state_kentucky.png":
                return R.drawable.state_kentucky;
            case "state_louisiana.png":
                return R.drawable.state_louisiana;
            case "state_maine.png":
                return R.drawable.state_maine;
            case "state_maryland.png":
                return R.drawable.state_maryland;
            case "state_massachusetts.png":
                return R.drawable.state_massachussets;
            case "state_michigan.png":
                return R.drawable.state_michigan;
            case "state_minnesota.png":
                return R.drawable.state_minnesota;
            case "state_mississippi.png":
                return R.drawable.state_mississippi;
            case "state_missouri.png":
                return R.drawable.state_missouri;
            case "state_montana.png":
                return R.drawable.state_montana;
            case "state_nebraska.png":
                return R.drawable.state_nebraska;
            case "state_nevada.png":
                return R.drawable.state_nevada;
            case "state_new_hampshire.png":
                return R.drawable.state_new_hampshire;
            case "state_new_jersey.png":
                return R.drawable.state_new_jersey;
            case "state_new_mexico.png":
                return R.drawable.state_new_mexico;
            case "state_new_york.png":
                return R.drawable.state_new_york;
            case "state_north_carolina.png":
                return R.drawable.state_north_carolina;
            case "state_north_dakota.png":
                return R.drawable.state_north_dakota;
            case "state_ohio.png":
                return R.drawable.state_ohio;
            case "state_oklahoma.png":
                return R.drawable.state_oklahoma;
            case "state_oregon.png":
                return R.drawable.state_oregon;
            case "state_pennsylvania.png":
                return R.drawable.state_pennsylvania;
            case "state_rhode_island.png":
                return R.drawable.state_rhode_island;
            case "state_south_carolina.png":
                return R.drawable.state_south_carolina;
            case "state_south_dakota.png":
                return R.drawable.state_south_dakota;
            case "state_tennessee.png":
                return R.drawable.state_tennessee;
            case "state_texas.png":
                return R.drawable.state_texas;
            case "state_utah.png":
                return R.drawable.state_utah;
            case "state_vermont.png":
                return R.drawable.state_vermont;
            case "state_virginia.png":
                return R.drawable.state_virginia;
            case "state_washington.png":
                return R.drawable.state_washington;
            case "state_west_virginia.png":
                return R.drawable.state_west_virginia;
            case "state_wisconsin.png":
                return R.drawable.state_wisconsin;
            case "state_wyoming.png":
                return R.drawable.state_wyoming;
            // ToDo: update when ready here:
            case "trump_img_1.png":
                return R.drawable.trump_img_1;
            case "trump_img_2.png":
                return R.drawable.trump_img_1;
            case "trump_img_3.png":
                return R.drawable.trump_img_1;
            case "trump_img_4.png":
                return R.drawable.trump_img_1;
            case "trump_img_5.png":
                return R.drawable.trump_img_1;
            default:
                return 0;
        }
    }
}
