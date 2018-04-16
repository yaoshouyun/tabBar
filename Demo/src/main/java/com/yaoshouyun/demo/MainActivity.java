package com.yaoshouyun.demo;

import android.support.v4.app.Fragment;
import android.util.Log;

import com.yaoshouyun.amanager.EventManager;
import com.yaoshouyun.aview.BaseActivity;
import com.yaoshouyun.tabbar.TabBar;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private TabBar tabBar;

    @Override
    public int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initUiAndListener() {
        final List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentA());
        fragments.add(new FragmentB());
        fragments.add(new FragmentC());
        fragments.add(new FragmentD());
        tabBar = findViewById(R.id.tabBar);
        tabBar.setOnTabBarListenter(new TabBar.OnTabBarListenter() {
            @Override
            public void onChange(int index) {
                Log.d("tabBar", "index=" + index);
//                Toast.makeText(MainActivity.this, "index=" + index, Toast.LENGTH_SHORT).show();
            }
        });
        tabBar.setFragments(fragments);
        EventManager.register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(String event) {
        Log.d("tabBar", "event");
    }

}
