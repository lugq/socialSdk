package um.lugq.socialsdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

/**
 * Description：利用友盟的分享面板
 * Creator: Created by peter.
 * Date: 2017/12/18.
 */

public class ShareHelper {

    /**
     * 检查分享的字段
     *
     * @param conver 预览图
     * @param target 链接地址
     * @param title  分享标题
     * @param des    描述
     * @return
     */
    private static boolean checkoutShareFiled(Context context, String conver, String target, String title, String des) {
        if (TextUtils.isEmpty(conver)) {
            Toast.makeText(context, "预览图不能为空!", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (TextUtils.isEmpty(conver)) {
            Toast.makeText(context, "链接地址不能为空!", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    /**
     * 视频分享
     */
    public static void shareVideo() {

    }

    /**
     * 音频分享
     */
    public static void shareAudio() {

    }

    /**
     * 链接分享
     *
     * @param activity .
     */
    public static void shareTarget(Activity activity, String conver, String target, String title, String des) {

        UMWeb umWeb = buildShareUmWeb(activity, conver, target, title, des);

        new ShareAction(activity)
                .withMedia(umWeb)
                .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE)
                //.setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE)
                .setCallback(new UMShareListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onResult(SHARE_MEDIA share_media) {
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media) {

                    }
                })
                .open();

    }

    /**
     * @param conver
     * @param target
     * @param title
     * @param des
     * @return
     */
    private static UMWeb buildShareUmWeb(Context context,String conver, String target, String title, String des) {
        UMWeb umWeb = new UMWeb(target);
        UMImage umImage;
        //设置预览图
        if (!TextUtils.isEmpty(conver)) {
            umImage = new UMImage(context, conver);
            umWeb.setThumb(umImage);
        }

        if (!TextUtils.isEmpty(title)) {
            umWeb.setTitle(title);
        }

        if (!TextUtils.isEmpty(des)) {
            umWeb.setDescription(des);
        }
        return umWeb;
    }

    private static boolean checkoutShareFiled() {
        return false;
    }
}
