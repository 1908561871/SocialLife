package cn.com.elex.social_life.support.callback;

import com.avos.avoscloud.im.v2.AVIMClient;
import com.avos.avoscloud.im.v2.AVIMException;
import com.avos.avoscloud.im.v2.callback.AVIMClientCallback;

/**
 * Created by zhangweibo on 2015/11/5.
 */
public  abstract  class CustomAVIMClientCallback extends AVIMClientCallback {


    private MsgCallBack msgCallBack ;


    public CustomAVIMClientCallback(MsgCallBack msgCallBack) {
        this.msgCallBack = msgCallBack;
    }

    public void done(AVIMClient avimClient, AVIMException e) {

        if (e==null){

            success();

         }else{
            msgCallBack.failure(e.getMessage());
        }


    }


    protected  abstract   void  success();


}
