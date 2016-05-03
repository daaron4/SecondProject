package com.companyname.secondproject;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

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
            cursorAdapter = new CursorAdapter(this, cursor, 0) {
                @Override
                public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                    LayoutInflater layoutInflater = LayoutInflater.from(context);
                    View view = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
                    return view;
                }

                @Override
                public void bindView(View view, Context context, Cursor cursor) {
                    ImageView stateImg = (ImageView) view.findViewById(R.id.state_img);
                    int resourceId = StateActivity.getDrawableValue(cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_IMG_NAME)));
                    stateImg.setImageResource(resourceId);

                    TextView stateName = (TextView) view.findViewById(R.id.state_name);
                    String stateNameText = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_STATE_NAME));
                    stateName.setText(stateNameText);

                }
            };

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
