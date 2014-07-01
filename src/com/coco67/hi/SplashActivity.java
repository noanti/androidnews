package com.coco67.hi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class SplashActivity extends Activity {   
  
     private final int SPLASH_DISPLAY_LENGHT = 5000; //�ӳ�����    
       
     protected void onCreate(Bundle savedInstanceState) {   
         super.onCreate(savedInstanceState); 
         this.requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ��������
         setContentView(R.layout.splash);   
      new Handler().postDelayed(new Runnable() {   
           // Ϊ�˼��ٴ���ʹ������Handler����һ����ʱ�ĵ���   
            public void run() {   
                Intent i = new Intent(SplashActivity.this, MainActivity.class);   
                 // ͨ��Intent������������������Main���Activity   
                SplashActivity.this.startActivity(i); // ����Main����   
                SplashActivity.this.finish(); // �ر��Լ����������   
             }   
        }, SPLASH_DISPLAY_LENGHT); 
     }
 }  
