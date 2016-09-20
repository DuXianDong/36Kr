package com.du.a36kr.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.du.a36kr.R;
import com.du.a36kr.ui.adapter.MessageAdapter;
import com.du.a36kr.ui.fragment.child_fragment.LoginFragment;
import com.du.a36kr.ui.fragment.child_fragment.RegisterFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/8.
 * 消息Fragment类
 */
public class MessageFragment extends AbsBaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragments;
    private MessageAdapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initViews() {
        viewPager = byView(R.id.message_pager);
        tabLayout = byView(R.id.message_tab);

    }

    @Override
    protected void initData() {
        fragments = new ArrayList<>();
        fragments.add(new LoginFragment());
        fragments.add(new RegisterFragment());
        adapter = new MessageAdapter(getChildFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
