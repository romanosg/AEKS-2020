package com.android.MemoryGameActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.Database.DBHandler;
import com.android.Database.Player;
import com.android.R;

//the activity of findplayer that is used to find the data of a player in the database
public class findPlayerActivity extends AppCompatActivity {

    TextView infoLabel;
    TextView pairsOf2Wins;
    TextView pairsOf3Wins;
    TextView battleWins;
    TextView textView;

    //creating the activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_player);

        infoLabel = findViewById(R.id.playerSearchInfo);
        pairsOf2Wins = findViewById(R.id.wins1);
        pairsOf3Wins = findViewById(R.id.wins2);
        battleWins = findViewById(R.id.wins3);
        textView = findViewById(R.id.playerTextView);

        if (savedInstanceState != null) {
            //Retrieve data from the Bundle
            CharSequence savedInfoText = savedInstanceState.getCharSequence("savedInfoText");
            CharSequence savedPairsOf2Wins = savedInstanceState.getCharSequence("savedPairsOf2Wins");
            CharSequence savedPairsOf3Wins = savedInstanceState.getCharSequence("savedPairsOf3Wins");
            CharSequence savedBattleWins = savedInstanceState.getCharSequence("savedBattleWins");

            //Restore the dynamic state of the UI
            infoLabel.setText(savedInfoText);
            pairsOf2Wins.setText(savedPairsOf2Wins);
            pairsOf3Wins.setText(savedPairsOf3Wins);
            battleWins.setText(savedBattleWins);
        } else{
            //Initialize the UI
            infoLabel.setText("Search Player");
            pairsOf2Wins.setText("-");
            pairsOf3Wins.setText("-");
            battleWins.setText("-");
        }



        }

    //restoring the data if activity is destroyed
    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        CharSequence infoText = infoLabel.getText();
        outState.putCharSequence("savedInfoText", infoText);
        CharSequence pairsOf2WinsText = pairsOf2Wins.getText();
        outState.putCharSequence("savedPairsOf2Wins", pairsOf2WinsText);
        CharSequence pairsOf3WinsText = pairsOf3Wins.getText();
        outState.putCharSequence("savedPairsOf3Wins", pairsOf3WinsText);
        CharSequence battleWinsText = battleWins.getText();
        outState.putCharSequence("battleWins", battleWinsText);
    }


    //functionality of the findplayer button. Displays the data from DB if player is found
    public void findPlayer(View view){
        DBHandler db = new DBHandler(this, null, null, 1);
        Player player = db.findPlayer(textView.getText().toString());
        if(player!=null){
            //player found
            infoLabel.setText("Player Found");
            pairsOf2Wins.setText("" + player.getPairsOf2Wins());
            pairsOf3Wins.setText("" + player.getPairsOf3Wins());
            battleWins.setText("" + player.getBattleWins());
        }else{
            //player not found
            infoLabel.setText("Player not Found");
            pairsOf2Wins.setText("-");
            pairsOf3Wins.setText("-");
            battleWins.setText("-");
        }
    }

    //functionality of the button of deleteplayer button. Deletes a player from DB if found
    public void deletePlayer(View view){
        DBHandler db = new DBHandler(this, null, null, 1);
        Player player = db.findPlayer(textView.getText().toString());
        if(player!=null){
            //player found
            db.deletePlayer(textView.getText().toString());
            infoLabel.setText(player.getName() + "'s Data Deleted");
            pairsOf2Wins.setText("-");
            pairsOf3Wins.setText("-");
            battleWins.setText("-");

        }else{
            //player not found
            infoLabel.setText("Player not Found");
            pairsOf2Wins.setText("-");
            pairsOf3Wins.setText("-");
            battleWins.setText("-");
        }
    }

    //fuctionality of back button that returns to the previous activity
    public void exit(View view){
        onBackPressed();
    }
}
