package test.baway.com.nsg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import been.Data_dl;
import utils.Constant;


/**
 * name:周振辉
 * 时间：2017/9/10 13:21
 * 类描述：
 */

public class LogonActivity extends AppCompatActivity {
    private TextView zhuce;
    private TextView overlook;
    private EditText name;
    private EditText paw;
    private Button but;
    private TextView qq;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loaon_xml);





        init();
        dz();
        QQ();
    }

    private void QQ() {

    }

    public void DL(View v) {

        String n = name.getText().toString();
        String p = paw.getText().toString();

        OkHttpUtils
                .post()
                .url(Constant.LINK_MOBILE_DL)
                .addParams("username", n)
                .addParams("password", p)
                .addParams("client", "android")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(final String response) {
                        Data_dl data = new Gson().fromJson(response,Data_dl.class);
                        if(data.getCode() == 200){
                            Toast.makeText(LogonActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
                            Intent mIntent = new Intent();
                            mIntent.putExtra("name", data.getDatas().getUsername());
                            // 设置结果，并进行传送
                           LogonActivity.this.setResult(0, mIntent);
                            finish();

                        }else{
                            Toast.makeText(LogonActivity.this,"用户名或密码错误",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }





    private void init() {
        zhuce = (TextView)findViewById(R.id.logon_enroll);
        overlook = (TextView)findViewById(R.id.logon_overlook);
        name = (EditText)findViewById(R.id.logon_name);
        paw = (EditText)findViewById(R.id.logon_paw);
        //but = (Button)findViewById(R.id.login_logon);
        qq = (TextView)findViewById(R.id.logon_QQ);

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
