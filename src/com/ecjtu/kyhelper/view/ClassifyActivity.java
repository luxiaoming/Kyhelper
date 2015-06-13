package com.ecjtu.kyhelper.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.ecjtu.kyhelper.R;
import com.ecjtu.kyhelper.adapter.GridAdapter;
import com.ecjtu.ui.MyGridView;

/**
 * TODO : ClassifyActivity.java--分类主界面
 * 
 * @author ECJTU IsayesHu
 * @date 2015年3月29日
 */
public class ClassifyActivity extends Activity implements OnItemClickListener {

	private MyGridView kdMathClass; // 数学核心考点
	private MyGridView kdEnglishClass; // 英语核心考点
	private MyGridView kdPolityClass; // 政治核心考点
	private MyGridView kdFuXi; // 考研复习经验

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_classify);

		initView();
	}

	/**
	 * 初始化组件并适配数据
	 */
	public void initView() {
		kdEnglishClass = (MyGridView) findViewById(R.id.gv_english_class);
		kdPolityClass = (MyGridView) findViewById(R.id.gv_polity_class);
		kdFuXi = (MyGridView) findViewById(R.id.gv_fuxi_class);
		kdMathClass = (MyGridView) findViewById(R.id.gv_math_class);

		kdEnglishClass.setAdapter(new GridAdapter(this, 0));
		kdEnglishClass.setOnItemClickListener(this);

		kdPolityClass.setAdapter(new GridAdapter(this, 1));
		kdPolityClass.setOnItemClickListener(this);

		kdFuXi.setAdapter(new GridAdapter(this, 2));
		kdFuXi.setOnItemClickListener(this);

		kdMathClass.setAdapter(new GridAdapter(this, 3));
		kdMathClass.setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Log.i("GridView点击了： ", "position");
		// toast("点击了： " + position);
		switch (parent.getId()) {

		// 点击数学核心考点中的子项
		case R.id.gv_math_class:
			toClassifyAllActivity(GridAdapter.mMathTexts[position], "1"
					+ (position + 1));
			break;
		// 点击英语核心考点中的子项
		case R.id.gv_english_class:
			toClassifyAllActivity(GridAdapter.kyEngTexts[position], "2"
					+ (position + 1));
			break;
		// 点击政治核心考点的子项
		case R.id.gv_polity_class:
			toClassifyAllActivity(GridAdapter.mPolityTexts[position], "3"
					+ (position + 1));
			break;
		// 点击考研复习经验的子项
		case R.id.gv_fuxi_class:
			toClassifyAllActivity(GridAdapter.mExperienceTexts[position], "4"
					+ (position + 1));
			break;
		default:
			break;
		}

	}

	@SuppressWarnings("unused")
	private void toast(String toast) {
		Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
	};

	private void toClassifyAllActivity(String title, String type) {
		Intent toClassifyAll = new Intent(ClassifyActivity.this,
				ClassifyAllActivity.class);
		toClassifyAll.putExtra("title", title);
		// 当前点击的项的父分类
		toClassifyAll.putExtra("type", type);
		startActivity(toClassifyAll);
	}

}
