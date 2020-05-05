package com.example.th103;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView web;
    EditText osoite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);

    }

    public void getWWW(View v){
        osoite = findViewById(R.id.editText);
        String page = osoite.getText().toString();
        if (page.equals("index.html"))   {
            web.loadUrl("file:///android_asset/index.html");
        }else {
            web.loadUrl("http://" + page);
        }
    }

    public void refresh(View v){
        web.reload();
    }

    public void helloWorld(View v){
        web.evaluateJavascript("javascript:shoutOut()", null);
    }

    public void moiMaailma(View v) {
        web.evaluateJavascript("javascript:initialize()", null);
    }
}