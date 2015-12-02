package cn.com.elex.social_life.ui.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.elex.social_life.R;
import cn.com.elex.social_life.model.bean.LocationMsg;
import cn.com.elex.social_life.presenter.PublishLogPresenter;
import cn.com.elex.social_life.support.callback.LocationCallBack;
import cn.com.elex.social_life.support.location.LocationManager;
import cn.com.elex.social_life.ui.adapter.GridlayoutImagesAdapter;
import cn.com.elex.social_life.ui.base.BaseActivity;
import cn.com.elex.social_life.ui.iview.IPublishLogView;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

/**
 * Created by zhangweibo on 2015/12/1.
 */
public class PublishLogActivity extends BaseActivity implements IPublishLogView {

    @Bind(R.id.tv_location)
    TextView location;
    @Bind(R.id.layout_images)
    GridView layoutImages;
    @Bind(R.id.parent_layout)
    RelativeLayout parentLayout;
    @Bind(R.id.et_title)
    EditText etTitle;
    private ArrayList<String> mSelectPath;
    private PublishLogPresenter presenter;
    private int requestCode = 1;
    private int resultCode = 2;
    private Intent data;
    private BaseAdapter imageAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_log);
        ButterKnife.bind(this);
        presenter = new PublishLogPresenter(this);
        init();
        setHeader(true, R.string.publish_log, R.string.publish, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    public void init() {
        mSelectPath = new ArrayList<String>();
        imageAdapter = new GridlayoutImagesAdapter(this, mSelectPath);
        layoutImages.setAdapter(imageAdapter);
    }

    @OnClick(R.id.image_select)
    public void selectPhoto() {
        presenter.selectPhoto();
    }

    @OnClick(R.id.location)
    public void locatePositon() {
        showSoftInput(etTitle);

        LocationManager.getInstance().obtainCurrentLocation(new LocationCallBack() {
            @Override
            public void locSuccess(LocationMsg msg) {
                location.setText(msg.getAddr());
            }

            @Override
            public void locFailure() {
                location.setText(getResources().getString(R.string.location_failure));
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.requestCode = requestCode;
        this.resultCode = resultCode;
        this.data = data;
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                 ArrayList<String>  path = data.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT);
                mSelectPath.addAll(path);
                imageAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public ArrayList<String> getSelectPath() {
        return mSelectPath;
    }

    @Override
    public void setSelectPath(ArrayList<String> selectPath) {
        this.mSelectPath = selectPath;
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



    @Override
    protected void onStart() {
        super.onStart();
    }


}
