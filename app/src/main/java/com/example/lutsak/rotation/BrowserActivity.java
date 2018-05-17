package com.example.lutsak.rotation;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class BrowserActivity extends AppCompatActivity {

    WebView webView;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.layout_browser);

        webView = findViewById(R.id.webView);
        Uri data = getIntent().getData();
        if (saveInstanceState == null) {
            webView.loadUrl(data.toString());
        }
        webView.setWebViewClient(new WebClient());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        webView.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        webView.restoreState(savedInstanceState);
    }

    public class WebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            super.shouldOverrideUrlLoading(view, url);
            webView.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
        }
    }
}
