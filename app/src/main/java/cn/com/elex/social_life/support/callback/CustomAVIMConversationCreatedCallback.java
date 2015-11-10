package cn.com.elex.social_life.support.callback;

import com.avos.avoscloud.im.v2.AVIMConversation;
import com.avos.avoscloud.im.v2.AVIMException;
import com.avos.avoscloud.im.v2.callback.AVIMConversationCreatedCallback;

/**
 * Created by zhangweibo on 2015/11/5.
 */
public abstract class CustomAVIMConversationCreatedCallback extends AVIMConversationCreatedCallback {


    private MsgCallBack msgCallBack ;


    public CustomAVIMConversationCreatedCallback(MsgCallBack msgCallBack) {
        this.msgCallBack = msgCallBack;
    }

    public void done(AVIMConversation avimConversation, AVIMException e) {

        if (e==null){

            success(avimConversation);

        }else{
            msgCallBack.failure(e.getMessage());
        }

    }

    protected   abstract  void  success(AVIMConversation avimConversation);



}
