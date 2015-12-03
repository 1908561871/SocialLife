package cn.com.elex.social_life.model.bean;

import android.os.Parcel;

import com.avos.avoscloud.AVClassName;
import com.avos.avoscloud.AVObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangweibo on 2015/12/3.
 */
@AVClassName("PublishLogBean")
public class PublishLogBean extends AVObject{

    //此处为我们的默认实现，当然你也可以自行实现
    public static final Creator CREATOR = AVObjectCreator.instance;
    private String title;

    private String content;

    private double lat;

    private double lon;

    private String addr;

    private String userName;

    private ArrayList<String> imageUrls;


    public PublishLogBean(){
    }

    public PublishLogBean(Parcel in){
        super(in);
    }

    public String getUserName() {
        return  getString("userName");
    }

    public void setUserName(String userName) {
        put("userName", userName);

    }

    public String getTitle() {
        return  getString("title");
    }

    public void setTitle(String title) {
        put("title", title);
    }

    public String getContent() {
        return  getString("content");
    }

    public void setContent(String content) {
        put("content", content);
    }

    public double getLat() {
        return  getDouble("lat");
    }

    public void setLat(double lat) {
        put("lat", lat);
    }

    public double getLon() {
        return  getDouble("lon");
    }

    public void setLon(double lon) {
        put("lon", lon);
    }

    public String getAddr() {
        return  getString("addr");
    }

    public void setAddr(String addr) {
        put("addr", addr);
    }

    public ArrayList<String> getImageUrls() {
        return (ArrayList<String>) getList("imageUrls");
    }

    public void setImageUrls(ArrayList<String> imageUrls) {
        put("imageUrls", imageUrls);
    }
}
