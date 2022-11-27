package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MovieDB extends SQLiteOpenHelper {

    // creating constant variables for the database
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

    // Method for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TITLE_COL + " TEXT,"
                + DURATION_COL + " TEXT,"
                + GENRE_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT,"
                + PRICE_COL + " TEXT)";

        // execute query
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

    // Method to read all the movies
    public ArrayList<MovieDTO> readMovies() {

        // Creating a database to read our database
        SQLiteDatabase db = this.getReadableDatabase();

        // Creating a cursor with query to read data from database.
        Cursor cursorMovies = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        // Creating a new array list.
        ArrayList<MovieDTO> movieDTOArrayList = new ArrayList<>();

        // Moving cursor to first position.
        if (cursorMovies.moveToFirst()) {
            do {
                // Adding the data from cursor to our array list.
                movieDTOArrayList.add(new MovieDTO(cursorMovies.getString(1),
                        cursorMovies.getString(2),
                        cursorMovies.getString(3),
                        cursorMovies.getString(4),
                        cursorMovies.getString(5)));
            } while (cursorMovies.moveToNext());
            // Moving cursor to next.
        }
        // Closing the cursor
        cursorMovies.close();
        // Returning array list.
        return movieDTOArrayList;
    }

    // Method for updating the movies
    public void updateMovie(String originalMovieTitle, String movieTitle, String movieDuration,
                             String movieGenre, String movieDescription, String moviePrice) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // Passing all values along with its key and value pair.
        values.put(TITLE_COL, movieTitle);
        values.put(DURATION_COL, movieDuration);
        values.put(GENRE_COL, movieGenre);
        values.put(DESCRIPTION_COL, movieDescription);
        values.put(PRICE_COL, moviePrice);

        // Calling an update method to update the database and passing the values.
        // Comparing it with title of the movie which is stored in original title variable.
        db.update(TABLE_NAME, values, "title=?", new String[]{originalMovieTitle});
        db.close();
    }

    // Method for deleting a movie.
    public void deleteMovie(String movieTitle) {

        // Creating a variable to write to the database.
        SQLiteDatabase db = this.getWritableDatabase();

        // Calling a method to delete a movie and comparing it with the movie title.
        db.delete(TABLE_NAME, "title=?", new String[]{movieTitle});
        db.close();
    }

    // Method to check if the table exists already.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
