package com.companyname.secondproject;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    // This activity allows the user to add new quotes to the database

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
    }

    public void clickedAdd(View view) {
        EditText userInputEditText = (EditText) findViewById(R.id.edit_text);
        String userInput = userInputEditText.getText().toString();
        Cursor cursor = DataBaseHelper.getInstance(UpdateActivity.this).getTrumpTableData();

        // Checks if quote already exists:
        boolean addThisQuote = true;
        while (cursor.moveToNext()) {
            String currentQuote = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_TRUMP_QUOTE));
            if (userInput.equals(currentQuote)) {
                Toast.makeText(UpdateActivity.this, "That quote is already in here!", Toast.LENGTH_LONG).show();
                addThisQuote = false;
            }
        }
        cursor.close();

        // Adds quote if its not an empty string:
        if (addThisQuote) {
            if (!userInput.equals("")) {
                DataBaseHelper.getInstance(UpdateActivity.this).addQuote(userInput);
                Toast.makeText(UpdateActivity.this, "Quote added", Toast.LENGTH_LONG).show();
                userInputEditText.setText("");
            }
            else {
                Toast.makeText(UpdateActivity.this, "You can't add nothing man!", Toast.LENGTH_LONG).show();
            }
        }

    }

}
