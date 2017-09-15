package test.baway.com.nsg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * name:周振辉
 * 时间：2017/9/15 18:57
 * 类描述：
 */

public class Ewm_Activity extends AppCompatActivity {
    @BindView(R.id.ewm_tv)
    TextView ewmTv;
    @BindView(R.id.ewm_wv)
    WebView ewmWv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ewm_xml);
        ButterKnife.bind(this);
    }
    public void scanCode(View view){
        startActivityForResult(new Intent(this, ScannerActivity.class), 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            ewmTv.setText(data.getStringExtra("text")); // 显示识别到的文字
            ewmWv.loadUrl(data.getStringExtra("text")); // 将识别的内容当作网址加载到WebView
        }
    }
}
