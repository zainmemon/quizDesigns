package com.silversages.quiz.networkTask;

import android.database.sqlite.SQLiteDatabase;
import com.silversages.quiz.QuizApp;

public abstract class NetworkTask {

	SQLiteDatabase db = QuizApp.db;
	int Success = 0;

	public abstract void PerformTask();

}
