package com.ecjtu.kyhelper.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.ecjtu.kyhelper.R;

/**
 * TODO : 玩个游戏放松下
 * 
 * @author ECJTU IsayesHu
 * @date 2015年4月2日
 */

public class WebviewPlayAGame extends Activity {

	private String url = "http://blog.nicerdata.com/resources/ky/";
	private WebView webView;
	private ProgressDialog dialog;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wsq);

		webView = (WebView) findViewById(R.id.wv_wsq);
		// 设置使用够执行JS脚本
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl(url);
		// 使网页可以在webView中直接打开
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// 返回值是true的时候控制网页在webView中去打开，如果为false就调用系统浏览器
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
					dialog = new ProgressDialog(WebviewPlayAGame.this);
					dialog.setTitle("玩命加载中...");
					dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
					dialog.setProgress(newProgress);
					dialog.show();
				} else {
					dialog.setProgress(newProgress);
				}
			}
		});
	}
}
