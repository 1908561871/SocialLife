package cn.com.elex.social_life.support.util;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;

import cn.com.elex.social_life.sys.exception.GlobalApplication;

/**
 * Created by zhangweibo on 2015/11/13.
 */
public class BitmapUtil {


    public static Bitmap getBitmapEmojiFromAssert(String path) {

        AssetManager mngr = GlobalApplication.getInstance().getAssets();
        InputStream in = null;
        try {
            in = mngr.open("emoticons/" + path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Bitmap temp = BitmapFactory.decodeStream(in, null, null);
        return temp;
    }



}
