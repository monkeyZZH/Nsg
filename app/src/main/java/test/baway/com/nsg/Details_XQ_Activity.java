package test.baway.com.nsg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import utils.Constant;

/**
 * name:周振辉
 * 时间：2017/9/5 20:45
 * 类描述：
 */

public class Details_XQ_Activity extends AppCompatActivity {
    @BindView(R.id.details_xq_fanhui)
    ImageView detailsXqFanhui;
    @BindView(R.id.details_webview)
    WebView detailsWebview;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_xq_xml);
        ButterKnife.bind(this);
        //获取url
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        //返回按钮
        detailsXqFanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //展示详情
        detailsWebview.setInitialScale(138);
        detailsWebview.loadUrl(Constant.LINK_MOBILE_SPXQ_WEBVIEW + url);

    }



}
