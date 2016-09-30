package com.du.a36kr.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.du.a36kr.R;
import com.du.a36kr.ui.activity.AccountStateActivity;
import com.du.a36kr.ui.activity.LoginActivity;
import com.du.a36kr.ui.activity.MineOrderActivity;

/**
 * Created by dllo on 16/9/8.
 * 我的Fragment类
 */
public class MineFragment extends AbsBaseFragment implements View.OnClickListener {
    private LinearLayout orderLayout;//我的订单
    private RelativeLayout relativeLayout;//登录的状态
    private LinearLayout account_stateLayout;//账号信息
    @Override
    protected int setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initViews() {
        orderLayout = byView(R.id.mine_order);
        account_stateLayout = byView(R.id.mine_account_state);
        relativeLayout = byView(R.id.mine_relative_layout);

    }

    @Override
    protected void initData() {
        orderLayout.setOnClickListener(this);
        account_stateLayout.setOnClickListener(this);
        relativeLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_order:
                goTo(MineOrderActivity.class);
                break;
            case R.id.mine_account_state:
                Intent accountIntent = new Intent(context, AccountStateActivity.class);
                startActivity(accountIntent);
                break;
            case R.id.mine_relative_layout:
                goTo(LoginActivity.class);
                break;
        }

    }
}
