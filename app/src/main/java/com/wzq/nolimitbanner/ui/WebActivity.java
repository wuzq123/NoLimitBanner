package com.wzq.nolimitbanner.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.wzq.nolimitbanner.R;
import com.wzq.nolimitbanner.bean.Banner;

/**
 * Created by wzq on 17-mip1-22.
 */

public class WebActivity extends AppCompatActivity {

    private WebView webView;

    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);


        webView = (WebView) findViewById(R.id.webView);
        url = getIntent().getStringExtra("url");
        if (url != null) {
            webView.loadUrl(url);
            webView.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    webView.loadUrl(url);
                    return true;
                }
            });
        }
    }
}
