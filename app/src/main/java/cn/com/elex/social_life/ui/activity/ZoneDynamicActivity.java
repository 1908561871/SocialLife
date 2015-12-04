package cn.com.elex.social_life.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cjj.MaterialRefreshLayout;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.com.elex.social_life.R;
import cn.com.elex.social_life.model.bean.PublishLogBean;
import cn.com.elex.social_life.support.view.DividerItemDecoration;
import cn.com.elex.social_life.support.view.load.LoadViewHelper;
import cn.com.elex.social_life.ui.adapter.MessageAdapter;
import cn.com.elex.social_life.ui.adapter.ZoneDynamicAdapter;
import cn.com.elex.social_life.ui.base.BaseActivity;

/**
 * Created by zhangweibo on 2015/12/4.
 */
public class ZoneDynamicActivity extends BaseActivity {

    @Bind(R.id.log_recycle)
    RecyclerView logRecycle;
    @Bind(R.id.log_refresh)
    MaterialRefreshLayout logRefresh;

    private ZoneDynamicAdapter adapter;
    private List<PublishLogBean> publishLogs;
    LoadViewHelper helper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_dynamic);
        ButterKnife.bind(this);
        helper=new LoadViewHelper(logRefresh);
        helper.showLoading();
        initRecycleView();
    }



    public void initRecycleView() {
        adapter = new ZoneDynamicAdapter(this, publishLogs);
        logRecycle.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        logRecycle.setAdapter(adapter);
        logRecycle.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }


    public void getData(){




    }






}
