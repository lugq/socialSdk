package um.lugq.socialsdk;

/**
 * Description：
 * Creator: Created by peter.
 * Date: 2018/3/1.
 */

public interface SocialListener {

    void onSuccess(SocialUser user);

    void onFail(String error);

}
