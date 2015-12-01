package cn.com.elex.social_life.presenter;

import android.app.Activity;

import cn.com.elex.social_life.model.imodel.IPublishLogModel;
import cn.com.elex.social_life.model.imodel.PublishLogModel;
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

        model.selectPhoto((Activity) view,view.getSelectPath());

    }

    public void dealWithResult(){

        model.dealWithResult(view.getRequstCode(),view.getResultCode(),view.getData());

    }



}
