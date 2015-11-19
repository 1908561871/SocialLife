package cn.com.elex.social_life.ui.activity;

import android.os.Bundle;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.com.elex.social_life.R;
import cn.com.elex.social_life.support.view.EditTextWithDeleteButton;
import cn.com.elex.social_life.ui.base.BaseActivity;

/**
 * Created by zhangweibo on 2015/11/19.
 */
public class RegisterByEmailActivity extends BaseActivity {


    @Bind(R.id.et_email)
    EditTextWithDeleteButton email;
    @Bind(R.id.et_pwd)
    EditTextWithDeleteButton password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_by_email);
        ButterKnife.bind(this);
    }







}
