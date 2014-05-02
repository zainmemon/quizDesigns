package com.silversages.quiz.object;

public class CategoryObject {

	private int ID;
	private String Title;

	public CategoryObject(String title, int _ID) {

		this.Title = title;
		ID = _ID;

	}

	public String getName() {
		return Title;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

}
