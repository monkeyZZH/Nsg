package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import adapter.CartAdapter;
import been.Data_cart;
import test.baway.com.nsg.R;
import utils.Constant;
import utils.HttpUtil;
import utils.OnNetListener;

import static java.lang.Float.parseFloat;

/**
 * name:周振辉
 * 时间：2017/8/31 14:24
 * 类描述：
 */

public class F_cart extends Fragment {


private List<Data_cart.DatasBean.GoodsCommendListBean> list,list2;
    private CartAdapter adapter;
    private ListView listView;
    private TextView spzj;
    private int sum;
    private float price;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_cart_xml, container, false);
        listView = (ListView)view.findViewById(R.id.cart_lisrview);
                spzj = (TextView)view.findViewById(R.id.cart_spzj);
        jiashuju();
        return view;
    }

    private void jiashuju() {
        HttpUtil.getHttpUtil().get(getActivity(), Constant.LINK_MOBILE_SPXQ + 100009, new OnNetListener() {
            @Override
            public void onSuccess(String str) {
                Data_cart data = new Gson().fromJson(str, Data_cart.class);
                list = new ArrayList<Data_cart.DatasBean.GoodsCommendListBean>();
                list.addAll(data.getDatas().getGoods_commend_list());
                list2 = new ArrayList<Data_cart.DatasBean.GoodsCommendListBean>();
                list2.add(list.get(0));
                list2.add(list.get(1));
                list2.add(list.get(2));
                list2.add(list.get(3));
                adapter = new CartAdapter(getActivity(), list2);
                listView.setAdapter(adapter);
                //给控件设置初始值
                for(int i = 0; i <list2.size();i++){
                    price+= parseFloat(list2.get(i).getGoods_promotion_price());
                }
                sum = list2.size();
                spzj.setText("共计"+sum+"件商品，共计"+price+"元");
            }
        });
    }
    //自定义的方法，接收Adapter传过来的数据
    public void setData(int a ,int b){
        sum+=a;
        price+=b;
        spzj.setText("共计"+sum+"件商品，共计"+price+"元");
    }
    //自定义的方法，接收Adapter传过来的数据
    public void setDelete(int a){
       list2.remove(a);
        adapter.notifyDataSetChanged();

    }

}
