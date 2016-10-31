package com.example.sqlitedb;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	MySqliteDataBase myDataBase = null;
	SQLiteDatabase sqlite = null;
	String tableName = "BookStory";
	ContentValues values = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button addBtn = (Button) findViewById(R.id.addBtn);
		Button deleteBtn = (Button) findViewById(R.id.deleteBtn);
		Button updateBtn = (Button) findViewById(R.id.updateBtn);
		Button selectBtn = (Button) findViewById(R.id.selectBtn);
		Button deleteTableBtn = (Button) findViewById(R.id.deleteAllTable);
		Button updataDbBtn = (Button) findViewById(R.id.updateDatabaseBtn);
		updataDbBtn .setOnClickListener(this);
		deleteTableBtn.setOnClickListener(this);
		selectBtn.setOnClickListener(this);
		selectBtn.setOnClickListener(this);
		addBtn.setOnClickListener(this);
		updateBtn.setOnClickListener(this);
		deleteBtn.setOnClickListener(this);
		//myDataBase = new MySqliteDataBase(MainActivity.this, "Book.db", null, 1);
		//sqlite = myDataBase.getWritableDatabase();
		values = new ContentValues();
		myDataBase = new MySqliteDataBase(MainActivity.this, "Book.db", null,3);
		sqlite = myDataBase.getWritableDatabase();
    	

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		// data/data/com.example.sqlitedb/databases

		switch (v.getId()) {
		case R.id.addBtn:
			AddActivity.startAction(MainActivity.this, sqlite, tableName);
			break;
		case R.id.deleteBtn:
			sqlite.delete(tableName, "page >? and price =? ", new String[] { "240", "22.0" });
			break;
		case R.id.updateBtn:
			values.put("category_code",2);
			sqlite.update(tableName, values, "name = ?", new String[] { "white" });
			break;
		case R.id.selectBtn:

			Cursor cursor = sqlite.query("BookStory", new String[] { "name" }, " page = ? ", new String[] { "240" },
					null, null, null);
			// Cursor cursor = sqlite.query("BookStory", null,null, null,null,
			// null,null,null);
			if (cursor.moveToFirst()) {
				do {
					String name = cursor.getString(cursor.getColumnIndex("name"));
					// String author =
					// cursor.getColumnName(cursor.getColumnIndex("author"));
					// double price =
					// cursor.getDouble(cursor.getColumnIndex("price"));
					// int page = cursor.getInt(cursor.getColumnIndex("page"));
					Toast.makeText(this, name, Toast.LENGTH_LONG).show();
					// name +";"+author+";"+price+";"+page+";"
				} while (cursor.moveToNext());

			}
			break;
		case R.id.deleteAllTable:
			sqlite.beginTransaction();
			
			ContentValues values = new ContentValues();
			try {
				if (true){
					throw new NullPointerException();
				
				}
				values.put("name", "Ggggg");
				values.put("author", "yyy");
				values.put("price", 25.0);
				values.put("page", 190);
				sqlite.insert("BookStory", null, values);
				sqlite.setTransactionSuccessful();	
				values.clear();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlite.endTransaction();
			
			}
	
			break;
		    case R.id.updateDatabaseBtn:
		    	
		    	
			break;

		}

	}
}
