package com.coco67.hi;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
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
	
	private ImageButton goback;
	private TextView mTitleTextView;
    private TextView mNewsTitle;
    private TextView mNewsSource;
    private TextView mNewsTime;
    private TextView mNewsContent;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//»•µÙ±ÍÃ‚¿∏ 
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
		// TODO Auto-generated method stub
		
		mTitleTextView = (TextView)findViewById(R.id.detail_title);
		mNewsTitle = (TextView)findViewById(R.id.newstitle);
		mNewsSource = (TextView)findViewById(R.id.newssource);
		mNewsTime = (TextView)findViewById(R.id.newstime);
		mNewsContent = (TextView)findViewById(R.id.newscontent);
		
		try{
			
//			String str = "adada";
//			
//			mTitleTextView.setText(str+"erfwf");
//			mNewsTitle.setText(str.toString()+"wdqda");
//			mNewsSource.setText(str.toString()+"wdqda");
//			mNewsTime.setText(str.toString()+"wdqda");
//			mNewsContent.setText(str.toString()+"wdqda");		
			
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
