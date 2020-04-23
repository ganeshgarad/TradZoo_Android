package com.tradzoo.Home.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tradzoo.Home.Model.Home;
import com.tradzoo.R;
import com.tradzoo.TradeCategory.TradeCategoryActivity;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private List<Home> homeList;
    private Context mContext;

    public HomeAdapter(List<Home> homeList, Context mContext) {
        this.homeList = homeList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_card,viewGroup,false);
        MyViewHolder myViewHolder =new MyViewHolder(view);
        return myViewHolder;
    }

    @NonNull
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Home home = homeList.get(position);
        holder.title.setText(home.getTitle());
        holder.cardView.setCardBackgroundColor(Color.parseColor(home.getColorCode()));
        holder.cardView.setOnClickListener(v->{
            mContext.startActivity(new Intent(mContext, TradeCategoryActivity.class));
        });
    }


    @Override
    public int getItemCount() {
        return homeList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.cardTitle);
            cardView = itemView.findViewById(R.id.card);
        }
    }
}
