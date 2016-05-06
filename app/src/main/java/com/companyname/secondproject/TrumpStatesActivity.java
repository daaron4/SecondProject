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
import android.widget.TextView;

public class TrumpStatesActivity extends AppCompatActivity {

    // This activity displays all states the trump won

    private CursorAdapter cursorAdapter;
    private Cursor cursor;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cursor = DataBaseHelper.getInstance(TrumpStatesActivity.this).searchStatesByTrumpSupport();
        displayResults();
    }

    private void displayResults() {
        listView = (ListView) findViewById(R.id.state_list_view);
        if (cursorAdapter == null) {
            createAdapter();
            listView.setAdapter(cursorAdapter);
        } else {
            cursorAdapter.swapCursor(cursor);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                respondToItemClick(i);
            }
        });
    }

    private void createAdapter() {
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
                int resourceId = UtilityHelper.getDrawableValue(cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_IMG_NAME)));
                stateImg.setImageResource(resourceId);

                TextView stateName = (TextView) view.findViewById(R.id.state_name);
                String stateNameText = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_STATE_NAME));
                stateName.setText(stateNameText);

                TextView stateDensityView = (TextView) view.findViewById(R.id.state_density_text);
                float stateDensity = cursor.getFloat(cursor.getColumnIndex(DataBaseHelper.COL_DENSITY));
                stateDensityView.setText("Density: " + stateDensity);

                TextView stateSizeView = (TextView) view.findViewById(R.id.state_size_text);
                float stateSize = cursor.getFloat(cursor.getColumnIndex(DataBaseHelper.COL_SQUARE_MILES));
                stateSizeView.setText("Size: " + stateSize + " sq.mi.");

            }
        };
    }

    // Takes the user to that state's detail page
    private void respondToItemClick(int i) {
        cursor.moveToPosition(i);
        int id = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COL_STATE_ID));
        Intent intent = new Intent(TrumpStatesActivity.this, StateActivity.class);
        intent.putExtra("id", id - 1);
        startActivity(intent);
    }

}
