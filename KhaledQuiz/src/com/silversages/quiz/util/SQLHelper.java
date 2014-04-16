package com.silversages.quiz.util;

import com.silversages.quiz.QuizApp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SQLHelper {
	static SQLiteDatabase db = QuizApp.db;

	public static void SetupDB(Context context) {
		db.execSQL("CREATE TABLE IF NOT EXISTS User(email TEXT,name TEXT, displayPic BLOB);");
		db.execSQL("CREATE TABLE IF NOT EXISTS FriendList(ID INTEGER PRIMARY KEY, email TEXT,name TEXT, displayPic BLOB);");
	}

	public static void clearData() {
		db.delete("Preference", null, null);
		Log.d(" QuizApp--SQLHelper", "Menu Item--Data Deleted");

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

}