package test.baway.com.nsg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * name:周振辉
 * 时间：2017/9/5 20:25
 * 类描述：
 */

public class Details_TU_Activity extends AppCompatActivity {
    @BindView(R.id.details_tu_fanhui)
    ImageView detailsTuFanhui;
    @BindView(R.id.details_tu_tu)
    ImageView detailsTuTu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_tu_xml);
        ButterKnife.bind(this);
        //设置图片
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        Glide.with(Details_TU_Activity.this).load(url).into(detailsTuTu);
        //返回按钮
        detailsTuFanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
