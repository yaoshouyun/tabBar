package com.yaoshouyun.demo;

import android.widget.Toast;

import com.yaoshouyun.aview.BaseFragment;

public class FragmentD extends BaseFragment {

    @Override
    public int layoutId() {
        return R.layout.frag_d;
    }

    @Override
    public void onPageStateChange(boolean isVisible, boolean isFirst) {
        super.onPageStateChange(isVisible, isFirst);
        Toast.makeText(getContext(), "D=" + isVisible + "，" + isFirst, Toast.LENGTH_SHORT).show();
    }

}
