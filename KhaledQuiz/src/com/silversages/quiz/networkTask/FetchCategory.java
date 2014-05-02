package com.silversages.quiz.networkTask;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import com.silversages.quiz.QuizApp;
import com.silversages.quiz.object.CategoryObject;
import com.silversages.quiz.util.JSONParser;
import com.silversages.quiz.util.SQLHelper;

public class FetchCategory extends NetworkTask {

	@Override
	public void PerformTask(Activity activity) {
		// TODO Auto-generated method stub

		new Task().execute();
	}

	class Task extends AsyncTask<Void, Void, JSONObject> {

		@Override
		protected JSONObject doInBackground(Void... params) {
			// TODO Auto-generated method stub
			ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();

			JSONParser getData = new JSONParser();

			JSONObject result = getData.makeHttpRequest(QuizApp.serverPath
					+ "fetch_category.php", "GET", param);

			return result;
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(JSONObject result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			JSONArray _category = null;
			JSONObject rowR = null;
			try {
				if (result != null) {
					JSONObject json_data = result;

					int success = json_data.getInt("success");
					Log.d("QuizApp", "Result: " + success);

					if (success == 1) {
						Log.d("QuizApp", "Fetching Successful");
						_category = result.getJSONArray("category");

						if (_category.length() > 0) {

							CategoryObject[] obj = new CategoryObject[_category
									.length()];
							for (int i = 0; i < _category.length(); i++) {
								rowR = _category.getJSONObject(i);
								obj[i] = new CategoryObject(
										rowR.getString("name"),
										rowR.getInt("id"));
							}
							SQLHelper.truncateCategory();
							SQLHelper.intsertCategory(obj);
						}
					} else {
						Log.d("QuizApp", "Couldnot connect to the server");

					}
				}

			} catch (ParseException e1) {
				e1.printStackTrace();

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}

		}
	}
}
