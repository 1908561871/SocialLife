package cn.com.elex.social_life.cloud.im.message;

import com.avos.avoscloud.im.v2.AVIMConversation;
import com.avos.avoscloud.im.v2.messages.AVIMTextMessage;

import java.util.List;

import cn.com.elex.social_life.cloud.im.ClientUserManager;
import cn.com.elex.social_life.support.callback.CustomAVIMClientCallback;
import cn.com.elex.social_life.support.callback.CustomAVIMConversationCreatedCallback;
import cn.com.elex.social_life.support.callback.CustomConversitonCallBack;
import cn.com.elex.social_life.support.callback.MsgCallBack;
import cn.com.elex.social_life.support.util.StringUtils;

/**
 * Created by zhangweibo on 2015/11/5.
 */
public class MessageSendCotrol {

    /**
     * 发送文本消息
     * @param reveiver
     * @param callBack
     */

    public static void sendTextMsg(final List<String> reveiver, final String title,final MsgCallBack callBack){

        ClientUserManager.obtainCurrentClentUser().open(new CustomAVIMClientCallback(callBack) {
            @Override
            protected void success() {
                ClientUserManager.obtainCurrentClentUser().createConversation(reveiver, title != null ? title : StringUtils.tailorNameWithAnd(reveiver), null, new CustomAVIMConversationCreatedCallback(callBack) {
                    @Override
                    protected void success(AVIMConversation avimConversation) {
                        AVIMTextMessage msg = new AVIMTextMessage();
                        msg.setText("耗子，起床！");
                        // 发送消息
                        avimConversation.sendMessage(msg, new CustomConversitonCallBack(callBack));
                    }
                });

            }
        });

    }






}
