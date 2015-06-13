package com.ecjtu.kyhelper.adapter;

import java.util.List;
import com.ecjtu.kyhelper.R;
import com.ecjtu.kyhelper.model.SComment;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * TODO : 评论列表适配器
 * 
 * @author ECJTU IsayesHu
 * @date 2015年4月3日
 */

@SuppressLint("InflateParams")
public class SCommentAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater = null;
	private List<SComment> mSComList = null; // 所选分类下的所有列表

	public SCommentAdapter(Context context, List<SComment> list) {
		setmContext(context);
		mSComList = list;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return mSComList.size();
	}

	@Override
	public Object getItem(int position) {
		return mSComList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		SComHolder scomHolder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.scom_list_item, null);
			scomHolder = new SComHolder();
			scomHolder.tvComUser = (TextView) convertView
					.findViewById(R.id.tv_commit_user);
			scomHolder.tvComContent = (TextView) convertView
					.findViewById(R.id.tv_commit_content);
			convertView.setTag(scomHolder);
		} else {
			scomHolder = (SComHolder) convertView.getTag();
		}
		scomHolder.tvComUser.setText(mSComList.get(position).getUserName());
		scomHolder.tvComContent.setText(mSComList.get(position).getContent());
		return convertView;
	}

	public Context getmContext() {
		return mContext;
	}

	public void setmContext(Context mContext) {
		this.mContext = mContext;
	}

}
