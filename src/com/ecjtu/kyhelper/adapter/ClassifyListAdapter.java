package com.ecjtu.kyhelper.adapter;

import java.util.ArrayList;
import java.util.Iterator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ecjtu.data.TypeDef;
import com.ecjtu.kyhelper.R;
import com.ecjtu.kyhelper.model.Subject;

/**
 * TODO : 适配器--适配某一分类下的列表数据
 * 
 * @author ECJTU IsayesHu
 * @date 2015年4月3日
 */

@SuppressLint("InflateParams")
public class ClassifyListAdapter extends BaseAdapter {

	/**
	 * LayoutInflater是用来找res/layout/下的xml布局文件，并且实例化；而findViewById()
	 * 是找xml布局文件下的具体widget控件(如Button、TextView等)
	 */
	private Context mContext;
	private LayoutInflater mInflater = null;// LayoutInflater作用是将layout的xml布局文件实例化为View类对象
	private ArrayList<Subject> mClassifyList = null; // 所选分类下的所有列表
	private String subType; // 科目的分类

	public ClassifyListAdapter(Context context,
			ArrayList<Subject> classifyList, String type) {
		setmContext(context);
		mClassifyList = classifyList;
		subType = type;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return mClassifyList.size();
	}

	@Override
	public Object getItem(int position) {
		return mClassifyList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	// 刷新列表中的数据
	public void refresh(ArrayList<Subject> list) {
		mClassifyList = list;
		// 将数字的类型编号转换为文字
		exchangeType(subType);
		notifyDataSetChanged();
	}

	/**
	 * 根据当前的type类型, 转换成相应的文字
	 * 
	 * @param typeString
	 */
	private void exchangeType(String typeString) {

		int type = Integer.parseInt(typeString);
		int fatherType = type / 10; // 父类型编号
		int sonType = type % 10; // 子类型编号

		Iterator<Subject> iterator = mClassifyList.iterator();
		while (iterator.hasNext()) {
			switch (fatherType) {
			case 1:
				iterator.next().setType(
						TypeDef.typeDadList[fatherType - 1] + "/"
								+ TypeDef.typeSonList1[sonType - 1]);
				break;
			case 2:
				iterator.next().setType(
						TypeDef.typeDadList[fatherType - 1] + "/"
								+ TypeDef.typeSonList2[sonType - 1]);
				break;
			case 3:
				iterator.next().setType(
						TypeDef.typeDadList[fatherType - 1] + "/"
								+ TypeDef.typeSonList3[sonType - 1]);
				break;
			case 4:
				iterator.next().setType(
						TypeDef.typeDadList[fatherType - 1] + "/"
								+ TypeDef.typeSonList4[sonType - 1]);
				break;
			default:
				break;
			}
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		/**
		 * int position位置，一般BaseAdapter都是很多类型一样的数据展示在界面，该属性是判断显示在界面上的是第几个，
		 * 通过position在BaseAdapter自定义的数组或者集合中取值。并展示在界面上。 View convertView
		 * 展示在界面上的一个item。因为手机屏幕就那么大，所以一次展示给用户看见的内容是固定的，如果你List中有1000条数据，
		 * 不应该new1000个converView
		 * ，那样内存肯定不足，应该学会控件重用，滑出屏幕的convertView就在下面新进来的item中重新使用，只是修改下他展示的值
		 */
		ClassifyHolder classifyHodler;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.subject_all_list_item,
					null);
			classifyHodler = new ClassifyHolder();
			classifyHodler.tvClassifyName = (TextView) convertView
					.findViewById(R.id.tv_subject_name);
			classifyHodler.tvClassifyType = (TextView) convertView
					.findViewById(R.id.tv_subject_type);
			classifyHodler.tvClassifyLoc = (TextView) convertView
					.findViewById(R.id.tv_subject_loc);
			convertView.setTag(classifyHodler);
		} else {
			// 把查找的view缓存起来方便多次重用
			// 不用重新构建VIEW，利用系统中缓存的VIEW，可以提高效率
			classifyHodler = (ClassifyHolder) convertView.getTag();
		}
		classifyHodler.tvClassifyName.setText(mClassifyList.get(position)
				.getName());
		// 类型需要单独处理
		classifyHodler.tvClassifyType.setText(mClassifyList.get(position)
				.getType());
		classifyHodler.tvClassifyLoc.setText(mClassifyList.get(position)
				.getSummary());
		return convertView;
	}

	public Context getmContext() {
		return mContext;
	}

	public void setmContext(Context mContext) {
		this.mContext = mContext;
	}

}
