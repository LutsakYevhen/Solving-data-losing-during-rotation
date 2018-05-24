package com.example.lutsak.rotation;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class BrowserActivity extends AppCompatActivity {

    private static WebView mWebView;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.layout_browser);

        mWebView = findViewById(R.id.webView);
        Uri data = getIntent().getData();
        if (saveInstanceState == null) {
            mWebView.loadUrl(data.toString());
        }
        mWebView.setWebViewClient(new WebClient());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mWebView.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mWebView.restoreState(savedInstanceState);
    }

    private static class WebClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            super.shouldOverrideUrlLoading(view, url);
            mWebView.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
        }
    }
}
