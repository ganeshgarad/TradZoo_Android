package com.tradzoo.TradeCategory;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.graphics.drawable.ArgbEvaluator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ramijemli.percentagechartview.PercentageChartView;
import com.tradzoo.R;
import com.tradzoo.TradeCategory.Adapter.TradeCategoryAdapter;
import com.tradzoo.TradeCategory.Model.TradeCategory;

import java.util.ArrayList;
import java.util.List;

public class TradeCategoryActivity extends AppCompatActivity {

    ViewPager viewPager;
    TradeCategoryAdapter tradeCategoryAdapter;
    Integer[] colors  = {Color.WHITE,Color.WHITE,Color.WHITE,Color.WHITE,Color.WHITE,Color.WHITE};
    @SuppressLint("RestrictedApi")
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    List<TradeCategory> tradeCategoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade_category);
        tradeCategoryList = new ArrayList<>();
        tradeCategoryList.add(new TradeCategory("Equity Cash","24","57","#802783D9"));
        tradeCategoryList.add(new TradeCategory("Equity Future","2","57","#80B1BF14"));
        tradeCategoryList.add(new TradeCategory("Equity Options","242","57","#802783D9"));
        tradeCategoryList.add(new TradeCategory("Banknifty Future","214","57","#80B1BF14"));
        tradeCategoryList.add(new TradeCategory("Banknifty Options","124","57","#802783D9"));
        tradeCategoryList.add(new TradeCategory("Nifty Future","2465","57","#80B1BF14"));

        tradeCategoryAdapter = new TradeCategoryAdapter(tradeCategoryList,this);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(tradeCategoryAdapter);
        viewPager.setPadding(70,0,70,0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onPageScrolled(int position, float positionOffset, int i1) {
                if(position<(tradeCategoryAdapter.getCount()-1)&&position<(colors.length - 1)){
                    viewPager.setBackgroundColor((Integer)argbEvaluator.evaluate(positionOffset,colors[position],colors[position+1]));
                }
                else{
                    viewPager.setBackgroundColor(colors[position]-1);
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
