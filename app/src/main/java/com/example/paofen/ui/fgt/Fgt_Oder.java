package com.example.paofen.ui.fgt;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.paofen.R;
import com.example.paofen.ui.fgt.oder.OderAdapter;
import com.example.paofen.ui.fgt.oder.bean.OderBean;
import com.lykj.aextreme.afinal.common.BaseFragment;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

public class Fgt_Oder extends BaseFragment {
    @BindView(R.id.profile_image)
    CircleImageView profileImage;
    @BindView(R.id.bt_paidui)
    TextView btPaidui;
    @BindView(R.id.pb_load)
    ProgressBar pbLoad;
    @BindView(R.id.view_paiduiloding)
    LinearLayout viewPaiduiloding;
    @BindView(R.id.loding_view_text)
    LinearLayout loding_view_text;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @BindView(R.id.myOderRecyclerView)
    RecyclerView myOderRecyclerView;
    Unbinder unbinder1;

    @Override
    public int initLayoutId() {
        return R.layout.fgt_oder;
    }

    @Override
    public void initView() {
        updateUI();
        //刷新
        mRefreshLayout.setEnableRefresh(true);//是否启用下拉刷新功能
        mRefreshLayout.setEnableLoadMore(true);//是否启用上拉加载功能
        mRefreshLayout.setEnableHeaderTranslationContent(true);  //内容跟随偏移
        mRefreshLayout.setRefreshHeader(new MaterialHeader(context).setShowBezierWave(false));  //设置 Header 为 Material风格
        mRefreshLayout.setRefreshFooter(new BallPulseFooter(context).setSpinnerStyle(SpinnerStyle.Scale));    //设置 Footer 为 球脉冲
        mRefreshLayout.setOnRefreshListener(refreshlayout -> {
            refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
        });
        mRefreshLayout.setOnLoadMoreListener(refreshlayout -> {
            refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示刷新失败
        });
    }

    List<OderBean> data = new ArrayList<>();

    @Override
    public void initData() {
        myOderRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        for (int i = 0; i < 3; i++) {
            OderBean bean = new OderBean();
            bean.setStatus(i);
            data.add(bean);
        }
        OderAdapter adapter = new OderAdapter(data);
        myOderRecyclerView.setAdapter(adapter);
    }

    private Unbinder unbinder;

    @Override
    public void updateUI() {
        hideHeader();
        unbinder = ButterKnife.bind(Fgt_Oder.this, v);
    }

    @Override
    public void onNoInterNet() {

    }

    @Override
    public void sendMsg(int flag, Object obj) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder1.unbind();
    }

    @OnClick(R.id.bt_paidui)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_paidui:
                viewPaiduiloding.setVisibility(View.VISIBLE);
                loding_view_text.setVisibility(View.VISIBLE);
                break;
        }
    }
}
