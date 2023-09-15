<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</head>
<body>
<c:url var="urlSupprimer" value="/etudiant/supprimer"/>
<c:url var="urlModifier" value="/etudiant/modifier"/>
<div class="container">
    <h1>Liste étudiants</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Numéro</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Genre</th>
        </tr>
        </thead>
        <c:forEach var="etudiant" items="${etudiants}">
            <tr>
                <td>${etudiant.numero}</td>
                <td>${etudiant.nom}</td>
                <td>${etudiant.prenom}</td>
                <td>${etudiant.sexe}</td>
                <td>
                    <a class="btn btn-danger" href="${urlSupprimer}?num=${etudiant.numero}">Supprimer</a>
                    <a class="btn btn-danger" href="${urlModifier}/numero=${etudiant.numero}">Modifier</a><!--/numero au lieu de ?num parceque on modifie dans uri et non url-->
                </td>                                  <!--Dans l<url on met app/controlleur/methode/ valeur(genre 2)-->
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
