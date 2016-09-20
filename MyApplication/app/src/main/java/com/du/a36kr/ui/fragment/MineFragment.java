package com.du.a36kr.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.du.a36kr.R;
import com.du.a36kr.ui.activity.AccountStateActivity;

/**
 * Created by dllo on 16/9/8.
 * 我的Fragment类
 */
public class MineFragment extends AbsBaseFragment implements View.OnClickListener {
    private LinearLayout orderLayout,account_stateLayout;
    @Override
    protected int setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initViews() {
        orderLayout = byView(R.id.mine_order);
        account_stateLayout = byView(R.id.mine_account_state);

    }

    @Override
    protected void initData() {
        orderLayout.setOnClickListener(this);
        account_stateLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_order:
                break;
            case R.id.mine_account_state:
                Intent accountIntent = new Intent(context, AccountStateActivity.class);
                startActivity(accountIntent);
                break;
        }

    }
}
