package com.silversages.quiz.activities;

import java.util.ArrayList;

import com.silversages.quiz.R;
import com.silversages.quiz.adapter.CategoryAdaptor;
import com.silversages.quiz.object.CategoryObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class Category extends Activity {

	ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.category);

		list = (ListView) findViewById(R.id.listview1);

		ArrayList<CategoryObject> mylist = new ArrayList<CategoryObject>();

		mylist.add(new CategoryObject("Cricket", this));

		CategoryAdaptor adaptor = new CategoryAdaptor(this, mylist);

		list.setAdapter(adaptor);

	}

}
