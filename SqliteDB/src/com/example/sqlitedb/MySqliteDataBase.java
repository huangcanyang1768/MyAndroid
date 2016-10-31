package com.example.sqlitedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqliteDataBase extends SQLiteOpenHelper {
	
	Context context = null;
	private static String BOOKINF_TABLE = "create table BookStory("
			+ "id integer primary key autoincrement,"
			+ "name text,"
			+ "author text,"
			+ "page integer,"
			+ "price real)";
	
	private static String CAtEGORY_TABLE= "create table Category("
			+ "id integer primary key autoincrement,"
			+ "category_name text,"
			+ "category_code integer)";
			

	public MySqliteDataBase(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(BOOKINF_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
       switch (oldVersion) {
       //更新数据库最佳实例， 注意不写break 是为了跨版本升级
	     case 1:
	    	 db.execSQL(CAtEGORY_TABLE);
	     case 2 :
	    	 db.execSQL("Alter table BookStory add column category_code integer");
		
	
	}
        
        
	}

}
