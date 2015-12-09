package cn.com.elex.social_life.presenter;

import java.util.List;

import cn.com.elex.social_life.model.FindNearPeopleModel;
import cn.com.elex.social_life.model.imodel.IFindNearPeopleModel;
import cn.com.elex.social_life.support.callback.CustomFindCallBack;
import cn.com.elex.social_life.support.callback.DataQueryCallBack;
import cn.com.elex.social_life.support.location.LocationManager;
import cn.com.elex.social_life.support.util.ToastUtils;
import cn.com.elex.social_life.ui.iview.IFindNearPeopleView;

/**
 * Created by zhangweibo on 2015/12/9.
 */
public class FindNearPeoplePresenter {

    private IFindNearPeopleModel model;

    private IFindNearPeopleView view;

    public FindNearPeoplePresenter(IFindNearPeopleView view) {
        this.view = view;
        model=new FindNearPeopleModel();
    }



    public void getData(){

        model.obtainNearPeopleData(LocationManager.getInstance().getGeoPoint(),new CustomFindCallBack(new DataQueryCallBack() {
            @Override
            public void success(List list) {
                if (list.size()<2){
                    view.closeLoadMore();
                }
                view.updateData(list);
            }

            @Override
            public void failure(String msg) {
                view.closeLoadMore();
                ToastUtils.show(msg);
            }
        }),view.getPagerNum()*2);

    }

}
