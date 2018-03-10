package um.lugq.socialsdk;

/**
 * Description：
 * Creator: Created by peter.
 * Date: 2018/3/1.
 */

public class SocialUser {
    private String userName;
    private String openid;
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
