package cn.com.elex.social_life.model.imodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

import me.nereo.multi_image_selector.MultiImageSelectorActivity;

/**
 * Created by zhangweibo on 2015/12/1.
 */
public class PublishLogModel implements  IPublishLogModel {


    private final int REQUEST_IMAGE=1;

    @Override
    public void selectPhoto(Activity context, ArrayList<String> mSelectPath) {
        Intent intent = new Intent(context, MultiImageSelectorActivity.class);
        // 是否显示拍摄图片
        intent.putExtra(MultiImageSelectorActivity.EXTRA_SHOW_CAMERA, true);
        // 最大可选择图片数量
        intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_COUNT, 9);
        // 选择模式
        intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_MODE, MultiImageSelectorActivity.MODE_MULTI);
        // 默认选择
        if(mSelectPath != null && mSelectPath.size()>0){
            intent.putExtra(MultiImageSelectorActivity.EXTRA_DEFAULT_SELECTED_LIST, mSelectPath);
        }
        context.startActivityForResult(intent, REQUEST_IMAGE);
    }


    @Override
    public void dealWithResult(int requestCode, int resultCode, Intent data) {





    }
}
