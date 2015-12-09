package cn.com.elex.social_life.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.com.elex.social_life.R;
import cn.com.elex.social_life.model.bean.UserInfo;
import cn.com.elex.social_life.presenter.FindNearPeoplePresenter;
import cn.com.elex.social_life.support.util.ToastUtils;
import cn.com.elex.social_life.support.view.DividerGridItemDecoration;
import cn.com.elex.social_life.ui.adapter.FindNearPeopleAdapter;
import cn.com.elex.social_life.ui.base.BaseFragment;
import cn.com.elex.social_life.ui.iview.IFindNearPeopleView;


/**
 * Created by Administrator on 2015/10/30.
 */
public class FindTabFragment extends BaseFragment implements IFindNearPeopleView {

    @Bind(R.id.recycle_view)
    RecyclerView recycleView;
    @Bind(R.id.refresh_layout)
    MaterialRefreshLayout refreshLayout;
    private FindNearPeopleAdapter adapter;
    private List<UserInfo> userInfos;
    private int pager;
    private FindNearPeoplePresenter presenter;
    @Override
    protected int getResourceLyoutID() {
        return R.layout.fragment_tab_find;
    }

    @Override
    protected void onViewFirstLoading() {

        refreshLayout.autoRefresh();
    }

    @Override
    protected void onViewReloading() {

    }

    @Override
    protected void setViewData() {
        recycleView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
       // recycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recycleView.setAdapter(adapter);
        recycleView.addItemDecoration(new DividerGridItemDecoration(getActivity()));
        refreshLayout.setLoadMore(true);
        refreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {
                pager=1;
                presenter.getData();
            }
        });


    }




    @Override
    protected void preloadDataInit() {
        presenter=new FindNearPeoplePresenter(this);
        userInfos=new ArrayList<UserInfo>();
        adapter=new FindNearPeopleAdapter(userInfos,getContext());
    }


    @Override
    public int getPagerNum() {
        return pager;
    }

    @Override
    public void setPagerNum(int pager) {

        this.pager=pager;
    }

    @Override
    public void updateData(List<UserInfo> infos) {
        stopRefresh();
        userInfos.addAll(infos);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void stopRefresh() {
        refreshLayout.finishRefresh();
        refreshLayout.finishRefreshLoadMore();
    }

    @Override
    public void closeLoadMore() {
        refreshLayout.setLoadMore(false);
    }

    @Override
    public void openLoadMore() {
        refreshLayout.setLoadMore(true);
    }

}
