package com.companyname.secondproject;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
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

        TextView textView = (TextView) findViewById(R.id.tv);
        textView.setText("Name of state is: " + display);


    }
}
