package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import adapter.f_classify_left_adapter;
import been.Data_classify;
import test.baway.com.nsg.R;
import utils.Constant;

/**
 * name:周振辉
 * 时间：2017/8/31 14:24
 * 类描述：
 */

public class F_classify extends Fragment{

    private ListView listView;
    private f_classify_left_adapter adapter;
    private List<Data_classify.DatasBean.ClassListBean> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_classify_xml,container,false);
        listView = (ListView) view.findViewById(R.id.left_list);

        okhttp();
        return view;
    }

    private void okhttp() {
        String url = Constant.LINK_MOBILE_CLASS;
                OkHttpUtils
                        .get()
                        .url(url)
//                        .addParams("username", "hyman")
//                        .addParams("password", "123")
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
                                Log.e("00000",response);
                                Data_classify data = new Gson().fromJson(response,Data_classify.class);
                                list = new ArrayList<Data_classify.DatasBean.ClassListBean>();
                                list.addAll(data.getDatas().getClass_list());
                                adapter = new f_classify_left_adapter(getActivity(),list);
                                listView.setAdapter(adapter);

                            }
                        });

    }
}
