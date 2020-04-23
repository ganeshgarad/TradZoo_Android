package com.tradzoo;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tradzoo.Home.MainActivity;

public class LoginActivity extends AppCompatActivity {

    private Button facebookButton,googleButton;
    private TextView privacyButton;
    AlertDialog aleartPrivacy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        facebookButton = findViewById(R.id.facebookButton);
        googleButton = findViewById(R.id.googleButton);
        privacyButton = findViewById(R.id.privacyButton);
        privacyButton.setOnClickListener(v->{
            privacyPopup();
        });
        facebookButton.setOnClickListener(v->{
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
        googleButton.setOnClickListener(v->{
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
    }

    private void privacyPopup() {
        LayoutInflater li = LayoutInflater.from(this);
        View view = li.inflate(R.layout.privacy_policy_popup, null);

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this, R.style.Theme_AppCompat_DayNight_Dialog_Alert);
        alertDialogBuilder.setView(view);
        String mUrl ="https://www.reliancesmartmoney.com/online-privacy";
        WebView mWebView = (WebView) view.findViewById(R.id.webView);
        Button backButton = view.findViewById(R.id.backButton);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });
        mWebView.loadUrl(mUrl);
        aleartPrivacy = alertDialogBuilder.create();
        aleartPrivacy.show();
        aleartPrivacy.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);//
        backButton.setOnClickListener(v->{
            aleartPrivacy.dismiss();
        });
    }
}
