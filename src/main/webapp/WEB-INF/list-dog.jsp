<%@ page import="org.example.exercice5doglist.model.Dog" %>
<jsp:useBean id="dogList" type="java.util.ArrayList<org.example.exercice5doglist.model.Dog>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of dog</title>
    <%@include file="bootstrap.html"%>
</head>
<body>
<br/>
<div class="container-md rounded text-bg-dark p-3">

    <table class="table table-sm table-dark">
        <legend>Liste des chiens</legend>
        <thead>
        <tr>
            <th>Nom</th>
            <th>Race</th>
            <th>Date de naissance</th>
        </tr>
        </thead>
        <tbody class="table-group-divider"  >
        <% if (!dogList.isEmpty()) { %>
            <% for (Dog dog : dogList) { %>
                <tr>
                    <td><%= dog.getName() %></td>
                    <td><%= dog.getBreed() %></td>
                    <td><%= dog.getDateOfBirth() %></td>
                </tr>
            <% } %>
        <% } else { %>
            <tr>
                <td colspan="3">Aucun chien n'est enregistré</td>
            </tr>
        <% } %>

        </tbody>
    </table>
        <a href="add-dog" class="btn btn-success">Ajouter un chien</a>
</div>
</body>
</html>
