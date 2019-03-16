package com.example.apiex;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebViewClient;

public class WebView extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_web_view );

        class MyWebViewClient extends WebViewClient {
            @Override
            public boolean shouldOverrideUrlLoading(android.webkit.WebView view, String url) {
                if (Uri.parse(url).getHost().equals(getIntent().getStringExtra("data")))
                    return false;
                else
                    return super.shouldOverrideUrlLoading(view, url);
            }
        }

        android.webkit.WebView webView = (android.webkit.WebView) findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(getIntent().getStringExtra("data"));
        webView.setWebViewClient(new MyWebViewClient());
    }
}
