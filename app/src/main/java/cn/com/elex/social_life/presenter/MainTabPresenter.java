package cn.com.elex.social_life.presenter;


import cn.com.elex.social_life.model.imodel.IMainTabModel;
import cn.com.elex.social_life.model.imodel.MainTabModel;
import cn.com.elex.social_life.ui.iview.IMainTabView;

/**
 * Created by zhangweibo on 2015/11/3.
 */
public class MainTabPresenter {

    IMainTabModel mainTabModel;
    IMainTabView mainTabView;

    public MainTabPresenter(IMainTabView mainTabView) {
        this.mainTabView = mainTabView;
        mainTabModel=new MainTabModel();
    }







}
