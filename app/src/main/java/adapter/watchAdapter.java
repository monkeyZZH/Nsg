package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import been.Data_watch;
import test.baway.com.nsg.R;

/**
 * name:周振辉
 * 时间：2017/9/1 18:56
 * 类描述：
 */

public class watchAdapter extends BaseAdapter{
     private Context mContext;
         private List<Data_watch.DatasBean.GoodsListBean> mList;

         public watchAdapter(Context context, List<Data_watch.DatasBean.GoodsListBean> list) {
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
         public View getView(int position, View convertView, ViewGroup parent) {
             ViewHolder holder=null;
             if(convertView==null){
                 convertView=View.inflate(mContext, R.layout.watch_list_item,null);
                 holder=new ViewHolder();
                 holder.name = (TextView) convertView.findViewById(R.id.watch_list_item_name);
                 holder.price = (TextView) convertView.findViewById(R.id.watch_list_item_price);
                 holder.shouchu = (TextView) convertView.findViewById(R.id.watch_list_item_shouchu);
                 holder.image = (ImageView) convertView.findViewById(R.id.watch_list_item_image);

                 convertView.setTag(holder);
             }else{
                 holder=(ViewHolder)convertView.getTag();
             }
             holder.name.setText(mList.get(position).getGoods_name());
             holder.price.setText("¥:"+mList.get(position).getGoods_price());
             holder.shouchu.setText("已售："+mList.get(position).getGoods_salenum()+"件");
             Glide.with(mContext).load(mList.get(position).getGoods_image_url()).into(holder.image);

             return convertView;
         }

         class ViewHolder{

             TextView name,price,shouchu;
             ImageView image;

         }
}
