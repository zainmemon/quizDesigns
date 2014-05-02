package com.silversages.quiz.object;

import android.content.Context;

public class CategoryObject {

	private String Title;
	private Context context;

	public CategoryObject(String title, Context ctx) {

		this.Title = title;
		context = ctx;

	}

	public String getName() {
		return Title;
	}

	public Context getContext() {
		return context;
	}

}
