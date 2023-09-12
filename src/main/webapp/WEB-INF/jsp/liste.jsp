<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="fr">
<body>
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
                    <button class="btn btn-danger" onclick="location.href='/TestSpring/etudiant/supprimer?numero=${etudiant.numero}'">Supprimer</button> |
                    <a class="btn btn-danger" href="/TestSpring/etudiant/modifier?numero=${etudiant.numero}">modifier</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
