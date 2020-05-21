//activity that presents the highscores
package com.android.MemoryGameActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.Database.DBHandler;
import com.android.Database.Player;
import com.memory_game.app.R;

import org.w3c.dom.Text;


//activity regarding the highscores of players on each mode
public class Highscores extends AppCompatActivity {

    TextView P1tv;
    TextView P2tv;
    TextView P3tv;

    //creates the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscores);

        DBHandler db = new DBHandler(this, null, null, 1);
        P1tv = findViewById(R.id.PlayerData1);
        P2tv = findViewById(R.id.PlayerData2);
        P3tv = findViewById(R.id.PlayerData3);

        //restoring data upon activity recreation
        if(savedInstanceState!=null){
            //Retrieve data from the Bundle
            CharSequence savedP1tvText = savedInstanceState.getCharSequence("savedP1tvText");
            CharSequence savedP2tvText = savedInstanceState.getCharSequence("savedP2tvText");
            CharSequence savedP3tvText = savedInstanceState.getCharSequence("savedP3tvText");


            //Restore the dynamic state of the UI
            P1tv.setText(savedP1tvText);
            P2tv.setText(savedP2tvText);
            P3tv.setText(savedP3tvText);

        }
        else{
            //initializing data

            //code below is used to experiment with database
            db.addPlayer("Cheat", 1000, 1000, 1000);
            db.deleteAllData();
            db.addPlayer("Dimosthenis", 45, 400, 300);
            db.addPlayer("Maria", 32, 45, 45);
            db.addPlayer("Thanos", 36, 20, 9);


            Player P1 = db.findHighestPairsOfTwoWinsPlayer();
            Player P2 = db.findHighestPairsOfThreeWinsPlayer();
            Player P3 = db.findHighestBattleWinsPlayer();

            //sets text at default value: "none"
            P1tv.setText("None");
            P2tv.setText("None");
            P3tv.setText("None");

            //adds a player on highscores of a mode if they have at least 1 win in that mode
            if (P1 != null && P1.getPairsOf2Wins() != 0) {
                P1tv.setText("" + P1.getName() + " " + P1.getPairsOf2Wins());
            }
            if (P2 != null && P2.getPairsOf3Wins() != 0) {
                P2tv.setText("" + P2.getName() + " " + P2.getPairsOf3Wins());
            }
            if (P3 != null && P3.getBattleWins() != 0) {
                P3tv.setText("" + P3.getName() + " " + P3.getBattleWins());
            }
        }
    }

    //saving the data upon destruction of activity
    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        CharSequence P1tvText = P1tv.getText();
        outState.putCharSequence("savedP1tvText", P1tvText);
        CharSequence P2tvText = P2tv.getText();
        outState.putCharSequence("savedP2tvText", P2tvText);
        CharSequence P3tvText = P3tv.getText();
        outState.putCharSequence("savedP3tvText", P3tvText);
    }

    //function of exit button that returns to the main activity
    public void exit(View view){
        onBackPressed();
    }
}
