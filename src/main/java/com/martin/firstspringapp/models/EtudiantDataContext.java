package com.martin.firstspringapp.models;
import java.util.ArrayList;
import java.util.List;
public class EtudiantDataContext {
    public static List<Etudiant> liste= new ArrayList(){
        {
            add(new Etudiant(1,"Etudiant1","Etudiant1",'M'));
            add(new Etudiant(2,"Etudiant2","Etudiant2",'F'));
            add(new Etudiant(3,"Etudiant3","Etudiant3",'M'));
            add(new Etudiant(4,"Etudiant4","Etudiant4",'F'));
        }
    };
    public void supprimer(int numero){
        EtudiantDataContext.liste.removeIf((e)->e.getNumero()==numero);
    }
    public void modifier(Etudiant etud,int ancienNum){
        // rechercher l'ancien étudiant
        Etudiant ancEtud=EtudiantDataContext.liste.stream().filter(e->e.getNumero()==ancienNum).findFirst().orElse(null);
        // remplacer l'ancien par le nouveau
        ancEtud.setNumero(etud.getNumero());
        ancEtud.setNom(etud.getNom());
        ancEtud.setPrenom(etud.getPrenom());
        ancEtud.setSexe(etud.getSexe());
    }

}
