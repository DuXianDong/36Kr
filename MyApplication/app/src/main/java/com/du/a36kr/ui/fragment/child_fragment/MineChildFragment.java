package com.du.a36kr.ui.fragment.child_fragment;

import android.os.Bundle;

import com.du.a36kr.R;
import com.du.a36kr.ui.fragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/28.
 *我的里的我的订单的二级界面里滑动的Fragment
 */
public class MineChildFragment extends AbsBaseFragment{
    public static MineChildFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MineChildFragment fragment = new MineChildFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_child_mine;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initData() {

    }
}
