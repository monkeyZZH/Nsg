package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import adapter.ExpandableListViewAdapter;
import adapter.f_classify_left_adapter;
import been.Data_classify;
import been.f_classify_right01;
import been.f_classify_right02;
import test.baway.com.nsg.R;
import utils.Constant;
import utils.HttpUtil;
import utils.OnNetListener;
import utils.xutils;

/**
 * name:周振辉
 * 时间：2017/8/31 14:24
 * 类描述：
 */

public class F_classify extends Fragment{

    private ListView listView;
    private f_classify_left_adapter adapter;
    private List<Data_classify.DatasBean.ClassListBean> list;


    ExpandableListView mExpandableListView;
    ExpandableListViewAdapter mExpandableListViewAdapter;
    private static final String TAG = "Main";
    private List<String> r_list;
    private List<f_classify_right01.DatasBean.ClassListBean> r_list2;
private List<f_classify_right02.DatasBean.ClassListBean> list3;
    private  String[][] arr;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_classify_xml,container,false);
        listView = (ListView) view.findViewById(R.id.left_list);
        mExpandableListView = (ExpandableListView) view.findViewById(R.id.expandableListView);

        zuo_okhttp();
        you(1);
        return view;
    }

    private void you(int a) {
        r_list = new ArrayList<>();
        r_list2 = new ArrayList<>();
        String url = Constant.LINK_MOBILE_CLASS_XQ+a;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback()
                {
                    @Override
                    public void onError(Request request, Exception e)
                    {

                    }
                    @Override
                    public void onResponse(String response)
                    {
                        f_classify_right01 data = new Gson().fromJson(response,f_classify_right01.class);
                        r_list2.addAll(data.getDatas().getClass_list());
                        for (int i = 0;i<r_list2.size();i++)
                        {
                            r_list.add(r_list2.get(i).getGc_name());
                        }
                        new Thread(){
                            @Override
                            public void run() {
                                super.run();
                                arr = new String[r_list2.size()][];

                                for (int i = 0;i<r_list2.size();i++){
                                    String url = Constant.LINK_MOBILE_CLASS_XQ+r_list2.get(i).getGc_id();
                                    String aa = xutils.getUrlConnect(url);
                                    f_classify_right02 data2 = new Gson().fromJson(aa,f_classify_right02.class);

                                    list3 = new ArrayList<f_classify_right02.DatasBean.ClassListBean>();
                                    list3.addAll(data2.getDatas().getClass_list());
                                    String[] arr2 = new String[list3.size()];
                                    for (int a=0;a<list3.size();a++){
                                        arr2[a] = list3.get(a).getGc_name();
                                    }
                                    arr[i]=arr2;
                                    arr2.clone();
                                }

                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        mExpandableListViewAdapter = new ExpandableListViewAdapter(getActivity(),r_list,arr);
                                        mExpandableListView.setAdapter(mExpandableListViewAdapter);   //设置它的adapter
//                                        for (int i = 0 ;i<list.size() ;i++){
//                                            mExpandableListView.expandGroup(i);
//                                        }

                                    }

                                });
                            }
                        }.start();
                    }
                });

        //设置父item的点击事件
        mExpandableListView
                .setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView parent,
                                                View v, int groupPosition, long id) {
                        return false;

                    }
                });

        //设置子item的点击事件
        mExpandableListView
                .setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView parent,
                                                View v, int groupPosition, int childPosition,
                                                long id) {
                        Log.e(TAG, "groupPosition=" + groupPosition
                                + ",childPosition=" + childPosition);
                        return false;
                    }
                });




    }

 

    private void zuo_okhttp() {
        HttpUtil.getHttpUtil().get(getContext(), Constant.LINK_MOBILE_CLASS, new OnNetListener() {
            @Override
            public void onSuccess(String str) {
                Data_classify data = new Gson().fromJson(str,Data_classify.class);
                list = new ArrayList<Data_classify.DatasBean.ClassListBean>();
                list.addAll(data.getDatas().getClass_list());
                adapter = new f_classify_left_adapter(getActivity(),list);
                listView.setAdapter(adapter);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                r_list2.clear();
//                list3.clear();
//                arr.clone();
//                r_list.clear();
                String a = list.get(position).getGc_id();
                int b = Integer.parseInt(a);
               you(b);
            }
        });
    }

}
