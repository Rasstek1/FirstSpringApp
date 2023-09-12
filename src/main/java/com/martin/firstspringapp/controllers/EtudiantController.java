package com.martin.firstspringapp.controllers;

import com.martin.firstspringapp.models.Etudiant;
import com.martin.firstspringapp.models.EtudiantDataContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EtudiantController {

    private EtudiantDataContext dc= new EtudiantDataContext();
    public EtudiantController(){}
    @RequestMapping("/etudiant/liste")
    public ModelAndView liste(){
        return new ModelAndView("liste", "etudiants",EtudiantDataContext.liste );
    }

    @RequestMapping(value="/etudiant/supprimer", method = RequestMethod.GET)
    public String supprimer(HttpServletRequest request){
        int numero=Integer.parseInt(request.getParameter("numero"));
        dc.supprimer(numero);
        return return "redirect: /etudiant/liste ";

    }
    @RequestMapping(value="/etudiant/modifier", method = RequestMethod.GET)
    public ModelAndView modifier(HttpServletRequest request){
        //récupérer le numéro de l'élément à modifier
        int numero=Integer.parseInt(request.getParameter("numero"));
        // rechercher l'lément à modifier
        Etudiant etud=EtudiantDataContext.liste.stream().
                filter(e->e.getNumero()==numero).findFirst().orElse(null);
        //envoyer l'étudiant à la vue modifier
        return new ModelAndView("modifier", "etudiant",etud );
    }

    @RequestMapping(value="/etudiant/modifier", method = RequestMethod.POST)
    public String modifier(HttpServletRequest request){
        int numero=Integer.parseInt(request.getParameter("numero"));
        //construire un nouveau étudiant
        Etudiant etud= new Etudiant();
        etud.setNumero(Integer.parseInt(request.getParameter("numero")));
        etud.setNom(request.getParameter("nom"));
        etud.setPrenom(request.getParameter("prenom"));
        etud.setSexe(request.getParameter("sexe").charAt(0));
        // modifier l'ancien étudiant
        dc.modifier(etud,numero);
        return "redirect:/etudiant/liste";
    }
}


