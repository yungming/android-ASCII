package com.example.ascii;

import java.io.BufferedReader;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	int result,i;
	EditText resultat;
	BufferedReader read;
String nul =null;
	TextView eng1,eng2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        Button bt1=(Button) findViewById(R.id.ASCII);bt1.setOnClickListener(listener);
        Button bt2=(Button) findViewById(R.id.binary);bt2.setOnClickListener(listener);

        eng1=(TextView) findViewById(R.id.textView2);
        eng1.setMovementMethod(new ScrollingMovementMethod());//�ưʭI��
        resultat=(EditText) findViewById(R.id.editText1);
        
               		
	}
	
	private Button.OnClickListener listener=new
	Button.OnClickListener(){
		public void onClick(View V){
			if("".equals(resultat.getText().toString().trim())){//��J�ŭ�
 					Toast.makeText(getBaseContext(), "�Э��s��J�^��/�G�i��", Toast.LENGTH_SHORT).show();
 			}
			else{			
				switch(V.getId())
				{
					case R.id.ASCII://ASCII��10�i��M2�i��
	 					for(int i=0;i<resultat.getText().length();i++){	 						
	 						eng1.setText(eng1.getText()+"\n"+resultat.getText().charAt(i)+"\t\t"+Integer.toString(ascii(resultat.getText().charAt(i))));
	 						eng1.setText(eng1.getText()+"(10)\t\t"+binary(resultat.getText().charAt(i))+"(2)");
	 						
	 					}
					break;
					case R.id.binary:
						
						if((resultat.getText().length())%8==0||Judge(resultat.getText().toString()))
						{eng1.setText(eng1.getText()+"\n"+BigbintoASCII(resultat.getText().toString()));}
						else
						{ Toast.makeText(getBaseContext(), "���~!! �G�i��D��8�ӭ��Ʋզ��ΫD1�B0",Toast.LENGTH_SHORT).show();}
					break;

				}
			}
			
		}
	};
			
	
	public void clear(View V){

		eng1.setText("");
		resultat.setText("");

	}
	
			
	
    public int ascii(char mot){//�r������
    	result=(int) mot;
    	return result;
    }
    public boolean Judge(String str){//�P�_�r��O�_1��0�զ�
    	boolean t=true;
			for(int i=0;i<str.length();i++)
			{	 						
				if(str.substring(i,i+1)!="1"||str.substring(i,i+1)!="0")
				{t=false;}					
			}
			if(t)
			{return true;}
			else
			{return false;}

    }
    
    public String binary(int number){//10�i����2�i��
    	String binary;
    	binary= Integer.toBinaryString(number);
    	while(true)
    	{
        	if(binary.length()<8)
        	{
        		binary="0"+binary;
        	}
        	else
    		{return binary;}	
    	}

    }
    /*
    public String binarytoASCII(String str){//2�i����10�A��r��(8Bits)
    	String ASCII;int number;
        	if(str.substring(0,1)=="0")
        	{
        		return binarytoASCII(str.substring(1));
        	}
        	else
    	 	{
        		number=Integer.valueOf(str,2);
            	ASCII=new Character((char)number).toString();
            	return ASCII;
    	 	}


    }
    */
    public StringBuffer BigbintoASCII(String str){//�j�q2�i����10�A��r��

    StringBuffer str2=new StringBuffer();
    for(int i=0;i<str.length();i+=8){
    	str2.append((char)Integer.parseInt(str.substring(i,i+8),2));
    }
    return str2;



    } 
    public MovementMethod scrollbars(){
		return new ScrollingMovementMethod();
    	
    }
}
