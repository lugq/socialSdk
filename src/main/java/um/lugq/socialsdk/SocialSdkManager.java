package um.lugq.socialsdk;

import android.app.Application;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Description：
 * Creator: Created by peter.
 * Date: 2018/3/1.
 */

public class SocialSdkManager {

    /**
     * 社会化组件初始化
     * @param app Application
     * @param SinaWeibo_ID 新浪微博的ID
     * @param SinaWeibo_KEY 新浪微博KEY
     * @param SinaWeibo_CallBackUrl 新浪微博回调地址
     * @param WX_ID 微信ID
     * @param WX_KEY 微信KEY
     * @param QQZone_ID QQ ID
     * @param QQZone_KEY QQ KEY
     * @param DEBUG 默认为false
     */
    public static void init(Application app,
                            String SinaWeibo_ID, String SinaWeibo_KEY, String SinaWeibo_CallBackUrl,
                            String WX_ID, String WX_KEY,
                            String QQZone_ID, String QQZone_KEY,
                            boolean DEBUG) {
        PlatformConfig.setSinaWeibo(SinaWeibo_ID, SinaWeibo_KEY, SinaWeibo_CallBackUrl);
        PlatformConfig.setWeixin(WX_ID, WX_KEY);
        PlatformConfig.setQQZone(QQZone_ID, QQZone_KEY);

        Config.DEBUG = DEBUG;
        UMShareAPI.get(app);
    }


}
