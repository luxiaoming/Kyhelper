package com.ecjtu.kyhelper.webview;

import com.ecjtu.kyhelper.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * TODO : 新闻资讯
 * 
 * @author ECJTU IsayesHu
 * @date 2015年3月31日
 */
public class WebviewXinWenZiXun extends Activity {
	private String url = "http://blog.nicerdata.com/新闻资讯.html";
	private WebView webView;
	private ProgressDialog dialog;

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
				// 返回值是true的时候控制网页在webView中去打开，如果
				// 为false就调用系统 浏览器
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
		webView.setWebChromeClient(new WebChromeClient() {
			@Override
			public void onProgressChanged(WebView view, int newProgress) {

				// newProgress 1-100之间的整数
				if (newProgress == 100) {
					// 网页加载完毕
					closeDialog();
				} else {
					// 网页正在加载,打开ProgressDialog
					openDialog(newProgress);
				}
				super.onProgressChanged(view, newProgress);
			}

			private void closeDialog() {
				if (dialog != null && dialog.isShowing()) {
					dialog.dismiss();
					dialog = null;
				}
			}

			private void openDialog(int newProgress) {
				if (dialog == null) {
					dialog = new ProgressDialog(WebviewXinWenZiXun.this);
					dialog.setTitle("正在加载...");
					dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
					dialog.setProgress(newProgress);
					dialog.show();
				} else {
					dialog.setProgress(newProgress);
				}
			}
		});
	}

	// 改写物理按键返回的逻辑
	// @Override
	// public boolean onKeyDown(int keyCode, KeyEvent event) {
	//
	// if (keyCode == KeyEvent.KEYCODE_BACK) {
	// Toast.makeText(this, webView.getUrl(), Toast.LENGTH_SHORT).show();
	//
	// if (webView.canGoBack()) {
	// // 返回上一页面
	// webView.goBack();
	// return true;
	// } else {
	// System.exit(0);
	// }
	// }
	// return super.onKeyDown(keyCode, event);
	// }
}
