package test.baway.com.nsg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * name:周振辉
 * 时间：2017/9/15 11:07
 * 类描述：
 */

public class ScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mZXingScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mZXingScannerView = new ZXingScannerView(this); // 将ZXingScannerView作为布局
        setContentView(mZXingScannerView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mZXingScannerView.setResultHandler(this); // 设置处理结果回调
        mZXingScannerView.startCamera(); // 打开摄像头
    }

    @Override
    protected void onPause() {
        super.onPause();
        mZXingScannerView.stopCamera(); // 活动失去焦点的时候关闭摄像头
    }
    @Override
    public void handleResult(Result result) { // 实现回调接口，将数据回传并结束活动
        Intent data = new Intent();
        data.putExtra("text", result.getText());
        setResult(RESULT_OK, data);
        finish();
    }
}
