<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

</head>
<body>
<c:url var="urlModifier" value="/etudiant/modifier"/>
<table class="table table-striped">
    <form method="post" action="${urlModifier}">
        <tr>
            <td>Numéro :</td>
            <td><input class="form-control" type="text" name="numero" value="${etudiant.numero}" readonly/></td>
        </tr>
        <tr>
            <td>Nom :</td>
            <td><input class="form-control" type="text" name="nom" value="${etudiant.nom}" /></td>
        </tr>
        <tr>
            <td>Prénom :</td>
            <td><input class="form-control" type="text" name="prenom" value="${etudiant.prenom}" /></td>
        </tr>
        <tr>
            <td>Sexe :</td>
            <td>
                <c:if test="${etudiant.sexe.toString().toUpperCase()=='M'}">
                    <input type="radio" name="sexe" value="M" checked >Masculin</input>
                    <input type="radio" name="sexe" value="F" >Féminin</input>
                </c:if>
                <c:if test="${etudiant.sexe.toString().toUpperCase()=='F'}">
                    <input type="radio" name="sexe" value="M" >Masculin</input>
                    <input type="radio" name="sexe" value="F" checked>Féminin</input>
                </c:if>

            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button  type="submit" name="submit"  class="btn btn-primary center" >Valider</button>
                <button  type="reset" name="annuler" class="btn btn-danger center" onclick="return confirm('Voulez-vous effacer tous les champs?');">Annuler</button>

            </td>
        </tr>
    </form>
</table>
</body>
</html>
