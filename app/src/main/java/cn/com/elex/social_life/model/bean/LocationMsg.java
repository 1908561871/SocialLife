package cn.com.elex.social_life.model.bean;

/**
 * Created by zhangweibo on 2015/12/2.
 */
public class LocationMsg {

    private double lon;
    private double lat;
    private String addr;

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
