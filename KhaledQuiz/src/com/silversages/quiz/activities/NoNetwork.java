package com.silversages.quiz.activities;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.silversages.quiz.R;
import com.silversages.quiz.abstracts.QuizActivity;
import com.silversages.quiz.util.NetworkManager;

public class NoNetwork extends QuizActivity {

	TextView refresh;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.no_network);
		SetupView();
	}

	@Override
	protected void PostExecute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void PreExecute() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void SetupView() {
		// TODO Auto-generated method stub

		refresh = (TextView) findViewById(R.id.tryAgain);
		refresh.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (NetworkManager.IsConnected()) {
					NoNetwork.this.finish();
				}

			}
		});
	}
}
