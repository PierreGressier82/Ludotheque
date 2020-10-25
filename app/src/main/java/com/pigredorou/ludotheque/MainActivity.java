package com.pigredorou.ludotheque;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pigredorou.ludotheque.activity.EditerJeuDeSocieteActivity;
import com.pigredorou.ludotheque.activity.IndexableListViewActivity;
import com.pigredorou.ludotheque.activity.JeuDeSocieteActivity;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ImageView mImageChoisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Masque la barre de titre l'application
        Objects.requireNonNull(getSupportActionBar()).hide();

        Button boutonDetailJeu = findViewById(R.id.detail_jeu);
        Button boutonListeJeux = findViewById(R.id.scroll_jeux);
        Button boutonPhoto = findViewById(R.id.choisir_image_jeu);
        Button boutonAjouter = findViewById(R.id.ajout_jeu);
        mImageChoisi = findViewById(R.id.image_choisie);

        boutonDetailJeu.setOnClickListener(new Button.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent DetailJeu = new Intent(MainActivity.this, JeuDeSocieteActivity.class);
                   startActivityForResult(DetailJeu, 11);
               }
           }
        );

        boutonListeJeux.setOnClickListener(new Button.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   Intent ListeJeux = new Intent(MainActivity.this, IndexableListViewActivity.class);
                                                   startActivityForResult(ListeJeux, 12);
                                               }
                                           }
        );

        boutonAjouter.setOnClickListener(new Button.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   Intent AjoutJeu = new Intent(MainActivity.this, EditerJeuDeSocieteActivity.class);
                                                   startActivityForResult(AjoutJeu, 13);
                                               }
                                           }
        );

        boutonPhoto.setOnClickListener(new Button.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent galleriePhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                   startActivityForResult(galleriePhoto, 14);
               }
           }
        );
    }

    /**
     * au retour de la sélection de l'image (après appel de startActivityFroResult)
     * @param resquestCode : code de requête
     * @param resultCode : code retour
     * @param data : données
     */
    public void onActivityResult(int resquestCode, int resultCode, Intent data) {
        super.onActivityResult(resultCode, resultCode, data);
        // Vérifie si une images est récupérée
        if (resquestCode==14 && resultCode==RESULT_OK) {
            // Accès à l'image
            //Uri imageSelectionnee = data.getData();
            InputStream ims = null;
            try {
                ims = getContentResolver().openInputStream(Objects.requireNonNull(data.getData()));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            // Récupération de l'image
            Bitmap image = BitmapFactory.decodeStream(ims);
            // Redimmenssione l'image
            if (image != null)
                image = modifieTailleImage(image, 0.8f);
            // Affichage de l'image
            mImageChoisi.setImageBitmap(image);
        }
        else if (resquestCode==14){
            Toast.makeText(this, "Aucune image sélectionnée", Toast.LENGTH_LONG).show();
        }

    }

    /**
     * Permet de redimenssioner une image en fonction de la taille de l'écran
     * @param image : image a redimensionner
     * @param proportions : proportions voulues (valeur entre 0 et 1)
     * @return : retourne l'image à la taille choisie
     */
    private Bitmap modifieTailleImage(Bitmap image, float proportions) {
        DisplayMetrics metrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        // Taille de l'écran (et affectation de la proportion)
        float largeurEcran = metrics.heightPixels*proportions;
        float longueurEcran = metrics.widthPixels*proportions;
        // Taille de l'image
        float largeurImage = image.getHeight();
        float longueurImage = image.getWidth();
        // Calcul du ratio entre image et écran
        float largeurRatio = largeurEcran/largeurImage;
        float longueurRatio = longueurEcran/longueurImage;
        // Récupérer le plus petit ratio
        float ratio = Math.min(largeurRatio, longueurRatio);
        image = Bitmap.createScaledBitmap(image, (int)(longueurImage*ratio), (int)(largeurImage*ratio), true);
        // Retourne la nouvelle image
        return image;
    }
}
