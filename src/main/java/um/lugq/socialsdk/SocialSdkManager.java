package um.lugq.socialsdk;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

/**
 * Description：
 * Creator: Created by peter.
 * Date: 2018/3/1.
 */

public class SocialSdkManager {
    private static final String TAG = SocialSdkManager.class.getSimpleName();

    /**
     * 社会化组件初始化
     *
     * @param app                   Application
     * @param SinaWeibo_ID          新浪微博的ID
     * @param SinaWeibo_KEY         新浪微博KEY
     * @param SinaWeibo_CallBackUrl 新浪微博回调地址
     * @param WX_ID                 微信ID
     * @param WX_KEY                微信KEY
     * @param QQZone_ID             QQ ID
     * @param QQZone_KEY            QQ KEY
     * @param DEBUG                 默认为false
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

    /**
     * 微信登录
     */
    public static void loginWX(Activity context, SocialListener socialListener) {
        mSocialListener = socialListener;
        UMShareAPI.get(context).getPlatformInfo(context, SHARE_MEDIA.WEIXIN, authListener);
    }

    private static SocialListener mSocialListener;

    /**
     * 微博登录
     */
    public static void loginSina(Activity context, SocialListener socialListener) {
        mSocialListener = socialListener;
        UMShareAPI.get(context).getPlatformInfo(context, SHARE_MEDIA.SINA, authListener);
    }

    /**
     * QQ登录
     */
    public static void loginQQ(Activity context) {
        UMShareAPI.get(context).getPlatformInfo(context, SHARE_MEDIA.QQ, authListener);
    }

    private static UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            //Toast.makeText(mContext, "成功了", Toast.LENGTH_LONG).show();
            if (data != null) {
                String json = GsonUtil.GsonString(data);
                try {
                    if (json != null) {
                        BackDataEntity entity = GsonUtil.GsonToBean(json, BackDataEntity.class);
                        if (entity != null) {
                            SocialUser user = SocialUserJsonMapper.newInstance().transform(entity);
                            if (mSocialListener != null) {
                                mSocialListener.onSuccess(user);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Log.i(TAG, json);
            }
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            //Toast.makeText(mContext, "失败：" + t.getMessage(),                                  Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            //Toast.makeText(mContext, "取消了", Toast.LENGTH_LONG).show();
        }
    };
}
