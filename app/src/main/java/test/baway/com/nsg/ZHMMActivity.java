package test.baway.com.nsg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * name:周振辉
 * 时间：2017/9/10 14:28
 * 类描述：
 */

public class ZHMMActivity extends AppCompatActivity{
    private WebView webView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhmm_xml);
        webView = (WebView)findViewById(R.id.zhmm_webview);

    }
}
