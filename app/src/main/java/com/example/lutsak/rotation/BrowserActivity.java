package com.example.lutsak.rotation;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class BrowserActivity extends AppCompatActivity {

    private WebTask mWebTask;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.layout_browser);

        mWebTask = new WebTask();
        mWebTask.execute(getIntent().getData());
    }

    private class WebTask extends AsyncTask<Uri, Void, String>{
        private WebView mWebView = findViewById(R.id.webView);

        @Override
        protected String doInBackground(Uri... uri) {
            return uri[0].toString();
        }

        @Override
        protected void onPostExecute(String string) {
            mWebView.loadUrl(string);
        }
    }
}
