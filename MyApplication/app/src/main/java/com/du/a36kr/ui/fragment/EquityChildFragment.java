package com.du.a36kr.ui.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.du.a36kr.R;

/**
 * Created by dllo on 16/9/9.
 */
public class EquityChildFragment extends AbsBaseFragment {
    private TextView textView;
    @Override
    protected int setLayout() {
        return R.layout.fragment_all_equity;
    }

    public static EquityChildFragment newInstance(String str) {

        Bundle args = new Bundle();

        args.putString("text",str);
        EquityChildFragment fragment = new EquityChildFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initViews() {
        textView =byView(R.id.fragment_all_tv);

    }

    @Override
    protected void initData() {
        Bundle bundle = getArguments();
        String string = bundle.getString("text");
        textView.setText(string);


    }
}
