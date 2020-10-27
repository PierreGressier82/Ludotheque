package com.pigredorou.ludotheque.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pigredorou.ludotheque.MainActivity;
import com.pigredorou.ludotheque.R;
import com.pigredorou.ludotheque.bdd.JeuDeSociete;
import com.pigredorou.ludotheque.bdd.JeuDeSocieteBDD;

public class JeuDeSocieteActivity extends AppCompatActivity {

    private int mIdJeuSelectionne;
    private TextView mTitre;
    private TextView mNbJoueurs;
    private TextView mAgeMini;
    private TextView mDuree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu_de_societe);
        //Todo - Creer une activité pour modifier un jeu
        //Todo - Créer une activité pour filtrer sur les jeux selon un critère (nombre de joueur, durée, age, ...)

        mIdJeuSelectionne = getIntent().getIntExtra(MainActivity.PREF_KEY_ID_JEU, 0);

        // Ouvre une instance de la base, affiche les éléments du jeu et ferme la base
        if (mIdJeuSelectionne != 0) {
            JeuDeSociete jeuSelectionne = selectionne_jeu(mIdJeuSelectionne);
            String textTempo;

            mTitre = findViewById(R.id.text_titre_du_jeu);
            mNbJoueurs = findViewById(R.id.text_nombre_joueur);
            mAgeMini = findViewById(R.id.text_age_joueur);
            mDuree = findViewById(R.id.text_duree);

            if (jeuSelectionne != null) {
                mTitre.setText(jeuSelectionne.getNom());
                textTempo = jeuSelectionne.getNbJoueursMin() + " à " + jeuSelectionne.getNbJoueursMax();
                mNbJoueurs.setText(textTempo);
                textTempo = jeuSelectionne.getAgeMini() + "+";
                mAgeMini.setText(textTempo);
                textTempo = EditerJeuDeSocieteActivity.listeDuree[jeuSelectionne.getDuree() - 1] + " min";
                mDuree.setText(textTempo);
            }
            else
                Toast.makeText(this, "Pb lors de la sélection du jeu" + mIdJeuSelectionne, Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Pas de jeu sélectionné", Toast.LENGTH_SHORT).show();

    }

    private JeuDeSociete selectionne_jeu(int idJeu) {
        JeuDeSociete jeuDeSociete;
        JeuDeSocieteBDD jeuDeSocieteBDD = new JeuDeSocieteBDD(getBaseContext());
        jeuDeSocieteBDD.open();
        Cursor cursor = jeuDeSocieteBDD.getJeuxparID(idJeu);

        if (cursor.moveToFirst()) {
            // The elements to retrieve
            int id, nbJMin, nbJMax, duree, ageMin;
            String nom;
            //String date;
            int count = 0;
            do {
                id = cursor.getInt(0);
                nom = cursor.getString(1);
                nbJMin = cursor.getInt(2);
                nbJMax = cursor.getInt(3);
                ageMin = cursor.getInt(4);
                duree = cursor.getInt(5);
                //date = cursor.getString(3);
                count++;
                // Affichage du jeu récupéré
                jeuDeSociete = new JeuDeSociete(id,nom,nbJMin,nbJMax,ageMin,duree);

            } while (cursor.moveToNext());
        } else {
            Toast.makeText(this, "Pas de jeu", Toast.LENGTH_LONG).show();
            jeuDeSociete = new JeuDeSociete();
        }

        jeuDeSocieteBDD.close();

        return jeuDeSociete;
    }
}
