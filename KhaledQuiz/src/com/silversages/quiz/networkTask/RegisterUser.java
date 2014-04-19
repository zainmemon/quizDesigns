package com.silversages.quiz.networkTask;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.silversages.quiz.QuizApp;
import com.silversages.quiz.activities.Login;
import com.silversages.quiz.object.User;
import com.silversages.quiz.util.JSONParser;

public class RegisterUser extends NetworkTask {

	Login activity;
	User user;

	public RegisterUser(User user) {
		super();
		this.user = user;
	}

	@Override
	public void PerformTask(Activity activity) {
		// TODO Auto-generated method stub
		this.activity = (Login)activity;
		new Task().execute();
	}

	class Task extends AsyncTask<Void, Void, JSONObject> {

		@Override
		protected void onPostExecute(JSONObject result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

			try {
				if (result != null) {
					JSONObject json_data = result;

					int success = json_data.getInt("success");
					Log.d("QuizApp", "Result: " + success);

					if (success == 1) {
						Log.d("QuizApp", "Insertion Successful");
						((Login) activity).PostExecute();
					} else {
						Log.d("QuizApp", "Couldnot connect to the server");
						Toast.makeText(activity,
								"Couldnot connect to the server",
								Toast.LENGTH_LONG).show();
					}
				}

			} catch (ParseException e1) {
				e1.printStackTrace();
				Toast.makeText(activity, "Couldnot connect to the server",
						Toast.LENGTH_LONG).show();

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Toast.makeText(activity, "Couldnot connect to the server",
						Toast.LENGTH_LONG).show();

			}

		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

		@Override
		protected JSONObject doInBackground(Void... params) {
			// TODO Auto-generated method stub

			ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("name", user.personName));
			param.add(new BasicNameValuePair("email", user.email));
			param.add(new BasicNameValuePair("via", user.via));

			JSONParser getData = new JSONParser();

			JSONObject result = getData.makeHttpRequest(QuizApp.serverPath
					+ "register_user.php", "GET", param);

			return result;
		}

	}

}
