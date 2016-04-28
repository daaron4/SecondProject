package com.companyname.secondproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by David on 4/27/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "States.db";
    public static final int DATABASE_VERSION = 1;

    public static final String STATES_TABLE = "states";

    public static final String COL_ID = "_id";
    public static final String COL_STATE_NAME = "state_name";

    public static final String[] COL_NAMES = {COL_ID, COL_STATE_NAME};

    private static final String CREATE_STATES_TABLE =
            "CREATE TABLE " + STATES_TABLE +
                    "(" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_STATE_NAME + " TEXT)";

    private static DataBaseHelper instance;

    public static DataBaseHelper getInstance(Context context){
        if (instance == null) {
            instance = new DataBaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    private DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_STATES_TABLE);
        loadDataBase(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + STATES_TABLE);
        onCreate(db);
    }

    private void loadDataBase(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(COL_STATE_NAME, "Alabama");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Alaska");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Arizona");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Arkansas");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "California");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Colorado");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Connecticut");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Delaware");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Florida");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Georgia");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Hawaii");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Idaho");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Illinois");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Indiana");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Iowa");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Kansas");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Kentucky");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Louisiana");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Maine");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Maryland");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Massachusetts");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Michigan");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Minnesota");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Missouri");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Montana");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Nebraska");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Nevada");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "New Hampshire");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "New Jersey");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "New Mexico");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "New York");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "North Carolina");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "North Dakota");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Ohio");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Oklahoma");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Nevada");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Oregon");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Pennsylvania");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Rhode Island");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "South Carolina");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "South Dakota");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Tennessee");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Texas");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Utah");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Vermont");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Virginia");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Washington");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "West Virginia");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Wisconsin");
        db.insert(STATES_TABLE, null, values);
        values.put(COL_STATE_NAME, "Wyoming");
        db.insert(STATES_TABLE, null, values);
    }

    public void insert(String state) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_STATE_NAME, state);
        db.insert(STATES_TABLE, null, values);
    }

    public Cursor getStates(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(STATES_TABLE, // a. table
                COL_NAMES, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        return cursor;
    }

    public Cursor searchStates(String query){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(STATES_TABLE, // a. table
                COL_NAMES, // b. column names
                COL_STATE_NAME + " LIKE ?", // c. selections
                new String[]{"%" + query + "%"}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursor;
    }

}
