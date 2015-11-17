package cn.com.elex.social_life.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.com.elex.social_life.R;
import cn.com.elex.social_life.support.view.autoscrollviewpager.AutoScrollViewPager;
import cn.com.elex.social_life.ui.base.BaseActivity;
import cn.com.elex.social_life.ui.fragment.GuideIntroduceFragment;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by zhangweibo on 2015/11/17.
 */
public class GuideActivity extends BaseActivity {


    @Bind(R.id.indicator)
    CircleIndicator indicator;
    @Bind(R.id.viewpager)
    AutoScrollViewPager viewpager;
    public MyPagerAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_guide);
        ButterKnife.bind(this);
        adapter=new MyPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        indicator.setViewPager(viewpager);
    }


    class MyPagerAdapter extends FragmentPagerAdapter{


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return GuideIntroduceFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return GuideIntroduceFragment.introduces.size();
        }
    }


    @Override
    protected void onResume() {
        viewpager.startAutoScroll();
        super.onResume();
    }

    @Override
    protected void onPause() {
        viewpager.stopAutoScroll();
        super.onPause();
    }
}
