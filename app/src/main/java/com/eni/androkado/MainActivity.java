package com.eni.androkado;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class MainActivity extends AppCompatActivity {
    static final String KEY_EXTRA_ARTICLE = "keyArticle";
    private Article croissant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Affectation des vues
        TextView textViewNomArticle = findViewById(R.id.textViewNomArticle);
        TextView textViewDescription = findViewById(R.id.textViewDescription);
        TextView textViewPrix = findViewById(R.id.textViewPrix);
        MaterialRatingBar ratingBarEnvie = findViewById(R.id.ratingBarEnvie);
        ToggleButton toggleButtonAchete = findViewById(R.id.toggleButtonAchete);
        ImageButton imageButtonURL = findViewById(R.id.imageButtonURL);

        croissant = new Article(
                "Croissant",
                "Viennoiserie au beurre",
                1.1f,
                4,
                "https://fr.wikipedia.org/wiki/Pain_au_chocolat",
                false);

        textViewNomArticle.setText(croissant.getNom());
        textViewPrix.setText(croissant.getPrix() + "€");
        textViewDescription.setText(croissant.getDescription());
        ratingBarEnvie.setRating(croissant.getEnvie());
        toggleButtonAchete.setChecked(croissant.isAchete());
        imageButtonURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, croissant.getUrl(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, InfoUrlActivity.class);
                intent.putExtra(KEY_EXTRA_ARTICLE, croissant);
                startActivity(intent);
            }
        });
    }

}
