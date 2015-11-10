package cn.com.elex.social_life.ui.activity;

import android.os.Bundle;
import android.widget.EditText;

import org.buraktamturk.loadingview.LoadingView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.elex.social_life.R;
import cn.com.elex.social_life.presenter.RegisterPresenter;
import cn.com.elex.social_life.ui.base.BaseActivity;
import cn.com.elex.social_life.ui.iview.IRegisterView;


/**
 * Created by zhangweibo on 2015/11/2.
 * 注册
 */
public class RegisterActivity extends BaseActivity implements IRegisterView {

    @Bind(R.id.et_pwd)
    EditText et_pwd;
    @Bind(R.id.et_confirm_pwd)
    EditText et_confirm_pwd;
    @Bind(R.id.et_username)
    EditText et_username;
    private RegisterPresenter presenter;
    @Bind(R.id.loadingview)
    LoadingView loadingView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        presenter=new RegisterPresenter(this);
        setHeader(true,getResources().getString(R.string.register));
    }


    @Override
    public String getUserName() {
        return et_username.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return et_pwd.getText().toString().trim();
    }

    @Override
    public String getConfirmPwd() {
        return et_confirm_pwd.getText().toString().trim();
    }

    @Override
    public void showLoadingView() {
        loadingView.setLoading(true);
    }

    @Override
    public void hideLoadingView() {
        loadingView.setLoading(false);
    }

    @OnClick(R.id.btn_register)
    public void signUp(){
       presenter.signUp(getUserName(),getPwd(),getConfirmPwd());

   }




}
