package com.ecjtu.kyhelper.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ecjtu.kyhelper.R;

/**
 * TODO : 复试指南
 * 
 * @author ECJTU IsayesHu
 * @date 2015年4月2日
 */

public class WebviewFuShiZhiNan extends Activity {

	private String url = "http://m.kaoyan.com/www/fushi/jingyan/";
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webviews);
		init();
	}

	@SuppressLint("SetJavaScriptEnabled")
	private void init() {
		webView = (WebView) findViewById(R.id.id_for_webview);
		webView.getSettings().setBuiltInZoomControls(true);
		webView.getSettings().setDefaultFontSize(5);
		webView.loadUrl(url);
		// 使网页可以在webView中直接打开
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// 返回值是true的时候控制网页在webView中去打开，如果 为false就调用系统浏览器
				view.loadUrl(url);
				return true;
			}
			// WebViewClient帮助WebView去处理一些页面控制和请求通知

		});
		// 启用支持javaScript
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);
		// WebView加载页面优先使用缓存加载
		settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

	}
}
