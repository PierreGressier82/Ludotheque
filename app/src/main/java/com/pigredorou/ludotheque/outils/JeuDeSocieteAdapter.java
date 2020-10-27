package com.pigredorou.ludotheque.outils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pigredorou.ludotheque.R;
import com.pigredorou.ludotheque.activity.EditerJeuDeSocieteActivity;
import com.pigredorou.ludotheque.bdd.JeuDeSociete;

import java.util.ArrayList;

public class JeuDeSocieteAdapter extends ArrayAdapter<JeuDeSociete> {
    private final Context _context;
    private ArrayList<JeuDeSociete> _jeuxDeSociete;

    public JeuDeSocieteAdapter(Context context, int resource, ArrayList<JeuDeSociete> jeuxDeSociete) {
        super(context, resource, jeuxDeSociete);
        _context = context;
        _jeuxDeSociete = jeuxDeSociete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_item, parent, false);
        } else {
            convertView = convertView;
        }

        ImageView imageView = convertView.findViewById(R.id.image_jeu);
        //imageView.setBackgroundResource(_jeuxDeSociete.get(position).getImageCouverture());

        TextView vueTitreJeu = convertView.findViewById(R.id.titre_jeu);
        vueTitreJeu.setText(_jeuxDeSociete.get(position).getNom());
        vueTitreJeu.setTag(_jeuxDeSociete.get(position).getId());

        TextView vueAge = convertView.findViewById(R.id.age_mini);
        String texteAge = _jeuxDeSociete.get(position).getAgeMini() + "+ ";
        vueAge.setText(texteAge);

        TextView nbJoueur = convertView.findViewById(R.id.nb_joueurs);
        String texteNbJoueurs;
        if (_jeuxDeSociete.get(position).getNbJoueursMin() == _jeuxDeSociete.get(position).getNbJoueursMax())
            texteNbJoueurs = String.valueOf(_jeuxDeSociete.get(position).getNbJoueursMin());
        else
            texteNbJoueurs = _jeuxDeSociete.get(position).getNbJoueursMin() + " à " + _jeuxDeSociete.get(position).getNbJoueursMax();
        nbJoueur.setText(texteNbJoueurs);

        TextView duree = convertView.findViewById(R.id.duree);
        String texteDuree = EditerJeuDeSocieteActivity.listeDuree[_jeuxDeSociete.get(position).getDuree() -1] + " min ";
        duree.setText(texteDuree);

        return convertView;
    }}
