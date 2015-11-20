package cn.com.elex.social_life.model;

import android.content.Context;
import android.content.Intent;

import cn.com.elex.social_life.cloud.data.DataStorage;
import cn.com.elex.social_life.model.imodel.IRegisterByEmailModel;
import cn.com.elex.social_life.support.callback.MsgCallBack;
import cn.com.elex.social_life.sys.exception.GlobalApplication;
import cn.com.elex.social_life.ui.activity.RegisterByEmailActivity;

/**
 * Created by zhangweibo on 2015/11/20.
 */
public class RegisterByEmialModel  implements IRegisterByEmailModel{

    @Override
    public void signUpByEmial(String emial, String pwd,MsgCallBack callBack) {
        DataStorage.signUpByEmail(emial,pwd,callBack);
    }
}
