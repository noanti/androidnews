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
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ��������  
	    setContentView(R.layout.activity_main);
	    
		ListView mainlv = (ListView) findViewById(R.id.mainlv);  	      
	    //���ɶ�̬���飬����ת������  
	    ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();  
	    for(int i=0;i<30;i++)  
	    {  
	        HashMap<String, String> map = new HashMap<String, String>();  
	        map.put("ItemTitle", "This is Title.....");  
	        map.put("ItemBrief", "This is text.....");  
	        mylist.add(map);  
	    }  
	    //����������������===��ListItem  
	    SimpleAdapter mSchedule = new SimpleAdapter(this, //ûʲô����  
	                                                mylist,//������Դ   
	                                                R.layout.listitem,//ListItem��XMLʵ��  
	                                                  
	                                                //��̬������ListItem��Ӧ������          
	                                                new String[] {"ItemTitle", "ItemBrief"},   
	                                                  
	                                                //ListItem��XML�ļ����������TextView ID  
	                                                new int[] {R.id.itemtitle,R.id.itembrief});  
	    //��Ӳ�����ʾ  
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
	    //���ɶ�̬���飬����ת������  
	    ArrayList<HashMap<String, String>> catelist = new ArrayList<HashMap<String, String>>();  
	    for(int i=0;i<30;i++)  
	    {  
	        HashMap<String, String> map = new HashMap<String, String>();  
	        map.put("cateItemTitle", "����"+i);  
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
				//LinearLayout item = (LinearLayout)arg0.getItemAtPosition(arg2);
				//arg0.get
				//item.setBackgroundColor(getResources().getColor(R.color.black));
				//arg.setBackgroundColor(getResources().getColor(R.color.black));
				//TextView catetitle = (TextView)arg1.findViewById(R.id.cateitemtitle);
				//catetitle.setTextColor(getResources().getColor(R.color.white));
				TextView t = (TextView)catelv.getChildAt(arg2).findViewById(R.id.cateitemtitle);
				if (t.getText().equals("����"+arg2))
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
