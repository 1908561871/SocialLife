package cn.com.elex.social_life.ui.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.zanlabs.widget.infiniteviewpager.InfiniteViewPager;
import com.zanlabs.widget.infiniteviewpager.indicator.CirclePageIndicator;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.elex.social_life.R;
import cn.com.elex.social_life.ui.adapter.GuideIntroduceAdpter;
import cn.com.elex.social_life.ui.base.BaseActivity;

/**
 * Created by zhangweibo on 2015/11/17.
 */
public class GuideActivity extends BaseActivity {


    @Bind(R.id.indicator)
    CirclePageIndicator indicator;
    @Bind(R.id.viewpager)
    InfiniteViewPager viewpager;
    private GuideIntroduceAdpter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_guide);
        ButterKnife.bind(this);
        adapter = new GuideIntroduceAdpter(this);
        viewpager.setAdapter(adapter);
        indicator.setViewPager(viewpager);
        viewpager.setAutoScrollTime(5000);
    }


    @Override
    protected void onResume() {
        if (viewpager != null) {
            viewpager.startAutoScroll();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        if (viewpager != null) {
            viewpager.stopAutoScroll();
        }
        super.onPause();
    }


    @OnClick(R.id.tv_login)
    public void login() {

        goToPagerByIntent(LoginActivity.class);

    }

    @OnClick(R.id.tv_register)
    public void register(){
        goToPagerByIntent(RegisterByEmailActivity.class);
    }






}
