package com.du.a36kr.ui.fragment.child_fragment;

import android.view.View;
import android.widget.Button;

import com.du.a36kr.R;
import com.du.a36kr.ui.fragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/18.
 * 登录界面
 */
public class LoginFragment extends AbsBaseFragment implements View.OnClickListener {
    private Button loginBtn;

    @Override
    protected int setLayout() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initViews() {
        loginBtn = byView(R.id.login_btn);

    }

    @Override
    protected void initData() {
        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn:
                break;
        }
    }
}
