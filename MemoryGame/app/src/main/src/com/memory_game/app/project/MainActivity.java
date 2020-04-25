package com.cocktails.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.content.Intent;
import android.content.Context;


public class MainActivity extends Activity {
	
	private static Context context;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
	  this.context = getApplicationContext();
      setContentView(R.layout.activity_main);
      final Button ingredientsButton = (Button) findViewById(R.id.ingredientsButton);
      final Button cocktailsButton = (Button) findViewById(R.id.cocktailsButton);
      final Button playButton = (Button) findViewById(R.id.playButton);
      final Button clearIngredients = (Button) findViewById(R.id.clearIngredients);
      final Button clearCocktails = (Button) findViewById(R.id.clearCocktails);
         View.OnClickListener handler = new View.OnClickListener(){

      public void onClick(View v) {

      if(v==ingredientsButton){ 
            // doStuff
            newActivity(1);
            //Log.i("Content "," Main layout ");
    }
	 else if(v==cocktailsButton){ 
            // doStuff
            newActivity(2);
            //Log.i("Content "," Main layout ");
    }
	else if(v==playButton){
		newActivity(3);
	}
	else if(v==clearIngredients){
		Ingredients.setFile("IngredientsList", MainActivity.context);
		Ingredients.clear();
	}
	else if(v==clearCocktails){
		Cocktails.setFile("CocktailsList", MainActivity.this);
		Cocktails.clear();
	}
   }
  };
  ingredientsButton.setOnClickListener(handler);
  cocktailsButton.setOnClickListener(handler);
  playButton.setOnClickListener(handler);
  clearIngredients.setOnClickListener(handler);
  clearCocktails.setOnClickListener(handler);
   }
   void newActivity(int i){
			Intent intentMain = null;
	        if(i==1)intentMain = new Intent(this, IngredientsActivity.class);
            else if(i==2)intentMain = new Intent(this, CocktailsActivity.class);
            else if(i==3)intentMain = new Intent(this, PlayActivity.class);
			startActivity(intentMain);
   }
}