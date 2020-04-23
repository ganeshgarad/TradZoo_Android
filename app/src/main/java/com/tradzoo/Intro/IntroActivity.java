package com.tradzoo.Intro;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tradzoo.Intro.Adapter.IntroViewPagerAdapter;
import com.tradzoo.LoginActivity;
import com.tradzoo.R;

public class IntroActivity extends AppCompatActivity {

    public ViewPager introPager;
    public IntroViewPagerAdapter introViewPagerAdapter;
    private int[] layouts;
    private TextView[] dots;
    private LinearLayout dotsLayouts;
    private Context context;
    private TextView skipButton,nextButton;
    private Button getStartedButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        introPager = findViewById(R.id.intro_pager);
        dotsLayouts = findViewById(R.id.layoutDots);
        skipButton = findViewById(R.id.skipButton);
        nextButton = findViewById(R.id.nextButton);
        getStartedButton = findViewById(R.id.getStartedButton);
        context = getBaseContext();
        layouts = new int[]{
                R.layout.onboarding,
                R.layout.onboarding2,
                R.layout.onboarding3,
        };
        //adding bottom dots
        addBottomDots(0);
        changeStatusBarColor();
        introViewPagerAdapter = new IntroViewPagerAdapter(context,layouts);
        introPager.setAdapter(introViewPagerAdapter);
        introPager.addOnPageChangeListener(introPagerPageChangeListener);

        skipButton.setOnClickListener(v->{
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });
        nextButton.setOnClickListener(v->{
            introPager.setCurrentItem(introPager.getCurrentItem()+1);
        });
        getStartedButton.setOnClickListener(v->{
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        });
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];
        @SuppressLint("ResourceType") int colorActive = getResources().getInteger(R.color.active_indicator_color);
        @SuppressLint("ResourceType") int colorInActive = getResources().getInteger((R.color.inactive_indicator_color));
        dotsLayouts.removeAllViews();
        for(int i=0; i<layouts.length;i++)
        {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorInActive);
            dotsLayouts.addView(dots[i]);
        }
        if(dots.length>0)
        {
            dots[currentPage].setTextColor(colorActive);
        }
    }
    //    Pager Listner
    ViewPager.OnPageChangeListener introPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if(position==2){
                getStartedButton.setVisibility(View.VISIBLE);
            }
            else {
                getStartedButton.setVisibility(View.GONE);
            }
        }
        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
