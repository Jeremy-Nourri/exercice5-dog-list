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

<table class="col-6 offset-2 rounded text-bg-dark p-3">
    <thead>
    <tr>
        <th>nom</th>
        <th>race</th>
        <th>date de naissance</th>
    </tr>
    </thead>
    <tbody>
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
</body>
</html>
