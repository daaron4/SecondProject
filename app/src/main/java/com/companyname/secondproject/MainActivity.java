package com.companyname.secondproject;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CursorAdapter cursorAdapter;
    private Cursor cursor;
    private CursorAdapter cursorAdapter1;
    private Cursor cursor1;
    private ListView stateListView;
    private ListView quoteListView;
    private String query;
    private int numberQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayHelpfulPopUp();
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

    private void displayHelpfulPopUp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Instructions");
        builder.setMessage(R.string.search_description);
        builder.setIcon(R.drawable.trump_icon);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //does nothing
            }
        });
        builder.show();
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            query = intent.getStringExtra(SearchManager.QUERY);
            try {
                numberQuery = Integer.parseInt(query);
                // requirements for searching by asshole density
                if (numberQuery >= 0 && numberQuery <= 100) {
                    cursor = DataBaseHelper.getInstance(MainActivity.this).filterByDensity(numberQuery);
                    displayResults();
                }
                // requirements for searching by state size
                else if (numberQuery > 100) {
                    cursor = DataBaseHelper.getInstance(MainActivity.this).filterByStateSize(numberQuery);
                    displayResults();
                }
                else {
                    // tell user about incorrect input
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_LONG).show();
                }
            } catch (NumberFormatException e) {
                // search by the string the user put in, first is state, second is quote
                cursor = DataBaseHelper.getInstance(MainActivity.this).searchStatesByName(query);
                displayResults();
                cursor1 = DataBaseHelper.getInstance(MainActivity.this).searchQuotes(query);
                displayResultsNew();
            }
        }
    }

    private void displayResultsNew() {
        quoteListView = (ListView) findViewById(R.id.quote_list_view);
        if (cursorAdapter1 == null) {
            createAdapterNew();
            quoteListView.setAdapter(cursorAdapter1);
        } else {
            cursorAdapter1.swapCursor(cursor1);
        }

        quoteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                respondToQuoteItemClick(i);
            }
        });
    }

    private void createAdapterNew() {
        cursorAdapter1 = new CursorAdapter(this, cursor1, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                View view = layoutInflater.inflate(R.layout.super_simple, viewGroup, false);
                return view;
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                TextView stateName = (TextView) view.findViewById(R.id.simple_tv);
                String stateNameText = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_TRUMP_QUOTE));
                stateName.setText(stateNameText);
            }
        };
    }

    private void displayResults() {
        // ToDo: figure out how to clear the other cursor
        stateListView = (ListView) findViewById(R.id.state_list_view);
        if (cursorAdapter == null) {
            createAdapter();
            stateListView.setAdapter(cursorAdapter);
        } else {
            cursorAdapter.swapCursor(cursor);
        }

        stateListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

    private void respondToItemClick(int i) {
        cursor.moveToPosition(i);
        int id = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COL_STATE_ID));
        Intent intent = new Intent(MainActivity.this, StateActivity.class);
        intent.putExtra("id", id - 1);
        startActivity(intent);
    }

    private void respondToQuoteItemClick(int i) {
        cursor1.moveToPosition(i);
        final int id = cursor1.getInt(cursor1.getColumnIndex(DataBaseHelper.COL_TRUMP_ID));
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.favorite);
        builder.setIcon(R.drawable.trump_icon);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DataBaseHelper.getInstance(MainActivity.this).favoriteQuoteAtIndex(id);
                Toast.makeText(MainActivity.this, "Quote added to favorites!", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Fine then, don't add that quote.", Toast.LENGTH_LONG).show();
            }
        });
        builder.show();
    }

}
