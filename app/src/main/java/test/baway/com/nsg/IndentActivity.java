package test.baway.com.nsg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import Dao.LoveDao;
import Dao.User;
import adapter.IndentAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import view.Cart_Listview;

/**
 * name:周振辉
 * 时间：2017/9/8 15:03
 * 类描述：
 */

public class IndentActivity extends AppCompatActivity {
    @BindView(R.id.indent_lv)
    Cart_Listview indentLv;
    @BindView(R.id.indent_fanhui)
    ImageView indentFanhui;

    private List<User> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.indent_xml);
        ButterKnife.bind(this);
        list = LoveDao.queryAll();
        IndentAdapter adapter = new IndentAdapter(IndentActivity.this, list);
        indentLv.setAdapter(adapter);
        indentFanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
