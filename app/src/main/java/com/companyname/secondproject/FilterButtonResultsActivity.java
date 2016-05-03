package com.companyname.secondproject;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class FilterButtonResultsActivity extends AppCompatActivity {

    private CursorAdapter cursorAdapter;
    private Cursor cursor;
    private ListView listView;
    private ListView.OnItemClickListener itemClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_button_results);
        createListener();

        cursor = DataBaseHelper.getInstance(FilterButtonResultsActivity.this).searchStatesByTrumpSupport();
        listView = (ListView)findViewById(R.id.fitler_list_view);
        if (cursorAdapter == null) {
            cursorAdapter = new SimpleCursorAdapter(
                    FilterButtonResultsActivity.this,
                    android.R.layout.simple_list_item_1,
                    cursor,
                    new String[]{DataBaseHelper.COL_STATE_NAME},
                    new int[]{android.R.id.text1},
                    0);
            listView.setAdapter(cursorAdapter);
        }
        else {
            cursorAdapter.swapCursor(cursor);
        }

        listView.setOnItemClickListener(itemClick);
    }

    private void createListener() {
        itemClick = new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cursor = DataBaseHelper.getInstance(FilterButtonResultsActivity.this).searchStatesByTrumpSupport();
                cursor.moveToPosition(i);
                int id = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COL_STATE_ID));
                Intent intent = new Intent(FilterButtonResultsActivity.this, StateActivity.class);
                intent.putExtra("id", id - 1);
                startActivity(intent);
            }
        };
    }

}
