package com.rootlu.calculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Activity_result extends Activity {

	private TextView tv_paytotalshow;
	private TextView tv_interestshow;
	private TextView tv_monthshow;
	private TextView tv_loantotalshow;
	private TextView tv_monthnumshow;
	private Button btn_end;

	
	String loantype;
	String paytype;
	String year;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_result);
		
		tv_paytotalshow=(TextView)findViewById(R.id.tv_paytotalshow);
		tv_interestshow=(TextView)findViewById(R.id.tv_interestshow);
		tv_monthshow=(TextView)findViewById(R.id.tv_monthshow);
		tv_loantotalshow=(TextView)findViewById(R.id.tv_loantotalshow);
		tv_monthnumshow=(TextView)findViewById(R.id.tv_monthnumshow);
		btn_end=(Button)findViewById(R.id.btn_end);

		// 取得从 Activity03 当中传递过来的 Intent 对象   
        Intent intent = getIntent(); 
        // 从 Intent 当中根据 key 取得 value 
        
        //还款方式
        String paytype=intent.getStringExtra("paytype_key");
        int paytype_id=Integer.valueOf(paytype).intValue();

		//贷款总额
		String busloan= intent.getStringExtra("busloan_key");
		double busloan_double=Double.valueOf(busloan).doubleValue();	
		String publoan=intent.getStringExtra("publoan_key");
		double publoan_double=Double.valueOf(publoan).doubleValue();
		double loantotal_double=busloan_double+publoan_double;
//		tv_loantotalshow.setText(loantotal_double+"");
        //贷款年数
        String year=intent.getStringExtra("year_key");
        int year_id=Integer.valueOf(year).intValue();

		//月利率
        String busratemonth=intent.getStringExtra("busrate_key");
		double busratemonth_double=Double.valueOf(busratemonth).doubleValue();
        String pubratemonth=intent.getStringExtra("pubrate_key");
		double pubratemonth_double=Double.valueOf(pubratemonth).doubleValue();	
