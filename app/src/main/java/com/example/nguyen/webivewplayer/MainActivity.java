package com.example.nguyen.webivewplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.nguyen.player.WebViewPlayer;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private String data = "<iframe src=\"@URL@\" scrolling=\"no\" frameborder=\"0\" width=\"@WIDTH@\" height=\"@HEIGHT@\" allowfullscreen=\"true\" webkitallowfullscreen=\"true\" mozallowfullscreen=\"true\"></iframe>";
    private String mUrl = "https://openload.co/embed/lxpA7Kzfkvg/Purpose_of_Alumni_%282018%29_KR_720p.mp4";
    private int mWidth = 350;
    private int mHeight = 215;

    WebViewPlayer webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create webview
        webView = findViewById(R.id.wv);
        webView.getSettings().setJavaScriptEnabled(true);


        // setting data to play
        settingData(mUrl, mWidth, mHeight);
    }

    private void settingData(String url, int width, int height) {
        data = data.replaceAll("@URL", url)
                .replaceAll("@WIDTH", String.valueOf(width))
                .replaceAll("@HEIGHT", String.valueOf(height));

        webView.loadDataWithBaseURL("", data, "text/html", "UTF-8", "");

        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.d(TAG, url);
                super.shouldOverrideUrlLoading(view, url);
                return true;
            }
        });
    }
}
