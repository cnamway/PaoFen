package com.example.paofen.ui.fgt;

import com.example.paofen.R;
import com.lykj.aextreme.afinal.common.BaseFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 返款
 */
public class Fgt_FanKuan extends BaseFragment {
    @Override
    public int initLayoutId() {
        return R.layout.fgt_fankuan;
    }

    @Override
    public void initView() {
        updateUI();
    }


    @Override
    public void initData() {

    }
    private Unbinder unbinder;
    @Override
    public void updateUI() {
        hideHeader();
        unbinder = ButterKnife.bind(Fgt_FanKuan.this, v);
    }

    @Override
    public void onNoInterNet() {

    }

    @Override
    public void sendMsg(int flag, Object obj) {

    }
}
