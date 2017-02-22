package com.wzq.nolimitbanner.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.wzq.nolimitbanner.R;
import com.wzq.nolimitbanner.adapter.ImagePagerAdapter;
import com.wzq.nolimitbanner.bean.Banner;

import java.util.List;

/**
 * Created by wzq on 17-mip1-22.
 */

public class AdView extends FrameLayout{
    private View view;


    private ViewFlow viewFlow;


    private CircleFlowIndicator circleFlowIndicator;


    private ImagePagerAdapter imagePagerAdapter;


    private final int timeSpan = 1500;

    public AdView(Context context) {
        this(context, null);
    }

    public AdView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AdView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {

        view = LayoutInflater.from(getContext()).inflate(R.layout.ad_view, this);


        viewFlow = (ViewFlow) view.findViewById(R.id.viewFlow);

        circleFlowIndicator = (CircleFlowIndicator) view.findViewById(R.id.circleFlowIndicator);
        viewFlow.setFlowIndicator(circleFlowIndicator);
        viewFlow.setTimeSpan(timeSpan);

    }



    public void setData(List<Banner> banners, boolean isLooper)
    {
        if(imagePagerAdapter == null)
        {
            imagePagerAdapter = new ImagePagerAdapter(getContext(), banners);
            viewFlow.setAdapter(imagePagerAdapter);
        }
        else
            imagePagerAdapter.setData(banners);
        imagePagerAdapter.setInfiniteLoop(isLooper);
        viewFlow.setmSideBuffer(banners.size());
        viewFlow.setSelection(0);
        viewFlow.startAutoFlowTimer();
    }
}
