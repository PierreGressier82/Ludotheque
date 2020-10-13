package com.pigredorou.ludotheque.bdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class JeuDeSocieteDBOpenHelper extends SQLiteOpenHelper {
    static class Constants implements BaseColumns {

        static final String DATABASE_NAME = "ludotheque.db";
        static final int DATABASE_VERSION = 1;
        static final String TABLE_JDS = "JeuxSociete";

        // Noms de colonnes
        static final String COL_ID = "_id";
        static final String COL_NOM = "nom";
        static final String COL_AGEMIN = "AgeMin";
        static final String COL_NBJMIN = "nbJoueursMin";
        static final String COL_NBJMAX = "nbJoueursMax";
        static final String COL_DUREE = "Duree";
        static final String COL_REGLESPDF = "ReglesPDF";
        static final String COL_RESUMEREGLES = "ResumeRegles";
        static final String COL_LUDOVOX = "LienLudovox";
        static final String COL_DATEAJOUT = "dateAjout";

        // Index des colonnes
        //public static final int NUM_COL_ID = 0;
        //public static final int NUM_COL_SCORE = 1;
        //public static final int NUM_COL_NOM = 2;
        //public static final int NUM_COL_DATE = 3;
        //public static final int NUM_COL_NBJ = 4;
    }

    private static final String CREATION_TABLE_SCORE = "create table " + Constants.TABLE_JDS + " ("
            + Constants.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Constants.COL_NOM + " TEXT NOT NULL, "
            + Constants.COL_AGEMIN + " INTEGER NOT NULL, "
            + Constants.COL_DUREE + " INTEGER NOT NULL, "
            + Constants.COL_NBJMIN + " INTEGER NOT NULL, "
            + Constants.COL_NBJMAX + " INTEGER NOT NULL, "
            + Constants.COL_REGLESPDF + " TEXT, "
            + Constants.COL_RESUMEREGLES + " TEXT, "
            + Constants.COL_LUDOVOX + " TEXT, "
            + Constants.COL_DATEAJOUT + " DATE NOT NULL)";

    JeuDeSocieteDBOpenHelper(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATION_TABLE_SCORE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_JDS);
        onCreate(db);
    }
}
