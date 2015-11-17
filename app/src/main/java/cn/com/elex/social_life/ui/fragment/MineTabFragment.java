package cn.com.elex.social_life.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.elex.social_life.R;
import cn.com.elex.social_life.ui.base.BaseFragment;


/**
 * Created by Administrator on 2015/10/30.
 */
public class MineTabFragment extends BaseFragment {



    @Override
    protected int getResourceLyoutID() {
        return R.layout.fragment_tab_mine;
    }

    @Override
    protected void onViewFirstLoading() {

    }

    @Override
    protected void onViewReloading() {

    }

    @Override
    protected void setViewData() {

    }

    @Override
    protected void preloadDataInit() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Bind(R.id.user_info)
    RelativeLayout userInfo;
    @Bind(R.id.share)
    RelativeLayout share;
    @Bind(R.id.posting)
    RelativeLayout posting;
    @Bind(R.id.setting)
    RelativeLayout setting;
    @Bind(R.id.more)
    RelativeLayout more;

    @OnClick({R.id.user_info,R.id.share,R.id.posting,R.id.setting,R.id.more})

    public void click(View v){

        switch (v.getId()){


        }



    }




}
