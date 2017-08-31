package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.baway.com.nsg.R;

/**
 * name:周振辉
 * 时间：2017/8/31 14:24
 * 类描述：
 */

public class F_home extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_home_xml,container,false);
        return view;
    }
}
