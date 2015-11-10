package cn.com.elex.social_life.presenter;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.SignUpCallback;

import cn.com.elex.social_life.sys.exception.CrashApplication;
import cn.com.elex.social_life.model.RegisterModel;
import cn.com.elex.social_life.model.imodel.IRegisterModel;
import cn.com.elex.social_life.ui.iview.IRegisterView;
import cn.com.elex.social_life.support.util.ToastUtils;

/**
 * Created by zhangweibo on 2015/11/2.
 */
public class RegisterPresenter {

    public IRegisterView iRegisterView;

    public IRegisterModel iRegisterModel;

    public RegisterPresenter(IRegisterView iRegisterView) {
        this.iRegisterView = iRegisterView;
        iRegisterModel=new RegisterModel();
    }



    public void signUp(String userName,String pwd,String confirmPwd){

        if (iRegisterModel.vertifyInfo(userName,pwd,confirmPwd)){
            iRegisterView.showLoadingView();

            iRegisterModel.signUp(userName, pwd, new SignUpCallback() {
                @Override
                public void done(AVException e) {
                    iRegisterView.hideLoadingView();
                    if (null==e){
                        ToastUtils.show(CrashApplication.getInstance(),"注册成功");
                    }else{
                        ToastUtils.show(CrashApplication.getInstance(),"注册失败");
                    }
                }
            });
        }else{
            ToastUtils.show(CrashApplication.getInstance(),"请输入正确的信息");
        }

    }










}
