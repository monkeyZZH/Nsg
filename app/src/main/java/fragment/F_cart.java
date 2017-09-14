package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import Dao.User;
import adapter.CartAdapter;
import test.baway.com.nsg.IndentActivity;
import test.baway.com.nsg.R;

import static java.lang.Float.parseFloat;

/**
 * name:周振辉
 * 时间：2017/8/31 14:24
 * 类描述：
 */

public class F_cart extends Fragment {


private List<User> list;
    private CartAdapter adapter;
    private ListView listView;
    private TextView spzj;
    private int sum;
    private float price;
    private Button jiesuan;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_cart_xml, container, false);
        listView = (ListView)view.findViewById(R.id.cart_lisrview);
                spzj = (TextView)view.findViewById(R.id.cart_spzj);
        jiesuan = (Button)view.findViewById(R.id.cart_jiesuan);
        jiesuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), IndentActivity.class);
                startActivity(intent);
            }
        });
        jiashuju();
        return view;
    }

    private void jiashuju() {
                list = Dao.LoveDao.queryAll();
                adapter = new CartAdapter(getActivity(), list);
                listView.setAdapter(adapter);
                //给控件设置初始值
                for(int i = 0; i <list.size();i++){
                    price+= parseFloat(list.get(i).getPrice());
                }
                sum = list.size();
                spzj.setText("共计"+sum+"件商品，共计"+price+"元");

    }
    //自定义的方法，接收Adapter传过来的数据
    public void setData(int a ,int b){
        sum+=a;
        price+=b;
        spzj.setText("共计"+sum+"件商品，共计"+price+"元");
    }
    //自定义的方法，接收Adapter传过来的数据
    public void setDelete(int a){
       list.remove(a);
        adapter.notifyDataSetChanged();
        Dao.LoveDao.deleteLove(a+1);

    }


}
