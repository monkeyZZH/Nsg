package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import test.baway.com.nsg.LogonActivity;
import test.baway.com.nsg.R;

/**
 * name:周振辉
 * 时间：2017/8/31 14:24
 * 类描述：
 */

public class F_mine extends Fragment{
    private TextView mine_name;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f_mine_xml,container,false);
        mine_name = (TextView)view.findViewById(R.id.mine_name);
        mine_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LogonActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
