package com.silversages.quiz.networkTask;

import android.graphics.Bitmap;

public class RegisterUser {

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

}
