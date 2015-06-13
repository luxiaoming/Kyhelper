package com.ecjtu.kyhelper.view;

import com.ecjtu.kyhelper.R;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.TabActivity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

/**
 * TODO : 应用主界面
 * 
 * @author ECJTU IsayesHu
 * @date 2015年4月3日
 */
@SuppressWarnings("deprecation")
public class BaseActivity extends TabActivity {

	private TabHost tabHost;
	private LayoutInflater layoutInflater;

	String[] mTitle = new String[] { "研讯", "分类", "交流", "更多" };
	int[] mIcon = new int[] { R.drawable.ic_tabkynews, R.drawable.ic_tabmenu,
			R.drawable.ic_tabtalk, R.drawable.ic_tabmore };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);

		initTabView();

	}

	@SuppressLint("InflateParams")
	public View getTabItemView(int i) {
		// TODO Auto-generated method stub
		View view = layoutInflater.inflate(R.layout.tab_widget_item, null);
		ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
		imageView.setImageResource(mIcon[i]);
		TextView textView = (TextView) view.findViewById(R.id.textview);
		textView.setText(mTitle[i]);
		return view;
	}

	public void initTabView() {

		/**
		 * tabHost.newTabSpec("artist")创建一个标签项，其中artist为它的标签标识符，
		 * 相当于jsp页面标签的name属性
		 * setIndicator("艺术标签",resources.getDrawable(R.drawable
		 * .ic_tab))设置标签显示文本以及标签上的图标（该图标并不是一个图片，而是一个xml文件哦）
		 * setContent(intent)为当前标签指定一个意图 tabHost.addTab(spec); 将标签项添加到标签中
		 */

		tabHost = getTabHost();
		layoutInflater = LayoutInflater.from(this);
		TabHost.TabSpec spec;

		Intent intent1 = new Intent(this, HomeActivity.class);
		spec = tabHost.newTabSpec(mTitle[0]).setIndicator(getTabItemView(0))
				.setContent(intent1);
		tabHost.addTab(spec);

		Intent intent2 = new Intent(this, ClassifyActivity.class);
		spec = tabHost.newTabSpec(mTitle[1]).setIndicator(getTabItemView(1))
				.setContent(intent2);
		tabHost.addTab(spec);

		Intent intent3 = new Intent(this, CommunionWsqActivity.class);
		spec = tabHost.newTabSpec(mTitle[2]).setIndicator(getTabItemView(2))
				.setContent(intent3);
		tabHost.addTab(spec);

		Intent intent4 = new Intent(this, MoreActivity.class);
		spec = tabHost.newTabSpec(mTitle[3]).setIndicator(getTabItemView(3))
				.setContent(intent4);
		tabHost.addTab(spec);

		tabHost.setCurrentTab(0);
	}

	@Override
	public void onBackPressed() {
		Toast.makeText(this, "确定要退出考研助手么?", Toast.LENGTH_LONG).show();
		// super.onBackPressed();
	}

}
