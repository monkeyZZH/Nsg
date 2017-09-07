package adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import been.Data_cart;
import fragment.F_cart;
import test.baway.com.nsg.MainActivity;
import test.baway.com.nsg.R;

/**
 * name:周振辉
 * 时间：2017/9/6 16:39
 * 类描述：
 */

public class CartAdapter extends BaseAdapter {
     private Context mContext;
         private List<Data_cart.DatasBean.GoodsCommendListBean> mList;
        private int aa = 1;
         public CartAdapter(Context context, List<Data_cart.DatasBean.GoodsCommendListBean> list) {
             mContext = context;
             mList = list;
         }

         @Override
         public int getCount() {
             return mList.size();
         }

         @Override
         public Object getItem(int position) {
             return null;
         }

         @Override
         public long getItemId(int position) {
             return 0;
         }

         @Override
         public View getView(final int position, View convertView, ViewGroup parent) {
             ViewHolder holder=null;
             if(convertView==null){
                 convertView=View.inflate(mContext, R.layout.cart_item,null);
                 holder=new ViewHolder();
                 holder.name = (TextView)convertView.findViewById(R.id.cart_item_name1);
                 holder.price = (TextView)convertView.findViewById(R.id.cart_item_price1);
                 holder.image = (ImageView)convertView.findViewById(R.id.cart_item_image1);
                 holder.shu = (TextView)convertView.findViewById(R.id.cart_item_shushu);
                 holder.jia = (Button)convertView.findViewById(R.id.cart_item_jiajia);
                 holder.jian = (Button)convertView.findViewById(R.id.cart_item_jianjian);
                 holder.shu = (TextView)convertView.findViewById(R.id.cart_item_shushu);
                 holder.num = (TextView)convertView.findViewById(R.id.cart_item_numnum);
                 holder.DGZJ = (TextView)convertView.findViewById(R.id.cart_item_zongji1);
                 convertView.setTag(holder);
             }else{
                 holder=(ViewHolder)convertView.getTag();
             }
                 holder.name.setText(mList.get(position).getGoods_name());
                 holder.price.setText(mList.get(position).getGoods_promotion_price());
             Glide.with(mContext).load(mList.get(position).getGoods_image_url()).into(holder.image);
             holder.DGZJ.setText("共計1件商品，共計"+mList.get(position).getGoods_promotion_price()+"元");
             final ViewHolder finalHolder = holder;
             final ViewHolder finalHolder1 = holder;
             final ViewHolder finalHolder2 = holder;
             final ViewHolder finalHolder3 = holder;
             //数量加号的点击事件
             holder.jia.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     //获取当前的数量
                     int count =Integer.parseInt(finalHolder3.shu.getText().toString()) ;
                     //每点击一次数量加一
                     ++count;
                     //设置item中对应的数值
                     finalHolder.shu.setText(""+count);
                     finalHolder1.num.setText("X"+count);
                     //计算当前数量商品的总价
                     float b=Float.parseFloat(mList.get(position).getGoods_promotion_price());
                     float c = b*count;
                     //设置商品总价
                     finalHolder2.DGZJ.setText("共计"+count+"件商品，共计"+c+"元");
                    //获取当前Fragment所在的Activity
                     MainActivity fc = (MainActivity) mContext;
                     //获取当前Activyty中的所有Fragment，以List集合形式得到
                     List<Fragment> fragments = fc.getSupportFragmentManager().getFragments();
                     //遍历装有Fragment的集合
                     for (Fragment f: fragments) {
                         //找到当前所在的Fragment
                         if (f instanceof F_cart){
                             //强转一下
                             F_cart f_card = (F_cart) f;
                             //利用得到的Fragment调用在Fragment中写的方法
                             //传的为正负值，便于累计计算
                             f_card.setData(1, (int) b);
                         }
                     }
                 }
             });

             holder.jian.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     int count =Integer.parseInt(finalHolder3.shu.getText().toString()) ;
                     if(count>0)
                     {
                         --count;
                         finalHolder.shu.setText(""+count);
                         finalHolder1.num.setText("X"+count);
                         float b=Float.parseFloat(mList.get(position).getGoods_promotion_price());
                         float c = b*count;
                         finalHolder2.DGZJ.setText("共计"+count+"件商品，共计"+c+"元");

                         MainActivity fc = (MainActivity) mContext;
                         List<Fragment> fragments = fc.getSupportFragmentManager().getFragments();
                         for (Fragment f: fragments) {
                             if (f instanceof F_cart){
                                 F_cart f_card = (F_cart) f;
                                 f_card.setData(-1, (int) -b);
                             }
                         }

                     }else if(count <= 0){
                         Toast.makeText(mContext,"最小数量",Toast.LENGTH_LONG).show();
                     }
                 }
             });




             return convertView;
         }
         class ViewHolder{
             Button jia,jian;
                TextView name,price,shu,num,DGZJ;
             ImageView image;
         }
}
