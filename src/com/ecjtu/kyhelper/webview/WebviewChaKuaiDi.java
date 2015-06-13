package com.ecjtu.kyhelper.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.ecjtu.kyhelper.R;

/**
 * TODO : 查快递--
 * 
 * @author ECJTU IsayesHu
 * @date 2015年3月31日
 */
@SuppressLint("SetJavaScriptEnabled")
public class WebviewChaKuaiDi extends Activity {

	private String url = "http://m.kuaidi100.com/all/";
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webviews);
		init();
	}

	private void init() {
		webView = (WebView) findViewById(R.id.id_for_webview);
		webView.loadUrl(url);
		// 使网页可以在webView中直接打开
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// 返回值是true的时候控制网页在webView中去打开，如果为false就调用系统浏览器
				view.loadUrl(url);
				return true;
			}

		});
		// 启用支持javaScript
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		// WebView加载页面优先使用缓存加载
		settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

	}

	// 改写物理按键返回的逻辑
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			// Toast.makeText(this, webView.getUrl(),
			// Toast.LENGTH_SHORT).show();

			if (webView.canGoBack()) {
				// 返回上一页面
				webView.goBack();
				return true;
			} else {
				System.exit(0);
			}
		}
		return super.onKeyDown(keyCode, event);
	}
}
