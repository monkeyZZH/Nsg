package test.baway.com.nsg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import adapter.watchAdapter;
import been.Data_watch;
import butterknife.BindView;
import butterknife.ButterKnife;
import utils.Constant;
import utils.HttpUtil;
import utils.OnNetListener;

/**
 * name:周振辉
 * 时间：2017/9/1 14:55
 * 类描述：
 */

public class WatchActivity extends AppCompatActivity {

    @BindView(R.id.FH)
    ImageView FH;
    @BindView(R.id.SS)
    ImageView SS;
    @BindView(R.id.watch_listview)
    ListView listview;

    private List<Data_watch.DatasBean.GoodsListBean> list;
    private watchAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watch_xml);
        ButterKnife.bind(this);

        HttpUtil.getHttpUtil().get(WatchActivity.this, Constant.LINK_MOBILE_SPLB, new OnNetListener() {
            @Override
            public void onSuccess(String str) {
                Data_watch data = new Gson().fromJson(str, Data_watch.class);
                list = new ArrayList<Data_watch.DatasBean.GoodsListBean>();
                list.addAll(data.getDatas().getGoods_list());
                adapter = new watchAdapter(WatchActivity.this, list);
                listview.setAdapter(adapter);
            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(WatchActivity.this,DetailsActivity.class);
                intent.putExtra("goods_id",list.get(position).getGoods_id());
                startActivity(intent);
            }
        });


    }

    public void FH(View v) {
        finish();
    }
}
