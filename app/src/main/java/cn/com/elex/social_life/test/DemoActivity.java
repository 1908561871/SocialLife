package cn.com.elex.social_life.test;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.elex.social_life.R;
import cn.com.elex.social_life.support.view.load.LoadViewHelper;
import cn.com.elex.social_life.ui.base.BaseActivity;

/**
 * Created by zhangweibo on 2015/11/6.
 */
public class DemoActivity extends BaseActivity {

    @Bind(R.id.bt_test)
    Button btTest;
    @Bind(R.id.content)
    LinearLayout content;
    LoadViewHelper helper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ButterKnife.bind(this);
        helper=new LoadViewHelper(content);
    }

    @OnClick({R.id.bt_test})
    public void click() {


    }

}
