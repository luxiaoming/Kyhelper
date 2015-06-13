package com.ecjtu.kyhelper.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.ecjtu.kyhelper.R;

/**
 * TODO : CommunionWsqActivity--微社区交流（花椒考研必胜）
 * 
 * @author ECJTU IsayesHu
 * @date 2015年3月29日
 */

@SuppressLint("SetJavaScriptEnabled")
public class CommunionWsqActivity extends Activity {

	private WebView wsqWebView;
	private static final String URL_WSQ = "http://m.wsq.qq.com/264442267";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wsq);

		wsqWebView = (WebView) findViewById(R.id.wv_wsq);
		// 设置使用够执行JS脚本
		wsqWebView.getSettings().setJavaScriptEnabled(true);
		// 设置使支持缩放
		wsqWebView.getSettings().setBuiltInZoomControls(true);
		wsqWebView.getSettings().setDefaultFontSize(5);
		wsqWebView.loadUrl(URL_WSQ);
		wsqWebView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// 使用当前 WebView 处理跳转
				view.loadUrl(url);
				// true 表示此事件在此处被处理，不需要再广播
				return true;
			}

			// 转向错误时的处理
			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				Toast.makeText(CommunionWsqActivity.this,
						"Oh no! " + description, Toast.LENGTH_SHORT).show();
			}
		});
	}

}
