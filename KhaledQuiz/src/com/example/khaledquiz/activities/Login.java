package com.example.khaledquiz.activities;

import com.example.khaledquiz.R;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class Login extends Activity {

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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
