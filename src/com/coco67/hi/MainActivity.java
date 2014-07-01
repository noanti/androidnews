package com.coco67.hi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.coco67.hi.MainActivity;
import com.coco67.hi.DetailActivity;
import com.meetme.android.horizontallistview.HorizontalListView;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private HorizontalListView catelv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ��������  
		
		if (android.os.Build.VERSION.SDK_INT > 9) {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		}
	    setContentView(R.layout.activity_main);
	    
		ListView mainlv = (ListView) findViewById(R.id.mainlv);  	      
	    mainlv.setOnItemClickListener(new OnItemClickListener() {
	    	@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(getApplicationContext(), "count:"+arg0.getCount(),
					     Toast.LENGTH_SHORT).show();
				
				Intent intent = new Intent(MainActivity.this, DetailActivity.class);			  
				startActivity(intent);
				
			}
		});
	    
	    catelv = (HorizontalListView) findViewById(R.id.catelv);  	      
	    //���ɶ�̬���飬����ת������  
	    ArrayList<HashMap<String, String>> catelist = new ArrayList<HashMap<String, String>>();  
	    
	    String[] str = {"�ۺ�","����","��ʷ","��½","̨��","����","���"};
	    for(int i=0;i<7;i++)
	    {
	    	HashMap<String, String> map = new HashMap<String, String>();  
	    	map.put("cateItemTitle", str[i]); 
		    catelist.add(map);  
	    }
	    //����������������===��ListItem  
	    SimpleAdapter Schedule = new SimpleAdapter(this, //ûʲô����  
	                                                catelist,//������Դ   
	                                                R.layout.categoryitem,//ListItem��XMLʵ��  
	                                                  
	                                                //��̬������ListItem��Ӧ������          
	                                                new String[] {"cateItemTitle"},   
	                                                  
	                                                //ListItem��XML�ļ����������TextView ID  
	                                                new int[] {R.id.cateitemtitle});  
	    //��Ӳ�����ʾ  
	    catelv.setAdapter(Schedule);
	    catelv.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				for (int i=0; i<arg0.getChildCount(); i++){
					TextView t = (TextView)arg0.getChildAt(i).findViewById(R.id.cateitemtitle);
					t.setBackgroundColor(0);
				}
				
				TextView t = (TextView)catelv.getChildAt(arg2).findViewById(R.id.cateitemtitle);
				t.setBackgroundColor(getResources().getColor(R.color.black));
				setmainlv(arg2);
			}
				
	    	
	    });
	    setmainlv(0);
	}

	public void setmainlv(int ind)
	{
		News[] list;
		RssParser rp = null;
		try {
			rp = new RssParser(ind);
		} catch (IOException e) {
			e.printStackTrace();
		}
		list = rp.getList();
		Log.d("info", "after getlist");
		ListView mainlv = (ListView) findViewById(R.id.mainlv);  	      
	    //���ɶ�̬���飬����ת������  
	    ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();  
	    for(int i=0;i<rp.count;i++)  
	    {  
	        HashMap<String, String> map = new HashMap<String, String>();  
	        map.put("ItemTitle", list[i].title);  
	        map.put("ItemBrief", list[i].digest);  
	        mylist.add(map);  
	    }  
	    //����������������===��ListItem  
	    SimpleAdapter mSchedule = new SimpleAdapter(MainActivity.this, //ûʲô����  
	                                                mylist,//������Դ   
	                                                R.layout.listitem,//ListItem��XMLʵ��  
	                                                  
	                                                //��̬������ListItem��Ӧ������          
	                                                new String[] {"ItemTitle", "ItemBrief"},   
	                                                  
	                                                //ListItem��XML�ļ����������TextView ID  
	                                                new int[] {R.id.itemtitle,R.id.itembrief});
	    //��Ӳ�����ʾ  
	    mainlv.setAdapter(mSchedule);
		
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
