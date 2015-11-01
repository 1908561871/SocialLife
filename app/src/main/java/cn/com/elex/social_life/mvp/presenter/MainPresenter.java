package cn.com.elex.social_life.mvp.presenter;

import android.content.Context;



/**
 * Created by zhangweibo on 2015/8/4.
 */
public class MainPresenter {

    private cn.com.elex.social_life.mvp.view.iview.IMainTabView iMainView;
    private cn.com.elex.social_life.mvp.model.imodel.IMainModel iMainModel;

    public MainPresenter(cn.com.elex.social_life.mvp.view.iview.IMainTabView iMainView) {
        this.iMainView = iMainView;
        iMainModel=  new cn.com.elex.social_life.mvp.model.MainModel();
    }


    public void IMinit(Context context){

        iMainModel.IMinit(context);
    }




}
