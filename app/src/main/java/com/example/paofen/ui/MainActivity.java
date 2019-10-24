package com.example.paofen.ui;

import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.example.paofen.R;
import com.example.paofen.commt.BaseAct;
import com.example.paofen.ui.fgt.Fgt_FanKuan;
import com.example.paofen.ui.fgt.Fgt_GuaMa;
import com.example.paofen.ui.fgt.Fgt_Oder;
import com.example.paofen.ui.fgt.Fgt_TongJI;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.common.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseAct {

    @Override
    public int initLayoutId() {
        return R.layout.activity_main;
    }

    private TextView[] title = new TextView[4];
    List<BaseFragment> fgtData = new ArrayList<>();

    @Override
    public void initView() {
        hideHeader();
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        ImmersionBar.with(MainActivity.this)
                .statusBarDarkFont(true)   //状态栏字体是深色，不写默认为亮色
                .init();
        title[0] = getView(R.id.main_tab_dingdan);
        title[1] = getView(R.id.main_tab_guama);
        title[2] = getView(R.id.main_tab_fankuan);
        title[3] = getView(R.id.main_tab_tongji);
        fgtData.add(new Fgt_Oder());
        fgtData.add(new Fgt_GuaMa());
        fgtData.add(new Fgt_FanKuan());
        fgtData.add(new Fgt_TongJI());
    }

    @OnClick({R.id.main_tab_dingdan, R.id.main_tab_guama, R.id.main_tab_fankuan, R.id.main_tab_tongji})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_tab_dingdan:
                setCurrent(0);
                break;
            case R.id.main_tab_guama:
                setCurrent(1);
                break;
            case R.id.main_tab_fankuan:
                setCurrent(2);
                break;
            case R.id.main_tab_tongji:
                setCurrent(3);
                break;
        }
    }

    @Override
    public void initData() {
        getSupportFragmentManager().beginTransaction().add(R.id.myFrame, fgtData.get(0)).add(R.id.myFrame, fgtData.get(1)).hide(fgtData.get(1)).show(fgtData.get(0)).commit();
        setCurrent(0);
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    public int currentTabIndex = 0;

    public void setCurrent(int indext) {
        if (currentTabIndex != indext) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(fgtData.get(currentTabIndex));
            if (!fgtData.get(indext).isAdded()) {
                trx.add(R.id.myFrame, fgtData.get(indext));
            }
            trx.show(fgtData.get(indext)).commit();
        }
        title[currentTabIndex].setSelected(false);
        title[indext].setSelected(true);
        currentTabIndex = indext;
    }
}
