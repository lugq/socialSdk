package um.lugq.socialsdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

/**
 * 不使用友盟的分享面板
 */
public class ShareHelper2 {

    /**
     * 生成 UMWeb
     * @param conver 缩略图
     * @param target 分享的链接
     * @param title 标题
     * @param des 描述
     */
    public static void share(Activity context, SHARE_MEDIA platform, String conver, String target, String title, String des) {

        UMWeb umWeb = buildShareUmWeb(context, conver, target, title, des);

        new ShareAction(context).setPlatform(platform)
                .withMedia(umWeb)
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
                }).share();
    }

    /**
     * 生成 UMWeb
     * @param conver 缩略图
     * @param target 分享的链接
     * @param title 标题
     * @param des 描述
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
}
