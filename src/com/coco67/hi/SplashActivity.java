package com.coco67.hi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class SplashActivity extends Activity {   
  
     private final int SPLASH_DISPLAY_LENGHT = 5000; //延迟五秒    
       
     protected void onCreate(Bundle savedInstanceState) {   
         super.onCreate(savedInstanceState); 
         this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
         setContentView(R.layout.splash);   
      new Handler().postDelayed(new Runnable() {   
           // 为了减少代码使用匿名Handler创建一个延时的调用   
            public void run() {   
                Intent i = new Intent(SplashActivity.this, MainActivity.class);   
                 // 通过Intent打开最终真正的主界面Main这个Activity   
                SplashActivity.this.startActivity(i); // 启动Main界面   
                SplashActivity.this.finish(); // 关闭自己这个开场屏   
             }   
        }, SPLASH_DISPLAY_LENGHT); 
     }
 }  
