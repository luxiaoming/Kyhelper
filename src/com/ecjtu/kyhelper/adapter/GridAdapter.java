package com.ecjtu.kyhelper.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ecjtu.data.TypeDef;
import com.ecjtu.kyhelper.R;

/**
 * 科目分类-- 网格布局(ImageView+TextView)适配器
 * 
 */
public class GridAdapter extends BaseAdapter {

	private Context mContext;
	private int mIndex = 0; // 代表当前需要适配页面中第几个GridView

	// 子分类--考研数学核心考点
	public static String[] mMathTexts = TypeDef.typeSonList1;
	private int[] mMathImages = { R.drawable.ic_8, R.drawable.ic_8,
			R.drawable.ic_8, R.drawable.ic_8 };

	// 子分类--考研英语核心考点
	public static String[] kyEngTexts = TypeDef.typeSonList2;
	private int[] mEnglishImages = { R.drawable.ic_4, R.drawable.ic_4,
			R.drawable.ic_4, R.drawable.ic_4 };

	// 子分类--考研政治核心考点
	public static String[] mPolityTexts = TypeDef.typeSonList3;
	private int[] mPolityImages = { R.drawable.ic_8, R.drawable.ic_8,
			R.drawable.ic_8, R.drawable.ic_8 };

	// 子分类--考研经验
	public static String[] mExperienceTexts = TypeDef.typeSonList4;
	private int[] mExperienceImages = { R.drawable.ic_4, R.drawable.ic_4,
			R.drawable.ic_4, R.drawable.ic_4 };

	public GridAdapter(Context context, int index) {
		mContext = context;
		mIndex = index;
	}

	@Override
	public int getCount() {
		int count = 0;
		switch (mIndex) {
		case 0:
			count = mEnglishImages.length;
			break;
		case 1:
			count = mPolityImages.length;
			break;
		case 2:
			count = mExperienceImages.length;
			break;
		case 3:
			count = mMathImages.length;
			break;
		default:
			break;
		}
		return count;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@SuppressLint("ViewHolder")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Inflate()作用就是将xml定义的一个布局找出来，但仅仅是找出来而且隐藏的，没有找到的同时并显示功能。
		View view = View.inflate(mContext, R.layout.subject_grid_item, null);

		ImageView image = (ImageView) view.findViewById(R.id.img_chooseImage);
		TextView text = (TextView) view.findViewById(R.id.tv_chooseText);
		switch (mIndex) {
		case 0:
			image.setImageResource(mEnglishImages[position]);
			text.setText(kyEngTexts[position]);
			break;
		case 1:
			image.setImageResource(mPolityImages[position]);
			text.setText(mPolityTexts[position]);
			break;
		case 2:
			image.setImageResource(mExperienceImages[position]);
			text.setText(mExperienceTexts[position]);
			break;
		case 3:
			image.setImageResource(mMathImages[position]);
			text.setText(mMathTexts[position]);
			break;
		default:
			break;
		}
		return view;
	}

}
