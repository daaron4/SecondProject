package com.companyname.secondproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Random;

/**
 * Created by David on 4/27/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper{

    // This is the database helper class
    // There are two tables in this database, one that contains trump data,
    // the other contains state data

    // All column names and such:
    public static final String DATABASE_NAME = "States.db";
    public static final int DATABASE_VERSION = 1;

    public static final String STATES_TABLE = "states";

    public static final String COL_STATE_ID = "_id";
    public static final String COL_STATE_NAME = "state_name";
    public static final String COL_TRUMP_SUPPORTER = "trump_support";
    public static final String COL_IMG_NAME = "img_name";
    public static final String COL_SQUARE_MILES = "square_miles";
    public static final String COL_TRUMP_VOTES = "trump_votes";
    public static final String COL_DENSITY = "density";

    public static final String[] COL_NAMES = {COL_STATE_ID, COL_STATE_NAME, COL_TRUMP_SUPPORTER,
            COL_IMG_NAME, COL_SQUARE_MILES, COL_TRUMP_VOTES, COL_DENSITY};

    private static final String CREATE_STATES_TABLE =
            "CREATE TABLE " + STATES_TABLE +
                    "(" +
                    COL_STATE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_STATE_NAME + " TEXT, " +
                    COL_TRUMP_SUPPORTER + " INTEGER, " +
                    COL_IMG_NAME + " TEXT, " +
                    COL_SQUARE_MILES + " REAL, " +
                    COL_TRUMP_VOTES + " REAL, " +
                    COL_DENSITY + " REAL)";

    public static final String TRUMP_TABLE = "trump";

    public static final String COL_TRUMP_ID = "_id";
    public static final String COL_TRUMP_QUOTE = "trump_quote";
    public static final String COL_TRUMP_IMG_NAME = "trump_img_name";
    public static final String COL_FAVORITE = "favorite";

    public static final String[] TRUMP_COL_NAMES = {COL_TRUMP_ID, COL_TRUMP_QUOTE, COL_TRUMP_IMG_NAME, COL_FAVORITE};

    private static final String CREATE_TRUMP_TABLE =
            "CREATE TABLE " + TRUMP_TABLE +
                    "(" +
                    COL_TRUMP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_TRUMP_QUOTE + " TEXT, " +
                    COL_TRUMP_IMG_NAME + " TEXT, " +
                    COL_FAVORITE + " INTEGER)";

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
        values.put(COL_TRUMP_QUOTE, "\"We can't continue to allow China to rape our country\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_1.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"Donald J. Trump is calling for a total and complete shutdown of Muslims entering the " +
                "United States until our country's representatives can figure out what is going on.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_2.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "(About Carly Fiorina...) \"Look at that face! Would anyone vote " +
                        "for that? Can you imagine that, the face of our next president?\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_3.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "(About Megyn Kelly...) \"You could see there was blood coming out of her eyes. Blood coming out of her… wherever.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_4.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "(About John McCain...) \"He’s not a war hero. He’s a war hero because he was captured. I like people who weren’t captured\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_5.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"I have a great relationship with the Mexican people.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_6.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"I actually don't have a bad hairline.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_7.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"Because I was down there and I watched our police and our firemen down at 7/11, " +
                "down at the World Trade Center right after it came down. And I saw the greatest people I've ever seen in action.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_8.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"You know, it doesn't really matter what (the media) writes as long as you've got a young and beautiful piece of ass.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_9.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"All of the women on 'The Apprentice' flirted with me — consciously or unconsciously. That’s to be expected.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_10.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"I will build a great wall – and nobody builds walls better than me, believe me – and " +
                "I’ll build them very inexpensively. I will build a great, great wall on our Southern border, and I will make " +
                "Mexico pay for that wall. Mark my words.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_11.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"I have never seen a thin person drinking Diet Coke.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_12.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"26,000 unreported sexual assaults in the military — only 238 convictions. " +
                "What did these geniuses expect when they put men & women together?\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_13.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"The most difficult aspect of the prenuptial agreement is informing your future wife (or husband): " +
                "I love you very much, but just in case things don’t work out, this is what you will get in the divorce. There are " +
                "basically three types of women and reactions. One is the good woman who very much loves her future husband, solely " +
                "for himself, but refuses to sign the agreement on principle. I fully understand this, but the man should take a pass " +
                "anyway and find someone else. The other is the calculating woman who refuses to sign the prenuptial agreement because " +
                "she is expecting to take advantage of the poor, unsuspecting sucker she’s got in her grasp. There is also the woman who" +
                " will openly and quickly sign a prenuptial agreement in order to make a quick hit and take the money given to her\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_14.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"Angelina Jolie’s been with so many guys she makes me look like a baby... And, I just don’t even find her attractive\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_15.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"Women have one of the great acts of all time. The smart ones act very feminine and needy, but inside they " +
                "are real killers. The person who came up with the expression ‘the weaker sex’ was either very naive or had to be kidding. " +
                "I have seen women manipulate men with just a twitch of their eye — or perhaps another body part\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_16.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"Cher is somewhat of a loser. She's lonely. She's unhappy. She's very miserable\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_17.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "(About himself...) \"Women find his power almost as much of a turn-on as his money\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_18.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"I think the only difference between me and the other candidates " +
                "is that I’m more honest and my women are more beautiful\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_19.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"My IQ is one of the highest — and you all know it! Please don't feel so stupid or insecure; it's not your fault\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_20.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "(About his daughter...) \"Yeah, she's really something, and what a beauty, that one. If I weren't happily married and, ya know, her father\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_1.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "(This quote is by Ronald Regan...) \"The line of ‘Make America Great Again,’ the phrase, that was mine, I came up with it about a year ago, " +
                "and I kept using it, and everybody’s using it, they are all loving it. I don’t know; I guess I should copyright it, maybe I have copyrighted it.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_2.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"If Ivanka weren't my daughter, perhaps I'd be dating her\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_3.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"Women are far stronger than men. Their sex drive makes us look like babies. Some women try to portray themselves as being of the weaker sex, but " +
                "don’t believe it for a minute.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_4.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"Women are far worse than men, far more aggressive, and boy, can they be smart. Let’s give credit where credit is due, and let’s salute women for their " +
                "tremendous power, which most men are afraid to admit they have.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_5.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"My fingers are long and beautiful, as, it has been well been documented, are various other parts of my body.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_6.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"In life you have to rely on the past, and that's called history.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_7.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"Part of the beauty of me is that I am very rich.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_8.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"Money was never a big motivation for me, except as a way to keep score.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_9.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"I am being proven right about massive vaccinations. The doctors lied. Save our children and their future.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_10.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"When Mexico sends its people, they’re not sending their best. They’re not sending you. They’re sending people that " +
                "have lots of problems, and they’re bringing those problems with them. They’re bringing drugs. They’re bringing crime. " +
                "They’re rapists. And some, I assume, are good people.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_11.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"I’m not a racist. I don’t have a racist bone in my body.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_12.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"What can be simpler or more accurately stated? The Mexican Government is forcing their most unwanted people into the United States. " +
                "They are, in many cases, criminals, drug dealers, rapists, etc.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_13.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "(About 'Pulp Fiction') \"My favorite part is when Sam has his gun out in the diner and he tells the guy to tell his girlfriend to " +
                "shut up. Tell that bitch to be cool. Say: ‘Bitch be cool.’ I love those lines.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_14.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"Today I officially declare my candidacy for President of the United States.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_15.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"Rosie O’Donnell’s disgusting. I mean, both inside and out. You take a look at her, she’s a slob.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_16.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"It’s certainly not groundbreaking news that the early victories by the women on ‘The Apprentice’ were, to " +
                "a very large extent, dependent on their sex appeal.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_17.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"I have really given a lot of women great opportunity. Unfortunately, after they are a star, the fun is over for me.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_18.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "(About Women...) \"You have to treat ’em like shit.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_19.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"When a man leaves a woman, especially when it was perceived that he has left for a piece of ass—a good " +
                "one!—there are 50 percent of the population who will love the woman who was left.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_20.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"New Hampshire has a tremendous drug epidemic. I am going to create borders. No drugs are coming in. We're going to build a wall.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_1.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"When you get these terrorists, you have to take out their families.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_2.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "\"I would bring back waterboarding, and I would bring back a hell of a lot worse than waterboarding." +
                " You can rest assured that as commander in chief, I would use whatever enhanced interrogation methods we could to keep this country safe.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_3.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

        values.put(COL_TRUMP_QUOTE, "(About John McCain...) \"But you know, he lost, so I’ve never liked him as much after that, because I don’t like losers.\"");
        values.put(COL_TRUMP_IMG_NAME, "trump_img_4.png");
        values.put(COL_FAVORITE, 0);
        db.insert(TRUMP_TABLE, null, values);

    }

    private void loadStatesTable(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(COL_STATE_NAME, "Alabama");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_alabama.png");
        values.put(COL_SQUARE_MILES, 50744);
        values.put(COL_TRUMP_VOTES, 317735);
        float density = 317735f / 50744f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Alaska");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_alaska.png");
        values.put(COL_SQUARE_MILES, 571951);
        values.put(COL_TRUMP_VOTES, 7346);
        density = 7346f / 571951f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Arizona");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_arizona.png");
        values.put(COL_SQUARE_MILES, 113635);
        values.put(COL_TRUMP_VOTES, 249916);
        density = 249916f / 113635f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Arkansas");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_arkansas.png");
        values.put(COL_SQUARE_MILES, 52068);
        values.put(COL_TRUMP_VOTES, 133144);
        density = 133144f / 52068f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "California");
        values.put(COL_IMG_NAME, "state_california.png");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_SQUARE_MILES, 155959);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f / 155959f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Colorado");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_colorado.png");
        values.put(COL_SQUARE_MILES, 103718);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f / 103718f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Connecticut");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_connecticut.png");
        values.put(COL_SQUARE_MILES, 4845);
        values.put(COL_TRUMP_VOTES, 123367);
        density = 123367f / 4845f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Delaware");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_delaware.png");
        values.put(COL_SQUARE_MILES, 1954);
        values.put(COL_TRUMP_VOTES, 42472);
        density = 42472f / 1954f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Florida");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_florida.png");
        values.put(COL_SQUARE_MILES, 53927);
        values.put(COL_TRUMP_VOTES, 1077221);
        density = 1077221f / 53927f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Georgia");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_georgia.png");
        values.put(COL_SQUARE_MILES, 57906);
        values.put(COL_TRUMP_VOTES, 501707);
        density = 501707f / 57906f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Hawaii");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_hawaii.png");
        values.put(COL_SQUARE_MILES, 6423);
        values.put(COL_TRUMP_VOTES, 6805);
        density = 6805f / 6423f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Idaho");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_idaho.png");
        values.put(COL_SQUARE_MILES, 82747);
        values.put(COL_TRUMP_VOTES, 62478);
        density = 62478f / 82747f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Illinois");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_illinois.png");
        values.put(COL_SQUARE_MILES, 55584);
        values.put(COL_TRUMP_VOTES, 556916);
        density = 556916f / 55584f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Indiana");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_indiana.png");
        values.put(COL_SQUARE_MILES, 35867);
        values.put(COL_TRUMP_VOTES, 587706);
        density = 35867f / 587706f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Iowa");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_iowa.png");
        values.put(COL_SQUARE_MILES, 55869);
        values.put(COL_TRUMP_VOTES, 45427);
        density = 45427f / 55869f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Kansas");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_kansas.png");
        values.put(COL_SQUARE_MILES, 81815);
        values.put(COL_TRUMP_VOTES, 17062);
        density = 17062f / 81815f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Kentucky");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_kentucky.png");
        values.put(COL_SQUARE_MILES, 39728);
        values.put(COL_TRUMP_VOTES, 82493);
        density = 82493f / 39728f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Louisiana");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_louisiana.png");
        values.put(COL_SQUARE_MILES, 43562);
        values.put(COL_TRUMP_VOTES, 124818);
        density = 124818f / 43562f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Maine");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_maine.png");
        values.put(COL_SQUARE_MILES, 30862);
        values.put(COL_TRUMP_VOTES, 124818);
        density = 124818f / 30862f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Maryland");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_maryland.png");
        values.put(COL_SQUARE_MILES, 9774);
        values.put(COL_TRUMP_VOTES, 236623);
        density = 236623f / 9774f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Massachusetts");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_massachusetts.png");
        values.put(COL_SQUARE_MILES, 7840);
        values.put(COL_TRUMP_VOTES, 311313);
        density = 311313f / 7840f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Michigan");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_michigan.png");
        values.put(COL_SQUARE_MILES, 56804);
        values.put(COL_TRUMP_VOTES, 483751);
        density = 483751f / 56804f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Minnesota");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_minnesota.png");
        values.put(COL_SQUARE_MILES, 79610);
        values.put(COL_TRUMP_VOTES, 24018);
        density = 24018f / 79610f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Mississippi");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_mississippi.png");
        values.put(COL_SQUARE_MILES, 46907);
        values.put(COL_TRUMP_VOTES, 191755);
        density = 191755f / 46907f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Missouri");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_missouri.png");
        values.put(COL_SQUARE_MILES, 68886);
        values.put(COL_TRUMP_VOTES, 382093);
        density = 382093f / 68886f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Montana");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_montana.png");
        values.put(COL_SQUARE_MILES, 145552);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f / 145552f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Nebraska");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_nebraska.png");
        values.put(COL_SQUARE_MILES, 76872);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f / 76872f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Nevada");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_nevada.png");
        values.put(COL_SQUARE_MILES, 109826);
        values.put(COL_TRUMP_VOTES, 34531);
        density = 34531f / 109826f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "New Hampshire");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_new_hampshire.png");
        values.put(COL_SQUARE_MILES, 8968);
        values.put(COL_TRUMP_VOTES, 100406);
        density = 100406f / 8968f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "New Jersey");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_new_jersey.png");
        values.put(COL_SQUARE_MILES, 7417);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f / 7417f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "New Mexico");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_new_mexico.png");
        values.put(COL_SQUARE_MILES, 121356);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f / 121356f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "New York");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_new_york.png");
        values.put(COL_SQUARE_MILES, 47214);
        values.put(COL_TRUMP_VOTES, 524932);
        density = 524932f / 47214f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "North Carolina");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_north_carolina.png");
        values.put(COL_SQUARE_MILES, 48711);
        values.put(COL_TRUMP_VOTES, 458151);
        density = 458151f / 48711f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "North Dakota");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_north_dakota.png");
        values.put(COL_SQUARE_MILES, 68976);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f / 68976f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Ohio");
        values.put(COL_TRUMP_SUPPORTER, 3);
        values.put(COL_IMG_NAME, "state_ohio.png");
        values.put(COL_SQUARE_MILES, 40948);
        values.put(COL_TRUMP_VOTES, 727585);
        density = 727585f / 40948f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Oklahoma");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_oklahoma.png");
        values.put(COL_SQUARE_MILES, 68667);
        values.put(COL_TRUMP_VOTES, 130141);
        density = 130141f / 68667f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Oregon");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_oregon.png");
        values.put(COL_SQUARE_MILES, 95997);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f / 95997f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Pennsylvania");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_pennsylvania.png");
        values.put(COL_SQUARE_MILES, 44817);
        values.put(COL_TRUMP_VOTES, 892702);
        density = 892702f / 44817f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Rhode Island");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_rhode_island.png");
        values.put(COL_SQUARE_MILES, 1045);
        values.put(COL_TRUMP_VOTES, 39059);
        density = 39059f / 1045f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "South Carolina");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_south_carolina.png");
        values.put(COL_SQUARE_MILES, 30110);
        values.put(COL_TRUMP_VOTES, 239851);
        density = 239851f / 30110f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "South Dakota");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_south_dakota.png");
        values.put(COL_SQUARE_MILES, 75885);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f / 75885;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Tennessee");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_tennessee.png");
        values.put(COL_SQUARE_MILES, 41217);
        values.put(COL_TRUMP_VOTES, 332702);
        density = 332702f / 41217f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Texas");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_texas.png");
        values.put(COL_SQUARE_MILES, 261797);
        values.put(COL_TRUMP_VOTES, 757618);
        density = 757618f / 261797f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Utah");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_utah.png");
        values.put(COL_SQUARE_MILES, 82144);
        values.put(COL_TRUMP_VOTES, 24864);
        density = 24864f / 82144f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Vermont");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_vermont.png");
        values.put(COL_SQUARE_MILES, 9250);
        values.put(COL_TRUMP_VOTES, 19968);
        density = 19968f / 9250f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Virginia");
        values.put(COL_TRUMP_SUPPORTER, 1);
        values.put(COL_IMG_NAME, "state_virginia.png");
        values.put(COL_SQUARE_MILES, 39594);
        values.put(COL_TRUMP_VOTES, 355960);
        density = 355960f / 39594f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Washington");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_washington.png");
        values.put(COL_SQUARE_MILES, 66544);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f / 66544f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "West Virginia");
        values.put(COL_TRUMP_SUPPORTER, 2);
        values.put(COL_IMG_NAME, "state_west_virginia.png");
        values.put(COL_SQUARE_MILES, 24078);
        values.put(COL_TRUMP_VOTES, 0);
        density = 0f / 24078f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Wisconsin");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_wisconsin.png");
        values.put(COL_SQUARE_MILES, 54310);
        values.put(COL_TRUMP_VOTES, 386370);
        density = 386370f / 54310f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);

        values.put(COL_STATE_NAME, "Wyoming");
        values.put(COL_TRUMP_SUPPORTER, 0);
        values.put(COL_IMG_NAME, "state_wyoming.png");
        values.put(COL_SQUARE_MILES, 97100);
        values.put(COL_TRUMP_VOTES, 70);
        density = 70f / 97100f;
        values.put(COL_DENSITY, density);
        db.insert(STATES_TABLE, null, values);
    }

    // All methods are self explanitory:

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

    public Cursor getTrumpTableData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TRUMP_TABLE, // a. table
                TRUMP_COL_NAMES, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        return cursor;
    }

    public Cursor getDensityData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(STATES_TABLE, // a. table
                COL_NAMES, // b. column names
                null, // c. selections
                null, // d. selections args
                null, // e. group by
                null, // f. having
                COL_DENSITY + " DESC ", // g. order by
                null); // h. limit
        return cursor;
    }

    public Cursor filterByDensity(int numberQuery){
        SQLiteDatabase db = this.getReadableDatabase();
        //where clause:
        String selections = "density > ?";

        String[] selectionArgs = new String[] {
                String.valueOf(numberQuery)
        };

        Cursor cursor = db.query(STATES_TABLE, // a. table
                COL_NAMES, // b. column names
                selections, // c. selections
                selectionArgs, // d. selections args
                null, // e. group by
                null, // f. having
                COL_DENSITY + " DESC ", // g. order by
                null); // h. limit
        return cursor;
    }

    public Cursor filterByStateSize(int numberQuery){
        SQLiteDatabase db = this.getReadableDatabase();
        //where clause:
        String selections = "square_miles < ?";

        String[] selectionArgs = new String[] {
                String.valueOf(numberQuery)
        };

        Cursor cursor = db.query(STATES_TABLE, // a. table
                COL_NAMES, // b. column names
                selections, // c. selections
                selectionArgs, // d. selections args
                null, // e. group by
                null, // f. having
                COL_SQUARE_MILES + " DESC ", // g. order by
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

    public Cursor searchQuotes(String query){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TRUMP_TABLE, // a. table
                TRUMP_COL_NAMES, // b. column names
                COL_TRUMP_QUOTE + " LIKE ?", // c. selections
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

    public void addQuote(String quote) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_TRUMP_QUOTE, quote);
        Random random = new Random();
        // ToDo: can't forget to update this if ever more pictures get added:
        int numberOfPictures = 20;
        int randNum = random.nextInt(numberOfPictures) + 1;
        String imageNameToAdd = "trump_img_" + randNum + ".png";
        values.put(COL_TRUMP_IMG_NAME, imageNameToAdd);
        values.put(COL_FAVORITE, 0);

        db.insert(TRUMP_TABLE, null, values);
    }

    public void favoriteQuoteAtIndex(int index) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_FAVORITE, 1);

        String selection = "_id = ?";

        String[] selectionArgs = new String[]{
                String.valueOf(index)
        };

        db.update(TRUMP_TABLE, values, selection, selectionArgs);
    }

    public Cursor getFavoriteQuotes(){
        SQLiteDatabase db = this.getReadableDatabase();
        //where clause:
        String selections = "favorite = ?";

        String[] selectionArgs = new String[] {
                String.valueOf(1)
        };

        Cursor cursor = db.query(TRUMP_TABLE, // a. table
                TRUMP_COL_NAMES, // b. column names
                selections, // c. selections
                selectionArgs, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit
        return cursor;
    }

    public void removeQuoteFromFavorites(int index){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_FAVORITE, 0);

        String selection = "_id = ?";

        String[] selectionArgs = new String[]{
                String.valueOf(index)
        };

        db.update(TRUMP_TABLE, values, selection, selectionArgs);
    }

}