//		tv_interestshow.setText(busratemonth+"@"+pubratemonth);
		//还款总额
		double totalpay=0;
		double buspay=0;
		double pubpay=0;
		
		//月还款总额
		double monthpay=0;
		double busmonthpay=0;
		double pubmonthpay=0;

		//等额本息
		if(paytype_id==0)
		{
			//贷款总额、贷款月数
			tv_loantotalshow.setText(loantotal_double+"");
			tv_monthnumshow.setText(Integer.toString((12*(year_id+1))));
			//商业贷款
			if(busloan_double!=0&&publoan_double==0)
			{
				busmonthpay=(busloan_double*busratemonth_double/100*Math.pow((1+busratemonth_double/100), (12*(year_id+1))))
						 /(Math.pow((1+busratemonth_double/100), (12*(year_id+1)))-1);
				pubmonthpay=0;
			}
			//公积金贷款
			if(busloan_double==0&&publoan_double!=0)
			{
				busmonthpay=0;  
				pubmonthpay=(publoan_double*pubratemonth_double/100*Math.pow((1+pubratemonth_double/100), (12*(year_id+1))))
						 /(Math.pow((1+pubratemonth_double/100), (12*(year_id+1)))-1);
			}
			//组合型
			if(busloan_double!=0&&publoan_double!=0)
			{
				busmonthpay=(busloan_double*busratemonth_double/100*Math.pow((1+busratemonth_double/100), (12*(year_id+1))))
						 /(Math.pow((1+busratemonth_double/100), (12*(year_id+1)))-1);
				pubmonthpay=(publoan_double*pubratemonth_double/100*Math.pow((1+pubratemonth_double/100), (12*(year_id+1))))
						 /(Math.pow((1+pubratemonth_double/100), (12*(year_id+1)))-1);
			}
			monthpay=busmonthpay+pubmonthpay;
			//设定输出格式，保留小数点后四位
			DecimalFormat df = new DecimalFormat("#0.0000");
			tv_monthshow.setText(df.format(monthpay));
			tv_paytotalshow.setText(df.format(monthpay*12*(year_id+1)));
			tv_interestshow.setText(df.format(monthpay*12*(year_id+1)-loantotal_double));
		}
		//等额本金
		else if(paytype_id==1)
		{
			//贷款总额、贷款月数
			tv_loantotalshow.setText(loantotal_double+"");
			tv_monthnumshow.setText(Integer.toString((12*(year_id+1))));
			//商业贷款
			if(busloan_double!=0&&publoan_double==0)
			{ 
				//设定输出格式，保留小数点后四位
				DecimalFormat df = new DecimalFormat("#.0000");
				buspay=(12*(year_id+1)+1)*busloan_double*busratemonth_double/200+busloan_double;
				pubpay=0;
				
				//月还款
				double[] arr_monthpay=new double[6];
				arr_monthpay[0]=(busloan_double/(12*(year_id+1)))+(busloan_double-0)*busratemonth_double/100;
				tv_monthshow.setText("第1月："+df.format(arr_monthpay[0])+"\n");
				 
				for(int i=1;i<6;i++)
				{
				 arr_monthpay[i]=(busloan_double/(12*(year_id+1)))+busratemonth_double/100*(busloan_double-((i*((12*(year_id+1))/6)-1)*(busloan_double/(12*(year_id+1)))));
				 tv_monthshow.append("第"+i*((12*(year_id+1))/6)+"月："+df.format(arr_monthpay[i])+"\n");
				}	 
			}
			//公积金贷款
			if(busloan_double==0&&publoan_double!=0)
			{
				//设定输出格式，保留小数点后四位
				DecimalFormat df = new DecimalFormat("#.0000");
				buspay=0;
				pubpay=(12*(year_id+1)+1)*publoan_double*pubratemonth_double/200+publoan_double;
				//月还款
				double[] arr_monthpay=new double[6];
				arr_monthpay[0]=(publoan_double/(12*(year_id+1)))+(publoan_double-0)*pubratemonth_double/100;
				tv_monthshow.setText("第1月："+df.format(arr_monthpay[0])+"\n");
				 
				for(int i=1;i<6;i++)
				{
					arr_monthpay[i]=(publoan_double/(12*(year_id+1)))+pubratemonth_double/100*(publoan_double-((i*((12*(year_id+1))/6)-1)*(publoan_double/(12*(year_id+1)))));
					tv_monthshow.append("第"+i*((12*(year_id+1))/6)+"月："+df.format(arr_monthpay[i])+"\n");
				}	 
			}
			//组合型
			if(busloan_double!=0&&publoan_double!=0)
			{
				//设定输出格式，保留小数点后四位
				DecimalFormat df = new DecimalFormat("#.0000");
				buspay=(12*(year_id+1)+1)*busloan_double*busratemonth_double/200+busloan_double;
				pubpay=(12*(year_id+1)+1)*publoan_double*pubratemonth_double/200+publoan_double;
				//月还款
				double[] arr_monthpay=new double[6];
				 arr_monthpay[0]=((busloan_double/(12*(year_id+1)))+(busloan_double-0)*busratemonth_double/100)
						 +((publoan_double/(12*(year_id+1)))+(publoan_double-0)*pubratemonth_double/100);
				 tv_monthshow.setText("第1月："+df.format(arr_monthpay[0])+"\n");
				 
				 for(int i=1;i<6;i++)
				 {
					 arr_monthpay[i]=((busloan_double/(12*(year_id+1)))+busratemonth_double/100*(busloan_double-((i*((12*(year_id+1))/6)-1)*(busloan_double/(12*(year_id+1))))))
							 +((publoan_double/(12*(year_id+1)))+pubratemonth_double/100*(publoan_double-((i*((12*(year_id+1))/6)-1)*(publoan_double/(12*(year_id+1))))));
					 tv_monthshow.append("第"+i*((12*(year_id+1))/6)+"月："+df.format(arr_monthpay[i])+"\n");
				 }	 
			}
			//设定输出格式，保留小数点后四位
			DecimalFormat df = new DecimalFormat("#.0000");
			//还款总额
			totalpay=buspay+pubpay;
			tv_paytotalshow.setText(df.format(totalpay));
			//支付利息款
			tv_interestshow.setText(df.format(totalpay-loantotal_double));
			
		}
		
		btn_end.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//清屏
				tv_loantotalshow.setText("");
				tv_paytotalshow.setText("");
				tv_interestshow.setText("");
				tv_monthnumshow.setText("");
				tv_monthshow.setText("");
				//返回填写信息界面
				Intent intent=new Intent();
				// 设置 Intent 对象要启动的 Activity 
            	intent.setClass(Activity_result.this, Activity_loan.class); 
              	// 通过 Intent 对象启动另外一个 Activity 
            	startActivity(intent);
			}
			
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}

}
