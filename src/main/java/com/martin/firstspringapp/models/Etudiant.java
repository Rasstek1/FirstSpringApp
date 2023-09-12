package com.martin.firstspringapp.models;

public class Etudiant {
    private int numero;
    private String nom;
    private String prenom;
    private char sexe;


    //Constructeur
    public Etudiant(int numero, String nom, String prenom, char sexe) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
    }
    public Etudiant() {
    }

    //Methodes
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom=prenom;
    }
    public char getSexe() {
        return sexe;
    }
    public void setSexe(char sexe) {
        this.sexe = sexe;
    }



}
