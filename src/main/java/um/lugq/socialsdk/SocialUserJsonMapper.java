package um.lugq.socialsdk;

/**
 * Description：
 * Creator: Created by peter.
 * Date: 2018/3/1.
 */

public class SocialUserJsonMapper {
    // 转换类使用单例模式
    private static SocialUserJsonMapper instance = null;

    private SocialUserJsonMapper(){}

    public static SocialUserJsonMapper newInstance(){
        if(null == instance){
            instance = new SocialUserJsonMapper();
        }
        return instance;
    }

    public SocialUser transform(BackDataEntity data) {
        SocialUser user = null;
        if (data != null) {
            user = new SocialUser();
            user.setUserName(data.getScreen_name());
            user.setOpenid(data.getOpenid());
            user.setUid(data.getUid());
            user.setIconurl(data.getIconurl());
            user.setGender(data.getGender());
            user.setAvatar_hd(data.getAvatar_hd());
        }
        return user;
    }
}
