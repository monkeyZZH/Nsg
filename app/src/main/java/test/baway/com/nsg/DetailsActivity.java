package test.baway.com.nsg;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import adapter.CartAdapter;
import been.Data_cart;
import butterknife.BindView;
import butterknife.ButterKnife;
import utils.Constant;
import utils.HttpUtil;
import utils.OnNetListener;
import view.Cart_Listview;

/**
 * name:周振辉
 * 时间：2017/9/5 14:12
 * 类描述：
 */

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.cart_fanhui)
    ImageView cartFanhui;
    @BindView(R.id.cart_shoucang)
    ImageView cartShoucang;
    @BindView(R.id.cart_fenxaing)
    ImageView cartFenxaing;
    @BindView(R.id.cart_title)
    LinearLayout cartTitle;
    @BindView(R.id.cart_end)
    LinearLayout cartEnd;
    @BindView(R.id.cart_tu)
    ImageView cartTu;
    @BindView(R.id.cart_name)
    TextView cartName;
    @BindView(R.id.cart_price)
    TextView cartPrice;
    @BindView(R.id.cart_yishou)
    TextView cartYishou;
    @BindView(R.id.cart_jieshao)
    RelativeLayout cartJieshao;
    @BindView(R.id.cart_lv)
    Cart_Listview cartLv;
    @BindView(R.id.scrollview)
    ScrollView scrollview;
    @BindView(R.id.spxq)
    TextView spxq;

    private List<Data_cart.DatasBean.GoodsCommendListBean> list;
    private CartAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_xml);

        ButterKnife.bind(this);
        //从顶部开始
        scrollview.smoothScrollTo(0, 0);

        Intent intent = getIntent();
        String a = intent.getStringExtra("goods_id");
        list(a);
    }

    private void list(String a) {
        HttpUtil.getHttpUtil().get(DetailsActivity.this, Constant.LINK_MOBILE_SPXQ + a, new OnNetListener() {
            @Override
            public void onSuccess(String str) {
                Data_cart data = new Gson().fromJson(str, Data_cart.class);
                list = new ArrayList<Data_cart.DatasBean.GoodsCommendListBean>();
                list.addAll(data.getDatas().getGoods_commend_list());
                adapter = new CartAdapter(DetailsActivity.this, list);
                cartLv.setAdapter(adapter);
                //设置大图
                Glide.with(DetailsActivity.this).load(data.getDatas().getGoods_image()).into(cartTu);
                //设置名字
                cartName.setText(data.getDatas().getGoods_info().getGoods_name());
                //设置价格
                cartPrice.setText(data.getDatas().getGoods_info().getGoods_marketprice() + "");
                //图片详情
                tu(data.getDatas().getGoods_image());
                //商品详情
                xq(data.getDatas().getGoods_info().getGoods_id());
                //listview跳转
                cartLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(DetailsActivity.this,DetailsActivity.class);
                        intent.putExtra("goods_id",list.get(position).getGoods_id());
                        startActivity(intent);
                        finish();
                    }
                });
            }
        });
        cartLv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    scrollview.requestDisallowInterceptTouchEvent(true);
                } else {
                    scrollview.requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
        });
    }

    public void tu(final String url) {
        cartTu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, Details_TU_Activity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
    }

    public void xq(final String url) {
        spxq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, Details_XQ_Activity.class);
                intent.putExtra("url", url);
                startActivity(intent);
            }
        });
    }
}
