package com.yaoshouyun.demo;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.yaoshouyun.amanager.EventManager;
import com.yaoshouyun.aview.BaseActivity;
import com.yaoshouyun.tabbar.TabBar;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    @Override
    public int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initUiAndListener() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentA());
        fragments.add(new FragmentB());
        fragments.add(new FragmentC());
        fragments.add(new FragmentD());
        TabBar tabBar = findViewById(R.id.tabBar);
        tabBar.setFragments(fragments);
        EventManager.register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(String event) {
        Toast.makeText(this, event, Toast.LENGTH_SHORT).show();
    }

}
