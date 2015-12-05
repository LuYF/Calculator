package com.rootlu.calculator;


import com.singularsys.jep.EvaluationException;
import com.singularsys.jep.Jep;
import com.singularsys.jep.ParseException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Activity_dec extends Activity {

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
		Button btn_meue=null;
		
		Button btn_Add=null;
		Button btn_Mul=null;
		Button btn_Sub=null;
		Button btn_Div=null;
		Button btn_Sqrt=null;	
		Button btn_Lbra=null;
		Button btn_Rbra=null;
		Button btn_Square=null;
		Button btn_complex=null;
		TextView tv_result=null;
		

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_activity_dec);
			//获取文本框
			tv_result=(TextView)findViewById(R.id.tv_result);
		
	    
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
	    	btn_Add=(Button)findViewById(R.id.btn_Add);
	    	btn_Sub=(Button)findViewById(R.id.btn_Sub);
	    	btn_Mul=(Button)findViewById(R.id.btn_Mul);
	    	btn_Div=(Button)findViewById(R.id.btn_Div);
	    	btn_Sqrt=(Button)findViewById(R.id.btn_Sqrt);	
	    	btn_Lbra=(Button)findViewById(R.id.btn_Lbra);
	    	btn_Rbra=(Button)findViewById(R.id.btn_Rbra);
	    	btn_Square=(Button)findViewById(R.id.btn_Square);
	    	btn_meue=(Button)findViewById(R.id.btn_meue);
	    	btn_complex=(Button)findViewById(R.id.btn_complex);
	    	tv_result=(TextView)findViewById(R.id.tv_result);
	    
	    	
	    	//清屏按钮功能
	    	btn_Ce.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					tv_result.setText("");
					
				}
	    	});
	    	//退格按钮功能
	    	btn_Backspace.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub	
				    String str=tv_result.getText().toString();
				    if(tv_result.getText().length()!=0)
				    	tv_result.setText(str.substring(0, str.length()-1));
				    
				}	
	    	});
	    	
	    	//为按钮绑定监听事件
	        btn_0.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
	        		String myString=tv_result.getText().toString();
	                myString+="0";
	                tv_result.setText(myString);
	               
				}
	        	
	        });
	        btn_1.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String myString1=tv_result.getText().toString();
	                myString1+="1";
	                tv_result.setText(myString1);
				}
	        	
	        });
	        btn_2.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String myString2=tv_result.getText().toString();
	                myString2+="2";
	                tv_result.setText(myString2);
				}
	        	
	        });
	        btn_3.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String myString3=tv_result.getText().toString();
	                myString3+="3";
	                tv_result.setText(myString3);
				}
	        	
	        });
	        btn_4.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String myString4=tv_result.getText().toString();
	                myString4+="4";
	                tv_result.setText(myString4);
				}
	        	
	        });
	        btn_5.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String myString5=tv_result.getText().toString();
	                myString5+="5";
	                tv_result.setText(myString5);
				}
	        	
	        });
	        btn_6.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String myString6=tv_result.getText().toString();
	                myString6+="6";
	                tv_result.setText(myString6);
				}
	        	
	        }
	        );
	        btn_7.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String myString7=tv_result.getText().toString();
	                myString7+="7";
	                tv_result.setText(myString7);
				}
	        	
	        });
	        btn_8.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String myString8=tv_result.getText().toString();
	                myString8+="8";
	                tv_result.setText(myString8);
				}
	        	
	        });
	        btn_9.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String myString9=tv_result.getText().toString();
	                myString9+="9";
	                tv_result.setText(myString9);	
				}
	        	
	        });
	        btn_point.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String myStringPoint=tv_result.getText().toString();
	                myStringPoint+=".";
	                tv_result.setText(myStringPoint);
				}
	        	
	        });
	        btn_complex.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String myStringComplex=tv_result.getText().toString();
	                myStringComplex+="i";
	                tv_result.setText(myStringComplex);
				}
	        	
	        });
	        
	        btn_Add.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String myStringAdd=tv_result.getText().toString();
	                if(myStringAdd!=null)
	                {
	                	tv_result.append("+");
	                }   
				}
	        	
	        });
	        btn_Sub.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String myStringAdd=tv_result.getText().toString();
	                if(myStringAdd.equals(null))
	                {
	                    return;
	                } 
	                tv_result.append("-");
				}
	        	
	        });
	        btn_Mul.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String myStringAdd=tv_result.getText().toString();
	                if(myStringAdd.equals(null))
	                {
	                    return;
	                } 
	                tv_result.append("*");
				}
	        	
	        });
	        btn_Div.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String myStringAdd=tv_result.getText().toString();
	                if(myStringAdd.equals(null))
	                {
	                    return;
	                } 
	                tv_result.append("/");
				}
	        	
	        });
	        btn_Sqrt.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String myStringAdd=tv_result.getText().toString();
	                if(myStringAdd.equals(null))
	                {
	                    return;
	                } 
	                tv_result.append("^(1/2)");
				}
	        	
	        });
	        btn_Square.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String myStringAdd=tv_result.getText().toString();
	                if(myStringAdd.equals(null))
	                {
	                    return;
	                } 
	                tv_result.append("^2");
				}
	        	
	        });
	        btn_Lbra.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String myStringAdd=tv_result.getText().toString();
	                if(myStringAdd.equals(null))
	                {
	                    return;
	                } 
	                tv_result.append("(");
				}
	        	
	        });
	        btn_Rbra.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String myStringAdd=tv_result.getText().toString();
	                if(myStringAdd.equals(null))
	                {
	                    return;
	                } 
	                tv_result.append(")");
				}
	        	
	        });

	 	   	//实现等于按钮功能
	 	   btn_equal.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String str=tv_result.getText().toString();
				Jep jep=new Jep();
				try {
					jep.parse(str);
					try {
						tv_result.setText(jep.evaluate().toString());
					} catch (EvaluationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	 	   });
	 	  //返回主菜单
	  	   btn_meue.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();
					// 设置 Intent 对象要启动的 Activity 
	         	intent.setClass(Activity_dec.this, MainActivity.class); 
	           	// 通过 Intent 对象启动另外一个 Activity 
	         	startActivity(intent);
				}
		    	 
		     });
		}
}
