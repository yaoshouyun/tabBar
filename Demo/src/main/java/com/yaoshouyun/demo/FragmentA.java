package com.yaoshouyun.demo;

import android.widget.Toast;

import com.yaoshouyun.aview.BaseFragment;

public class FragmentA extends BaseFragment {

    @Override
    public int layoutId() {
        return R.layout.frag_a;
    }

    @Override
    public void onPageStateChange(boolean isVisible, boolean isFirst) {
        super.onPageStateChange(isVisible, isFirst);
        Toast.makeText(getContext(), "A=" + isVisible + "，" + isFirst, Toast.LENGTH_SHORT).show();
    }

}
