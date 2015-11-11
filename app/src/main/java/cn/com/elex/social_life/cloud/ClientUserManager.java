package cn.com.elex.social_life.cloud;

import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.im.v2.AVIMClient;
import com.avos.avoscloud.im.v2.AVIMConversation;

import cn.com.elex.social_life.model.bean.UserInfo;
import cn.com.elex.social_life.support.callback.IMLoginCallBack;

/**
 * Created by zhangweibo on 2015/11/5.
 */
public class ClientUserManager {

    AVIMClient client;

    AVUser user;


    private static class SingleClientUserManager {
        private static final ClientUserManager instance = new ClientUserManager();
    }

    public static ClientUserManager getInstance() {
        return SingleClientUserManager.instance;
    }

    private ClientUserManager() {

    }


    public  AVIMClient obtainCurrentClentUser(){

        if (client==null){
            if (AVUser.getCurrentUser()!=null)
            client = AVIMClient.getInstance(AVUser.getCurrentUser().getUsername());
        }
        return client;
    }

    public  AVUser  obtainCurrentUser(){

        if (user==null){
            user=  AVUser.getCurrentUser();
        }
        return user;
    }


    public  void clearUserMsg(){

        client=null;

    }

    /**
     * IM登录
     * @param callBack
     */

    public  void imLogin(IMLoginCallBack callBack){

        obtainCurrentClentUser().open(callBack);
    }

    /**
     * IM退出
     * @param callBack
     */
    public void imQuit(IMLoginCallBack callBack){


        obtainCurrentClentUser().close(callBack);

    }


    /**
     * 使用用户名登录
     * @param useName
     * @param pwd
     * @param callback
     */

    public  void loginByUserName(String useName ,String pwd, LogInCallback callback)
    {

        AVUser.logInInBackground(useName, pwd, callback);

    }




}
