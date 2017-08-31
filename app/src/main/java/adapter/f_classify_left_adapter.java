package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import been.Data_classify;
import test.baway.com.nsg.R;

/**
 * name:周振辉
 * 时间：2017/8/31 15:35
 * 类描述：
 */

public class f_classify_left_adapter extends BaseAdapter{
     private Context mContext;
         private List<Data_classify.DatasBean.ClassListBean> mList;

         public f_classify_left_adapter(Context context, List<Data_classify.DatasBean.ClassListBean> list) {
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
                 convertView= View.inflate(mContext, R.layout.f_classify_left_item,null);
                 holder=new ViewHolder();
                    holder.name = (TextView)convertView.findViewById(R.id.f_classify_left_name);
                    holder.image = (ImageView)convertView.findViewById(R.id.f_classify_left_image);

                 convertView.setTag(holder);
             }else{
                 holder=(ViewHolder)convertView.getTag();
             }
             holder.name.setText(mList.get(position).getGc_name());
             Glide.with(mContext).load(mList.get(position).getImage()).into(holder.image);

             return convertView;
         }

         class ViewHolder{
                TextView name;
                ImageView image;
         }
}
