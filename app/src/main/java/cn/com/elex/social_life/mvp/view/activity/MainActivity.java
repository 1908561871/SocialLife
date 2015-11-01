package cn.com.elex.social_life.mvp.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.com.elex.social_life.R;
import cn.com.elex.social_life.app.BaseActivity;

/**
 * Created by Administrator on 2015/10/30.
 */
public class MainActivity extends BaseActivity {

    @Bind(R.id.sdv_loadingview)
     SimpleDraweeView sdv_loadingview;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sdv_loadingview.setImageURI(Uri.parse("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1205/02/c0/11459868_1335958865509.jpg"));
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                goToMainTabActivity();

            }
        }, 3000);
    }

    public void goToMainTabActivity(){

        Intent intent=new Intent(this,MainTabTabActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }



}
