package com.pigredorou.ludotheque.bdd;

public class JeuDeSociete {
    private String mNom; // Nom du jeu
    private int mAgeMini; // Age minimum
    private int mDuree; // Durée en minutes
    private int mNbJoueursMin; // Nombre de joueurs minimum
    private int mNbJoueursMax; // Nombre de joueurs maximum
    private String mReglesPDF; // Règles du jeu en PDF
    private String mLienLudovox; // Lien vers la video de Ludovox
    private String mReglesSimplifiees; // Résumé des règles
    private String mDateAjout; // Date d'ajout du jeu

    public String getNom() {
        return this.mNom;
    }

    public int getAgeMini() {
        return this.mAgeMini;
    }

    public int getDuree() {
        return this.mDuree;
    }

    public int getNbJoueursMin() {
        return this.mNbJoueursMin;
    }

    public int getNbJoueursMax() {
        return this.mNbJoueursMax;
    }

    public String getReglesPDF() {
        return this.mReglesPDF;
    }

    public String getLienLudovox() {
        return this.mLienLudovox;
    }

    public String getReglesSimplifiees() {
        return this.mReglesSimplifiees;
    }

    public String getDateAjout() {
        return this.mDateAjout;
    }
}
