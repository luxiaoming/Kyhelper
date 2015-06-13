package com.ecjtu.kyhelper.view;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

import com.ecjtu.kyhelper.R;
import com.ecjtu.kyhelper.adapter.ClassifyListAdapter;
import com.ecjtu.kyhelper.model.Subject;

/**
 * TODO : 某一分类下的所有页面
 * 
 * @author ECJTU IsayesHu
 * @date 2015年4月2日
 */
public class ClassifyAllActivity extends Activity implements
		OnItemClickListener {

	private static final String TAG = "ClassifyAllActivity"; // need it

	private TextView tvTitle;
	private ListView lvSubjectAllList;
	private ClassifyListAdapter classifyListAdapter;

	// 记录从ClassifyActivity中传过来的当前点击项的类型
	private String type;
	private List<Subject> subjectList = new ArrayList<Subject>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_classify_all);

		// 得到从上级Activity中传入的Type数据
		type = getIntent().getStringExtra("type");

		// 获取科目数据
		getSubjectsData();

		initView();

	}

	public void initView() {
		// 设置标题
		tvTitle = (TextView) findViewById(R.id.tv_title);
		tvTitle.setText(getIntent().getStringExtra("title"));

		lvSubjectAllList = (ListView) findViewById(R.id.lv_subject_all);
		classifyListAdapter = new ClassifyListAdapter(this,
				(ArrayList<Subject>) subjectList, type);
		lvSubjectAllList.setAdapter(classifyListAdapter);
		lvSubjectAllList.setOnItemClickListener(this);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// toast("点击了： " + position);
		// 将当前点击的Subject对象传递给下一个Activity
		Intent toSubjectItem = new Intent(ClassifyAllActivity.this,
				SubjectItemActivity.class);
		Bundle bundle = new Bundle();
		bundle.putSerializable("subject", subjectList.get(position));
		bundle.putString("subjectID", subjectList.get(position).getObjectId()); // ID需要单独传递,否则获取到的是null
		Log.i(TAG, ">>发出>>" + "subjectID: "
				+ subjectList.get(position).getObjectId() + " subjectName: "
				+ subjectList.get(position).getName());
		toSubjectItem.putExtras(bundle);
		startActivity(toSubjectItem);
	}

	private void getSubjectsData() {
		BmobQuery<Subject> query = new BmobQuery<Subject>();
		query.order("-updatedAt");
		Subject subject = new Subject();
		subject.setType(type);
		query.addWhereEqualTo("type", subject.getType()); // 查询当前类型的知识点
		query.findObjects(this, new FindListener<Subject>() {

			@Override
			public void onSuccess(List<Subject> object) {
				// toast("查询成功. 共计" + object.size());
				if (object.size() == 0)
					toast("资料还没找齐呢, 耐心等待吧");
				subjectList = object;
				// 通知Adapter数据更新
				classifyListAdapter.refresh((ArrayList<Subject>) subjectList);
				classifyListAdapter.notifyDataSetChanged();

			}

			@Override
			public void onError(String msg) {
				toast("查询失败:" + msg);
			}

		});
	}

	private void toast(String toast) {
		Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
	};

}
