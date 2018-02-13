package com.example.nguyen.player;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * Created by nguyen on 13/02/2018.
 */

public class WebViewPlayer extends WebView {

    private String mUrl = "";

    public WebViewPlayer(Context context) {
        super(context);
    }

    public WebViewPlayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WebViewPlayer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
