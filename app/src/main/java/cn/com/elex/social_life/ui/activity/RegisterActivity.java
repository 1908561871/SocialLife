package cn.com.elex.social_life.ui.activity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import org.buraktamturk.loadingview.LoadingView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.elex.social_life.R;
import cn.com.elex.social_life.presenter.RegisterPresenter;
import cn.com.elex.social_life.support.view.EditTextWithDeleteButton;
import cn.com.elex.social_life.ui.base.BaseActivity;
import cn.com.elex.social_life.ui.iview.IRegisterView;


/**
 * Created by zhangweibo on 2015/11/2.
 * 注册
 */
public class RegisterActivity extends BaseActivity implements IRegisterView {


    @Bind(R.id.et_phone)
    EditTextWithDeleteButton phoneNum;
    @Bind(R.id.et_pwd)
    EditTextWithDeleteButton userPwd;
    @Bind(R.id.et_code)
    EditTextWithDeleteButton code;
    @Bind(R.id.tv_obtain_code)
    TextView obtainCode;
    private RegisterPresenter presenter;
    @Bind(R.id.loadingview)
    LoadingView loadingView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        presenter = new RegisterPresenter(this);
        setHeader(true, getResources().getString(R.string.register));
        resetCodeHeight();
    }


    @Override
    public String getPhoneNum() {
        return phoneNum.getText();
    }

    @Override
    public String getPwd() {
        return userPwd.getText();
    }

    @Override
    public String getCode() {
        return code.getText();
    }

    @Override
    public void showLoadingView() {
        loadingView.setLoading(true);
    }

    @Override
    public void hideLoadingView() {
        loadingView.setLoading(false);
    }

    public void signUp() {
        presenter.signUp(getPhoneNum(), getPwd(), getCode());

    }

    public void resetCodeHeight(){
        obtainCode.measure(0, 0);
        ViewGroup.MarginLayoutParams params= (ViewGroup.MarginLayoutParams) obtainCode.getLayoutParams();
        params.width=obtainCode.getMeasuredWidth();
        obtainCode.setLayoutParams(params);
    }


    @OnClick(R.id.tv_obtain_code)
    public void obtainCode(){

    }

}
