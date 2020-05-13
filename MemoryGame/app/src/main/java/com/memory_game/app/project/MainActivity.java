package com.memory_game.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.view.View;
import android.content.Intent;
import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;

import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.widget.LinearLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.memory_game.app.GameManagers.GameManagerNormal;
import com.memory_game.app.GameManagers.GameManagerMod4;
import com.memory_game.app.GameManagers.GameManagerMod8;
import com.memory_game.app.project.*;
import com.memory_game.app.NormalActivity;

public class MainActivity extends Activity {
	
int num_buttons = 3;
AndroidGui gui;
LinearLayout ll;

	private static Context context;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.context = getApplicationContext();
      setContentView(R.layout.activity_main);
      setLabels();
      buttons();
      this.ll = (LinearLayout)findViewById(R.id.linear_layout);
   }
     
     /**
     * Αρχηκοποιεί τα JLabels.
     */
    protected TextView setLabels(){
        TextView title = (TextView) findViewById(R.id.title_text1);
        
        title.setText("Choose");

        return title;
    }

    protected Button[] buttons(){
        Button[] buttonsArray = new Button[num_buttons];
    	for(int i =0;i<num_buttons;i++){
    		buttonsArray[i] = (Button) findViewById(R.id.choice01+i);
                buttonsArray[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
    		    int id = v.getId();
           	    id=id-R.id.choice01;
                    ll.removeViewAt(0);
                    ll.removeViewAt(0);
                    ll.removeViewAt(0);
                    switch(id){
                        case 0: normal(true);break;
                        case 1: normal(false);break;
                        case 2: battle();break;
                    }
                }
            });
    		}
        buttonsArray[0].setText("normal");
        buttonsArray[1].setText("3 cards");
        buttonsArray[2].setText("battle");
        return buttonsArray;
    }

    void normal(final boolean normal){
        final SeekBar seekBar = new SeekBar(this);
        final SeekBar seekBar2 = new SeekBar(this);
        final SeekBar seekBar3 = new SeekBar(this);
        seekBar.setMax(3);
        seekBar2.setMax(3);
        seekBar3.setMax(2);
//      seekBar.setIndeterminate(true);

        ShapeDrawable thumb = new ShapeDrawable(new OvalShape());
        ShapeDrawable thumb2 = new ShapeDrawable(new OvalShape());
        ShapeDrawable thumb3 = new ShapeDrawable(new OvalShape());

        thumb.setIntrinsicHeight(80);
        thumb.setIntrinsicWidth(30);
        thumb2.setIntrinsicHeight(80);
        thumb2.setIntrinsicWidth(30);
        thumb3.setIntrinsicHeight(80);
        thumb3.setIntrinsicWidth(30);
        seekBar.setThumb(thumb);
        seekBar.setProgress(1);
        seekBar.setVisibility(View.VISIBLE);
        seekBar.setBackgroundColor(Color.WHITE);
        
        seekBar2.setThumb(thumb2);
        seekBar2.setProgress(1);
        seekBar2.setVisibility(View.VISIBLE);
        seekBar2.setBackgroundColor(Color.WHITE);

        seekBar3.setThumb(thumb3);
        seekBar3.setProgress(1);
        seekBar3.setVisibility(View.VISIBLE);
        seekBar3.setBackgroundColor(Color.WHITE);

        LayoutParams lp = new LayoutParams(200, 50);
        seekBar.setLayoutParams(lp);
        seekBar2.setLayoutParams(lp);
        seekBar3.setLayoutParams(lp);
        
        final TextView tv1 = new TextView(this);
        tv1.setText("Number Of players, max 4 starts as 1");

        TextView tv2 = new TextView(this);
        tv2.setText("Number Of bots, max 3");

        TextView tv3 = new TextView(this);
        tv3.setText("Bots' lvl, max 3 starts as 1");

        Button play = new Button(this);
        play.setText("PLAY");
        play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
    		    int num_of_players = seekBar.getProgress();
                    int num_of_bots = seekBar2.getProgress();
                    int bots_lvl = seekBar3.getProgress();
                    //tv1.setText(num_of_players+"   "+num_of_bots+"   "+bots_lvl);
                    Intent intent = new Intent(getBaseContext(), NormalActivity.class);
                    intent.putExtra("num_of_players", num_of_players+1);
                    intent.putExtra("num_of_bots", num_of_bots);
                    intent.putExtra("normal", normal);
                    switch(bots_lvl){
                        case 0: intent.putExtra("bota",'e');intent.putExtra("botb",'e');intent.putExtra("botc",'e');break;
                        case 1: intent.putExtra("bota",'n');intent.putExtra("botc",'n');intent.putExtra("botc",'n');break;
                        case 2: intent.putExtra("bota",'h');intent.putExtra("botc",'h');intent.putExtra("botc",'h');break;
                    }
		    startActivity(intent);
                }
            });



        ll.addView(tv1, 0);
        ll.addView(seekBar, 1);
        ll.addView(tv2, 2);
        ll.addView(seekBar2, 3);
        ll.addView(tv3, 4);
        ll.addView(seekBar3, 5);
        ll.addView(play, 6);
        
    }
    void battle(){

        final SeekBar seekBar2 = new SeekBar(this);
        final SeekBar seekBar3 = new SeekBar(this);
        seekBar2.setMax(3);
        seekBar3.setMax(2);

        ShapeDrawable thumb2 = new ShapeDrawable(new OvalShape());
        ShapeDrawable thumb3 = new ShapeDrawable(new OvalShape());

        thumb2.setIntrinsicHeight(80);
        thumb2.setIntrinsicWidth(30);
        thumb3.setIntrinsicHeight(80);
        thumb3.setIntrinsicWidth(30);
        
        seekBar2.setThumb(thumb2);
        seekBar2.setProgress(1);
        seekBar2.setVisibility(View.VISIBLE);
        seekBar2.setBackgroundColor(Color.WHITE);

        seekBar3.setThumb(thumb3);
        seekBar3.setProgress(1);
        seekBar3.setVisibility(View.VISIBLE);
        seekBar3.setBackgroundColor(Color.WHITE);

        LayoutParams lp = new LayoutParams(200, 50);
        seekBar2.setLayoutParams(lp);
        seekBar3.setLayoutParams(lp);

        TextView tv2 = new TextView(this);
        tv2.setText("Number Of bots, max 3");

        TextView tv3 = new TextView(this);
        tv3.setText("Bots' lvl, max 3 starts as 1");

        Button play = new Button(this);
        play.setText("PLAY");
        play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //tv1.setText(num_of_players+"   "+num_of_bots+"   "+bots_lvl);
                    int num_of_bots = seekBar2.getProgress();
                    int bots_lvl = seekBar3.getProgress();
                    Intent intent = new Intent(getBaseContext(), BattleActivity.class);
                    intent.putExtra("num_of_bots", num_of_bots);
                    switch(bots_lvl){
                        case 0: intent.putExtra("bota",'e');intent.putExtra("botb",'e');intent.putExtra("botc",'e');break;
                        case 1: intent.putExtra("bota",'n');intent.putExtra("botc",'n');intent.putExtra("botc",'n');break;
                        case 2: intent.putExtra("bota",'h');intent.putExtra("botc",'h');intent.putExtra("botc",'h');break;
                    }
		    startActivity(intent);
                }
            });
        ll.addView(tv2, 0);
        ll.addView(seekBar2, 1);
        ll.addView(tv3, 2);
        ll.addView(seekBar3, 3);
        ll.addView(play, 4);
    }

}
