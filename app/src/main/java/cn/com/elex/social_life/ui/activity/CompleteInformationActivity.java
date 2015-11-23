package cn.com.elex.social_life.ui.activity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
import cn.com.elex.social_life.support.util.MemoryControl;
import cn.com.elex.social_life.support.util.ToastUtils;
import cn.com.elex.social_life.support.view.dialog.ActionSheetDialog;
import cn.com.elex.social_life.support.view.dialog.base.OnOperItemClickL;
import cn.com.elex.social_life.support.view.imageview.CircleImageView;
import cn.com.elex.social_life.sys.exception.GlobalApplication;
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
    private static final int PICKER = 1;
    private static final int CROP = 2;
    private static final int TAKE_PHOTO = 3;

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
        final String[] stringItems = {"相册", "拍照"};
        final ActionSheetDialog dialog = new ActionSheetDialog(this, stringItems, userIcon);
        dialog.isTitleShow(false).show();

        dialog.setOnOperItemClickL(new OnOperItemClickL() {
            @Override
            public void onOperItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    chooseHeadIcon();
                } else if (position == 1) {
                    takePhotos();
                }
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

    public void chooseHeadIcon()
    {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICKER);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK)
        {
            if (requestCode==PICKER){
                if (data.getData()!=null){
                    startActivityForResult(new Intent(this,CropActivity.class).putExtra("uri",data.getData()),CROP);
                }
            }else if (requestCode==TAKE_PHOTO){
                startActivityForResult(new Intent(this,CropActivity.class).putExtra("uri",Uri.parse(MemoryControl.getTempImagePath())),CROP);
            }else if(requestCode==CROP){
                userIcon.setImageBitmap(GlobalApplication.getInstance().tempBitmap);
            }
        }
    }

    public void takePhotos(){

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//action is capture

        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.parse(MemoryControl.getTempImagePath()));

        startActivityForResult(intent, TAKE_PHOTO);
    }



    @Override
    protected void onDestroy() {
        GlobalApplication.getInstance().recycleBitmap();
        super.onDestroy();
    }






}
