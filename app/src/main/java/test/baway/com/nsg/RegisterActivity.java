package test.baway.com.nsg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import been.Data_dl;
import utils.Constant;

/**
 * name:周振辉
 * 时间：2017/9/10 13:37
 * 类描述：
 */

public class RegisterActivity extends AppCompatActivity {

    private EditText name,paw,paw2,youxiang;
    private Button but;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_xml);
        init();

    }

    public void ZC(View v) {

        String n = name.getText().toString();
        String p = paw.getText().toString();
        String p2 = paw2.getText().toString();
        String y = youxiang.getText().toString();

        OkHttpUtils
                .post()
                .url(Constant.LINK_MOBILE_ZC)
                .addParams("username", n)
                .addParams("password", p)
                .addParams("password_confirm", p2)
                .addParams("email", y)
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
                            Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_LONG).show();
                            finish();

                        }else{
                            Toast.makeText(RegisterActivity.this,data.getDatas().getError(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void init() {
        name = (EditText)findViewById(R.id.name);
        paw = (EditText)findViewById(R.id.paw);
        paw2 = (EditText)findViewById(R.id.paw2);
        youxiang = (EditText)findViewById(R.id.youxiang);
        but = (Button)findViewById(R.id.registr);
    }
}
