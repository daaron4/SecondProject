package com.companyname.secondproject;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class FavoritesActivity extends AppCompatActivity {

    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        ListView listView = (ListView) findViewById(R.id.favorites_list_view);
        cursor = DataBaseHelper.getInstance(FavoritesActivity.this).getFavoriteQuotes();

        CursorAdapter cursorAdapter = new CursorAdapter(this, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                View view = layoutInflater.inflate(R.layout.super_simple, viewGroup, false);
                return view;
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView quoteView = (TextView) view.findViewById(R.id.simple_tv);
                String quote = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_TRUMP_QUOTE));
                quoteView.setText(quote);
            }
        };

        listView.setAdapter(cursorAdapter);
    }
}
