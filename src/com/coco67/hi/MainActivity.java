package com.coco67.hi;

import java.util.ArrayList;
import java.util.HashMap;

import com.meetme.android.horizontallistview.HorizontalListView;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	private HorizontalListView catelv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏  
	    setContentView(R.layout.activity_main);
	    
		ListView mainlv = (ListView) findViewById(R.id.mainlv);  	      
	    //生成动态数组，并且转载数据  
	    ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();  
	    for(int i=0;i<30;i++)  
	    {  
	        HashMap<String, String> map = new HashMap<String, String>();  
	        map.put("ItemTitle", "This is Title.....");  
	        map.put("ItemBrief", "This is text.....");  
	        mylist.add(map);  
	    }  
	    //生成适配器，数组===》ListItem  
	    SimpleAdapter mSchedule = new SimpleAdapter(this, //没什么解释  
	                                                mylist,//数据来源   
	                                                R.layout.listitem,//ListItem的XML实现  
	                                                  
	                                                //动态数组与ListItem对应的子项          
	                                                new String[] {"ItemTitle", "ItemBrief"},   
	                                                  
	                                                //ListItem的XML文件里面的两个TextView ID  
	                                                new int[] {R.id.itemtitle,R.id.itembrief});  
	    //添加并且显示  
	    mainlv.setAdapter(mSchedule);
	    mainlv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(getApplicationContext(), "count:"+arg0.getCount(),
					     Toast.LENGTH_SHORT).show();
				
				
			}
		});
	    
	    catelv = (HorizontalListView) findViewById(R.id.catelv);  	      
	    //生成动态数组，并且转载数据  
	    ArrayList<HashMap<String, String>> catelist = new ArrayList<HashMap<String, String>>();  
	    for(int i=0;i<30;i++)  
	    {  
	        HashMap<String, String> map = new HashMap<String, String>();  
	        map.put("cateItemTitle", "体育"+i);  
	        catelist.add(map);  
	    } 
	    //生成适配器，数组===》ListItem  
	    SimpleAdapter Schedule = new SimpleAdapter(this, //没什么解释  
	                                                catelist,//数据来源   
	                                                R.layout.categoryitem,//ListItem的XML实现  
	                                                  
	                                                //动态数组与ListItem对应的子项          
	                                                new String[] {"cateItemTitle"},   
	                                                  
	                                                //ListItem的XML文件里面的两个TextView ID  
	                                                new int[] {R.id.cateitemtitle});  
	    //添加并且显示  
	    catelv.setAdapter(Schedule);
	    catelv.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				for (int i=0; i<arg0.getChildCount(); i++){
					TextView t = (TextView)arg0.getChildAt(i).findViewById(R.id.cateitemtitle);
					t.setBackgroundColor(0);
				}
				//LinearLayout item = (LinearLayout)arg0.getItemAtPosition(arg2);
				//arg0.get
				//item.setBackgroundColor(getResources().getColor(R.color.black));
				//arg.setBackgroundColor(getResources().getColor(R.color.black));
				//TextView catetitle = (TextView)arg1.findViewById(R.id.cateitemtitle);
				//catetitle.setTextColor(getResources().getColor(R.color.white));
				TextView t = (TextView)catelv.getChildAt(arg2).findViewById(R.id.cateitemtitle);
				if (t.getText().equals("体育"+arg2))
					t.setBackgroundColor(getResources().getColor(R.color.black));
				
			}
	    	
	    });
	    int t=mainlv.getCount();
	}
	@Override  
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		//int id = item.getItemId();
		//if (id == R.id.action_settings) {
		//	return true;
		//}
		return super.onOptionsItemSelected(item);
		//return true;
	}

}
