package com.silversages.quiz.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.silversages.quiz.abstracts.QuizActivity;
import com.silversages.quiz.util.SQLHelper;

public class Dashboard extends QuizActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(this);
		if (prefs.getBoolean("first_time", false)) {

			SetupView();

		} else {
			new Task().execute();
			startActivity(new Intent(Dashboard.this, Login.class));

		}
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

	}

	class Task extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			SQLHelper.SetupDB(getBaseContext());

			return null;
		}

	}

}
