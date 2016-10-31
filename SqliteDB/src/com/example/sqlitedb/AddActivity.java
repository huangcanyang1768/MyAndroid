package com.example.sqlitedb;

import android.R.integer;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class AddActivity extends Activity {

	static SQLiteDatabase sqliteHelper = null;
	static String tName = null;
	ContentValues values = null;
	EditText bNameEdit = null;
	EditText bPageEdit = null;
	EditText bPriceEdit = null;
	EditText bAuthorEdit = null;
	String bName,bAuthor;
	double bPrice;
	int bPage;

	static void startAction(Context context, SQLiteDatabase sqlite, String tableName) {
		sqliteHelper = sqlite;
		tName = tableName;
		Intent intent = new Intent(context, AddActivity.class);
		context.startActivity(intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		bNameEdit = (EditText) findViewById(R.id.bookname);
		bPageEdit = (EditText) findViewById(R.id.bookpage);
		bPriceEdit = (EditText) findViewById(R.id.bookprice);
		bAuthorEdit = (EditText) findViewById(R.id.authorname);
		findViewById(R.id.submit).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bName = bNameEdit.getText().toString();
				bPrice = Double.parseDouble(bPriceEdit.getText().toString());
				bPage = Integer.parseInt(bPageEdit.getText().toString());
				bAuthor = bAuthorEdit.getText().toString();
				values = new ContentValues();
				values.put("name", bName);
				values.put("author", bAuthor);
				values.put("page", bPage);
				values.put("price", bPrice );	
				sqliteHelper.insert(tName, null, values);
				values.clear();

			}
		});

	}

}
