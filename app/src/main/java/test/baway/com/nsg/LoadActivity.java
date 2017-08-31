package test.baway.com.nsg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * name:周振辉
 * 时间：2017/8/31 9:22
 * 类描述：
 */

public class LoadActivity extends AppCompatActivity {
    @BindView(R.id.textView)
    TextView textView;

    private int i = 3;
    Timer timer = new Timer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_xml);
        ButterKnife.bind(this);
        timer.schedule(task, 1000, 1000);
    }
    TimerTask task = new TimerTask() {
        @Override
        public void run() {

            runOnUiThread(new Runnable() {      // UI thread
                @Override
                public void run() {
                    i--;
                    textView.setText("倒计时："+i+"S");
                    if(i == 0){
                        Intent intent = new Intent(LoadActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }
    };
}
