package com.example.storagetech;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SharePreference extends Activity implements OnClickListener {
	CheckBox checkBtn = null;
	EditText accountCount = null;
	EditText passwordCount = null;
    String account,password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		checkBtn = (CheckBox) findViewById(R.id.checkBtn);
		Button loginBtn = (Button) findViewById(R.id.LoginBtn);
		loginBtn.setOnClickListener(this);
		accountCount = (EditText) findViewById(R.id.accountContent);
		passwordCount = (EditText) findViewById(R.id.passwordContent);
        Log.d("tag", "oncreate");
        SharedPreferences sharePre =  PreferenceManager.getDefaultSharedPreferences(this);
        //sharepreferences 文件名为 com.example.storagetech_preferences.xml (包名点缀)
        
        //  SharedPreferences sharePre2 = getPreferences(MODE_APPEND);
        // sharepreferences 文件名为 SharePreference.xml (当前活动的类名)
        // SharedPreferences shr =  getSharedPreferences("abc", MODE_APPEND);
        //  sharepreference文件名为参数值
     
        if(sharePre.getBoolean("remenber", false)){
        	account = sharePre.getString("account", null);
        	password = sharePre.getString("password",null);
        	accountCount.setText(account);
        	passwordCount.setText(password);
        	accountCount.setSelection(account.length());
        	passwordCount.setSelection(password.length());
        	checkBtn.setChecked(sharePre.getBoolean("remenber", false));
        }
	}
     @Override
    protected void onStart() {
    	// TODO Auto-generated method stub
    	super.onStart();
    	Log.d("tag","Onstart");
    }
     @Override
    protected void onRestart() {
    	// TODO Auto-generated method stub
    	super.onRestart();
    	Log.d("tag", "onrestart");
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.LoginBtn:
			account = accountCount.getText().toString();
			password = passwordCount.getText().toString();
			if (account.equals("huangcanyang") && password.equals("123456")) {
				SharedPreferences sharePre = PreferenceManager.getDefaultSharedPreferences(this);
				SharedPreferences.Editor edit = sharePre.edit();
				if (checkBtn.isChecked()) {
					edit.putBoolean("remenber", true);
					edit.putString("account", account);
					edit.putString("password", password);
					edit.commit();
				} else {
					edit.clear();
				}
				edit.commit();
				
				MainActivity.startAction(this);
				
				
				
			}else{
				Toast.makeText(this, "password  is uncorrected", Toast.LENGTH_LONG).show();
			}
			break;
		}

	}

}
