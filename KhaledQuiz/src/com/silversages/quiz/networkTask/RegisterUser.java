package com.silversages.quiz.networkTask;

import android.graphics.Bitmap;
import android.os.AsyncTask;

public class RegisterUser extends NetworkTask {

	String email;
	String name;
	String via;
	Bitmap pic;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public Bitmap getPic() {
		return pic;
	}

	public void setPic(Bitmap pic) {
		this.pic = pic;
	}

	public RegisterUser(String email, String name, String via, Bitmap pic) {
		super();
		this.email = email;
		this.name = name;
		this.via = via;
		this.pic = pic;
	}

	@Override
	public void PerformTask() {
		// TODO Auto-generated method stub

		new Task().execute();
	}

	class Task extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			return null;
		}

	}

}
