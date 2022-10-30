package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MovieDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "movieDB";

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "movies";

    private static final String ID_COL = "id";

    private static final String TITLE_COL = "title";

    private static final String DURATION_COL = "duration";

    private static final String GENRE_COL = "genre";

    private static final String DESCRIPTION_COL = "description";

    private static final String PRICE_COL = "price";


    public MovieDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TITLE_COL + " TEXT,"
                + DURATION_COL + " TEXT,"
                + GENRE_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT,"
                + PRICE_COL + " TEXT)";

        db.execSQL(query);
    }

    public void addNewMovie(String movieTitle, String movieDuration, String movieGenre, String movieDescription, String moviePrice) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(TITLE_COL, movieTitle);
        values.put(DURATION_COL, movieDuration);
        values.put(GENRE_COL, movieGenre);
        values.put(DESCRIPTION_COL, movieDescription);
        values.put(PRICE_COL, moviePrice);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    public ArrayList<MovieModal> readMovies() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorMovies = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        ArrayList<MovieModal> movieModalArrayList = new ArrayList<>();

        if (cursorMovies.moveToFirst()) {
            do {
                movieModalArrayList.add(new MovieModal(cursorMovies.getString(1),
                        cursorMovies.getString(2),
                        cursorMovies.getString(3),
                        cursorMovies.getString(4),
                        cursorMovies.getString(5)));
            } while (cursorMovies.moveToNext());
        }
        cursorMovies.close();
        return movieModalArrayList;
    }

    public void updateMovie(String originalMovieTitle, String movieTitle, String movieDuration,
                             String movieGenre, String movieDescription, String moviePrice) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TITLE_COL, movieTitle);
        values.put(DURATION_COL, movieDuration);
        values.put(GENRE_COL, movieGenre);
        values.put(DESCRIPTION_COL, movieDescription);
        values.put(PRICE_COL, moviePrice);

        db.update(TABLE_NAME, values, "title=?", new String[]{originalMovieTitle});
        db.close();
    }

    public void deleteMovie(String movieTitle) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, "title=?", new String[]{movieTitle});
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
