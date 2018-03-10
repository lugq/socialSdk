package um.lugq.socialsdk;

import com.umeng.socialize.bean.SHARE_MEDIA;

/**
 * Description：
 * Creator: Created by peter.
 * Date: 2018/3/1.
 */

public interface SocialListener {

    void onSuccess(SocialUser user, SHARE_MEDIA platform);

    void onFail(String error);

}
