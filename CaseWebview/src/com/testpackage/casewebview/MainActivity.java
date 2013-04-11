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
		webSettings.setSavePassword(false); // ȡ����ס������ʾ
		webSettings.setSaveFormData(false);
		webSettings.setJavaScriptEnabled(true);
		webSettings.setJavaScriptCanOpenWindowsAutomatically(true); // ͨ��js���µĴ���
		webView.setWebChromeClient(new MyWebChromeClient()); // ������չ

		webView.addJavascriptInterface(new JavaScriptInterface(), "GlobalCase"); // ���js�ӿ� GlobalCase����window����

		// mWebView.loadUrl( javascript:fillContent()");//ע�������fillContent()��������htmlʵ�ֵ�js����

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
	 * ֱ����ҳ��ʾ
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
	 * ֱ������ͼƬ��ʾ
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
	 * ������ʾ
	 */
	private void localHtmlZh() {

		try {

			String data = "���Ժ��� ���ĵ�Html����";

			// utf-8���봦��(��SDK1.5ģ��������ʵ�豸�϶�����������,SDK1.6����������ʾ)

			// webView.loadData(data, mimeType, encoding);

			// �����ݽ��б��봦��(SDK1.5�汾)

			webView.loadData(URLEncoder.encode(data, encoding), mimeType,

			encoding);

		}
		catch (Exception ex) {

			ex.printStackTrace();

		}

	}

	/**
	 * 
	 * ������ʾ(�ո�Ĵ���)
	 */
	private void localHtmlBlankSpace() {

		try {

			String data = " ���Ժ��пո��Html���� ";

			// ���Կո�������

			webView.loadData(URLEncoder.encode(data, encoding), mimeType,

			encoding);

			// webView.loadData(data, mimeType, encoding);

			// �Կո�������(��SDK1.5�汾��)

			webView.loadData(URLEncoder.encode(data, encoding).replaceAll("\\+", " "), mimeType, encoding);

		}
		catch (Exception ex) {

			ex.printStackTrace();

		}

	}

	/**
	 * 
	 * ��ʾ����ͼƬ�ļ�
	 */
	private void localImage() {

		try {

			// �����ļ�����(����ļ������пո���Ҫ��+�����)

			webView.loadUrl("file:///android_asset/www/img/ic_launcher.png");

		}
		catch (Exception ex) {

			ex.printStackTrace();

		}

	}

	/**
	 * 
	 * ��ʾ������ҳ�ļ�
	 */
	private void localHtml() {

		try {

			// �����ļ�����(����ļ������пո���Ҫ��+�����)

			webView.loadUrl("file:///android_asset/www/index.html");

		}
		catch (Exception ex) {

			ex.printStackTrace();

		}

	}

	/**
	 * 
	 * ��ʾ����ͼƬ�����ֻ�ϵ�Html����
	 */
	private void localHtmlImage() {

		try {

			String data = "���Ա���ͼƬ�����ֻ����ʾ,����APK���ͼƬ";

			// SDK1.5�����ļ�����(������ʾͼƬ)

			// webView.loadData(URLEncoder.encode(data, encoding), mimeType,

			// encoding);

			// SDK1.6���Ժ�汾

			// webView.loadData(data, mimeType, encoding);

			// �����ļ�����(����ʾͼƬ)

			webView.loadDataWithBaseURL("about:blank", data, mimeType,

			encoding, "");

		}
		catch (Exception ex) {

			ex.printStackTrace();

		}

	}

}