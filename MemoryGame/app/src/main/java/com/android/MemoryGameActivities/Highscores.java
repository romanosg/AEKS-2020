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

        //code below is used to experiment with database
        db.addPlayer("Cheat", 1000, 1000, 1000);
        db.deleteAllData();
        db.addPlayer("Dimosthenis", 45, 400, 300);
        db.addPlayer("Maria", 32, 45, 45);
        db.addPlayer("Thanos", 36, 20, 9);


        Player P1 = db.findHighestPairsOfTwoWinsPlayer();
        Player P2 = db.findHighestPairsOfThreeWinsPlayer();
        Player P3 = db.findHighestBattleWinsPlayer();

        //sets text at "none"
        P1tv = findViewById(R.id.PlayerData1);
        P1tv.setText("None");
        P2tv = findViewById(R.id.PlayerData2);
        P2tv.setText("None");
        P3tv = findViewById(R.id.PlayerData3);
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

    //function of exit button that returns to the main activity
    public void exit(View view){
        onBackPressed();
    }
}
