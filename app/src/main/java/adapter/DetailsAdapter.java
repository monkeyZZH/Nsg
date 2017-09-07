package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import been.Data_cart;
import test.baway.com.nsg.R;

/**
 * name:周振辉
 * 时间：2017/9/5 16:44
 * 类描述：
 */

public class DetailsAdapter extends BaseAdapter {
    private Context mContext;
    private List<Data_cart.DatasBean.GoodsCommendListBean> mList;
    private int count = 1;

    public DetailsAdapter(Context context, List<Data_cart.DatasBean.GoodsCommendListBean> list) {
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
            convertView=View.inflate(mContext, R.layout.details_item,null);
            holder=new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.details_itam_name);
            holder.price = (TextView)convertView.findViewById(R.id.details_itam_price);
            holder.image = (ImageView)convertView.findViewById(R.id.details_itam_image);



            convertView.setTag(holder);
        }else{
            holder=(ViewHolder)convertView.getTag();
        }
        holder.name.setText(mList.get(position).getGoods_name());
        holder.price.setText("¥:"+mList.get(position).getGoods_promotion_price());
        Glide.with(mContext).load(mList.get(position).getGoods_image_url()).into(holder.image);

        return convertView;
    }

    class ViewHolder{
        TextView name,price,jia,jian,shu,num;
        ImageView image;
    }
}
