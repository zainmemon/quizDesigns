package com.silversages.quiz.abstracts;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;

import com.silversages.quiz.QuizApp;
import com.silversages.quiz.activities.Dashboard;
import com.silversages.quiz.activities.NoNetwork;
import com.silversages.quiz.util.NetworkManager;
import com.silversages.quiz.util.SQLHelper;

public abstract class QuizActivity extends Activity {

	protected SQLHelper db;

	public abstract void PostExecute();

	public abstract void PreExecute();

	public abstract void SetupView();

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		registerReceiver(QuizApp.connRcv, new IntentFilter(
				"android.net.wifi.WIFI_STATE_CHANGED"));
		if (!NetworkManager.IsConnected() && QuizApp.hasNetwork == 1) {
			QuizApp.hasNetwork = 0;
			startActivity(new Intent(QuizActivity.this, NoNetwork.class));
		}

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		unregisterReceiver(QuizApp.connRcv);
	}
}
