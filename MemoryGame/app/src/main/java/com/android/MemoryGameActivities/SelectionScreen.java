package com.android.MemoryGameActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.memory_game.app.project.R;

public class SelectionScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_screen);
    }

    public void checkBoxClicked(View view){
        boolean checked=((CheckBox) view).isChecked();
        CharSequence message="";
        if(checked)
            message="Player is AI";
        else
            message="Player is human";
        int duration= Toast.LENGTH_SHORT;
        Toast toast=Toast.makeText(this,message,duration);
        toast.show();
    }
    public void radioButtonClicked(View view){
        RadioGroup difficulty = findViewById(R.id.difficulty_group);
        int rbid= difficulty.getCheckedRadioButtonId();
        CharSequence message="";

        switch(rbid){
            case R.id.radio_begginer:
                message="Beginner";
                break;
            case R.id.radio_novice:
                message="Novice";
                break;
            case R.id.radio_expert:
                message="Expert";
                break;
        }
        int duration= Toast.LENGTH_SHORT;
        Toast toast= Toast.makeText(this,message,duration);
        toast.show();

    }
}
