package com.tradzoo.Home;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.tradzoo.Home.Adapter.HomeAdapter;
import com.tradzoo.Home.Model.Home;
import com.tradzoo.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView homeRecycler;
    private List<Home> homeList;
    private HomeAdapter homeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.title);
        homeRecycler = findViewById(R.id.homeRecycler);
        Spannable word = new SpannableString("Trad");
        word.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.green_btn_end_color)), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(word);
        Spannable wordTwo = new SpannableString("Zoo");
        wordTwo.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.blue_btn_start_color)), 0, wordTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.append(wordTwo);
        homeList = new ArrayList<>();
        homeList.add(new Home("Intraday","#802783D9"));
        homeList.add(new Home("BTST","#80B1BF14"));
        LinearLayoutManager linearLayout =new GridLayoutManager(this,2);
        homeRecycler.setLayoutManager(linearLayout);
        homeAdapter = new HomeAdapter(homeList,this);
        homeRecycler.setAdapter(homeAdapter);
    }
}
