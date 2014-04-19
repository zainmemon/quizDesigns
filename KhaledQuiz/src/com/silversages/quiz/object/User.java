package com.silversages.quiz.object;

import android.graphics.Bitmap;

public class User {
	public Bitmap imgProfilePic;

	public String personName;

	public String personProfile;

	public String email;
	public String via;

	public Bitmap getImgProfilePic() {
		return imgProfilePic;
	}

	public void setImgProfilePic(Bitmap imgProfilePic) {
		this.imgProfilePic = imgProfilePic;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonProfile() {
		return personProfile;
	}

	public void setPersonProfile(String personProfile) {
		this.personProfile = personProfile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public User(Bitmap imgProfilePic, String personName, String personProfile,
			String email, String via) {
		super();
		this.imgProfilePic = imgProfilePic;
		this.personName = personName;
		this.personProfile = personProfile;
		this.email = email;
		this.via = via;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

}
