package cn.com.elex.social_life.bean;


import cn.com.elex.social_life.R;
import cn.com.elex.social_life.mvp.view.fragment.FindTabFragment;
import cn.com.elex.social_life.mvp.view.fragment.HomeTabFragment;
import cn.com.elex.social_life.mvp.view.fragment.MessageTabFragment;
import cn.com.elex.social_life.mvp.view.fragment.MineTabFragment;


/**
 * Created by zhangweibo on 2015/8/8.
 */
public enum  MainTab {
    //首页;
    HOME(R.mipmap.main_tab_home,R.string.home,0,0, HomeTabFragment.class,R.drawable.btn_tab_home),
    //消息
    MESSAGE(R.mipmap.main_tab_msg,R.string.message,1,1, MessageTabFragment.class,R.drawable.btn_tab_msg),
    //发现
    FIND(R.mipmap.main_tab_find,R.string.find,3,3, FindTabFragment.class,R.drawable.btn_tab_find),
    //我的
    MINE(R.mipmap.main_tab_mine,R.string.mine,4,4, MineTabFragment.class,R.drawable.btn_tab_mine);

    //图标
    private int icon;
    //标题
    private int title;
    //索引
    private int index;
    //浮标
    private int  View;

    private int drawable;
    private Class<?> clz;

    MainTab(int icon, int title, int index, int view, Class<?> clz, int drawable) {
        this.icon = icon;
        this.title = title;
        this.index = index;
        View = view;
        this.drawable = drawable;
        this.clz = clz;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getView() {
        return View;
    }

    public void setView(int view) {
        View = view;
    }

    public Class<?> getClz() {
        return clz;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }
}
