package com.rootlu.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Activity_cov extends Activity {
	    //声明控件
		Button btn_Ce=null;
		Button btn_Backspace=null;
		Button btn_0=null;
		Button btn_1=null;
		Button btn_2=null;
		Button btn_3=null;
		Button btn_4=null;
		Button btn_5=null;
		Button btn_6=null;
		Button btn_7=null;
		Button btn_8=null;
		Button btn_9=null;
		Button btn_point=null;		
		Button btn_equal=null;		
		TextView tv_ipRate=null;
		TextView tv_opRate=null;
		TextView tv_unit1=null;
		TextView tv_unit2=null;
		Button btn_reset=null;
		Button btn_meue=null;
		
	
//	private TextView view;
	private Spinner spinner;
	private Spinner spn_start;
	private Spinner spn_end;

	private ArrayAdapter<?> adapter;
	private ArrayAdapter<?> adapter_length;
	private ArrayAdapter<?> adapter_size;
	private ArrayAdapter<?> adapter_volume;
	private ArrayAdapter<?> adapter_weight;
	private ArrayAdapter<?> adapter_rate;
	
	int tranftype_id=0;
	int flag=0;
	double result=0;
	int start_id=0;
	int end_id=0;
	double que=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_cov);
		
		//获取文本框
		tv_ipRate=(TextView)findViewById(R.id.tv_result);
		//获取应用程序中的按钮
		btn_Ce=(Button)findViewById(R.id.btn_CE);
		btn_Backspace=(Button)findViewById(R.id.btn_Backspace);
		btn_0=(Button)findViewById(R.id.btn_0);
		btn_1=(Button)findViewById(R.id.btn_1);
		btn_2=(Button)findViewById(R.id.btn_2);
		btn_3=(Button)findViewById(R.id.btn_3);
		btn_4=(Button)findViewById(R.id.btn_4);
		btn_5=(Button)findViewById(R.id.btn_5);
		btn_6=(Button)findViewById(R.id.btn_6);
		btn_7=(Button)findViewById(R.id.btn_7);
		btn_8=(Button)findViewById(R.id.btn_8);
		btn_9=(Button)findViewById(R.id.btn_9);
		btn_point=(Button)findViewById(R.id.btn_point);
		btn_equal=(Button)findViewById(R.id.btn_equal);
		btn_reset=(Button)findViewById(R.id.btn_reset);
		btn_meue=(Button)findViewById(R.id.btn_meue);
		
		tv_ipRate=(TextView)findViewById(R.id.tv_ipRate);
		tv_opRate=(TextView)findViewById(R.id.tv_opRate);
		tv_unit1=(TextView)findViewById(R.id.tv_unit1);
		tv_unit2=(TextView)findViewById(R.id.tv_unit2);
		
		spinner=(Spinner)findViewById(R.id.spinner1);
		spn_start=(Spinner)findViewById(R.id.spn_start);
		spn_end=(Spinner)findViewById(R.id.spn_end);
		
		//创建适配器并定义样式，使用XML方式获取数据
		adapter=ArrayAdapter.createFromResource(this,R.array.select,android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new SpinnerXMLSelectedListener());//注册监听器
		//需要选择适配器类
		spinner.setVisibility(View.VISIBLE);
		
		//将可选内容与ArrayAdapter连接起来
		adapter_length=ArrayAdapter.createFromResource(this,R.array.spn_length,android.R.layout.simple_spinner_item);
		adapter_length.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter_size=ArrayAdapter.createFromResource(this,R.array.spn_size,android.R.layout.simple_spinner_item);
		adapter_size.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter_volume=ArrayAdapter.createFromResource(this,R.array.spn_volume,android.R.layout.simple_spinner_item);
		adapter_volume.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter_weight=ArrayAdapter.createFromResource(this,R.array.spn_weight,android.R.layout.simple_spinner_item);
		adapter_weight.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter_rate=ArrayAdapter.createFromResource(this,R.array.spn_rate,android.R.layout.simple_spinner_item);
		adapter_rate.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		 //设置默认值
	     spn_start.setVisibility(View.VISIBLE);
	     spn_end.setVisibility(View.VISIBLE);
		//下拉菜单监听事件
		 spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				tranftype_id=(int) spinner.getSelectedItemId();
				switch(tranftype_id)
				{
				case 0:
					spn_start.setAdapter(adapter_length);
					spn_end.setAdapter(adapter_length);
					spn_start.setSelection(0);
					spn_end.setSelection(1);
					flag=0;
					break;
				case 1:
					spn_start.setAdapter(adapter_size);
					spn_end.setAdapter(adapter_size);
					spn_start.setSelection(0);
					spn_end.setSelection(1);
					flag=1;
					break;
				case 2:
					spn_start.setAdapter(adapter_volume);
					spn_end.setAdapter(adapter_volume);
					spn_start.setSelection(0);
					spn_end.setSelection(1);
					flag=2;
					break;
				case 3: 
					spn_start.setAdapter(adapter_weight);
					spn_end.setAdapter(adapter_weight);
					spn_start.setSelection(0);
					spn_end.setSelection(1);
					flag=3;
					break;
				case 4:
					spn_start.setAdapter(adapter_rate);
					spn_end.setAdapter(adapter_rate);
					spn_start.setSelection(0);
					spn_end.setSelection(1);
					flag=4;
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			 
		 });
		
		//清屏按钮功能
    	btn_Ce.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tv_ipRate.setText(" ");
				tv_opRate.setText(" ");
				tv_unit1.setText(" ");
				tv_unit2.setText(" ");
			}
    	});
		//退格按钮功能
    	btn_Backspace.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub	
			    String str=tv_ipRate.getText().toString();
			    if(tv_ipRate.getText().length()!=0)
			    	tv_ipRate.setText(str.substring(0, str.length()-1));
			}	
    	});
    	//为按钮绑定监听事件
        btn_0.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
        		String myString=tv_ipRate.getText().toString();
                myString+="0";
                tv_ipRate.setText(myString);
               
			}
        	
        });
        btn_1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String myString1=tv_ipRate.getText().toString();
                myString1+="1";
                tv_ipRate.setText(myString1);
			}
        	
        });
        btn_2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String myString2=tv_ipRate.getText().toString();
                myString2+="2";
                tv_ipRate.setText(myString2);
			}
        	
        });
        btn_3.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String myString3=tv_ipRate.getText().toString();
                myString3+="3";
                tv_ipRate.setText(myString3);
			}
        	
        });
        btn_4.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String myString4=tv_ipRate.getText().toString();
                myString4+="4";
                tv_ipRate.setText(myString4);
			}
        	
        });
        btn_5.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String myString5=tv_ipRate.getText().toString();
                myString5+="5";
                tv_ipRate.setText(myString5);
			}
        	
        });
        btn_6.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String myString6=tv_ipRate.getText().toString();
                myString6+="6";
                tv_ipRate.setText(myString6);
			}
        	
        }
        );
        btn_7.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String myString7=tv_ipRate.getText().toString();
                myString7+="7";
                tv_ipRate.setText(myString7);
			}
        	
        });
        btn_8.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String myString8=tv_ipRate.getText().toString();
                myString8+="8";
                tv_ipRate.setText(myString8);
			}
        	
        });
        btn_9.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String myString9=tv_ipRate.getText().toString();
                myString9+="9";
                tv_ipRate.setText(myString9);	
			}
        	
        });
        btn_point.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String myStringPoint=tv_ipRate.getText().toString();
                myStringPoint+=".";
                tv_ipRate.setText(myStringPoint);
			}
        	
        });
    	
    	//实现等于按钮功能
  	   btn_equal.setOnClickListener(new OnClickListener(){

  		   
 		@Override
 		public void onClick(View v) {
 			// TODO Auto-generated method stub 			
 			String str=tv_ipRate.getText().toString();
 			if(str.equals(" ")==true)
 			{
 				new  AlertDialog.Builder(Activity_cov.this)    
				.setTitle("错误提示" )  
				.setMessage("请先输入换算数值！" )  
				.setPositiveButton("确定" ,  null )  
				.show();  
				return;
// 				tv_opRate.setText(" ");
 			}
 			else{
 			que=Double.parseDouble(str);			
 			switch(flag)
 			{
 			//长度换算
 			case 0:
 				start_id=(int) spn_start.getSelectedItemId();
 				end_id=(int) spn_end.getSelectedItemId();
 				switch(start_id)
 				{
 				case 0:
 					tv_unit1.setText("km");
 					switch(end_id)
 					{
 					case 0:
 						result=que;	
 	               	 	tv_unit2.setText("km");
 						break;
 					case 1:
 						result=que*1000;
 						tv_unit2.setText("m");
 	 					break;
 	 				case 2:
 	 					result=que*10000;
 	 					tv_unit2.setText("dm");
 	 					break;
 	 				case 3:
 	 					result=que*100000;
 	 					tv_unit2.setText("cm");
 	 					break;
 	 				case 4:
 	 					result=que*1000000;
 	 					tv_unit2.setText("mm");
 	 					break;
 					}
 					break;
 				case 1:
 					tv_unit1.setText("m");
 					switch(end_id)
 					{
 					case 0:
 						result=que/1000;
 						tv_unit2.setText("km");
 						break;
 					case 1:
 						result=que;
 						tv_unit2.setText("m");
 	 					break;
 	 				case 2:
 	 					result=que*10;
 	 					tv_unit2.setText("dm");
 	 					break;
 	 				case 3:
 	 					result=que*100;
 	 					tv_unit2.setText("cm");
 	 					break;
 	 				case 4:
 	 					result=que*1000;
 	 					tv_unit2.setText("mm");
 	 					break;
 					}
 					break;
 				case 2:
 					tv_unit1.setText("dm");
 					switch(end_id)
 					{
 					case 0:
 						result=que/10000;
 						tv_unit2.setText("km");
 						break;
 					case 1:
 						result=que/10;
 						tv_unit2.setText("m");
 	 					break;
 	 				case 2:
 	 					result=que;
 	 					tv_unit2.setText("dm");
 	 					break;
 	 				case 3:
 	 					result=que*10;
 	 					tv_unit2.setText("cm");
 	 					break;
 	 				case 4:
 	 					result=que*100;
 	 					tv_unit2.setText("mm");
 	 					break;
 					}
 					break;
 				case 3:
 					tv_unit1.setText("cm");
 					switch(end_id)
 					{
 					case 0:
 						result=que/100000;
 						tv_unit2.setText("km");
 						break;
 					case 1:
 						result=que/100;
 						tv_unit2.setText("m");
 	 					break;
 	 				case 2:
 	 					result=que/10;
 	 					tv_unit2.setText("dm");
 	 					break;
 	 				case 3:
 	 					result=que;
 	 					tv_unit2.setText("cm");
 	 					break;
 	 				case 4:
 	 					result=que*10;
 	 					tv_unit2.setText("mm");
 	 					break;
 					}
 					break;
 				case 4:
 					tv_unit1.setText("mm");
 					switch(end_id)
 					{
 					case 0:
 						result=que/1000000;
 						tv_unit2.setText("km");
 						break;
 					case 1:
 						result=que/1000;
 						tv_unit2.setText("m");
 	 					break;
 	 				case 2:
 	 					result=que/100;
 	 					tv_unit2.setText("dm");
 	 					break;
 	 				case 3:
 	 					result=que/10;
 	 					tv_unit2.setText("cm");
 	 					break;
 	 				case 4:
 	 					result=que;
 	 					tv_unit2.setText("mm");
 	 					break;
 					}
 					break;					 					
 				}
 				break;
 			//面积换算
 			case 1:
 				start_id=(int) spn_start.getSelectedItemId();
 				end_id=(int) spn_end.getSelectedItemId();
 				switch(start_id)
 				{
 				case 0:
 					tv_unit1.setText("km^2");
 					switch(end_id)
 					{
 					case 0:
 						result=que;
 						tv_unit2.setText("km^2");
 						break;
 					case 1:
 						result=que*1000000;
 						tv_unit2.setText("m^2");
 	 					break;
 	 				case 2:
 	 					result=que*100000000;
 	 					tv_unit2.setText("dm^2");
 	 					break;
 	 				case 3:
 	 					result=que*10000000000.0;
 	 					tv_unit2.setText("cm^2");
 	 					break;
 					}
 					break;
 				case 1:
 					tv_unit1.setText("m^2");
 					switch(end_id)
 					{
 					case 0:
 						result=que/1000000;
 						tv_unit2.setText("km^2");
 						break;
 					case 1:
 						result=que;
 						tv_unit2.setText("m^2");
 	 					break;
 	 				case 2:
 	 					result=que*100;
 	 					tv_unit2.setText("dm^2");
 	 					break;
 	 				case 3:
 	 					result=que*1000;
 	 					tv_unit2.setText("cm^2");
 	 					break;
 					}
 					break;
 				case 2:
 					tv_unit1.setText("dm^2");
 					switch(end_id)
 					{
 					case 0:
 						result=que/100000000;
 						tv_unit2.setText("km^2");
 						break;
 					case 1:
 						result=que/100;
 						tv_unit2.setText("m^2");
 	 					break;
 	 				case 2:
 	 					result=que;
 	 					tv_unit2.setText("dm^2");
 	 					break;
 	 				case 3:
 	 					result=que*100;
 	 					tv_unit2.setText("cm^2");
 	 					break;
 					}
 					break;
 				case 3:
 					tv_unit1.setText("cm^2");
 					switch(end_id)
 					{
 					case 0:
 						result=que/10000000000.0;
 						tv_unit2.setText("km^2");
 						break;
 					case 1:
 						result=que/10000;
 						tv_unit2.setText("m^2");
 	 					break;
 	 				case 2:
 	 					result=que/100;
 	 					tv_unit2.setText("dm^2");
 	 					break;
 	 				case 3:
 	 					result=que;
 	 					tv_unit2.setText("cm^2");
 	 					break;
 					}
 					break;
 				}
 				break;
 			//体积换算
 			case 2:
 				start_id=(int) spn_start.getSelectedItemId();
 				end_id=(int) spn_end.getSelectedItemId();
 				switch(start_id)
 				{
 				case 0:
 					tv_unit1.setText("m^3");
 					switch(end_id)
 					{
 					case 0:
 						result=que;
 						tv_unit2.setText("m^3");
 						break;
 					case 1:
 						result=que*1000;
 						tv_unit2.setText("dm^3");
 	 					break;
 	 				case 2:
 	 					result=que*1000000;
 	 					tv_unit2.setText("cm^3");
 	 					break;
 	 				case 3:
 	 					result=que*1000000000;
 	 					tv_unit2.setText("mm^3");
 	 					break;
 					}
 					break;
 				case 1:
 					tv_unit1.setText("dm^3");
 					switch(end_id)
 					{
 					case 0:
 						result=que/1000;
 						tv_unit2.setText("m^3");
 						break;
 					case 1:
 						result=que;
 						tv_unit2.setText("dm^3");
 	 					break;
 	 				case 2:
 	 					result=que*1000;
 	 					tv_unit2.setText("cm^3");
 	 					break;
 	 				case 3:
 	 					result=que*1000000;
 	 					tv_unit2.setText("mm^3");
 	 					break;
 					}
 					break;
 				case 2:
 					tv_unit1.setText("cm^3");
 					switch(end_id)
 					{
 					case 0:
 						result=que/1000000;
 						tv_unit2.setText("m^3");
 						break;
 					case 1:
 						result=que/1000;
 						tv_unit2.setText("dm^3");
 	 					break;
 	 				case 2:
 	 					result=que;
 	 					tv_unit2.setText("cm^3");
 	 					break;
 	 				case 3:
 	 					result=que*1000;
 	 					tv_unit2.setText("mm^3");
 	 					break;
 					}
 					break;
 				case 3:
 					tv_unit1.setText("mm^3");
 					switch(end_id)
 					{
 					case 0:
 						result=que/1000000000.0;
 						tv_unit2.setText("m^3");
 						break;
 					case 1:
 						result=que/1000000;
 						tv_unit2.setText("dm^3");
 	 					break;
 	 				case 2:
 	 					result=que/1000;
 	 					tv_unit2.setText("cm^3");
 	 					break;
 	 				case 3:
 	 					result=que;
 	 					tv_unit2.setText("mm^3");
 	 					break;
 					}
 					break;
 				}
 				break;
 			//重量换算
 			case 3:
 				start_id=(int) spn_start.getSelectedItemId();
 				end_id=(int) spn_end.getSelectedItemId();
 				switch(start_id)
 				{
 				case 0:
 					tv_unit1.setText("t");
 					switch(end_id)
 					{
 					case 0:
 						result=que;
 						tv_unit2.setText("t");
 						break;
 					case 1:
 						result=que*1000;
 						tv_unit2.setText("kg");
 	 					break;
 	 				case 2:
 	 					result=que*1000000;
 	 					tv_unit2.setText("g");
 	 					break;
 	 				case 3:
 	 					result=que*1000000000;
 	 					tv_unit2.setText("mg");
 	 					break;
 					}
 					break;
 				case 1:
 					tv_unit1.setText("kg");
 					switch(end_id)
 					{
 					case 0:
 						result=que/1000;
 						tv_unit2.setText("t");
 						break;
 					case 1:
 						result=que;
 						tv_unit2.setText("kg");
 	 					break;
 	 				case 2:
 	 					result=que*1000;
 	 					tv_unit2.setText("g");
 	 					break;
 	 				case 3:
 	 					result=que*1000000;
 	 					tv_unit2.setText("mg");
 	 					break;
 					}
 					break;
 				case 2:
 					tv_unit1.setText("g");
 					switch(end_id)
 					{
 					case 0:
 						result=que/1000000;
 						tv_unit2.setText("t");
 						break;
 					case 1:
 						result=que/1000;
 						tv_unit2.setText("kg");
 	 					break;
 	 				case 2:
 	 					result=que;
 	 					tv_unit2.setText("g");
 	 					break;
 	 				case 3:
 	 					result=que*1000;
 	 					tv_unit2.setText("mg");
 	 					break;
 					}
 					break;
 				case 3:
 					tv_unit1.setText("mg");
 					switch(end_id)
 					{
 					case 0:
 						result=que/1000000000.0;
 						tv_unit2.setText("t");
 						break;
 					case 1:
 						result=que/1000000;
 						tv_unit2.setText("kg");
 	 					break;
 	 				case 2:
 	 					result=que/1000;
 	 					tv_unit2.setText("g");
 	 					break;
 	 				case 3:
 	 					result=que;
 	 					tv_unit2.setText("mg");
 	 					break;
 					}
 					break;
 				}
 				break;
 			//汇率换算
 			case 4:
 				start_id=(int) spn_start.getSelectedItemId();
 				end_id=(int) spn_end.getSelectedItemId();
 				switch(start_id)
 				{
 				case 0:
 					tv_unit1.setText("CNY");
 					switch(end_id)
 					{
 					case 0:
 						result=que;
 						tv_unit2.setText("CNY");
 						break;
 					case 1:
 						result=que*0.1578;
 						tv_unit2.setText("USD");
 	 					break;
 	 				case 2:
 	 					result=que*19.0792;
 	 					tv_unit2.setText("JPY");
 	 					break;
 	 				case 3:
 	 					result=que*178.9163;
 	 					tv_unit2.setText("KER");
 	 					break;
 	 				case 4:
 	 					result=que*1.2232;
 	 					tv_unit2.setText("HKD");
 	 					break;
 	 				case 5:
 	 					result=que*0.1438;
 	 					tv_unit2.setText("EUR");
 	 					break;
 					}
 					break;
 				case 1:
 					tv_unit1.setText("USD");
 					switch(end_id)
 					{
 					case 0:
 						result=que*6.3357;
 						tv_unit2.setText("CNY");
 						break;
 					case 1:
 						result=que;
 						tv_unit2.setText("USD");
 	 					break;
 	 				case 2:
 	 					result=que*120.88;
 	 					tv_unit2.setText("JPY");
 	 					break;
 	 				case 3:
 	 					result=que*1133.56;
 	 					tv_unit2.setText("KER");
 	 					break;
 	 				case 4:
 	 					result=que*7.75;
 	 					tv_unit2.setText("HKD");
 	 					break;
 	 				case 5:
 	 					result=que*0.9112;
 	 					tv_unit2.setText("EUR");
 	 					break;
 					}
 					break;
 				case 2:
 					tv_unit1.setText("JPY");
 					switch(end_id)
 					{
 					case 0:
 						result=que*0.0524;
 						tv_unit2.setText("CNY");
 						break;
 					case 1:
 						result=que*0.0083;
 						tv_unit2.setText("USD");
 	 					break;
 	 				case 2:
 	 					result=que;
 	 					tv_unit2.setText("JPY");
 	 					break;
 	 				case 3:
 	 					result=que*9.3776;
 	 					tv_unit2.setText("KER");
 	 					break;
 	 				case 4:
 	 					result=que*0.0641;
 	 					tv_unit2.setText("HKD");
 	 					break;
 	 				case 5:
 	 					result=que*0.0075;
 	 					tv_unit2.setText("EUR");
 	 					break;
 					}
 					break;
 				case 3:
 					tv_unit1.setText("KER");
 					switch(end_id)
 					{
 					case 0:
 						result=que*0.0056;
 						tv_unit2.setText("CNY");
 						break;
 					case 1:
 						result=que*0.0009;
 						tv_unit2.setText("USD");
 	 					break;
 	 				case 2:
 	 					result=que*0.1066;
 	 					tv_unit2.setText("JPY");
 	 					break;
 	 				case 3:
 	 					result=que;
 	 					tv_unit2.setText("KER");
 	 					break;
 	 				case 4:
 	 					result=que*0.0068;
 	 					tv_unit2.setText("HKD");
 	 					break;
 	 				case 5:
 	 					result=que*0.0008;
 	 					tv_unit2.setText("EUR");
 	 					break;
 					}
 					break;
 				case 4:
 					tv_unit1.setText("HKD");
 					switch(end_id)
 					{
 					case 0:
 						result=que*0.8175;
 						tv_unit2.setText("CNY");
 						break;
 					case 1:
 						result=que*0.129;
 						tv_unit2.setText("USD");
 	 					break;
 	 				case 2:
 	 					result=que*15.5974;
 	 					tv_unit2.setText("JPY");
 	 					break;
 	 				case 3:
 	 					result=que*146.2658;
 	 					tv_unit2.setText("KER");
 	 					break;
 	 				case 4:
 	 					result=que;
 	 					tv_unit2.setText("HKD");
 	 					break;
 	 				case 5:
 	 					result=que*0.1176;
 	 					tv_unit2.setText("EUR");
 	 					break;
 					}
 					break;
 				case 5:
 					tv_unit1.setText("EUR");
 					switch(end_id)
 					{
 					case 0:
 						result=que*6.9534;
 						tv_unit2.setText("CNY");
 						break;
 					case 1:
 						result=que*1.0975;
 						tv_unit2.setText("USD");
 	 					break;
 	 				case 2:
 	 					result=que*132.6658;
 	 					tv_unit2.setText("JPY");
 	 					break;
 	 				case 3:
 	 					result=que*1244.0821;
 	 					tv_unit2.setText("KER");
 	 					break;
 	 				case 4:
 	 					result=que*8.5056;
 	 					tv_unit2.setText("HKD");
 	 					break;
 	 				case 5:
 	 					result=que;
 	 					tv_unit2.setText("EUR");
 	 					break;
 					}
 					break;
 				}
 				break;
 			}		
            str=result+"";
 			tv_opRate.setText(str);
 			}
 		}
  	   });
  	   
  	   //重新填写按钮
  	   btn_reset.setOnClickListener(new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			tv_ipRate.setText(" ");
			tv_opRate.setText(" ");
			tv_unit1.setText(" ");
			tv_unit2.setText(" ");
			//设置默认值
			spinner.setSelection(0);
			spn_start.setAdapter(adapter_length);
			spn_end.setAdapter(adapter_length);
			spn_start.setSelection(0);
			spn_end.setSelection(1);			
		} 		   
  	   });
  	   //返回主菜单
  	   btn_meue.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				// 设置 Intent 对象要启动的 Activity 
         	intent.setClass(Activity_cov.this, MainActivity.class); 
           	// 通过 Intent 对象启动另外一个 Activity 
         	startActivity(intent);
			}
	    	 
	     });
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_cov, menu);
		return true;
    }
	class SpinnerXMLSelectedListener implements OnItemSelectedListener{
		public void onItemSelected(AdapterView<?> arg0,View arg1,int arg2,long arg3){
//			view.setText("请选择换算单位:");

		}
		public void onNothingSelected(AdapterView<?> arg0){
	    }
    }
}