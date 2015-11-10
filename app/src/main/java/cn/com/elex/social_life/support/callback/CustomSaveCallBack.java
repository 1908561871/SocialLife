package cn.com.elex.social_life.support.callback;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.SaveCallback;

/**
 * Created by zhangweibo on 2015/11/9.
 */
public class CustomSaveCallBack extends SaveCallback {


    private DataSaveCallBack callBack;

    public CustomSaveCallBack(DataSaveCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void done(AVException e) {

        if (e==null){
            callBack.success();
        }else{
            callBack.failure(e.getMessage());
        }
    }
}
