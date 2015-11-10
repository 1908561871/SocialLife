package cn.com.elex.social_life.sys.receiver.im;


import com.avos.avoscloud.im.v2.AVIMClient;
import com.avos.avoscloud.im.v2.AVIMConversation;
import com.avos.avoscloud.im.v2.AVIMMessage;
import com.avos.avoscloud.im.v2.AVIMMessageHandler;

/**
 * Created by zhangweibo on 2015/11/5.
 */
public  class CustomMessageHandler extends AVIMMessageHandler {
    /**
     * 处理接收消息
     * @param message
     * @param conversation
     * @param client
     */
    @Override
    public void onMessage(AVIMMessage message,AVIMConversation conversation,AVIMClient client){

    }

    /**
     * 处理消息回执
     * @param message
     * @param conversation
     * @param client
     */
    public void onMessageReceipt(AVIMMessage message,AVIMConversation conversation,AVIMClient client){

    }
}