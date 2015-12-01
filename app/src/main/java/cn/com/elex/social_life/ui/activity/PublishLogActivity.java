package cn.com.elex.social_life.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.elex.social_life.R;
import cn.com.elex.social_life.presenter.PublishLogPresenter;
import cn.com.elex.social_life.ui.base.BaseActivity;
import cn.com.elex.social_life.ui.iview.IPublishLogView;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

/**
 * Created by zhangweibo on 2015/12/1.
 */
public class PublishLogActivity extends BaseActivity implements IPublishLogView{

    @Bind(R.id.image_select)
    ImageView imageSelect;
    private ArrayList<String> mSelectPath;
    private PublishLogPresenter presenter;
    private int requestCode=1;
    private int resultCode=2;
    private Intent data;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_log);
        ButterKnife.bind(this);
        presenter=new PublishLogPresenter(this);
    }


    @OnClick(R.id.image_select)
    public void selectPhoto(){
        presenter.selectPhoto();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.requestCode=requestCode;
        this.resultCode=resultCode;
        this.data=data;

    }

    @Override
    public ArrayList<String> getSelectPath() {
        return mSelectPath==null?new ArrayList<String>():mSelectPath;
    }

    @Override
    public void setSelectPath(ArrayList<String> selectPath) {
        this.mSelectPath=selectPath;
    }

    @Override
    public int getRequstCode() {
        return requestCode;
    }

    @Override
    public int getResultCode() {
        return resultCode;
    }

    @Override
    public Intent getData() {
        return data;
    }


}
