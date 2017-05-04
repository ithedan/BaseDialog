######先看效果

![dialog.gif](http://upload-images.jianshu.io/upload_images/3523210-190bc08bf2472db1.gif?imageMogr2/auto-orient/strip)
####使用方法：
####AndroidStudio引入（https://jitpack.io/）
#####step1:Add it in your root build.gradle at the end of repositories:
````
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
````
#####step2:Add the dependency
````
dependencies {
	         compile 'com.github.ithedan:BaseDialog:1.0'
	}
````
#####Activity中使用：
````
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
                .setPaddingdp(10, 0, 10, 0)//设置dialogpadding
                .setGravity(grary)//设置显示位置
                .setAnimation(animationStyle)//设置动画
                .setWidthHeightpx(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)//设置dialog的宽高
                .isOnTouchCanceled(true)//设置触摸dialog外围是否关闭dialog
                .addViewOnClickListener(R.id.but_choose_one, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,"相册", Toast.LENGTH_SHORT).show();
                    }
                })//设置监听事件
                .builder();
        dialog.show();

        Button button = dialog.getView(R.id.but_choose_three);//根据id获取dialog中的恐惧
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.close();
            }
        });//关闭dialog
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
````
######在BaseDialog:1.0中默认定义了以上六种动画效果，如果达不到项目要求可以根据自己的需求在style中自己定义，调用builder.setAnimation(int styleAnimation) 即可，dialog中默认的styles是：
````
<!--dialog style属性-->
    <style name="dialog_style" parent="@android:style/Theme.Dialog">
        <!--//Dialog的windowFrame框为无-->
        <item name="android:windowFrame">@null</item>
        <!--//是否浮现在activity之上-->
        <item name="android:windowIsFloating">true</item>
        <!--//是否半透明-->
        <item name="android:windowIsTranslucent">true</item>
        <!--//是否显示title-->
        <item name="android:windowNoTitle">true</item>
        <!--//设置dialog的背景-->
        <item name="android:background">@android:color/transparent</item>
        <!--//显示区域背景是否透明-->
        <item name="android:windowBackground">@android:color/transparent</item>
        <!--//就是用来控制灰度的值，当为1时，界面除了我们的dialog内容是高亮显示的，dialog以外的区域是黑色的，完全看不到其他内容，系统的默认值是0.5-->
        <item name="android:backgroundDimAmount">0.5</item>
        <!--//显示区域以外是否使用黑色半透明背景-->
        <item name="android:backgroundDimEnabled">true</item>
    </style>
````
######如果不符合要求可以调用builder.setStyle(int themeResId)设置自己的style;
######dialog封装主要是为了项目中有多个dialog，不需要每个自定义dialog都要重写，有一个BaseDialog就够用了，如有什么问题，敬请提出，十分感谢！希望越来越好，谢谢！如果喜欢，还请点击start，喜欢支持一下了，谢谢O(∩_∩)O~
