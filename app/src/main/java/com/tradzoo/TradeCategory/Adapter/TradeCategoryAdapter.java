package com.tradzoo.TradeCategory.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ramijemli.percentagechartview.PercentageChartView;
import com.tradzoo.R;
import com.tradzoo.TradeCategory.Model.TradeCategory;

import java.util.List;

public class TradeCategoryAdapter extends PagerAdapter {

    private List<TradeCategory> tradeCategoryList;
    private LayoutInflater layoutInflater;
    private Context context;

    public TradeCategoryAdapter(List<TradeCategory> tradeCategoryList, Context context) {
        this.tradeCategoryList = tradeCategoryList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return tradeCategoryList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.progress_card,container,false);
        TextView categoryTitle = view.findViewById(R.id.cardTitle);
        TextView buyTrade = view.findViewById(R.id.buyTrade);
        TextView sellTrade = view.findViewById(R.id.sellTrade);
        TextView totalTrade = view.findViewById(R.id.totalTrade);
        final PercentageChartView chartView = view.findViewById(R.id.progressBar);
        CardView cardView = view.findViewById(R.id.card);
        cardView.setCardBackgroundColor(Color.parseColor(tradeCategoryList.get(position).getCardColor()));
        buyTrade.setText(tradeCategoryList.get(position).getBuyCall());
        sellTrade.setText(tradeCategoryList.get(position).getSellCall());
        int totalTradeCall = Integer.parseInt(tradeCategoryList.get(position).getBuyCall())+Integer.parseInt(tradeCategoryList.get(position).getSellCall());
        float percentage = (Float.parseFloat(tradeCategoryList.get(position).getBuyCall())/totalTradeCall)*100;
        Log.d("Percentage",""+percentage);
        chartView.setProgress(percentage,false);
        totalTrade.setText(""+totalTradeCall);
        categoryTitle.setText(tradeCategoryList.get(position).getCategoryTitle());
        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
