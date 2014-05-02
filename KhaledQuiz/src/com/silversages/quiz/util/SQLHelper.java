package com.silversages.quiz.util;

import java.io.ByteArrayOutputStream;

import com.silversages.quiz.QuizApp;
import com.silversages.quiz.object.CategoryObject;
import com.silversages.quiz.object.User;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;

public class SQLHelper {
	static SQLiteDatabase db = QuizApp.db;

	public static void SetupDB() {
		// db.delete("User", null, null);
		// db.delete("FriendList", null, null);
		db.execSQL("CREATE TABLE IF NOT EXISTS User(email TEXT,name TEXT, displayPic BLOB);");
		db.execSQL("CREATE TABLE IF NOT EXISTS FriendList(ID INTEGER PRIMARY KEY, email TEXT,name TEXT, displayPic BLOB);");
		db.execSQL("CREATE TABLE IF NOT EXISTS Category(ID INTEGER PRIMARY KEY,name TEXT);");
	}

	public static void clearData() {
		db.delete("Preference", null, null);
		Log.d(" QuizApp--SQLHelper", "Menu Item--Data Deleted");

	}

	public static void truncateCategory() {
		db.delete("Category", null, null);
		Log.d(" QuizApp--SQLHelper", "Category--Data Deleted");

	}

	public static void intsertCategory(CategoryObject[] object) {

		ContentValues insertValues; 
		for (int i = 0; i < object.length; i++) {

			insertValues = new ContentValues();
			insertValues.put("name", object[i].getName());
			insertValues.put("ID", object[i].getID());
			db.insert("Category", null, insertValues);
		}
		Log.d(" QuizApp--SQLHelper", "Category--Data inserted");

	}

	public static Cursor getDashboardContactList() {
		// TODO Auto-generated method stub
		Log.d(" QuizApp--SQLHelper", "Contact--Querying Data");
		return db.rawQuery("select * from Contact order by name", null);
	}

	public static Cursor getDashboardContactList(int ID) {
		// TODO Auto-generated method stub
		Log.d(" QuizApp--SQLHelper", "Contact--Querying Data");
		return db.rawQuery("select * from Contact where ID = " + ID, null);
	}

	public static void insertContact(String name, String no, byte[] pic) {
		Log.d("QuizApp--SQLHelper", "Contact--Data" + name + " " + no);
		ContentValues insertValues = new ContentValues();
		insertValues.put("name", name);
		insertValues.put("number", no);
		insertValues.put("displayPic", pic);
		db.insert("Contact", null, insertValues);
		Log.d("QuizApp--SQLHelper", "Contact--Data inserted");

	}

	public static void registerUser(User user) {
		// TODO Auto-generated method stub

		Log.d("QuizApp--SQLHelper", "Contact--Data");
		byte[] byteArray = null;
		if (user.imgProfilePic != null) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			((Bitmap) user.imgProfilePic).compress(Bitmap.CompressFormat.PNG,
					50, stream);
			byteArray = stream.toByteArray();
		}
		ContentValues insertValues = new ContentValues();
		insertValues.put("name", user.personName);
		insertValues.put("email", user.email);
		insertValues.put("displayPic", byteArray);
		db.insert("User", null, insertValues);
		Log.d("QuizApp--SQLHelper", "Contact--Data inserted");

	}

	public static Cursor getDashboardCategoryList() {
		// TODO Auto-generated method stub
		Log.d(" QuizApp--SQLHelper", "Category--Querying Data");
		return db.rawQuery("select * from Category", null);
	}
}
