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
    private int mExtension; // Renseigné uniquement si le jeu est une extension. Pointe vers l'ID du jeu de base
    private byte[] mImageCouverture; // Image de la couverture du jeu

    String getNom() {
        return this.mNom;
    }

    int getAgeMini() {
        return this.mAgeMini;
    }

    int getDuree() {
        return this.mDuree;
    }

    int getNbJoueursMin() {
        return this.mNbJoueursMin;
    }

    int getNbJoueursMax() {
        return this.mNbJoueursMax;
    }

    String getReglesPDF() {
        return this.mReglesPDF;
    }

    String getLienLudovox() {
        return this.mLienLudovox;
    }

    String getReglesSimplifiees() {
        return this.mReglesSimplifiees;
    }

    String getDateAjout() {
        return this.mDateAjout;
    }

    int getExtension() {
        return this.mExtension;
    }

    byte[] getImageCouverture() {
        return this.mImageCouverture;
    }

    public void setNom(String nom) {
        this.mNom=nom;
    }

    public void setAgeMini(int ageMini) {
        this.mAgeMini=ageMini;
    }

    public void setDuree(int duree) {
        this.mDuree=duree;
    }

    public void setNbJoueursMin(int nbJoueursMin) {
        this.mNbJoueursMin=nbJoueursMin;
    }

    public void setNbJoueursMax(int nbJoueursMax) {
        this.mNbJoueursMax=nbJoueursMax;
    }

    public void setReglesPDF(String reglesPDF) {
        this.mReglesPDF=reglesPDF;
    }

    public void setLienLudovox(String lienLudovox) {
        this.mLienLudovox=lienLudovox;
    }

    public void setReglesSimplifiees(String reglesSimplifiees) {
        this.mReglesSimplifiees=reglesSimplifiees;
    }

    public void setDateAjout(String dateAjout) {
        this.mDateAjout=dateAjout;
    }

    public void setExtension(int extension) {
        this.mExtension=extension;
    }

    public void setImageCouverture(byte[] imageCouverture) {
        this.mImageCouverture=imageCouverture;
    }
}
