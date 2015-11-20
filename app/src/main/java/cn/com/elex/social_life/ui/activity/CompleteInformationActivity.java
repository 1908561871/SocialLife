package cn.com.elex.social_life.ui.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.com.elex.social_life.R;
import cn.com.elex.social_life.support.util.ToastUtils;
import cn.com.elex.social_life.support.view.dialog.ActionSheetDialog;
import cn.com.elex.social_life.support.view.dialog.base.OnOperItemClickL;
import cn.com.elex.social_life.support.view.imageview.CircleImageView;
import cn.com.elex.social_life.ui.base.BaseActivity;

/**
 * Created by zhangweibo on 2015/11/19.
 * 完善资料
 */
public class CompleteInformationActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {


    @Bind(R.id.nickername)
    EditText nickername;
    @Bind(R.id.user_icon)
    CircleImageView userIcon;
    @Bind(R.id.radio_group)
    RadioGroup radioGroup;
    @Bind(R.id.mail)
    RadioButton mail;
    @Bind(R.id.femail)
    RadioButton femail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_info);
        ButterKnife.bind(this);
        setHeader(R.string.complete_information);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @OnClick(R.id.user_icon)
    public void choosePhoto() {
        final String[] stringItems = {"版本更新", "帮助与反馈", "退出QQ"};
        final ActionSheetDialog dialog = new ActionSheetDialog(this, stringItems, userIcon);
        dialog.isTitleShow(false).show();

        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToastUtils.show(stringItems[position]);
                dialog.dismiss();
            }
        });

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.mail) {
            mail.setBackground(getResources().getDrawable(R.drawable.circle_green));
            femail.setBackground(getResources().getDrawable(R.drawable.circle_gray));
        }else{
            mail.setBackground(getResources().getDrawable(R.drawable.circle_gray));
            femail.setBackground(getResources().getDrawable(R.drawable.circle_red));
        }
    }


}
