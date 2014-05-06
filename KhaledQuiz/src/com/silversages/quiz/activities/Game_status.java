package com.silversages.quiz.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;
import com.silversages.quiz.R;

public class Game_status extends Activity {

	ProgressBar p;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_status);
		
		p = (ProgressBar) findViewById(R.id.ProgressBar);
		p.setProgress(70);
		
	}
}
