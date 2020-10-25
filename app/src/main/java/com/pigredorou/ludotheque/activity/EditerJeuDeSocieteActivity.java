package com.pigredorou.ludotheque.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pigredorou.ludotheque.R;
import com.pigredorou.ludotheque.bdd.JeuDeSociete;
import com.pigredorou.ludotheque.bdd.JeuDeSocieteBDD;

import java.text.DateFormat;
import java.util.Date;
import java.util.Objects;

public class EditerJeuDeSocieteActivity extends AppCompatActivity {
    private Button mBoutonValider;
    private TextView mTitreJeu;
    private NumberPicker mNbJoueursMin;
    private NumberPicker mNbJoueursMax;
    private NumberPicker mAgeMin;
    private NumberPicker mDuree;
    private TextView mReglesPDF;
    private TextView mLienLudovox;
    private TextView mDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editer_jeu_de_societe);

        //Masque la barre de titre l'application
        Objects.requireNonNull(getSupportActionBar()).hide();

        mBoutonValider = findViewById(R.id.bouton_valider);
        mTitreJeu = findViewById(R.id.text_titre_du_jeu);
        mNbJoueursMin = findViewById(R.id.nb_joueurs_min);
        mNbJoueursMax = findViewById(R.id.nb_joueurs_max);
        mAgeMin = findViewById(R.id.age_mini);
        mDuree = findViewById(R.id.duree);
        mReglesPDF = findViewById(R.id.text_regles_pdf);
        mLienLudovox = findViewById(R.id.text_lien_ludovox);
        mDescription = findViewById(R.id.text_description_detaillee);

        mBoutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Insertion en base des valeurs de l'activité
                JeuDeSociete jeuAAjouter = new JeuDeSociete();
                DateFormat format = DateFormat.getDateInstance();
                Date date = new Date();

                jeuAAjouter.setNom(mTitreJeu.toString());
                jeuAAjouter.setNbJoueursMin(mNbJoueursMin.getValue());
                jeuAAjouter.setNbJoueursMax(mNbJoueursMax.getValue());
                jeuAAjouter.setAgeMini(mAgeMin.getValue());
                jeuAAjouter.setDuree(mDuree.getValue());
                jeuAAjouter.setReglesPDF(mReglesPDF.toString());
                jeuAAjouter.setLienLudovox(mLienLudovox.toString());
                jeuAAjouter.setReglesSimplifiees(mDescription.toString());
                jeuAAjouter.setDateAjout(format.format(date));

                // Ouvre une instance de la base, ajoute l'élément et ferme la base
                JeuDeSocieteBDD jeuDeSocieteBDD = new JeuDeSocieteBDD(getBaseContext());
                jeuDeSocieteBDD.open();
                jeuDeSocieteBDD.insertClassement(jeuAAjouter);
                jeuDeSocieteBDD.close();
            }
        });

    }
}
