package com.hedan.custombasedialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hedan.basedialoglibrary.BaseDialog;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bottom = (Button) findViewById(R.id.bottom_top);
        Button top = (Button) findViewById(R.id.top_bottom);
        Button left = (Button) findViewById(R.id.left_right);
        Button right = (Button) findViewById(R.id.right_left);
        Button center = (Button) findViewById(R.id.center);
        Button center1 = (Button) findViewById(R.id.center1);
        bottom.setOnClickListener(this);
        top.setOnClickListener(this);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
        center.setOnClickListener(this);
        center1.setOnClickListener(this);
    }
    private void showDialog(int grary, int animationStyle) {
        BaseDialog.Builder builder = new BaseDialog.Builder(this);
        final BaseDialog dialog = builder.setViewId(R.layout.photo_choose_dialog)
                .setPaddingdp(10, 0, 10, 0)
                .setGravity(grary)
                .setAnimation(animationStyle)
                .setWidthHeightpx(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                .isOnTouchCanceled(true)
                .addViewOnClickListener(R.id.but_choose_one, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"相册", Toast.LENGTH_SHORT).show();
                    }
                })
                .builder();
        dialog.show();

        Button button = dialog.getView(R.id.but_choose_three);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.close();
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bottom_top:
                showDialog(Gravity.BOTTOM, R.style.Bottom_Top_aniamtion);
                break;
            case R.id.top_bottom:
                showDialog(Gravity.TOP, R.style.Top_Bottom_aniamtion);
                break;
            case R.id.left_right:
                showDialog(Gravity.CENTER, R.style.Left_Right_aniamtion);
                break;
            case R.id.right_left:
                showDialog(Gravity.CENTER, R.style.Right_Left_aniamtion);
                break;
            case R.id.center:
                showDialog(Gravity.CENTER, R.style.Alpah_aniamtion);
                break;
            case R.id.center1:
                showDialog(Gravity.CENTER, R.style.Scale_aniamtion);
                break;
        }
    }

}
