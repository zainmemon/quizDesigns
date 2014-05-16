package com.silversages.quiz.activities;

import com.silversages.quiz.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Question extends Activity {

	ProgressBar player1_score_progress;
	ProgressBar player2_score_progress;

	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.question);

		player1_score_progress = (ProgressBar) findViewById(R.id.player1_score_progress);
		player1_score_progress.setProgress(35);
		
		player2_score_progress = (ProgressBar) findViewById(R.id.player2_score_progress);
		player2_score_progress.setProgress(35);
		
		
	}
}
