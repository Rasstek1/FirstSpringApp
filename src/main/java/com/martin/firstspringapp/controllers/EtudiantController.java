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

    /*@RequestMapping(value="/etudiant/supprimer", method = RequestMethod.GET)
    public String supprimer(HttpServletRequest request){
        int numero=Integer.parseInt(request.getParameter("numero"));
        dc.supprimer(numero);
        return "redirect:/etudiant/liste";

    }*/

//Cette methode est la meme que celle au dessus mais on a utilisé requestParam et on retire pas tout le request pour trouver le numero
    //cest une suppression faite dans l'url
    //Avec RequestParam on recupere le numero dans lurl
    @RequestMapping(value = "/etudiant/supprimer", method = RequestMethod.GET)
    public String supprimer(@RequestParam("num") int numero) {//requestParam num parceque dans le html on a mis num
        dc.supprimer(numero);
        return "redirect:/etudiant/liste"; // Redirige vers la liste des étudiants après la suppression
    }

//Avec PathVariable on recupere le numero dans lurl
    @RequestMapping(value="/etudiant/modifier/{numero}", method = RequestMethod.GET)//{numero} est le parametre de la methode a mettre au bout de ladresse dans lurl
    public ModelAndView modifier(@PathVariable (name= "numero")int numero){//pathvariable pour recuperer le numero dans lurl
        // rechercher l'lément à modifier
        Etudiant etud=EtudiantDataContext.liste.stream().
                filter(e->e.getNumero()==numero).findFirst().orElse(null);
        //envoyer l'étudiant à la vue modifier
        return new ModelAndView("modifier", "etudiant",etud );
    }
//Avec ModelAttribute on recupere les données du formulaire
    @RequestMapping(value="/etudiant/modifier", method = RequestMethod.POST)
    public String modifierPost(@ModelAttribute(name="formModifier" )Etudiant etud){
        // modifier l' étudiant par son numero
        dc.modifier(etud,etud.getNumero());
        return "redirect:/etudiant/liste";

    }
}
