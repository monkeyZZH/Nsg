package test.baway.com.nsg;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import fragment.F_cart;
import fragment.F_classify;
import fragment.F_home;
import fragment.F_mine;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.frament)
    FrameLayout frament;
    @BindView(R.id.sy)
    RadioButton sy;
    @BindView(R.id.fl)
    RadioButton fl;
    @BindView(R.id.gwc)
    RadioButton gwc;
    @BindView(R.id.wd)
    RadioButton wd;


    private F_home f_home;
    private F_classify f_classify;
    private F_cart f_cart;
    private F_mine f_mine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //创建fragment对象
        f_home = new F_home();
        f_classify = new F_classify();
        f_cart = new F_cart();
        f_mine = new F_mine();

        //设置默认页
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frament, f_home)
                .commit();

    }

    //下面就是四个按钮的点击事件
    public void SY(View v) {
        //展示fragment页
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frament, f_home)
                .commit();
        //切换字体颜色
        sy.setTextColor(getResources().getColor(R.color.cheng));
        fl.setTextColor(getResources().getColor(R.color.hui));
        gwc.setTextColor(getResources().getColor(R.color.hui));
        wd.setTextColor(getResources().getColor(R.color.hui));

    }

    public void FL(View v) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frament, f_classify)
                .commit();
        sy.setTextColor(getResources().getColor(R.color.hui));
        fl.setTextColor(getResources().getColor(R.color.cheng));
        gwc.setTextColor(getResources().getColor(R.color.hui));
        wd.setTextColor(getResources().getColor(R.color.hui));
    }

    public void GWC(View v) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frament, f_cart)
                .commit();
        sy.setTextColor(getResources().getColor(R.color.hui));
        fl.setTextColor(getResources().getColor(R.color.hui));
        gwc.setTextColor(getResources().getColor(R.color.cheng));
        wd.setTextColor(getResources().getColor(R.color.hui));
    }

    public void Wd(View v) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frament, f_mine)
                .commit();
        sy.setTextColor(getResources().getColor(R.color.hui));
        fl.setTextColor(getResources().getColor(R.color.hui));
        gwc.setTextColor(getResources().getColor(R.color.hui));
        wd.setTextColor(getResources().getColor(R.color.cheng));
    }

}
