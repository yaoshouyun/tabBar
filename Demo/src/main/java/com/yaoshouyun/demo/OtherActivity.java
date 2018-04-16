package com.yaoshouyun.demo;

import android.view.View;

import com.yaoshouyun.amanager.EventManager;
import com.yaoshouyun.aview.BaseActivity;

public class OtherActivity extends BaseActivity {

    @Override
    public int layoutId() {
        return R.layout.activity_other;
    }

    @Override
    public void initUiAndListener() {
        getContentView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventManager.post("OtherActivity");
            }
        });
    }

}
