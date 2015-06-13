package com.ecjtu.kyhelper.adapter;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ecjtu.kyhelper.R;
import com.ecjtu.kyhelper.model.KyNews;

/**
 * TODO : 研讯列表适配器
 * 
 * @author ECJTU IsayesHu
 * @date 2015年4月3日
 */
public class NewsListAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater = null;
	private List<KyNews> mNewsList = null; // 所选分类下的所有列表

	public NewsListAdapter(Context context, List<KyNews> newsList) {
		setmContext(context);
		mNewsList = newsList;
		mInflater = LayoutInflater.from(context);
	}

	// getCount决定了listview一共有多少个item
	@Override
	public int getCount() {
		return mNewsList.size();
	}

	// 设置setOnItemClickListener点击选择处理事件中方便地调用,来获取当前行数据的
	@Override
	public Object getItem(int position) {
		return mNewsList.get(position);
	}

	// 它返回的是该postion对应item的id
	@Override
	public long getItemId(int position) {
		return position;
	}

	// 刷新列表中的数据
	public void refresh(ArrayList<KyNews> list) {
		mNewsList = list;
		// 修改已经生成的列表，添加或者修改数据,notifyDataSetChanged()可以在修改适配器绑定的数组后，不用重新刷新Activity，通知Activity更新ListView。
		notifyDataSetChanged();
	}

	// getView返回了每个item项所显示的view
	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		NewsHolder newsHolder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.news_list_item, null);
			newsHolder = new NewsHolder();
			newsHolder.tvNewsType = (TextView) convertView
					.findViewById(R.id.tv_news_type);
			newsHolder.tvNewsTitle = (TextView) convertView
					.findViewById(R.id.tv_news_title);
			newsHolder.tvNewsDate = (TextView) convertView
					.findViewById(R.id.tv_news_date);
			convertView.setTag(newsHolder);
		} else {
			newsHolder = (NewsHolder) convertView.getTag();
		}
		// 拆分字符串，只取年月日
		String[] ss = new String[2];
		ss = mNewsList.get(position).getCreatedAt().split(" ");
		newsHolder.tvNewsType.setText(mNewsList.get(position).getType()); // 文章类型
		newsHolder.tvNewsTitle.setText(mNewsList.get(position).getTitle()); // 文章标题
		newsHolder.tvNewsDate.setText(ss[0]); // 文章发布日期
		return convertView;
	}

	public Context getmContext() {
		return mContext;
	}

	public void setmContext(Context mContext) {
		this.mContext = mContext;
	}
}
