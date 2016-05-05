package com.companyname.secondproject;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FavoritesActivity extends AppCompatActivity {

    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        ListView listView = (ListView) findViewById(R.id.favorites_list_view);
        cursor = DataBaseHelper.getInstance(FavoritesActivity.this).getFavoriteQuotes();

        final CursorAdapter cursorAdapter = new CursorAdapter(this, cursor, 0) {
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cursor.moveToPosition(i);
                final int id = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COL_TRUMP_ID));
                AlertDialog.Builder builder = new AlertDialog.Builder(FavoritesActivity.this);
                builder.setTitle(R.string.delete);
                builder.setIcon(R.drawable.trump_icon);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DataBaseHelper.getInstance(FavoritesActivity.this).removeQuoteFromFavorites(id);
                        Toast.makeText(FavoritesActivity.this, "Quote removed from favorites.", Toast.LENGTH_LONG).show();
                        cursor = DataBaseHelper.getInstance(FavoritesActivity.this).getFavoriteQuotes();
                        cursorAdapter.swapCursor(cursor);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //does nothing
                    }
                });
                builder.show();
            }
        });

    }
}
