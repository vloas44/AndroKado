package com.eni.androkado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class InfoUrlActivity extends AppCompatActivity {
    public String url;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_url);
    }

    @Override
    protected void onStart() {

        super.onStart();
        //Récupération de l'intent en cours
        Intent intentRecupere = getIntent();
        //Récupération de l'extra
        Article articleRecupere = intentRecupere.getParcelableExtra(MainActivity.KEY_EXTRA_ARTICLE);
        //Récupération de l'url
        url = articleRecupere.getUrl();
        //Récupération d'un objet représentant la textView de l'activité B
        textView =  findViewById(R.id.textView);
        //Modification du textView avec le contenu de l'extra
        textView.setText(url);

    }
}
