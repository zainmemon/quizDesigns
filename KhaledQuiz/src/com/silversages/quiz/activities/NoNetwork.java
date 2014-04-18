package com.silversages.quiz.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.silversages.quiz.QuizApp;
import com.silversages.quiz.R;
import com.silversages.quiz.abstracts.QuizActivity;
import com.silversages.quiz.util.NetworkManager;

public class NoNetwork extends Activity {

	TextView refresh;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.no_network);
		SetupView();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		// Intent i = new Intent(this, Dashboard.class);
		// i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		// startActivity(i);
	}

	protected void SetupView() {
		// TODO Auto-generated method stub

		refresh = (TextView) findViewById(R.id.tryAgain);
		refresh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (NetworkManager.IsConnected()) {
					QuizApp.hasNetwork = 1;
					startActivity(new Intent(NoNetwork.this, Dashboard.class));
					NoNetwork.this.finish();
				}

			}
		});
	}
}
