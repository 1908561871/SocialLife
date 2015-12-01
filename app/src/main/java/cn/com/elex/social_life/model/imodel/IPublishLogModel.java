package cn.com.elex.social_life.model.imodel;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;

/**
 * Created by zhangweibo on 2015/12/1.
 */
public interface IPublishLogModel {

     void selectPhoto(Activity context, ArrayList<String> mSelectPath);


    void dealWithResult(int requestCode, int resultCode, Intent data);

}
