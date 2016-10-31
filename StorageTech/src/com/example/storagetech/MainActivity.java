package com.example.storagetech;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText content = null;
	String editContent = null;
    public static void startAction(Context context){
    	Intent intent = new Intent(context,MainActivity.class);
    	context.startActivity(intent);   	
    }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	     
		findViewById(R.id.storageBtn).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				
			}
		});
//		
//		content = (EditText) findViewById(R.id.Content);
//		FileInputStream fis =null;
//		try {
//			fis = openFileInput("data");
//			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
//			String cont=null;
//			StringBuilder sb= null;
//			while(  ( cont = br.readLine() )!=null  ){
//				sb = new StringBuilder();
//				sb.append(cont);				
//			}
//			if(!TextUtils.isEmpty(sb)){
//			        content.setText(sb.toString());
//			        content.setSelection(sb.length());
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			if(fis!=null){
//				try {
//					fis.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
	}
//
//	@Override
//	public void onClick(View v) {
//		// TODO Auto-generated method stub
//		switch (v.getId()) {
//		case R.id.storageBtn:
//			FileOutputStream fos = null;
//			try {
//				editContent = content.getText().toString();
//				fos = openFileOutput("data", MODE_PRIVATE);
//				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
//				//fos.write(editContent.getBytes());
//				bw.write(editContent);
//			    bw.flush();
//			    
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} finally {
//				try {
//					if (fos != null)
//						fos.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			break;
//		}

	//}
}
