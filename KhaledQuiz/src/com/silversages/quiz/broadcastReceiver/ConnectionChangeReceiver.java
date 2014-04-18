package com.silversages.quiz.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.silversages.quiz.QuizApp;
import com.silversages.quiz.activities.NoNetwork;

public class ConnectionChangeReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();

		if (activeNetInfo == null && QuizApp.hasNetwork==1) {

			Intent i = new Intent(context, NoNetwork.class);
			i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(i);
			QuizApp.hasNetwork=0;
		}
	}
}