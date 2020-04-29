package com.android.MemoryGameActivities;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.BackEnd.Learner;
import com.android.BackEnd.Mode_Sector;
import com.android.BackEnd.Sector;
import com.memory_game.app.R;

public class SelectionScreen extends AppCompatActivity {
    private Learner learner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_screen);
        learner = new Learner();

        Bundle extras=getIntent().getExtras();

        if(extras!=null){
            CharSequence gameMode= (CharSequence) extras.getSerializable("gameMode");
            CharSequence playerNumber= (CharSequence) extras.getSerializable("playerNumber");
        }
    }

    public void checkBoxClicked(View view){
        boolean checked=((CheckBox) view).isChecked();
        RadioButton rb1=findViewById(R.id.radio_beginner);
        RadioButton rb2=findViewById(R.id.radio_novice);
        RadioButton rb3=findViewById(R.id.radio_expert);

        CharSequence message="";
        if(checked) {
            message = "Player is AI";
            rb1.setClickable(false);
            rb2.setClickable(false);
            rb3.setClickable(false);
        }
        else{
            rb1.setClickable(true);
            rb2.setClickable(true);
            rb3.setClickable(true);
        }

        int duration= Toast.LENGTH_SHORT;
        Toast toast=Toast.makeText(this,message,duration);
        toast.show();
    }
    public void radioButtonClicked(View view){
        RadioGroup difficulty = findViewById(R.id.difficulty_group);
        int rbid= difficulty.getCheckedRadioButtonId();
        CharSequence message="";

        switch(rbid){
            case R.id.radio_beginner:
                learner.setSector(Sector.BEGINNER);
                message="Beginner";
                break;
            case R.id.radio_novice:
                learner.setSector(Sector.NOVICE);
                message="Novice";
                break;
            case R.id.radio_expert:
                learner.setSector(Sector.EXPERT);
                message="Expert";
                break;
        }
        int duration= Toast.LENGTH_SHORT;
        Toast toast= Toast.makeText(this,message,duration);
        toast.show();

    }
    public void previousActivity(View view){
        //code goes here
    }
    public void nextActivity(View view){
        //code goes here
    }
}
