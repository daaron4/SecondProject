package com.companyname.secondproject;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CursorAdapter cursorAdapter;
    private Cursor cursor;
    private ListView listView;
    private ListView.OnItemClickListener itemClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createListener();
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    private void createListener() {
        itemClick = new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cursor = DataBaseHelper.getInstance(MainActivity.this).searchStatesByTrumpSupport();
                cursor.moveToPosition(i);
                int id = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COL_STATE_ID));
                Intent intent = new Intent(MainActivity.this, StateActivity.class);
                intent.putExtra("id", id - 1);
                startActivity(intent);
            }
        };
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            final String query = intent.getStringExtra(SearchManager.QUERY);
            cursor = DataBaseHelper.getInstance(MainActivity.this).searchStatesByName(query);
            listView = (ListView)findViewById(R.id.list_view);
            if (cursorAdapter == null) {
                cursorAdapter = new SimpleCursorAdapter(
                        MainActivity.this,
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

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    cursor = DataBaseHelper.getInstance(MainActivity.this).searchStatesByName(query);
                    cursor.moveToPosition(i);
                    int id = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COL_STATE_ID));
                    Intent intent = new Intent(MainActivity.this, StateActivity.class);
                    intent.putExtra("id", id - 1);
                    startActivity(intent);
                }
            });
        }
    }
}
