package com.example.samplenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class Web extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        final WebView webView=(WebView) findViewById(R.id.web1);
        Intent intent =getIntent();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(intent.getStringExtra("url"));
    }
}