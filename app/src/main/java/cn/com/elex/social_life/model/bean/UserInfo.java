package cn.com.elex.social_life.model.bean;

import com.avos.avoscloud.AVRelation;
import com.avos.avoscloud.AVUser;

import java.util.List;

/**
 * Created by zhangweibo on 2015/11/2.
 */

public class UserInfo extends AVUser{

    /**
     * 账号类型（QQ,wexin,sina,phone）
     */
    private String accountType;

    /**
     * 好友
     */
    private AVRelation<UserInfo> friends;

    public void setNickName(String name) {
        this.put("nickName", name);
    }

    public String getNickName() {
        return this.getString("nickName");
    }

    public String getAccountType() {
        return this.getString("accountType");
    }

    public void setAccountType(String accountType) {
        this.put("accountType", accountType);
    }
}
