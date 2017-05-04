package com.hedan.basedialoglibrary;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

/**
 * Created by DengXiao on 2017/4/13.
 */

public class BaseDialog extends Dialog {
    private Context mContext;
    private int mHeight, mWidth, mGravity;
    private boolean mOnTouchCanceled;
    private View mView;
    private int mStyleAnimation;
    private int mPaddingLeft, mPaddingTop, mPaddingRight, mPaddingBotton;

    public BaseDialog(Builder builder) {
        super(builder.bContext);
    }

    public BaseDialog(Builder builder, int themeResId) {
        super(builder.bContext, themeResId);
        mContext = builder.bContext;
        mHeight = builder.bHeight;
        mWidth = builder.bWidth;
        mView = builder.bView;
        mGravity = builder.bGravity;
        mStyleAnimation = builder.bStyleAnimation;
        mOnTouchCanceled = builder.bOnTouchCanceled;
        mPaddingLeft = builder.bPaddingLeft;
        mPaddingTop = builder.bPaddingTop;
        mPaddingRight = builder.bPaddingRight;
        mPaddingBotton = builder.bPaddingBotton;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mView);
        setCanceledOnTouchOutside(mOnTouchCanceled);
        Window window = getWindow();
        if (mPaddingLeft != -11111) {
            window.getDecorView().setPadding(mPaddingLeft, mPaddingTop, mPaddingRight, mPaddingBotton);
        }
        if (mStyleAnimation != -11111) {
            window.setWindowAnimations(mStyleAnimation);
        }
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.gravity = mGravity != -11111 ? mGravity : Gravity.CENTER;
        layoutParams.width = mWidth != -11111 ? mWidth : LinearLayout.LayoutParams.WRAP_CONTENT;
        layoutParams.height = mHeight != -11111 ? mHeight : LinearLayout.LayoutParams.WRAP_CONTENT;
        window.setAttributes(layoutParams);
    }

    public static final class Builder {
        private Context bContext;
        private int bHeight = -11111, bWidth = -11111;
        private int bGravity = -11111;
        private boolean bOnTouchCanceled;
        private View bView;
        private int bThemeResId = R.style.dialog_style;
        private int bStyleAnimation = -11111;
        private int bPaddingLeft = -11111, bPaddingTop, bPaddingRight, bPaddingBotton;

        public Builder(Context mContext) {
            this.bContext = mContext;
        }

        public Builder setViewId(int viewId) {
            this.bView = LayoutInflater.from(bContext).inflate(viewId, null);
            return this;
        }

        public Builder setWidthHeightpx(int whidth, int height) {
            this.bWidth = whidth;
            this.bHeight = height;
            return this;
        }

        public Builder setWidthHeightdp(int whidth, int height) {
            this.bWidth = dip2px(bContext, whidth);
            this.bHeight = dip2px(bContext, height);
            return this;
        }


        public Builder setHeightpx(int height) {
            this.bHeight = height;
            return this;
        }

        public Builder setHeightdp(int height) {
            this.bHeight = dip2px(bContext, height);
            return this;
        }

        public Builder setWidthpx(int whidth) {
            this.bWidth = whidth;
            return this;
        }

        public Builder setWidthdp(int whidth) {
            this.bWidth = dip2px(bContext, whidth);
            return this;
        }

        public Builder isOnTouchCanceled(boolean var) {
            this.bOnTouchCanceled = var;
            return this;
        }

        public Builder addViewOnClickListener(int viewId, View.OnClickListener listener) {
            this.bView.findViewById(viewId).setOnClickListener(listener);
            return this;
        }

        public Builder setStyle(int themeResId) {
            this.bThemeResId = themeResId;
            return this;
        }

        public Builder setGravity(int gravity) {
            this.bGravity = gravity;
            return this;
        }

        public Builder setAnimation(int styleAnimation) {
            this.bStyleAnimation = styleAnimation;
            return this;
        }

        public Builder setPaddingdp(int paddingLeft, int paddingTop, int paddingRight, int paddingBotton) {
            this.bPaddingLeft = dip2px(bContext, paddingLeft);
            this.bPaddingTop = dip2px(bContext, paddingTop);
            this.bPaddingRight = dip2px(bContext, paddingRight);
            this.bPaddingBotton = dip2px(bContext, paddingBotton);
            return this;
        }

        public Builder setPaddingpx(int paddingLeft, int paddingTop, int paddingRight, int paddingBotton) {
            this.bPaddingLeft = paddingLeft;
            this.bPaddingTop = paddingTop;
            this.bPaddingRight = paddingRight;
            this.bPaddingBotton = paddingBotton;
            return this;
        }

        public BaseDialog builder() {
            return new BaseDialog(this, bThemeResId);
        }
    }

    public void close() {
        if (!((Activity) mContext).isFinishing()) {
            ((Activity) mContext).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (isShowing()) {
                        dismiss();
                    }
                }
            });
        }
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public  <T extends View> T getView(int resId) {
        if(mView!=null){
            return (T) mView.findViewById(resId);
        }
        return null;
    }
}
