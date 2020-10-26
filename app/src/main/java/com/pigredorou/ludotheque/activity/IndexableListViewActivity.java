package com.pigredorou.ludotheque.activity;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SectionIndexer;
import android.widget.Toast;

import com.pigredorou.ludotheque.R;
import com.pigredorou.ludotheque.bdd.JeuDeSociete;
import com.pigredorou.ludotheque.bdd.JeuDeSocieteBDD;
import com.pigredorou.ludotheque.outils.IndexableListView;
import com.pigredorou.ludotheque.outils.JeuDeSocieteAdapter;
import com.pigredorou.ludotheque.outils.StringMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IndexableListViewActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //MovieAdaptater adapter = new MovieAdaptater(getApplicationContext(), R.layout.activity_item, movies);
        //ListView list_movies = (ListView) findViewById(R.id.list_movies);
        //list_movies.setAdapter(adapter);
        //list_movies.setOnItemClickListener(listview_listerner);


    //OnItemClickListener listview_listerner = new OnItemClickListener() {
    //    @Override
    //    public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
    //        View titleView = view.findViewById(R.id.title);
    //        String title = (String) titleView.getTag();
    //        Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT).show();
    //    }
    //};

    ArrayList<JeuDeSociete> jeuxDeSociete = new ArrayList<>();

        // Ouvre une instance de la base, ajoute l'élément et ferme la base
        JeuDeSocieteBDD jeuDeSocieteBDD = new JeuDeSocieteBDD(getBaseContext());
        jeuDeSocieteBDD.open();
        Cursor cursor=jeuDeSocieteBDD.getJeuxTrieParNom();

        if (cursor.moveToFirst()) {
            // The elements to retrieve
            int id, nbJMin, nbJMax, duree, ageMin;
            String nom;
            //String date;
            int count = 0;
            do {
                //id = cursor.getInt(0);
                nom = cursor.getString(1);
                nbJMin = cursor.getInt(2);
                nbJMax = cursor.getInt(3);
                ageMin = cursor.getInt(4);
                duree = cursor.getInt(5);
                //date = cursor.getString(3);
                count++;
                // Affichage de la ligne
                //ajouteLigneTableau(layoutTableauScores, String.valueOf(count),String.valueOf(score),nom,date);
                jeuxDeSociete.add(new JeuDeSociete(nom, nbJMin, nbJMax, ageMin, duree));
            } while (cursor.moveToNext());
        }
        else {
            Toast.makeText(this, "Pas de score", Toast.LENGTH_LONG).show();
        }

        jeuDeSocieteBDD.close();
        //items.add("504");
        //items.add("6 qui prend!");
        //items.add("6 qui prend!: L'extension vachement bien");
        //items.add("7 Wonders");
        //items.add("8 Minutes pour un Empire");
        //items.add("8Bit Box");
        //items.add("8Bit Box: Outspeed");
        //items.add("8Bit Box: Pixoid");
        //items.add("8Bit Box: Stadium");
        //items.add("A capella");
        //items.add("Agent Hunter");
        //items.add("Andor");
        //items.add("Anti-virus");
        //items.add("Azul");
        //items.add("Bac à la Carte");
        //items.add("Banzai!");
        //items.add("Bellz!");
        //items.add("Blanc-Manger Coco");
        //items.add("Blanc-Manger Coco: La Pilule");
        //items.add("Bohnanza");
        //items.add("Boursicocotte");
        //items.add("Bugs & Co");
        //items.add("Burger Quiz");
        //items.add("C'est Toute la Question!");
        //items.add("C'est pas Sorcier");
        //items.add("C'est pas faux!");
        //items.add("Ca$h 'n Gun$");
        //items.add("Camelot");
        //items.add("Captain Sonar");
        //items.add("Carcassonne");
        //items.add("Charterstone");
        //items.add("Chromino");
        //items.add("Citadelles");
        //items.add("Cléopatre et la Societé des Architectes");
        //items.add("Colosseum");
        //items.add("Colt Express");
        //items.add("Colt Express: Horses & Stagecoach");
        //items.add("Colt Express: Marshal & Prisoners");
        //items.add("Concept");
        //items.add("Creationary");
        //items.add("Creatures & Cultists");
        //items.add("De l'Orc pour les braves");
        //items.add("Decrypto");
        //items.add("Detective: A Modern Crime Board Game");
        //items.add("Discovery: The Evolution Game – Prehistory");
        //items.add("Dixit: Odyssey");
        //items.add("Dizzle");
        //items.add("Djam");
        //items.add("Dobble");
        //items.add("Du Balai!");
        //items.add("Dungeon Twister");
        //items.add("Défifoo Jaune");
        //items.add("Elixir");
        //items.add("Encore et Encore !");
        //items.add("Encore!");
        //items.add("Exit: The Game – The Abandoned Cabin");
        //items.add("Exit: The Game – The Forbidden Castle");
        //items.add("Exit: The Game – The Forgotten Island");
        //items.add("Exit: The Game – The House of Riddles");
        //items.add("Exit: The Game – The Pharaoh's Tomb");
        //items.add("Exit: The Game – The Secret Lab");
        //items.add("Exit: The Game – The Sinister Mansion");
        //items.add("Fantasy");
        //items.add("Final Touch");
        //items.add("Fini!");
        //items.add("Galèrapagos");
        //items.add("Gambit 7");
        //items.add("Gang of Four");
        //items.add("Ghooost!");
        //items.add("Gùgōng");
        //items.add("HILO");
        //items.add("Haute Tension: Les Sociétés par Actions");
        //items.add("Haute tension");
        //items.add("Haute tension : Benelux/Central Europe");
        //items.add("IQ Puzzler");
        //items.add("Imagine");
        //items.add("Jack Bananas");
        //items.add("Jaipur");
        //items.add("Jungle Speed");
        //items.add("Kahuna");
        //items.add("Karuba");
        //items.add("Kezako");
        //items.add("Killer Bunnies and the Quest for the Magic Carrot");
        //items.add("Kingdomino");
        //items.add("Kingdomino: Age of Giants");
        //items.add("La Crique des Pirates");
        //items.add("La Fièvre de l'Or");
        //items.add("La Guerre des Moutons 2");
        //items.add("La guerre des moutons");
        //items.add("Le Grand Dalmuti");
        //items.add("Le Roi des Nains");
        //items.add("Les Aventuriers du Rail");
        //items.add("Les Aventuriers du Rail:  Inde");
        //items.add("Les Bâtisseurs: Moyen-Âge");
        //items.add("Les Chevaliers de la Table Ronde");
        //items.add("Les Chevaliers de la Table Ronde: La compagnie de Merlin");
        //items.add("Les Colons de Catane: EXTENSION pour 5 et 6 joueurs");
        //items.add("Les Colons de Catane: Le Jeu de Cartes");
        //items.add("Les Jeux du Fictionnaire");
        //items.add("Les Loups-Garous de Thiercelieux: Le Village");
        //items.add("Les citées perdues");
        //items.add("Les colons de Catane");
        //items.add("Ligretto jaune");
        //items.add("Ligretto rouge");
        //items.add("Ligretto bleu");
        //items.add("Little Town");
        //items.add("Mafia de Cuba");
        //items.add("Manchots barjots");
        //items.add("Mémoire 44");
        //items.add("Mémoire 44: Eastern Front");
        //items.add("Mémoire 44: Mediterranean Theater");
        //items.add("Mémoire 44: New Flight Plan");
        //items.add("Mémoire 44: Pacific Theater");
        //items.add("Mémoire 44: Terrain Pack");
        //items.add("Mémoire 44: Winter Wars");
        //items.add("Mémoire 44: Winter/Desert plateau de jeu");
        //items.add("Mr. Jack Pocket");
        //items.add("Mysterium");
        //items.add("Mystery Express");
        //items.add("Mystère à l'Abbaye");
        //items.add("New Angeles");
        //items.add("Noch mal so gut!");
        //items.add("Objets Trouvés");
        //items.add("Ooga Booga");
        //items.add("Oware");
        //items.add("Paf le singe!");
        //items.add("Pandemic");
        //items.add("Pollen");
        //items.add("Quadropolis");
        //items.add("Queendomino");
        //items.add("Qwirkle");
        //items.add("Relic Runners");
        //items.add("Richard Coeur de Lion");
        //items.add("Rising 5: Runes of Asteros");
        //items.add("Room 25");
        //items.add("Rory's Story Cubes");
        //items.add("Rummikub");
        //items.add("Saboteur");
        //items.add("Sequence");
        //items.add("Service Compris");
        //items.add("Shabadabada 2");
        //items.add("Shadows over Camelot: The Card Game");
        //items.add("Skull");
        //items.add("Small World");
        //items.add("Solitaire");
        //items.add("Splendor");
        //items.add("Takenoko");
        //items.add("Tchin Tchin");
        //items.add("The Logo Board Game");
        //items.add("Les charlatens de Belcastel");
        //items.add("Les charlatens de Belcastel: Les sorcières s'en mêlent");
        //items.add("The River");
        //items.add("Thurn and Taxis");
        //items.add("Time's Up! La Recharge: 2012");
        //items.add("Timeline: Events");
        //items.add("Timeline: Inventions");
        //items.add("Très Futé!");
        //items.add("UNO");
        //items.add("Unlock! Escape Adventures");
        //items.add("Wanted! Dead or Alive");
        //items.add("Welcome To...");
        //items.add("Welcome To...: Easter Egg Hunt & Doomsday Thematic Neighborhoods");
        //items.add("When I Dream");
        //items.add("Wings of War: Watch Your Back!");
        //Collections.sort(jeuxDeSociete);

        //ContentAdapter adapter = new ContentAdapter(this,android.R.layout.simple_list_item_1, jeuxDeSociete);

        ContentAdapter adapter = new ContentAdapter(this, android.R.layout.simple_list_item_1, jeuxDeSociete);
        //ListView list_movies = (ListView) findViewById(R.id.list_movies);
        //list_movies.setAdapter(adapter);
        //list_movies.setOnItemClickListener(listview_listerner);

        IndexableListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setFastScrollEnabled(true);
    }

    private static class ContentAdapter extends JeuDeSocieteAdapter implements SectionIndexer {

        private String mSections = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        ContentAdapter(Context context, int textViewResourceId, List<JeuDeSociete> objects) {
            super(context, textViewResourceId, (ArrayList<JeuDeSociete>) objects);
        }

        @Override
        public int getPositionForSection(int section) {
            // If there is no item for current section, previous section will be selected
            for (int i = section; i >= 0; i--) {
                for (int j = 0; j < getCount(); j++) {
                    if (i == 0) {
                        // For numeric section
                        for (int k = 0; k <= 9; k++) {
                            if (StringMatcher.match(String.valueOf(Objects.requireNonNull(getItem(j)).getNom().charAt(0)), String.valueOf(k)))
                                return j;
                        }
                    } else {
                        if (StringMatcher.match(String.valueOf(Objects.requireNonNull(getItem(j)).getNom().charAt(0)), String.valueOf(mSections.charAt(i))))
                            return j;
                    }
                }
            }
            return 0;
        }

        @Override
        public int getSectionForPosition(int position) {
            return 0;
        }

        @Override
        public Object[] getSections() {
            String[] sections = new String[mSections.length()];
            for (int i = 0; i < mSections.length(); i++)
                sections[i] = String.valueOf(mSections.charAt(i));
            return sections;
        }


    }
}