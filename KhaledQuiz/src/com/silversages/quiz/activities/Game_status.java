package com.silversages.quiz.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.silversages.quiz.R;

public class Game_status extends Activity {

	ProgressBar player1_progress;
	CountDownTimer timer;
	int start_time = 6 * 1000;
	int interval = 1 * 1000;

	ImageView level1;
	ImageView level2;
	ImageView level3;
	ImageView level4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_status);

		player1_progress = (ProgressBar) findViewById(R.id.ProgressBar);
		player1_progress.setProgress(70);

		level1 = (ImageView) findViewById(R.id.round_one);
		level2 = (ImageView) findViewById(R.id.round_two);
		level3 = (ImageView) findViewById(R.id.round_three);
		level4 = (ImageView) findViewById(R.id.round_four);

		timer = new CountDownTimer(start_time, interval) {

			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub
				long time = millisUntilFinished / 1000;

				if (time == 4) {
					level4.setImageResource(R.drawable.coloured_four);
				}
				if (time == 3) {
					level3.setImageResource(R.drawable.coloured_three);
				}
				if (time == 2) {
					level2.setImageResource(R.drawable.coloured_two);
				}
				if (time == 1) {
					level1.setImageResource(R.drawable.coloured_one);
				}

			}

			@Override
			public void onFinish() {
				// TODO Auto-generated method stub

				Intent i = new Intent(Game_status.this, Question.class);
				startActivity(i);
			}
		};

		timer.start();

	}
}
