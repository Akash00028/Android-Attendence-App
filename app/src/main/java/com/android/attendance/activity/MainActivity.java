package com.android.attendance.activity;

import com.example.androidattendancesystem.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button start;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

//		start =(Button)findViewById(R.id.buttonstart);
//		start.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//
//				Intent intent =new Intent(MainActivity.this,LoginActivity.class);
//				startActivity(intent);adadmin
//			}
//		});
		new Handler().postDelayed(
				new Runnable() {
					@Override
					public void run() {
						Intent i = new Intent(MainActivity.this,LoginActivity.class);
						//overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
						startActivity(i);
						finish();
					}
				},5000
		);



	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		finish();
	}
}
