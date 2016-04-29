package com.companyname.secondproject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);

        Cursor cursor = DataBaseHelper.getInstance(StateActivity.this).getStateData();
        cursor.moveToPosition(id);
        String display = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_STATE_NAME));
        String imgString = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_IMG_NAME));


        TextView textView = (TextView) findViewById(R.id.tv);
        textView.setText("Name of state is: " + display);

        ImageView imageView = (ImageView) findViewById(R.id.img_view);
        imageView.setImageResource(getDrawableValue(imgString));

    }

    private int getDrawableValue(String icon){
        switch(icon){
            case "cali_test.png":
                return R.drawable.cali_test;
            case "add":
                return android.R.drawable.ic_menu_add;
            case "upload":
                return android.R.drawable.ic_menu_upload;
            case "play":
                return android.R.drawable.ic_media_play;
            default:
                return 0;
        }
    }
}
