package com.ecjtu.kyhelper.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.ecjtu.kyhelper.R;
import com.ecjtu.kyhelper.webview.WebviewAppriseScore;
import com.ecjtu.kyhelper.webview.WebviewChaKuaiDi;
import com.ecjtu.kyhelper.webview.WebviewFenShuXian;
import com.ecjtu.kyhelper.webview.WebviewFuShiZhiNan;
import com.ecjtu.kyhelper.webview.WebviewJobNews;
import com.ecjtu.kyhelper.webview.WebviewKaoYanLunTan;
import com.ecjtu.kyhelper.webview.WebviewPlayAGame;
import com.ecjtu.kyhelper.webview.WebviewPlusPower;
import com.ecjtu.kyhelper.webview.WebviewQiuMaXing;
import com.ecjtu.kyhelper.webview.WebviewXinWenZiXun;
import com.ecjtu.kyhelper.webview.WebviewYuanXiaoZhuanYe;
import com.ecjtu.kyhelper.webview.WebviewZhangZiShi;
import com.ecjtu.kyhelper.webview.WebviewZiXiShi;

/**
 * 更多功能界面
 * 
 * @author ECJTU IsayesHu
 *
 */
public class MoreActivity extends Activity implements OnClickListener {

	private Button btnAbout;
	private Button btnJoin;
	private Button btnZZS;// 涨姿势
	private Button btnZNL;// 正能量
	private Button btnCKD;// 查快递
	private Button btnBTJ;// 书籍推荐
	private Button btnFSX;// 分数线
	private Button btnFSZN;// 复试指南
	private Button btnJYXX;// 就业消息
	private Button btnKYLT;// 考研论坛
	private Button btnPlayGm;// 玩个游戏放松下
	private Button btnQMX;// 求骂醒
	private Button btnXWZX;// 新闻资讯
	private Button btnYXZY;// 院校专业
	private Button btnZXS;// 花椒自习室安排
	private Button btnZXGF;// 在线估分

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabmore);
		initView();
	}

	public void initView() {

		btnAbout = (Button) findViewById(R.id.id_btn_About);
		btnJoin = (Button) findViewById(R.id.id_btn_ShareMe);
		btnZZS = (Button) findViewById(R.id.id_btn_ZhangZiShi);
		btnZNL = (Button) findViewById(R.id.id_btn_plusPower);
		btnBTJ = (Button) findViewById(R.id.id_btn_BookTuiJian);
		btnCKD = (Button) findViewById(R.id.id_btn_ChaKuaiDi);
		btnFSX = (Button) findViewById(R.id.id_btn_FenShuXian);
		btnFSZN = (Button) findViewById(R.id.id_btn_FuShiZhiNan);
		btnJYXX = (Button) findViewById(R.id.id_btn_JobNews);
		btnKYLT = (Button) findViewById(R.id.id_btn_KaoYanLunTan);
		btnPlayGm = (Button) findViewById(R.id.id_btn_PlayAGame);
		btnQMX = (Button) findViewById(R.id.id_btn_QiuMaXing);
		btnXWZX = (Button) findViewById(R.id.id_btn_XinWenZiXun);
		btnYXZY = (Button) findViewById(R.id.id_btn_YuanXiaoZhuanYe);
		btnZXS = (Button) findViewById(R.id.id_btn_ZiXiShi);
		btnZXGF = (Button) findViewById(R.id.id_btn_ZaiXianGuFen);

		btnAbout.setOnClickListener(this);
		btnJoin.setOnClickListener(this);
		btnZZS.setOnClickListener(this);
		btnZNL.setOnClickListener(this);
		btnCKD.setOnClickListener(this);
		btnBTJ.setOnClickListener(this);
		btnFSX.setOnClickListener(this);
		btnFSZN.setOnClickListener(this);
		btnJYXX.setOnClickListener(this);
		btnKYLT.setOnClickListener(this);
		btnPlayGm.setOnClickListener(this);
		btnQMX.setOnClickListener(this);
		btnXWZX.setOnClickListener(this);
		btnYXZY.setOnClickListener(this);
		btnZXS.setOnClickListener(this);
		btnZXGF.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.id_btn_ShareMe:
			Intent toShare = new Intent(Intent.ACTION_SEND);
			toShare.setType("text/plain");
			toShare.putExtra(Intent.EXTRA_SUBJECT, "分享");
			toShare.putExtra(Intent.EXTRA_TEXT, "花椒考研助手" + "\n"
					+ "测试版上线了，考研的花椒们赶紧下载体验吧" + "http://kyhelper.bmob.cn");
			startActivity(Intent.createChooser(toShare, "分享到"));
			break;
		case R.id.id_btn_ZaiXianGuFen:
			Intent toZaiXianGuFen = new Intent(MoreActivity.this,
					WebviewAppriseScore.class);
			startActivity(toZaiXianGuFen);
			break;
		case R.id.id_btn_ChaKuaiDi:
			Intent toChaKuaiDi = new Intent(MoreActivity.this,
					WebviewChaKuaiDi.class);
			startActivity(toChaKuaiDi);
			break;
		case R.id.id_btn_FenShuXian:
			Intent toFenShuXian = new Intent(MoreActivity.this,
					WebviewFenShuXian.class);
			startActivity(toFenShuXian);
			break;
		case R.id.id_btn_FuShiZhiNan:
			Intent toFuShiZhiNan = new Intent(MoreActivity.this,
					WebviewFuShiZhiNan.class);
			startActivity(toFuShiZhiNan);
			break;
		case R.id.id_btn_JobNews:
			Intent toJobNews = new Intent(MoreActivity.this,
					WebviewJobNews.class);
			startActivity(toJobNews);
			break;
		case R.id.id_btn_KaoYanLunTan:
			Intent toKaoYanLunTan = new Intent(MoreActivity.this,
					WebviewKaoYanLunTan.class);
			startActivity(toKaoYanLunTan);
			break;
		case R.id.id_btn_PlayAGame:
			Intent toPlayAGame = new Intent(MoreActivity.this,
					WebviewPlayAGame.class);
			startActivity(toPlayAGame);
			break;
		case R.id.id_btn_plusPower:
			Intent toplusPower = new Intent(MoreActivity.this,
					WebviewPlusPower.class);
			startActivity(toplusPower);
			break;
		case R.id.id_btn_QiuMaXing:
			Intent toQiuMaXing = new Intent(MoreActivity.this,
					WebviewQiuMaXing.class);
			startActivity(toQiuMaXing);
			break;
		case R.id.id_btn_XinWenZiXun:
			Intent toXinWenZiXun = new Intent(MoreActivity.this,
					WebviewXinWenZiXun.class);
			startActivity(toXinWenZiXun);
			break;
		case R.id.id_btn_YuanXiaoZhuanYe:
			Intent toYuanXiaoZhuanYe = new Intent(MoreActivity.this,
					WebviewYuanXiaoZhuanYe.class);
			startActivity(toYuanXiaoZhuanYe);
			break;
		case R.id.id_btn_ZhangZiShi:
			Intent toZhangZiShi = new Intent(MoreActivity.this,
					WebviewZhangZiShi.class);
			startActivity(toZhangZiShi);
			break;
		case R.id.id_btn_ZiXiShi:
			Intent toZiXiShi = new Intent(MoreActivity.this,
					WebviewZiXiShi.class);
			startActivity(toZiXiShi);
			break;
		case R.id.id_btn_BookTuiJian:
			Intent toBookTuiJian = new Intent(MoreActivity.this,
					WebviewChaKuaiDi.class);
			startActivity(toBookTuiJian);
			break;

		default:
			Intent toAbout = new Intent(MoreActivity.this, AboutActivity.class);
			startActivity(toAbout);
			break;
		}
	}

}
