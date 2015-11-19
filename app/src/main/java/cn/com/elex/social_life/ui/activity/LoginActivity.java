package cn.com.elex.social_life.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.buraktamturk.loadingview.LoadingView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.elex.social_life.R;
import cn.com.elex.social_life.presenter.LoginPresenter;
import cn.com.elex.social_life.ui.base.BaseActivity;
import cn.com.elex.social_life.ui.iview.ILoginView;

/**
 * Created by zhangweibo on 2015/11/2.
 */
public class LoginActivity extends BaseActivity implements ILoginView {

    @Bind(R.id.et_username)
    EditText et_username;
    @Bind(R.id.et_userpwd)
    EditText et_userpwd;
    @Bind(R.id.loadingview)
    LoadingView loadingview;
    @Bind(R.id.tv_forgetpwd)
    TextView tv_forgetpwd;
    @Bind(R.id.tv_fastlogin)
    TextView tv_fastlogin;
    LoginPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter=new LoginPresenter(this);

        setHeader(true, getResources().getString(R.string.login), getResources().getString(R.string.register), new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.goToSignUp();
            }
        });
    }


    @Override
    public String getUserName() {
        return et_username.getText().toString().trim();
    }

    @Override
    public String getUserPwd() {
        return et_userpwd.getText().toString().trim();
    }

    @Override
    public void showLoadView() {
        loadingview.setLoading(true);
    }

    @Override
    public void hideLoadView() {
        loadingview.setLoading(false);
    }

    @OnClick({R.id.btn_login, R.id.tv_forgetpwd,R.id.tv_fastlogin})
    public void click(View view) {

        switch (view.getId()){
            case R.id.btn_login:
                presenter.login(getUserName(),getUserPwd());
                break;

        }
    }

}
