/*
 * This class represents the database of Memory game. It stores the name of each player and their
 * total wins of each mode they have played. It also supports methods regarding the data management.
 */

package com.android.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHandler extends SQLiteOpenHelper {

    //static values regarding the database, table and column names
    public static final String DATABASE_NAME = "player.db";
    public static final String TABLE_PLAYERS = "players";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PAIRSOF2WINS = "pairsOf2Wins";
    public static final String COLUMN_PAIRSOF3WINS = "pairsOf3Wins";
    public static final String COLUMN_BATTLEWINS = "battleWins";

    //constructor of the database
    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, null, 1);
    }

    //method regarding the creation of the database
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PLAYERS_TABLE = "CREATE TABLE " + TABLE_PLAYERS + "(" + COLUMN_ID +
                " INTEGER PRIMARY KEY," + COLUMN_NAME + " TEXT,"
                + COLUMN_PAIRSOF2WINS + " INTEGER," + COLUMN_PAIRSOF3WINS + " INTEGER,"
                + COLUMN_BATTLEWINS + " INTEGER" + ")";

        db.execSQL(CREATE_PLAYERS_TABLE);
    }

    //methods regarding the update of the database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYERS);
        onCreate(db);
    }

    //method regarding deleting all data in the table
    public void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PLAYERS);
        db.close();
    }


    //method that creates a new row of data about a new player
    public void addNewPlayer(Player player) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, player.getName());
        values.put(COLUMN_PAIRSOF2WINS, 0);
        values.put(COLUMN_PAIRSOF3WINS, 0);
        values.put(COLUMN_BATTLEWINS, 0);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_PLAYERS, null, values);
        db.close();
    }



    //method that creates a row of fixed data about an imaginary player for experimentation.
    public void addPlayer(String name, int num1, int num2, int num3) {
       // if (findPlayer(name) !=null) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, name);
            values.put(COLUMN_PAIRSOF2WINS, num1);
            values.put(COLUMN_PAIRSOF3WINS, num2);
            values.put(COLUMN_BATTLEWINS, num3);
            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(TABLE_PLAYERS, null, values);
            db.close();
        //}
    }



    //method that finds the player data based on name if they exist. If they don't, it returns null.
    public Player findPlayer(String playerName) {
        String query = "SELECT * FROM " + TABLE_PLAYERS + " WHERE " + COLUMN_NAME + " = '"
                + playerName + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Player player = new Player("");
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            Log.d(null, cursor.getString(1) + " " + cursor.getString(2) + " " + cursor.getString(3) + " " + cursor.getString(4));
            player.setName(cursor.getString(1));
            player.setPairsOf2Wins(Integer.parseInt(cursor.getString(2)));
            player.setPairsOf3Wins(Integer.parseInt(cursor.getString(3)));
            player.setBattleWins(Integer.parseInt(cursor.getString(4)));
            cursor.close();
        }
        else { player = null; }
        db.close();
        return player;
        }



    //methods that deletes the data of a player based on the name
    public boolean deletePlayer(String playerName) {
        boolean result = false;
        String query = "SELECT * FROM " + TABLE_PLAYERS + " WHERE " + COLUMN_NAME + " = '"
                + playerName + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Player player = new Player("");
        if (cursor.moveToFirst()) {
            player.setName(cursor.getString(1));
            db.delete(TABLE_PLAYERS, COLUMN_NAME + " = ?", new String[] { String.valueOf(player.getName()) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }



    //method that updates the data of the mentioned player in the player table
    public void updateData(Player player){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, player.getName());
        values.put(COLUMN_PAIRSOF2WINS, player.getPairsOf2Wins());
        values.put(COLUMN_PAIRSOF3WINS, player.getPairsOf3Wins());
        values.put(COLUMN_BATTLEWINS, player.getBattleWins());
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_PLAYERS, values, COLUMN_NAME + " = ?", new String[] {player.getName()});
        db.close();
    }



    //method that finds the players with the highest pairs of 2 wins.
    //For multiple results, the result table is being randomized and the first element is selected.
    public Player findHighestPairsOfTwoWinsPlayer(){
        String query = "SELECT name, MAX(" + COLUMN_PAIRSOF2WINS + ") FROM " + TABLE_PLAYERS
                + " ORDER BY RANDOM()";
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);
            Player player = new Player("");
            if (cursor.moveToFirst()) {
                cursor.moveToFirst();
                player.setName(cursor.getString(0));
                player.setPairsOf2Wins(Integer.parseInt(cursor.getString(1)));
                cursor.close();
            }
            else { player = null; }
            db.close();
            return player;
    }

    //method that finds the players with the highest pairs of 3 wins.
    //For multiple results, the result table is being randomized and the first element is selected.
    public Player findHighestPairsOfThreeWinsPlayer(){
        String query = "SELECT name, MAX(" + COLUMN_PAIRSOF3WINS + ") FROM " + TABLE_PLAYERS
                + " ORDER BY RANDOM()";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Player player = new Player("");
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            player.setName(cursor.getString(0));
            player.setPairsOf3Wins(Integer.parseInt(cursor.getString(1)));
            cursor.close();
        }
        else { player = null; }
        db.close();
        return player;
    }



    //method that finds the players with the highest one on one wins.
    //For multiple results, the result table is being randomized and the first element is selected.
    public Player findHighestBattleWinsPlayer(){
        String query = "SELECT name, MAX(" + COLUMN_BATTLEWINS + ") FROM " + TABLE_PLAYERS
                + " ORDER BY RANDOM()";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Player player = new Player("");
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            player.setName(cursor.getString(0));
            player.setBattleWins(Integer.parseInt(cursor.getString(1)));
            cursor.close();
        }
        else { player = null; }
        db.close();
        return player;
    }

}
