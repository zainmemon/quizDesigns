package com.silversages.quiz.abstracts;

import android.app.Activity;

import com.silversages.quiz.util.SQLHelper;

public abstract class QuizActivity extends Activity {

	protected SQLHelper db;

	protected abstract void PostExecute();

	protected abstract void PreExecute();

	protected abstract void SetupView();
}
