package com.testpackage.casewebview;

import java.net.URLEncoder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.CasePackage.exwebview.R;
import com.testpackage.casewebview.widgets.MyWebChromeClient;

@SuppressLint("SetJavaScriptEnabled")
public class MainActivity extends Activity {

	WebView webView;

	final String mimeType = "text/html";

	final String encoding = "utf-8";

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		webView = (WebView) findViewById(R.id.webView);

		WebSettings webSettings = webView.getSettings();
		webSettings.setSavePassword(false); // 取消记住密码提示
		webSettings.setSaveFormData(false);
		webSettings.setJavaScriptEnabled(true);
		webSettings.setJavaScriptCanOpenWindowsAutomatically(true); // 通过js打开新的窗口
		webView.setWebChromeClient(new MyWebChromeClient()); // 弹窗扩展

		webView.addJavascriptInterface(new JavaScriptInterface(), "GlobalCase"); // 添加js接口 GlobalCase，是window对象

		// mWebView.loadUrl( javascript:fillContent()");//注意这里的fillContent()方法是在html实现的js方法

		// webHtml();

		// webImage();

		// localHtmlZh();

		// localHtmlBlankSpace();

		//
		localHtml();

		// localImage();

		// localHtmlImage();

	}

	final class JavaScriptInterface {
		JavaScriptInterface() {
		}

		public String getBtnTxt() {
			return "SET BACKGROUND";
		}
	}

	/**
	 * 
	 * 直接网页显示
	 */
	private void webHtml() {

		try {

			webView.loadUrl("http://www.phpwind.net/");

		}
		catch (Exception ex) {

			ex.printStackTrace();

		}

	}

	/**
	 * 
	 * 直接网络图片显示
	 */
	private void webImage() {

		try {

			webView

			.loadUrl("http://www.phpwind.net/themes/site/default/images/logo.png");

		}
		catch (Exception ex) {

			ex.printStackTrace();

		}

	}

	/**
	 * 
	 * 中文显示
	 */
	private void localHtmlZh() {

		try {

			String data = "测试含有 中文的Html数据";

			// utf-8编码处理(在SDK1.5模拟器和真实设备上都将出现乱码,SDK1.6上能正常显示)

			// webView.loadData(data, mimeType, encoding);

			// 对数据进行编码处理(SDK1.5版本)

			webView.loadData(URLEncoder.encode(data, encoding), mimeType,

			encoding);

		}
		catch (Exception ex) {

			ex.printStackTrace();

		}

	}

	/**
	 * 
	 * 中文显示(空格的处理)
	 */
	private void localHtmlBlankSpace() {

		try {

			String data = " 测试含有空格的Html数据 ";

			// 不对空格做处理

			webView.loadData(URLEncoder.encode(data, encoding), mimeType,

			encoding);

			// webView.loadData(data, mimeType, encoding);

			// 对空格做处理(在SDK1.5版本中)

			webView.loadData(URLEncoder.encode(data, encoding).replaceAll("\\+", " "), mimeType, encoding);

		}
		catch (Exception ex) {

			ex.printStackTrace();

		}

	}

	/**
	 * 
	 * 显示本地图片文件
	 */
	private void localImage() {

		try {

			// 本地文件处理(如果文件名中有空格需要用+来替代)

			webView.loadUrl("file:///android_asset/www/img/ic_launcher.png");

		}
		catch (Exception ex) {

			ex.printStackTrace();

		}

	}

	/**
	 * 
	 * 显示本地网页文件
	 */
	private void localHtml() {

		try {

			// 本地文件处理(如果文件名中有空格需要用+来替代)

			webView.loadUrl("file:///android_asset/www/index.html");

		}
		catch (Exception ex) {

			ex.printStackTrace();

		}

	}

	/**
	 * 
	 * 显示本地图片和文字混合的Html内容
	 */
	private void localHtmlImage() {

		try {

			String data = "测试本地图片和文字混合显示,这是APK里的图片";

			// SDK1.5本地文件处理(不能显示图片)

			// webView.loadData(URLEncoder.encode(data, encoding), mimeType,

			// encoding);

			// SDK1.6及以后版本

			// webView.loadData(data, mimeType, encoding);

			// 本地文件处理(能显示图片)

			webView.loadDataWithBaseURL("about:blank", data, mimeType,

			encoding, "");

		}
		catch (Exception ex) {

			ex.printStackTrace();

		}

	}

}