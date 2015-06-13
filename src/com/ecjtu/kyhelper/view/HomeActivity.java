package com.ecjtu.kyhelper.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import com.ecjtu.kyhelper.R;
import com.ecjtu.kyhelper.adapter.NewsListAdapter;
import com.ecjtu.kyhelper.model.KyNews;
import com.ecjtu.ui.ListScrollView;

/**
 * TODO : 研讯界面
 * 
 * @author ECJTU IsayesHu
 * @date 2015年4月23日
 */
@SuppressLint("ShowToast")
public class HomeActivity extends Activity implements OnItemClickListener {

	private ListScrollView listScrollView;

	// 校历
	private TextView tvWeek; // 周次和星期
	private TextView tvDay; // 年月日

	// 研讯新闻
	private ListView lvNewsList;
	private List<KyNews> newsList = new ArrayList<KyNews>();
	private NewsListAdapter newsListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		listScrollView = (ListScrollView) findViewById(R.id.listScrollView);
		lvNewsList = (ListView) findViewById(R.id.lv_news);
		listScrollView.setListView(lvNewsList);

		// 日历
		tvWeek = (TextView) findViewById(R.id.tv_week);
		tvDay = (TextView) findViewById(R.id.tv_day);
		setTime();

		// 新闻
		newsListAdapter = new NewsListAdapter(this, newsList);
		// 为 ListView 放置适配器
		lvNewsList.setAdapter(newsListAdapter);
		lvNewsList.setOnItemClickListener(this);

		getNewsData();
	}

	/**
	 * 设置日期的时间
	 */
	public void setTime() {
		Calendar calendar = Calendar.getInstance();
		String year = calendar.get(Calendar.YEAR) + "";
		String month = calendar.get(Calendar.MONTH) + 1 + "";
		String day = calendar.get(Calendar.DAY_OF_MONTH) + "";
		String week = calendar.get(Calendar.WEEK_OF_YEAR) - 9 + "";
		String dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1 + "";
		toast(year + "-" + month + "-" + day + " " + " 第 " + week + " 周 " + " "
				+ " 星期 " + dayOfWeek);
		tvWeek.setText(" 第 " + week + " 周 " + " " + " 星期 " + dayOfWeek);
		tvDay.setText(year + "年 " + month + "月 " + day + "日  ");
	}

	/**
	 * 初始化新闻列表数据
	 * 
	 * @date
	 * @author
	 */
	public void getNewsData() {
		BmobQuery<KyNews> query = new BmobQuery<KyNews>();
		query.order("-updatedAt");
		query.findObjects(this, new FindListener<KyNews>() {

			@Override
			public void onSuccess(List<KyNews> object) {
				newsList = object;
				// 通知Adapter数据更新
				newsListAdapter.refresh((ArrayList<KyNews>) newsList);
				newsListAdapter.notifyDataSetChanged();
			}

			@Override
			public void onError(String arg0) {
				toast("获取数据失败了");
			}
		});
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent toNewsDetail = new Intent(HomeActivity.this, NewsActivity.class);
		toNewsDetail.putExtra("NewsTitle", newsList.get(position).getTitle());
		toNewsDetail.putExtra("NewsAuthor", newsList.get(position).getAuthor());
		toNewsDetail
				.putExtra("NewsTime", newsList.get(position).getCreatedAt());
		toNewsDetail.putExtra("NewsContent", newsList.get(position)
				.getContent());
		startActivity(toNewsDetail);
	}

	public void toast(String toast) {
		Toast.makeText(this, toast, Toast.LENGTH_SHORT);
	}

}
