package cn.com.elex.social_life.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVFile;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.SaveCallback;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import cn.com.elex.social_life.model.bean.PublishLogBean;
import cn.com.elex.social_life.model.imodel.IPublishLogModel;
import cn.com.elex.social_life.support.callback.CustomSaveCallBack;
import cn.com.elex.social_life.support.util.TimeUtils;
import cn.com.elex.social_life.support.util.ToastUtils;
import me.nereo.multi_image_selector.MultiImageSelectorActivity;

/**
 * Created by zhangweibo on 2015/12/1.
 */
public class PublishLogModel implements  IPublishLogModel {


    private final int REQUEST_IMAGE=1;

    @Override
    public void selectPhoto(Activity context, ArrayList<String> mSelectPath,int count) {
        Intent intent = new Intent(context, MultiImageSelectorActivity.class);
        // 是否显示拍摄图片
        intent.putExtra(MultiImageSelectorActivity.EXTRA_SHOW_CAMERA, true);
        // 最大可选择图片数量
        intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_COUNT, count);
        // 选择模式
        intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_MODE, MultiImageSelectorActivity.MODE_MULTI);
      /*  // 默认选择
        if(mSelectPath != null && mSelectPath.size()>0){
            intent.putExtra(MultiImageSelectorActivity.EXTRA_DEFAULT_SELECTED_LIST, mSelectPath);
        }*/
        context.startActivityForResult(intent, REQUEST_IMAGE);
    }

    @Override
    public void commitData(final PublishLogBean data, final CustomSaveCallBack callback) {
        final ArrayList<AVFile> files=new ArrayList<AVFile>();
        AVFile file = null;
        for (int i = 0; i < data.getImageUrls().size(); i++) {
            try {
                file=AVFile.withFile((System.currentTimeMillis()+i)+"",new File(data.getImageUrls().get(i)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            files.add(file);
        }
        if (files.size()>0){
            try {
                AVObject.saveFileBeforeSave(files, false, new CustomSaveCallBack() {
                    @Override
                    public void success() {
                        data.setImageUrls(getImageUrl(files));
                        data.saveInBackground(callback);
                    }
                    @Override
                    public void failure(String error) {
                        callback.failure(error);
                    }
                });
            } catch (AVException e) {
                e.printStackTrace();
            }
        }else{
            data.saveInBackground(callback);
        }

    }


    public ArrayList<String> getImageUrl(ArrayList<AVFile> files){

        ArrayList<String> paths=new ArrayList<String>();

        for (int i = 0; i < files.size(); i++) {
            String path=files.get(i).getUrl();
            paths.add(path);
        }
        return  paths;
    }





}
