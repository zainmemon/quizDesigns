package com.silversages.quiz.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.silversages.quiz.R;
import com.silversages.quiz.abstracts.QuizActivity;
import com.silversages.quiz.adapter.CategoryAdaptor;
import com.silversages.quiz.networkTask.FetchCategory;
import com.silversages.quiz.object.CategoryObject;
import com.silversages.quiz.util.SQLHelper;

public class Dashboard extends QuizActivity {

	ListView list;
	CategoryObject[] categoryItem;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		SharedPreferences prefs = PreferenceManager
				.getDefaultSharedPreferences(this);

		if (prefs.getBoolean("first_time", false)) {
			setContentView(R.layout.category);

			SetupView();
			PreExecute();

		} else {
			new Task().execute();

			startActivity(new Intent(Dashboard.this, Login.class));
			this.finish();
		}
	}

	class Task extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			new FetchCategory().PerformTask(null);
		}

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			SQLHelper.SetupDB();

			return null;
		}

	}

	@Override
	public void PostExecute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void PreExecute() {
		// TODO Auto-generated method stub

		Cursor _cursor = null;

		_cursor = db.getDashboardCategoryList();

		Log.d(" QuizApp--DashboardList", "Cursor populated");
		if (_cursor.getCount() > 0) {
			categoryItem = new CategoryObject[_cursor.getCount()];
			Log.d(" QuizApp--DashboardList", "Data Exist");
			_cursor.moveToFirst();
			Log.d(" QuizApp--DashboardList", "Populating Adapter");

			for (int i = 0; i < _cursor.getCount(); i++) {

				categoryItem[i] = (new CategoryObject(_cursor.getString(_cursor
						.getColumnIndex("name")), _cursor.getInt(_cursor
						.getColumnIndex("ID"))));

				_cursor.moveToNext();
			}

			_cursor.close();

			CategoryAdaptor adaptor = new CategoryAdaptor(this, categoryItem);

			list.setAdapter(adaptor);

			Log.d(" QuizApp--DashboardList", "Populated");
		} else {
			categoryItem = new CategoryObject[_cursor.getCount()];
			Log.d(" QuizApp--DashboardList", "No Data Found");
		}

	}

	@Override
	public void SetupView() {
		// TODO Auto-generated method stub

		list = (ListView) findViewById(R.id.listview1);

	}

}
