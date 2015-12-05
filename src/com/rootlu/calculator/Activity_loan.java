package com.rootlu.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Activity_loan extends Activity {
	
	private Spinner spn_year;
	private Spinner spn_loantype;
	private Spinner spn_paytype;
	private Spinner spn_rate;
	private Button btn_start;
	private EditText et_busloan;
	private EditText et_busrate;
	private EditText et_pubrate;
	private Button btn_again;
	private Button btn_meue;
	
	private EditText et_publoan;
	private ArrayAdapter<CharSequence> adapter1;
	private ArrayAdapter<CharSequence> adapter2;
	private ArrayAdapter<CharSequence> adapter3;
	private ArrayAdapter<CharSequence> adapter4;

	//贷款类型
	int loantype_id=0;
	String loantype="";
	//还款方式
	int paytype_id=0;
	String paytype="";
	//贷款总额
	String busloan="";
	String publoan="";
	//按揭年数
	int year_id=0;
	String year="";
	//贷款利率
	int rate_id;
	String busratemonth="";
	String pubratemonth="";
	//年利率
	double busrate_year=0;
	double pubrate_year=0;
	//月利率
	double busrate_month=0;
	double pubrate_month=0;
	//商业贷款与公积金贷款利率数组
	double[] arr_busrate={4.78,3.7,3.05,4.35,5.6,3.91,3.22,4.6,5.34,4.12,3.4,4.85,
			5.61,4.34,3.57,5.1,5.89,4.55,3.74,5.35,6.16,4.76,3.92,5.6};
	double[] arr_pubrate={3.03,2.34,1.93,2.75,3.03,2.34,1.93,2.75,3.3,2.55,2.1,3,
			3.58,2.76,2.28,3.25,3.85,2.97,2.45,3.5,3.75,3.75,3.75,3.75};
	double[] arr_buspubrate={4.78,3.7,3.05,4.35,5.6,3.91,3.22,4.6,5.34,4.12,3.4,4.85,
			5.61,4.34,3.57,5.1,5.89,4.55,3.74,5.35,6.16,4.76,3.92,5.6,
			3.03,2.34,1.93,2.75,3.03,2.34,1.93,2.75,3.3,2.55,2.1,3,
			3.58,2.76,2.28,3.25,3.85,2.97,2.45,3.5,3.75,3.75,3.75,3.75};
	double[] arr_rate=new double[48];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_loan);
		
		btn_start=(Button)findViewById(R.id.btn_start);
	    et_busloan=(EditText)findViewById(R.id.et_busloan);
	    et_busrate=(EditText)findViewById(R.id.et_busrate);
	    et_pubrate=(EditText)findViewById(R.id.et_pubrate);
	    et_publoan=(EditText)findViewById(R.id.et_publoan);
	    btn_again=(Button)findViewById(R.id.btn_again);
	    btn_meue=(Button)findViewById(R.id.btn_meue);
		
		//获取下拉列表对象
		spn_year=(Spinner)findViewById(R.id.spn_year);
		spn_loantype=(Spinner)findViewById(R.id.spn_loantype);
		spn_paytype=(Spinner)findViewById(R.id.spn_paytype);
		spn_rate=(Spinner)findViewById(R.id.spn_rate);
		//将可选内容与ArrayAdapter连接起来
		adapter1=ArrayAdapter.createFromResource(this, R.array.spnyear, android.R.layout.simple_spinner_item);
		adapter2=ArrayAdapter.createFromResource(this, R.array.spnloantype, android.R.layout.simple_spinner_item);
		adapter3=ArrayAdapter.createFromResource(this, R.array.spnpaytype, android.R.layout.simple_spinner_item);
		adapter4=ArrayAdapter.createFromResource(this, R.array.spnrate, android.R.layout.simple_spinner_item);
		
		//设置下拉列表的风格 
		adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//将adapter 添加到spinner中
	    spn_year.setAdapter(adapter1);
	    spn_loantype.setAdapter(adapter2);
	    spn_paytype.setAdapter(adapter3);
	    spn_rate.setAdapter(adapter4);
	 
	    
	     //设置默认值
	     spn_year.setVisibility(View.VISIBLE);
	     spn_loantype.setVisibility(View.VISIBLE);
	     spn_paytype.setVisibility(View.VISIBLE);
	     spn_rate.setVisibility(View.VISIBLE);
	     
	     //贷款类型监听事件
	     spn_loantype.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				//贷款类型
				loantype_id=(int) spn_loantype.getSelectedItemId();
				switch(loantype_id)
				{
				case 0:
					busrate_month=4.78/12;
					pubrate_month=0;
					et_busloan.setEnabled(true);
					et_publoan.setText("0");
					et_publoan.setEnabled(false);
					for (int i=0;i<24;i++)
					{
						arr_rate[i]=arr_busrate[i];
					}
					for(int i=24;i<48;i++)
					{
						arr_rate[i]=0;
					}
					et_pubrate.setText("0");
					et_pubrate.setEnabled(false);
					et_busrate.setEnabled(true);
					et_busrate.setText(Double.toString(arr_rate[0]));
					break;
				case 1:
					busrate_month=0;
					pubrate_month=3.03/12;
					et_publoan.setEnabled(true);
					et_busloan.setText("0");
					et_busloan.setEnabled(false);
					for (int i=0;i<24;i++)
					{
						arr_rate[i]=0;
					}
					for(int i=24;i<48;i++)
					{
						arr_rate[i]=arr_pubrate[i-24];
					}
					et_busrate.setText("0");
					et_busrate.setEnabled(false);
					et_pubrate.setEnabled(true);
					et_pubrate.setText(Double.toString(arr_rate[24]));
					break;
				case 2:
					busrate_month=4.78/12;
					pubrate_month=3.03/12;
					et_publoan.setEnabled(true);
					et_busloan.setEnabled(true);
					et_pubrate.setEnabled(true);
					et_busrate.setEnabled(true);
					for (int i=0;i<48;i++)
					{
						arr_rate[i]=arr_buspubrate[i];
					}
					et_busrate.setText(Double.toString(arr_rate[0]));
					et_pubrate.setText(Double.toString(arr_rate[24]));
					break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
	    	 
	     });
	     
	     //利率选择监听事件
	     spn_rate.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				//贷款利率
				rate_id=(int) spn_rate.getSelectedItemId();
				switch(rate_id)
				{
					case 0:
						busrate_year=arr_rate[0];
						pubrate_year=arr_rate[24];
						et_busrate.setText(Double.toString(arr_rate[0]));
						et_pubrate.setText(Double.toString(arr_rate[24]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 1:
						busrate_year=arr_rate[1];
						pubrate_year=arr_rate[25];
						et_busrate.setText(Double.toString(arr_rate[1]));
						et_pubrate.setText(Double.toString(arr_rate[25]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 2:
						busrate_year=arr_rate[2];
						pubrate_year=arr_rate[26];
						et_busrate.setText(Double.toString(arr_rate[2]));
						et_pubrate.setText(Double.toString(arr_rate[26]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 3:
						busrate_year=arr_rate[3];
						pubrate_year=arr_rate[27];
						et_busrate.setText(Double.toString(arr_rate[3]));
						et_pubrate.setText(Double.toString(arr_rate[27]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 4:
						busrate_year=arr_rate[4];
						pubrate_year=arr_rate[28];
						et_busrate.setText(Double.toString(arr_rate[4]));
						et_pubrate.setText(Double.toString(arr_rate[28]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 5:
						busrate_year=arr_rate[5];
						pubrate_year=arr_rate[29];
						et_busrate.setText(Double.toString(arr_rate[5]));
						et_pubrate.setText(Double.toString(arr_rate[29]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 6:
						busrate_year=arr_rate[6];
						pubrate_year=arr_rate[30];
						et_busrate.setText(Double.toString(arr_rate[6]));
						et_pubrate.setText(Double.toString(arr_rate[30]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 7:
						busrate_year=arr_rate[7];
						pubrate_year=arr_rate[31];
						et_busrate.setText(Double.toString(arr_rate[7]));
						et_pubrate.setText(Double.toString(arr_rate[31]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 8:
						busrate_year=arr_rate[8];
						pubrate_year=arr_rate[32];
						et_busrate.setText(Double.toString(arr_rate[8]));
						et_pubrate.setText(Double.toString(arr_rate[32]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 9:
						busrate_year=arr_rate[9];
						pubrate_year=arr_rate[33];
						et_busrate.setText(Double.toString(arr_rate[9]));
						et_pubrate.setText(Double.toString(arr_rate[33]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 10:
						busrate_year=arr_rate[10];
						pubrate_year=arr_rate[34];
						et_busrate.setText(Double.toString(arr_rate[10]));
						et_pubrate.setText(Double.toString(arr_rate[34]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 11:
						busrate_year=arr_rate[11];
						pubrate_year=arr_rate[35];
						et_busrate.setText(Double.toString(arr_rate[11]));
						et_pubrate.setText(Double.toString(arr_rate[35]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 12:
						busrate_year=arr_rate[12];
						pubrate_year=arr_rate[36];
						et_busrate.setText(Double.toString(arr_rate[12]));
						et_pubrate.setText(Double.toString(arr_rate[36]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 13:
						busrate_year=arr_rate[13];
						pubrate_year=arr_rate[37];
						et_busrate.setText(Double.toString(arr_rate[13]));
						et_pubrate.setText(Double.toString(arr_rate[37]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 14:
						busrate_year=arr_rate[14];
						pubrate_year=arr_rate[38];
						et_busrate.setText(Double.toString(arr_rate[14]));
						et_pubrate.setText(Double.toString(arr_rate[38]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 15:
						busrate_year=arr_rate[15];
						pubrate_year=arr_rate[39];
						et_busrate.setText(Double.toString(arr_rate[15]));
						et_pubrate.setText(Double.toString(arr_rate[39]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 16:
						busrate_year=arr_rate[16];
						pubrate_year=arr_rate[40];
						et_busrate.setText(Double.toString(arr_rate[16]));
						et_pubrate.setText(Double.toString(arr_rate[40]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 17:
						busrate_year=arr_rate[17];
						pubrate_year=arr_rate[41];
						et_busrate.setText(Double.toString(arr_rate[17]));
						et_pubrate.setText(Double.toString(arr_rate[41]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 18:
						busrate_year=arr_rate[18];
						pubrate_year=arr_rate[42];
						et_busrate.setText(Double.toString(arr_rate[18]));
						et_pubrate.setText(Double.toString(arr_rate[42]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 19:
						busrate_year=arr_rate[19];
						pubrate_year=arr_rate[43];
						et_busrate.setText(Double.toString(arr_rate[19]));
						et_pubrate.setText(Double.toString(arr_rate[43]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 20:
						busrate_year=arr_rate[20];
						pubrate_year=arr_rate[44];
						et_busrate.setText(Double.toString(arr_rate[20]));
						et_pubrate.setText(Double.toString(arr_rate[44]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 21:
						busrate_year=arr_rate[23];
						pubrate_year=arr_rate[45];
						et_busrate.setText(Double.toString(arr_rate[21]));
						et_pubrate.setText(Double.toString(arr_rate[45]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 22:
						busrate_year=arr_rate[22];
						pubrate_year=arr_rate[46];
						et_busrate.setText(Double.toString(arr_rate[22]));
						et_pubrate.setText(Double.toString(arr_rate[46]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					case 23:
						busrate_year=arr_rate[23];
						pubrate_year=arr_rate[47];
						et_busrate.setText(Double.toString(arr_rate[23]));
						et_pubrate.setText(Double.toString(arr_rate[47]));
						busrate_month=busrate_year/12;
						pubrate_month=pubrate_year/12;
						break;
					default:
						break;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
	    	 
	     });

	     btn_start.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				//还款方式
				paytype_id=(int) spn_paytype.getSelectedItemId();
				paytype=Integer.toString(paytype_id);
				//贷款总额
				busloan=et_busloan.getText().toString();
				publoan=et_publoan.getText().toString();
				//按揭年数
				year_id=(int) spn_year.getSelectedItemId();
				year=Integer.toString(year_id);
				//月利率
				busratemonth=Double.toString(busrate_month);
				pubratemonth=Double.toString(pubrate_month);
				
				//异常判断
				if(busloan.equals("")|publoan.equals(""))
				{
					new  AlertDialog.Builder(Activity_loan.this)    
					.setTitle("错误提示" )  
					.setMessage("输入错误！请重新输入！" )  
					.setPositiveButton("确定" ,  null )  
					.show();  
					return;
				}
				//显示结果界面
				Intent intent = new Intent();
            	// 在 Intent 对象当中添加一个键值对
            	//还款方式
            	intent.putExtra("paytype_key", paytype);
				//贷款总额
            	intent.putExtra("busloan_key", busloan); 
            	intent.putExtra("publoan_key", publoan);
            	//贷款年数
            	intent.putExtra("year_key",year);
            	//贷款月利率
            	intent.putExtra("busrate_key",busratemonth);           	          	
            	intent.putExtra("pubrate_key",pubratemonth);  
            	// 设置 Intent 对象要启动的 Activity 
            	intent.setClass(Activity_loan.this, Activity_result.class); 
              	// 通过 Intent 对象启动另外一个 Activity 
            	startActivity(intent);
			}
		});
	     
	     //重新填写按钮监听事件
	     btn_again.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				spn_year.setVisibility(View.VISIBLE);
			    spn_loantype.setVisibility(View.VISIBLE);
			    spn_paytype.setVisibility(View.VISIBLE);
			    spn_rate.setVisibility(View.VISIBLE);
			    et_busloan.setText("");
			    et_publoan.setText("");
			    et_busrate.setText("");
			    et_pubrate.setText("");
			}
	     });
	     //返回主菜单按钮监听事件
	     btn_meue.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				// 设置 Intent 对象要启动的 Activity 
            	intent.setClass(Activity_loan.this, MainActivity.class); 
              	// 通过 Intent 对象启动另外一个 Activity 
            	startActivity(intent);
			}
	    	 
	     });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_loan, menu);
		return true;
	}

}
