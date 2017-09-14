package test.baway.com.nsg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * name:周振辉
 * 时间：2017/9/10 13:21
 * 类描述：
 */

public class LogonActivity extends AppCompatActivity{
    private TextView zhuce;
    private TextView overlook;
    private EditText name,paw;
    private Button but;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loaon_xml);
        DL();
       dz();
        init();
    }

    private void DL() {

    }

    private void init() {
        zhuce = (TextView)findViewById(R.id.enroll);
        overlook = (TextView)findViewById(R.id.overlook);
        name = (EditText)findViewById(R.id.logon_name);
        paw = (EditText)findViewById(R.id.logon_paw);
        but = (Button)findViewById(R.id.login_logon);
    }

    private void dz() {
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogonActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        overlook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogonActivity.this,ZHMMActivity.class);
                startActivity(intent);
            }
        });
    }
}
