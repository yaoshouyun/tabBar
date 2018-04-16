package com.yaoshouyun.tabbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

public class TabBar extends LinearLayout {

    private int defaultColor = Color.BLACK;//默认字体颜色
    private int selectedColor = Color.BLACK;//选中字体颜色
    private String[] tabNames;//Tab标题
    private int[] defaultIcons;//Tab未选中图标样式
    private int[] selectedIcons;//Tab选中图标样式

    private RadioGroup radioGroup;
    private FragmentActivity activity;

    public TabBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TabBar);
        defaultColor = a.getColor(R.styleable.TabBar_defaultColor, defaultColor);
        selectedColor = a.getColor(R.styleable.TabBar_selectedColor, selectedColor);
        tabNames = getResources().getStringArray(a.getResourceId(R.styleable.TabBar_tabNames, 0));
        defaultIcons = getIdsArray(a.getResourceId(R.styleable.TabBar_defaultIcons, 0));
        selectedIcons = getIdsArray(a.getResourceId(R.styleable.TabBar_selectedIcons, 0));
        a.recycle();
        View.inflate(getContext(), R.layout.tabbar, this);
        radioGroup = findViewById(R.id.radioGroup);
        activity = (FragmentActivity) getContext();

        if (tabNames.length != defaultIcons.length || tabNames.length != selectedIcons.length) {
            throw new RuntimeException("资源数量不匹配！");
        }

        ColorStateList colorStateList = new ColorStateList(new int[][]{
                {android.R.attr.state_checked},
                {}
        }, new int[]{selectedColor, defaultColor});
        int width = getScreenWidth() / tabNames.length;
        for (int i = 0; i < tabNames.length; i++) {
            RadioButton radio = new RadioButton(getContext());
            radio.setId(i);
            radio.setText(tabNames[i]);
            radio.setTextSize(12);
            radio.setTextColor(colorStateList);
            radio.setGravity(Gravity.CENTER);
            radio.setButtonDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
            StateListDrawable topDrawable = new StateListDrawable();
            topDrawable.addState(new int[]{android.R.attr.state_checked}, getResources().getDrawable(selectedIcons[i]));
            topDrawable.addState(new int[]{}, getResources().getDrawable(defaultIcons[i]));
            topDrawable.setBounds(0, 0, topDrawable.getMinimumWidth(), topDrawable.getMinimumHeight());
            radio.setCompoundDrawables(null, topDrawable, null, null);
            radio.setPadding(dp2px(5), dp2px(5), dp2px(5), dp2px(5));
            radioGroup.addView(radio, width, ViewGroup.LayoutParams.MATCH_PARENT);
        }
    }

    private int[] getIdsArray(int resId) {
        TypedArray arrays = getResources().obtainTypedArray(resId);
        int len = arrays.length();
        int[] ids = new int[len];
        for (int i = 0; i < len; i++) {
            ids[i] = arrays.getResourceId(i, 0);
        }
        return ids;
    }

    private int getScreenWidth() {
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

    private int dp2px(double dpValue) {
        return (int) Math.ceil(dpValue * getContext().getResources().getDisplayMetrics().density);
    }

    public void setFragments(final List<Fragment> fragments) {
        if (radioGroup.getChildCount() != fragments.size()) {
            throw new RuntimeException("资源数量不匹配！");
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, fragments.get(checkedId)).commit();
            }
        });
        radioGroup.check(0);
    }

}