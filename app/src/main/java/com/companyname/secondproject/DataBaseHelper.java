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
    public static final String COL_POPULATION = "population";
    public static final String COL_TRUMP_VOTES = "trump_votes";
    public static final String COL_DENSITY = "density";

    public static final String[] COL_NAMES = {COL_STATE_ID, COL_STATE_NAME, COL_TRUMP_SUPPORTER,
            COL_IMG_NAME, COL_POPULATION, COL_TRUMP_VOTES, COL_DENSITY};

    private static final String CREATE_STATES_TABLE =
            "CREATE TABLE " + STATES_TABLE +
                    "(" +
                    COL_STATE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_STATE_NAME + " TEXT, " +
                    COL_TRUMP_SUPPORTER + " INTEGER, " +
                    COL_IMG_NAME + " TEXT, " +
                    COL_POPULATION + " REAL, " +
                    COL_TRUMP_VOTES + " REAL, " +
                    COL_DENSITY + " REAL)";

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
        values.put(COL_TRUMP_QUOTE, "We can't continue to allow China to rape our country");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_1.png");
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "Donald J. Trump is calling for a total and complete shutdown of Muslims entering the " +
                "United States until our country's representatives can figure out what is going on");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_2.png");
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "Look at that face! Would anyone vote for that? Can you imagine that, the face of our next president?");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_3.png");
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "You could see there was blood coming out of her eyes. Blood coming out of her… wherever");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_4.png");
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "He’s not a war hero. He’s a war hero because he was captured. I like people who weren’t captured");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_5.png");
        db.insert(TRUMP_TABLE, null, values);
    }

    private void loadStatesTable(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(COL_STATE_NAME, "Alabama");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_alabama.png");
        values.put(COL_POPULATION, 4822023);
        values.put(COL_TRUMP_VOTES, 317735);
        float density = 4822023f / 317735f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Alaska");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_alaska.png");
        values.put(COL_POPULATION, 731449);
        values.put(COL_TRUMP_VOTES, 7346);
        density = 731449f / 7346f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Arizona");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_arizona.png");
        values.put(COL_POPULATION, 6553255);
        values.put(COL_TRUMP_VOTES, 249916);
        density = 6553255f / 249916f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Arkansas");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_arkansas.png");
        values.put(COL_POPULATION, 2949131);
        values.put(COL_TRUMP_VOTES, 133144);
        density = 2949131f / 133144f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "California");
        values.put(COL_IMG_NAME, "state_california.png");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_POPULATION, 38041430);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Colorado");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_colorado.png");
        values.put(COL_POPULATION, 5187582);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Connecticut");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_connecticut.png");
        values.put(COL_POPULATION, 3590347);
        values.put(COL_TRUMP_VOTES, 123367);
        density = 3590347f / 123367f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Delaware");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_delaware.png");
        values.put(COL_POPULATION, 917092);
        values.put(COL_TRUMP_VOTES, 42472);
        density = 917092f / 42472f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Florida");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_florida.png");
        values.put(COL_POPULATION, 19317568);
        values.put(COL_TRUMP_VOTES, 1077221);
        density = 19317568f / 1077221f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Georgia");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_georgia.png");
        values.put(COL_POPULATION, 9919945);
        values.put(COL_TRUMP_VOTES, 501707);
        density = 9919945f / 501707f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Hawaii");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_hawaii.png");
        values.put(COL_POPULATION, 1392313);
        values.put(COL_TRUMP_VOTES, 6805);
        density = 1392313f / 6805f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Idaho");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_idaho.png");
        values.put(COL_POPULATION, 1595728);
        values.put(COL_TRUMP_VOTES, 62478);
        density = 1595728f / 62478f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Illinois");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_illinois.png");
        values.put(COL_POPULATION, 12875255);
        values.put(COL_TRUMP_VOTES, 556916);
        density = 12875255f / 556916f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Indiana");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_indiana.png");
        values.put(COL_POPULATION, 6537334);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Iowa");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_iowa.png");
        values.put(COL_POPULATION, 3074186);
        values.put(COL_TRUMP_VOTES, 45427);
        density = 3074186f / 45427f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Kansas");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_kansas.png");
        values.put(COL_POPULATION, 2885905);
        values.put(COL_TRUMP_VOTES, 17062);
        density = 2885905f / 17062f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Kentucky");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_kentucky.png");
        values.put(COL_POPULATION, 4380415);
        values.put(COL_TRUMP_VOTES, 82493);
        density = 4380415f / 82493f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Louisiana");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_louisiana.png");
        values.put(COL_POPULATION, 4601893);
        values.put(COL_TRUMP_VOTES, 124818);
        density = 4601893f / 124818f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Maine");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_maine.png");
        values.put(COL_POPULATION, 1329192);
        values.put(COL_TRUMP_VOTES, 124818);
        density = 1329192f / 124818f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Maryland");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_maryland.png");
        values.put(COL_POPULATION, 5884563);
        values.put(COL_TRUMP_VOTES, 236623);
        density = 5884563f / 236623f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Massachusetts");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_massachusetts.png");
        values.put(COL_POPULATION, 6646144);
        values.put(COL_TRUMP_VOTES, 311313);
        density = 6646144f / 311313f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Michigan");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_michigan.png");
        values.put(COL_POPULATION, 9883360);
        values.put(COL_TRUMP_VOTES, 483751);
        density = 9883360f / 483751f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Minnesota");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_minnesota.png");
        values.put(COL_POPULATION, 5379139);
        values.put(COL_TRUMP_VOTES, 24018);
        density = 5379139f / 24018f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Mississippi");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_mississippi.png");
        values.put(COL_POPULATION, 2984926);
        values.put(COL_TRUMP_VOTES, 191755);
        density = 2984926f / 191755f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Missouri");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_missouri.png");
        values.put(COL_POPULATION, 6021988);
        values.put(COL_TRUMP_VOTES, 382093);
        density = 6021988f / 382093f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Montana");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_montana.png");
        values.put(COL_POPULATION, 1005141);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Nebraska");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_nebraska.png");
        values.put(COL_POPULATION, 1855525);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Nevada");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_nevada.png");
        values.put(COL_POPULATION, 2758931);
        values.put(COL_TRUMP_VOTES, 34531);
        density = 2758931f / 34531f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "New Hampshire");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_new_hampshire.png");
        values.put(COL_POPULATION, 1320718);
        values.put(COL_TRUMP_VOTES, 100406);
        density = 1320718f / 100406f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "New Jersey");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_new_jersey.png");
        values.put(COL_POPULATION, 8864590);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "New Mexico");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_new_mexico.png");
        values.put(COL_POPULATION, 2085538);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "New York");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_new_york.png");
        values.put(COL_POPULATION, 19570261);
        values.put(COL_TRUMP_VOTES, 524932);
        density = 19570261f / 524932f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "North Carolina");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_north_carolina.png");
        values.put(COL_POPULATION, 9752073);
        values.put(COL_TRUMP_VOTES, 458151);
        density = 9752073f / 458151f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "North Dakota");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_north_dakota.png");
        values.put(COL_POPULATION, 699628);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Ohio");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_ohio.png");
        values.put(COL_POPULATION, 11544225);
        values.put(COL_TRUMP_VOTES, 727585);
        density = 11544225f / 727585f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Oklahoma");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_oklahoma.png");
        values.put(COL_POPULATION, 3814820);
        values.put(COL_TRUMP_VOTES, 130141);
        density = 3814820f / 130141f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Oregon");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_oregon.png");
        values.put(COL_POPULATION, 3899353);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Pennsylvania");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_pennsylvania.png");
        values.put(COL_POPULATION, 12763536);
        values.put(COL_TRUMP_VOTES, 892702);
        density = 12763536f / 892702f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Rhode Island");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_rhode_island.png");
        values.put(COL_POPULATION, 1050292);
        values.put(COL_TRUMP_VOTES, 39059);
        density = 1050292f / 39059f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "South Carolina");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_south_carolina.png");
        values.put(COL_POPULATION, 4723723);
        values.put(COL_TRUMP_VOTES, 239851);
        density = 4723723f / 239851f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "South Dakota");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_south_dakota.png");
        values.put(COL_POPULATION, 833354);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Tennessee");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_tennessee.png");
        values.put(COL_POPULATION, 6456243);
        values.put(COL_TRUMP_VOTES, 332702);
        density = 6456243f / 332702f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Texas");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_texas.png");
        values.put(COL_POPULATION, 26059203);
        values.put(COL_TRUMP_VOTES, 757618);
        density = 26059203f / 757618f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Utah");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_utah.png");
        values.put(COL_POPULATION, 2855287);
        values.put(COL_TRUMP_VOTES, 24864);
        density = 2855287f / 24864f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Vermont");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_vermont.png");
        values.put(COL_POPULATION, 626011);
        values.put(COL_TRUMP_VOTES, 19968);
        density = 626011f / 19968f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Virginia");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_virginia.png");
        values.put(COL_POPULATION, 8185867);
        values.put(COL_TRUMP_VOTES, 355960);
        density = 8185867f / 355960f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Washington");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_washington.png");
        values.put(COL_POPULATION, 6897012);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "West Virginia");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_west_virginia.png");
        values.put(COL_POPULATION, 1855413);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Wisconsin");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_wisconsin.png");
        values.put(COL_POPULATION, 5726398);
        values.put(COL_TRUMP_VOTES, 386370);
        density = 5726398f / 386370f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Wyoming");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_wyoming.png");
        values.put(COL_POPULATION, 576412);
        values.put(COL_TRUMP_VOTES, 70);
        density = 576412f / 70f;
        values.put(COL_DENSITY, density);
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

    public int getStateVotingStatusAtIndex(int index) {
        SQLiteDatabase db = this.getReadableDatabase();

        //where clause:
        String selections = "_id = ?";

        String[] selectionArgs = new String[] {
                String.valueOf(index)
        };

        Cursor cursor = db.query(STATES_TABLE, // a. table
                COL_NAMES, // b. column names
                selections, // c. selections
                selectionArgs, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        cursor.moveToFirst();
        int status = cursor.getInt(cursor.getColumnIndex(COL_TRUMP_SUPPORTER));
        cursor.close();

        return status;
    }

    public String getTrumpQuoteAtIndex(int index) {
        SQLiteDatabase db = this.getReadableDatabase();

        //where clause:
        String selections = "_id = ?";

        String[] selectionArgs = new String[] {
                String.valueOf(index)
        };

        Cursor cursor = db.query(TRUMP_TABLE, // a. table
                TRUMP_COL_NAMES, // b. column names
                selections, // c. selections
                selectionArgs, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        cursor.moveToFirst();
        String quote = cursor.getString(cursor.getColumnIndex(COL_TRUMP_QUOTE));
        cursor.close();

        return quote;
    }

    public String getImagePathAtIndex(int index) {
        SQLiteDatabase db = this.getReadableDatabase();

        //where clause:
        String selections = "_id = ?";

        String[] selectionArgs = new String[] {
                String.valueOf(index)
        };

        Cursor cursor = db.query(TRUMP_TABLE, // a. table
                TRUMP_COL_NAMES, // b. column names
                selections, // c. selections
                selectionArgs, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        cursor.moveToFirst();
        String quote = cursor.getString(cursor.getColumnIndex(COL_TRUMP_IMG_NAME));
        cursor.close();

        return quote;
    }

    public int getTrumpTableSize() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TRUMP_TABLE, // a. table
                TRUMP_COL_NAMES, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        int size = cursor.getCount();
        cursor.close();

        return size;
    }

}
