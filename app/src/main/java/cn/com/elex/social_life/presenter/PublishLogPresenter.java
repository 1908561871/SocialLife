package cn.com.elex.social_life.presenter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.TextureView;

import cn.com.elex.social_life.R;
import cn.com.elex.social_life.model.PublishLogModel;
import cn.com.elex.social_life.model.bean.PublishLogBean;
import cn.com.elex.social_life.model.imodel.IPublishLogModel;
import cn.com.elex.social_life.support.callback.CustomSaveCallBack;
import cn.com.elex.social_life.support.util.ToastUtils;
import cn.com.elex.social_life.ui.iview.IPublishLogView;

/**
 * Created by zhangweibo on 2015/12/1.
 */
public class PublishLogPresenter {


   private IPublishLogView view;

   private IPublishLogModel model;

    public PublishLogPresenter(IPublishLogView view) {
        this.view = view;
        model=new PublishLogModel();
    }


    public void selectPhoto(){

        model.selectPhoto((Activity) view,view.getSelectPath(),8-view.getSelectPath().size());

    }


    public void commitData(){

        if (TextUtils.isEmpty(view.getLogTitle())){
            ToastUtils.show(R.string.title_blank_error);
            return;
        }
        if (TextUtils.isEmpty(view.getLogContent())){
            ToastUtils.show(R.string.content_blank_error);
            return;
        }
        if (view.getLocation()==null){
            ToastUtils.show(R.string.please_obtain_location);
            return;
        }

        view.showDialog();
        model.commitData(packData(), new CustomSaveCallBack() {
            @Override
            public void success() {
                ToastUtils.show("保存成功");
                view.hideDialog();
            }

            @Override
            public void failure(String error) {
                ToastUtils.show("保存失败");
                view.hideDialog();
            }
        });
    }


    public PublishLogBean packData(){
        PublishLogBean data=new PublishLogBean();
        data.setAddr(view.getLocation().getAddr());
        data.setLat(view.getLocation().getLat());
        data.setLon(view.getLocation().getLon());
        data.setContent(view.getLogContent());
        data.setTitle(view.getLogTitle());
        data.setImageUrls(view.getSelectPath());
        return  data;
    }



}
