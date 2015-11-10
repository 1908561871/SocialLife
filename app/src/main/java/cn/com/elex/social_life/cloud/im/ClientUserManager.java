package cn.com.elex.social_life.cloud.im;

import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.im.v2.AVIMClient;

import cn.com.elex.social_life.model.bean.UserInfo;

/**
 * Created by zhangweibo on 2015/11/5.
 */
public class ClientUserManager {

    static  AVIMClient client;

    static AVUser user;

    public static AVIMClient obtainCurrentClentUser(){

        if (client==null){
            if (AVUser.getCurrentUser()!=null)
            client = AVIMClient.getInstance(AVUser.getCurrentUser().getUsername());
        }
        return client;
    }

    public static AVUser  obtainCurrentUser(){

        if (user==null){
            user=  AVUser.getCurrentUser();
        }
        return user;
    }



    public static void clearUserMsg(){

        client=null;

    }


}
