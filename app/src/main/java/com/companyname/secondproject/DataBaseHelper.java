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

    public static final String COL_STATE_ID = "_id";
    public static final String COL_STATE_NAME = "state_name";
    public static final String COL_TRUMP_SUPPORTER = "trump_support";
    public static final String COL_IMG_NAME = "img_name";

    public static final String[] COL_NAMES = {COL_STATE_ID, COL_STATE_NAME, COL_TRUMP_SUPPORTER, COL_IMG_NAME};

    private static final String CREATE_STATES_TABLE =
            "CREATE TABLE " + STATES_TABLE +
                    "(" +
                    COL_STATE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_STATE_NAME + " TEXT, " +
                    COL_TRUMP_SUPPORTER + " INTEGER, " +
                    COL_IMG_NAME + " TEXT)";

    public static final String TRUMP_TABLE = "trump";

    public static final String COL_TRUMP_ID = "_id";
    public static final String COL_TRUMP_QUOTE = "trump_quote";
    public static final String COL_TRUMP_IMG_NAME = "trump_img_name";

    public static final String[] TRUMP_COL_NAMES = {COL_TRUMP_ID, COL_TRUMP_QUOTE, COL_TRUMP_IMG_NAME};

    private static final String CREATE_TRUMP_TABLE =
            "CREATE TABLE " + TRUMP_TABLE +
                    "(" +
                    COL_TRUMP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_TRUMP_QUOTE + " TEXT, " +
                    COL_TRUMP_IMG_NAME + " TEXT)";

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
        db.execSQL(CREATE_TRUMP_TABLE);
        loadStatesTable(db);
        loadTrumpTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + STATES_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TRUMP_TABLE);
        onCreate(db);
    }

    private void loadTrumpTable(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(COL_TRUMP_QUOTE, "i am donald trump, i suck.");
        db.insert(TRUMP_TABLE, null, values);
    }

    private void loadStatesTable(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(COL_STATE_NAME, "Alabama");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_alabama.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Alaska");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_alaska.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Arizona");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_arizona.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Arkansas");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_arkansas.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "California");
        values.put(COL_IMG_NAME, "state_california.png");
        values.put(COL_TRUMP_SUPPORTER, 0);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Colorado");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_colorado.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Connecticut");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_connecticut.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Delaware");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_delaware.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Florida");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_florida.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Georgia");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_georgia.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Hawaii");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_hawaii.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Idaho");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_idaho.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Illinois");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_illinois.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Indiana");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_indiana.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Iowa");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_iowa.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Kansas");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_kansas.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Kentucky");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_kentucky.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Louisiana");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_louisiana.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Maine");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_maine.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Maryland");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_maryland.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Massachusetts");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_massachusetts.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Michigan");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_michigan.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Minnesota");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_minnesota.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Mississippi");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_mississippi.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Missouri");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_missouri.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Montana");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_montana.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Nebraska");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_nebraska.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Nevada");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_nevada.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "New Hampshire");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_new_hampshire.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "New Jersey");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_new_jersey.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "New Mexico");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_new_mexico.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "New York");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_new_york.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "North Carolina");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_north_carolina.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "North Dakota");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_north_dakota.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Ohio");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_ohio.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Oklahoma");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_oklahoma.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Oregon");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_oregon.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Pennsylvania");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_pennsylvania.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Rhode Island");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_rhode_island.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "South Carolina");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_south_carolina.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "South Dakota");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_south_dakota.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Tennessee");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_tennessee.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Texas");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_texas.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Utah");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_utah.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Vermont");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_vermont.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Virginia");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_virginia.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Washington");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_washington.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "West Virginia");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_west_virginia.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Wisconsin");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_wisconsin.png");
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Wyoming");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_wyoming.png");
        db.insert(STATES_TABLE, null, values);
    }

    public Cursor getStateData(){
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

    public Cursor searchStatesByName(String query){
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

    public Cursor searchStatesByTrumpSupport(){
        SQLiteDatabase db = this.getReadableDatabase();

        //where clause:
        String selections = "trump_support = ?";

        String[] selectionArgs = new String[] {
                String.valueOf(1)
        };

        Cursor cursor = db.query(STATES_TABLE, // a. table
                COL_NAMES, // b. column names
                selections, // c. selections
                selectionArgs, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        return cursor;
    }

}
