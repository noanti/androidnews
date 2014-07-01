package com.coco67.hi;

import android.app.Activity; 
import android.content.Intent; 
import android.os.Bundle; 
import android.os.Handler; 
import android.view.Window;

public class SplashActivity extends Activity {    

    private final int SPLASH_DISPLAY_LENGHT = 5000; //延迟四秒 

    @Override 
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏 
        setContentView(R.layout.splash); 
        new Handler().postDelayed(new Runnable(){ 

         @Override 
         public void run() { 
             Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class); 
             SplashActivity.this.startActivity(mainIntent); 
                 SplashActivity.this.finish(); 
         } 
            
        }, SPLASH_DISPLAY_LENGHT); 
    } 
}