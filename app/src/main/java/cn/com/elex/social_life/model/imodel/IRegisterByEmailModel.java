package cn.com.elex.social_life.model.imodel;

import android.content.Context;

import cn.com.elex.social_life.support.callback.MsgCallBack;

/**
 * Created by zhangweibo on 2015/11/20.
 */
public interface IRegisterByEmailModel {


    void signUpByEmial(String emial,String pwd,MsgCallBack callBack);

}
