package com.wzq.nolimitbanner.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wzq.nolimitbanner.R;
import com.wzq.nolimitbanner.bean.Banner;
import com.wzq.nolimitbanner.widget.AdView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AdView adView;
    List<Banner> banners;

    private int ids[] = new int[]{
            R.drawable.mip1,
            R.drawable.mip2,
            R.drawable.mip3,
            R.drawable.mip4,
            R.drawable.mip5,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banners = new ArrayList<>();

        adView = (AdView) findViewById(R.id.adView);


        for (int i = 0; i < 5; i++) {
            Banner banner = new Banner();
            banner.setLinkUrl("https://www.baidu.com");
            banner.setPictureUrl("drawable://" + ids[i]);
            banners.add(banner);
        }

        adView.setData(banners, true);
    }
}
