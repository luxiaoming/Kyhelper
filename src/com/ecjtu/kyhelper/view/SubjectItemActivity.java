package com.ecjtu.kyhelper.view;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ecjtu.kyhelper.R;
import com.ecjtu.kyhelper.adapter.ViewPagerAdapter;
import com.ecjtu.kyhelper.model.Subject;
import com.ecjtu.ui.ViewPagerCompat;

@SuppressLint({ "InflateParams", "SimpleDateFormat" })
public class SubjectItemActivity extends Activity implements OnClickListener {

	private static final String TAG = "ClassifyItemActivity";

	// ViewPager页
	private View view2;
	private ViewPagerCompat viewPager; // viewpager
	private ViewPagerAdapter subjectViewPagerAdapter;
	private PagerTabStrip pagerTabStrip; // 一个viewpager的指示器，效果就是一个横的粗的下划线
	private List<View> viewList; // 把需要滑动的页卡添加到这个list中
	private List<String> titleList; // viewpager的标题

	// 控件
	private TextView tvSubjectName;
	private TextView tvSubjectInfo;
	private TextView tvSubjectLoc;
	private Button btnCommit;
	private EditText etCommit;
	private LinearLayout llCommitParent; // 评论父线性布局
	@SuppressWarnings("unused")
	private LinearLayout llCommitSon; // 评论子线性布局

	// 从上级页面中传入的数据
	private Subject subject; // 当期选择的Subject
	private String subjectID; // 当前选择的Subject的ID

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_classify_item);

		// 获取到从ClassifyAllActivity中传递过来的Subject对象
		subject = (Subject) getIntent().getSerializableExtra("subject");
		subjectID = getIntent().getStringExtra("subjectID");
		Log.i(TAG, "<<收到<<" + "subjectID: " + subject.getObjectId()
				+ " subjectName: " + subject.getName());
		Log.i(TAG, "<<收到<<" + "subjectID: " + subjectID + " subjectName: "
				+ subject.getName());

		initView();

		// 初始化页面以及适配数据
		initContentView();

	}

	@SuppressLint("InflateParams")
	public void initView() {

		viewPager = (ViewPagerCompat) findViewById(R.id.viewpager);
		pagerTabStrip = (PagerTabStrip) findViewById(R.id.pagertab);
		pagerTabStrip.setTabIndicatorColor(Color.YELLOW);
		pagerTabStrip.setDrawFullUnderline(false);
		pagerTabStrip.setBackgroundColor(Color.WHITE);
		pagerTabStrip.setTextSpacing(50);

		// view1 =
		// LayoutInflater.from(this).inflate(R.layout.viewpager_menu,null);
		view2 = LayoutInflater.from(this).inflate(
				R.layout.viewpager_subjectinfo, null);

		viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
		// viewList.add(view1);
		viewList.add(view2);

		titleList = new ArrayList<String>();// 每个页面的Title数据
		// titleList.add("目录");
		titleList.add("内容");
		subjectViewPagerAdapter = new ViewPagerAdapter(viewList, titleList);

		viewPager.setAdapter(subjectViewPagerAdapter);

	}

	public void initContentView() {

		tvSubjectName = (TextView) view2.findViewById(R.id.tv_subject_title);
		tvSubjectInfo = (TextView) view2
				.findViewById(R.id.tv_subject_introduce);
		tvSubjectLoc = (TextView) view2.findViewById(R.id.tv_subject_location);
		tvSubjectName.setText(subject.getName()); // 设置知识点名
		tvSubjectInfo.setText(subject.getContent()); // 设置知识点内容
		tvSubjectLoc.setText("这里是：" + subject.getSummary()); // 设置知识点目录索引

		btnCommit = (Button) view2.findViewById(R.id.btn_commit);
		btnCommit.setOnClickListener(this);

		// 获取到评论的布局
		etCommit = (EditText) view2.findViewById(R.id.et_commit);
		llCommitParent = (LinearLayout) view2
				.findViewById(R.id.ll_commit_parent_view);
		llCommitSon = (LinearLayout) findViewById(R.id.ll_commit_son_view);

	}

	/**
	 * 添加一条评论
	 * 
	 * @param user
	 * @param content
	 */
	public void insertCommit(String user, String content) {
		View view = LayoutInflater.from(this).inflate(R.layout.commit, null);
		TextView tvUser = (TextView) view.findViewById(R.id.tv_commit_user);
		TextView tvContent = (TextView) view
				.findViewById(R.id.tv_commit_content);
		tvUser.setText(user);
		tvContent.setText(content);
		llCommitParent.addView(view);
		tvUser = null;
		tvContent = null;
	}

	public void toast(String toast) {
		Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_commit:
			if (etCommit.getText().toString().equals("")) {
				toast("评论一句吧");
			} else {
				// SimpleDateFormat formatter = new SimpleDateFormat(
				// "yyyy年MM月dd日  HH:mm:ss ");
				// Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
				// String time = formatter.format(curDate);
				String content = etCommit.getText().toString();
				// + "[" + time
				// + "]";
				insertCommit("我" + ":", content);
				etCommit.setText("");
			}
			break;

		default:
			break;
		}

	}

}
