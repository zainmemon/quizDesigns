package com.silversages.quiz.activities;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

import com.silversages.quiz.abstracts.QuizActivity;

public class Login extends QuizActivity {

	ImageView image_signIn;
	ImageView image_signUp;
	TextView text_signin;
	TextView text_signup;
	ImageView image_gmail;
	ImageView image_facebook;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
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

		image_signIn = (ImageView) findViewById(R.id.image_signIn);
		image_signIn.setX(-80);

		image_signUp = (ImageView) findViewById(R.id.image_signUp);
		image_signUp.setX(-20);

		text_signin = (TextView) findViewById(R.id.text_signIn);
		text_signin.setX(-80);

		text_signup = (TextView) findViewById(R.id.text_signUp);
		text_signup.setX(-45);

		image_gmail = (ImageView) findViewById(R.id.gmail);

		image_facebook = (ImageView) findViewById(R.id.fb);

	}

}
