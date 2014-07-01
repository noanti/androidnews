package com.coco67.hi;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.OnGestureListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

public class DetailActivity extends ActionBarActivity implements
        OnClickListener, OnGestureListener {
	
	String[] str = new String[]{"综合","军事","历史","大陆","台湾","国际","社会"};
	private ImageButton goback;
	private TextView mTitleTextView;
    private TextView mNewsTitle;
    private TextView mNewsTime;
    private TextView mNewsContent;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏 
		setContentView(R.layout.activity_detail);	

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		goback=(ImageButton)this.findViewById(R.id.detail_back);
		goback.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		setupviews();
	}
	
	private void setupviews() {
		
		mTitleTextView = (TextView)findViewById(R.id.app_detail_title);
		mNewsTitle = (TextView)findViewById(R.id.newstitle);
		mNewsTime = (TextView)findViewById(R.id.newstime);
		mNewsContent = (TextView)findViewById(R.id.newscontent);
		try{
			Intent intent = getIntent();
			int currentPage = intent.getIntExtra("currentPage",0);
			String title = intent.getStringExtra("title");
			String link = intent.getStringExtra("link");
			String time = intent.getStringExtra("time");
			
			mTitleTextView.setText(str[currentPage]);
			mNewsTitle.setText(title);
			mNewsTime.setText(time);
			
			TestImageGetter imgGetter = new TestImageGetter(mNewsContent, this);
			mNewsContent.setText(Html.fromHtml("<html><head><title>TextView使用HTML</title></head><body><p><strong>强调</strong></p><p><em>斜体</em></p>"  
	                +"<p><a href=\"http://www.dreamdu.com/xhtml/\">超链接HTML入门</a>学习HTML!</p><p><font color=\"#aabb00\">颜色1"  
	                +"</p><p><font color=\"#00bbaa\">颜色2</p><h1>标题1</h1><img src=\"http://www.imhdr.com/wp-content/uploads/2013/06/20130616234511_46680.png\"/><h3>标题2</h3><h6>标题3</h6><p>大于>小于<</p><p>" +  
	                "下面是网络图片</p><img src=\"http://n.sinaimg.cn/transform/20140630/avxeafr1879693.jpg\"/><p>大于>小于<</p></body></html>",imgGetter,null));	
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_detail,
					container, false);
			return rootView;
		}
	}
	
	@Override
	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent arg0) {
		
	}

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		return false;
	}

	@Override
	public void onShowPress(MotionEvent arg0) {
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		return false;
	}

}
