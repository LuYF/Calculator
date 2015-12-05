package com.rootlu.calculator;

import com.singularsys.jep.Jep;
import com.singularsys.jep.ParseException;
import com.singularsys.jep.configurableparser.ConfigurableParser;
import com.singularsys.jep.configurableparser.matchers.HexNumberTokenMatcher;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Activity_hex extends Activity {
	//声明控件
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
	Button btn_A=null;
	Button btn_B=null;
	Button btn_C=null;
	Button btn_D=null;
	Button btn_E=null;
	Button btn_F=null;
	Button btn_equal=null;
	Button btn_Add=null;
	Button btn_Mul=null;
	Button btn_Sub=null;
	Button btn_Div=null;
	Button btn_Ce=null;
	Button btn_Lbra=null;
	Button btn_Rbra=null;
	Button btn_Backspace=null;
	Button btn_meue=null;
	TextView tv_result=null;
	
	//声明两个参数。接收tv_result前后的值
    double num1=0,num2=0;
    double Result=0;//计算结果
    int op=0;//判断操作数，
    boolean isClickEqu=false;//判断是否按了“=”
    
    ConfigurableParser cp;
    HexNumberTokenMatcher hexNumberTokenMatcher;
    Jep jep;
    
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_hex);
        //获取文本框
        tv_result=(TextView)findViewById(R.id.tv_result);
        
        //获取应用程序中的按钮
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
        btn_A=(Button)findViewById(R.id.btn_A);
        btn_B=(Button)findViewById(R.id.btn_B);
        btn_C=(Button)findViewById(R.id.btn_C);
        btn_D=(Button)findViewById(R.id.btn_D);
        btn_E=(Button)findViewById(R.id.btn_E);
        btn_F=(Button)findViewById(R.id.btn_F);
        btn_equal=(Button)findViewById(R.id.btn_equal);
        btn_Add=(Button)findViewById(R.id.btn_Add);
        btn_Sub=(Button)findViewById(R.id.btn_Sub);
        btn_Mul=(Button)findViewById(R.id.btn_Mul);
        btn_Div=(Button)findViewById(R.id.btn_Div);
        btn_Ce=(Button)findViewById(R.id.btn_CE);
        btn_Lbra=(Button)findViewById(R.id.btn_Lbra);
        btn_Rbra=(Button)findViewById(R.id.btn_Rbra);
        btn_Backspace=(Button)findViewById(R.id.btn_Backspace);
        tv_result=(TextView)findViewById(R.id.tv_result);
        btn_meue=(Button)findViewById(R.id.btn_meue);
       
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
    	
    	//数字按钮绑定监听事件
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
        btn_A.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String myStringA=tv_result.getText().toString();
                myStringA+="0xA";
                tv_result.setText(myStringA);	
			}
        	
        });
        btn_B.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String myStringB=tv_result.getText().toString();
                myStringB+="0xB";
                tv_result.setText(myStringB);	
			}
        	
        });
        btn_C.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String myStringC=tv_result.getText().toString();
                myStringC+="0xC";
                tv_result.setText(myStringC);	
			}
        	
        });
        btn_D.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String myStringD=tv_result.getText().toString();
                myStringD+="0xD";
                tv_result.setText(myStringD);	
			}
        	
        });
        btn_E.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String myStringE=tv_result.getText().toString();
                myStringE+="0xE";
                tv_result.setText(myStringE);	
			}
        	
        });
        btn_F.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String myStringF=tv_result.getText().toString();
                myStringF+="0xF";
                tv_result.setText(myStringF);	
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
        
       //等于按钮 
        btn_equal.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				init_Jep();
				
				try {
					tv_result.setText(jep.evaluate(jep.parse(tv_result.getText().toString())).toString());
					cp=null;
					jep=null;
					hexNumberTokenMatcher=null;
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (com.singularsys.jep.EvaluationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (Exception e) {
					// TODO: handle exception
					tv_result.setText(e.toString());
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
          	intent.setClass(Activity_hex.this, MainActivity.class); 
            	// 通过 Intent 对象启动另外一个 Activity 
          	startActivity(intent);
 			}
 	    	 
 	     });
    }
    private void init_Jep(){
		hexNumberTokenMatcher = new HexNumberTokenMatcher();
		cp = new  ConfigurableParser();
		cp.addTokenMatcher(hexNumberTokenMatcher);
		cp.addHashComments();
		cp.addSlashComments();
		cp.addDoubleQuoteStrings();
		cp.addWhiteSpace();
		cp.addExponentNumbers();
		cp.addOperatorTokenMatcher();
		cp.addSymbols("(",")","[","]",",");
		cp.setImplicitMultiplicationSymbols("(","[");
		cp.addIdentifiers();
		cp.addSemiColonTerminator();
		cp.addWhiteSpaceCommentFilter();
		cp.addBracketMatcher("(",")");
		cp.addFunctionMatcher("(",")",",");
		cp.addListMatcher("[","]",",");
		cp.addArrayAccessMatcher("[","]");
		jep=new Jep();
		jep.setComponent(cp);
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_hex, menu);
		return true;
	}

}
