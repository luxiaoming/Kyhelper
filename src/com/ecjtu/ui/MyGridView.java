package com.ecjtu.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * TODO : 详情页--分类网格视图
 * 
 * @author ECJTU IsayesHu
 * @date 2015年4月3日
 */
public class MyGridView extends GridView {

	public MyGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MyGridView(Context context) {
		super(context);
	}

	public MyGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	/**
	 * onMeasure方法是测量view和它的内容，决定measured width和measured height的，这个方法由
	 * measure(int, int)方法唤起，子类可以覆写onMeasure来提供更加准确和有效的测量。
	 */
	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}

}
/**
 * ListView或者GridView嵌套在ScrollView中：嵌套使用时，会出现ListView/GridView有自己的滚动条，
 * 而ScrollView又有自己的滚动条。解决此问题的核心是：重写ListView/GridView的OnMesure方法。
 */
