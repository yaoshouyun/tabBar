package com.yaoshouyun.demo;

import android.widget.Toast;

import com.yaoshouyun.aview.BaseFragment;

public class FragmentB extends BaseFragment {

    @Override
    public int layoutId() {
        return R.layout.frag_b;
    }

    @Override
    public void onPageStateChange(boolean isVisible, boolean isFirst) {
        super.onPageStateChange(isVisible, isFirst);
        Toast.makeText(getContext(), "B=" + isVisible + "，" + isFirst, Toast.LENGTH_SHORT).show();
    }

}
