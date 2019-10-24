package com.example.paofen.ui.fgt.oder;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.paofen.R;
import com.example.paofen.ui.fgt.oder.bean.OderBean;

import java.util.List;

public class OderAdapter extends BaseQuickAdapter<OderBean, BaseViewHolder> {
    public OderAdapter(@Nullable List<OderBean> data) {
        super(R.layout.item_oder, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OderBean item) {
        TextView oderStatus = helper.getView(R.id.item_oder_status);
        ImageView iconImg = helper.getView(R.id.item_oder_icon);
        switch (item.getStatus()) {
            case 0: //已下放
                Glide.with(mContext).load(R.mipmap.yixiafang).into(iconImg);
                oderStatus.setText("已下放");
                oderStatus.setTextColor(Color.parseColor("#60cc4f"));
                break;
            case 1: //已消单
                Glide.with(mContext).load(R.mipmap.yixiaodan).into(iconImg);
                oderStatus.setText("已消单");
                oderStatus.setTextColor(Color.parseColor("#dcdcdd"));
                break;
            case 2: //未支付
                Glide.with(mContext).load(R.mipmap.weizhifu).into(iconImg);
                oderStatus.setText("未支付");
                oderStatus.setTextColor(Color.parseColor("#dcdcdd"));
                break;

        }


    }
}
