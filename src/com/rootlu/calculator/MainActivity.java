package com.rootlu.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.rootlu.circlemenu.view.CircleImageView;
import com.rootlu.circlemenu.view.CircleLayout;
import com.rootlu.circlemenu.view.CircleLayout.OnItemClickListener;
import com.rootlu.circlemenu.view.CircleLayout.OnItemSelectedListener;

public class MainActivity extends Activity implements OnItemSelectedListener, OnItemClickListener{
	TextView selectedTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		CircleLayout circleMenu = (CircleLayout)findViewById(R.id.main_circle_layout);
		circleMenu.setOnItemSelectedListener(this);
		circleMenu.setOnItemClickListener(this);

		selectedTextView = (TextView)findViewById(R.id.main_selected_textView);
		selectedTextView.setText(((CircleImageView)circleMenu.getSelectedItem()).getName());
	}

	@Override
	public void onItemSelected(View view, int position, long id, String name) {		
		selectedTextView.setText(name);
	}

	@Override
	public void onItemClick(View view, int position, long id, String name) {
		Intent intent = new Intent();
		switch(position)
		{
		//十进制计算器
		case 0:
			// 设置 Intent 对象要启动的 Activity 
	    	intent.setClass(MainActivity.this, Activity_dec.class); 
	      	// 通过 Intent 对象启动另外一个 Activity 
	    	startActivity(intent);	
			break;
		//汇率单位换算
		case 1:
			// 设置 Intent 对象要启动的 Activity 
	    	intent.setClass(MainActivity.this, Activity_cov.class); 
	      	// 通过 Intent 对象启动另外一个 Activity 
	    	startActivity(intent);	
			break;
		//十六进制计算器
		case 2:
			
	    	// 设置 Intent 对象要启动的 Activity 
	    	intent.setClass(MainActivity.this, Activity_hex.class); 
	      	// 通过 Intent 对象启动另外一个 Activity 
	    	startActivity(intent);	
			break;
		//车房贷款
		case 3:
			// 设置 Intent 对象要启动的 Activity 
	    	intent.setClass(MainActivity.this, Activity_loan.class); 
	      	// 通过 Intent 对象启动另外一个 Activity 
	    	startActivity(intent);	
			break;
			
		}	
//		Toast.makeText(getApplicationContext(), getResources().getString(R.string.start_app) + " " + name, Toast.LENGTH_SHORT).show();
	}

}
