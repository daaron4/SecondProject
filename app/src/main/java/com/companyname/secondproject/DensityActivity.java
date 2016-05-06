package com.companyname.secondproject;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;

public class DensityActivity extends AppCompatActivity {

    // This activity shows all states filtered by their densities

    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_density);
        ListView listView = (ListView) findViewById(R.id.density_list_view);
        cursor = DataBaseHelper.getInstance(DensityActivity.this).getDensityData();

        CursorAdapter cursorAdapter = new CursorAdapter(this, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                View view = layoutInflater.inflate(R.layout.density_item, viewGroup, false);
                return view;
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView stateName = (TextView) view.findViewById(R.id.state_name);
                String stateNameText = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_STATE_NAME));
                stateName.setText(stateNameText);

                TextView stateDensityView = (TextView) view.findViewById(R.id.state_density);
                float stateDensityFloat = cursor.getFloat(cursor.getColumnIndex(DataBaseHelper.COL_DENSITY));
                DecimalFormat decimalFormat = new DecimalFormat();
                decimalFormat.setMaximumFractionDigits(2);
                String stateDensityString = decimalFormat.format(stateDensityFloat);

                stateDensityView.setText("" + stateDensityString + "%");

            }
        };

        listView.setAdapter(cursorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Display detail view for any state
                cursor.moveToPosition(i);
                int id = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COL_STATE_ID));
                Intent intent = new Intent(DensityActivity.this, StateActivity.class);
                intent.putExtra("id", id - 1);
                startActivity(intent);
            }
        });

    }

}
