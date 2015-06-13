package com.ecjtu.kyhelper.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.ecjtu.kyhelper.R;

/**
 * TODO : NewsActivity.java--推送研讯内容显示界面
 * 
 * @author ECJTU IsayesHu
 * @date 2015年3月29日
 */
public class NewsActivity extends Activity {

	private TextView kyNewsTitle;
	private TextView kyNewsAuthor;
	private TextView kyNewsTime;
	private TextView kyNewsContent;
	private String newsTitle;
	private String newsAuthor;
	private String newsTime;
	private String newsContent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);
		getIntentData();
		initView();
	}

	// 获取Intent中传入的新闻数据
	private void getIntentData() {
		// TODO Auto-generated method stub
		newsTitle = getIntent().getStringExtra("NewsTitle");
		newsAuthor = getIntent().getStringExtra("NewsAuthor");
		newsTime = getIntent().getStringExtra("NewsTime");
		newsContent = getIntent().getStringExtra("NewsContent");

	}

	private void initView() {
		// TODO Auto-generated method stub
		kyNewsTitle = (TextView) findViewById(R.id.tv_news_title);
		kyNewsAuthor = (TextView) findViewById(R.id.tv_news_author);
		kyNewsTime = (TextView) findViewById(R.id.tv_news_time);
		kyNewsContent = (TextView) findViewById(R.id.tv_news_content);

		kyNewsTitle.setText(newsTitle);
		kyNewsAuthor.setText("作者 : " + newsAuthor);
		kyNewsTime.setText("发布日期 : " + newsTime);
		kyNewsContent.setText(newsContent);
	}

}
