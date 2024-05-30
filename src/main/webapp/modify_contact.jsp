<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier un contact</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Modifier un contact</h1>
    
    <%-- Récupération du contact à modifier --%>
    <%@ page import="com.contactsapp.model.Contact" %>
    <% Contact contactToModify = (Contact) request.getAttribute("contactToModify"); %>
    
    <%-- Formulaire de modification --%>
    <form action="contacts" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="<%= contactToModify.getId() %>">
        Prénom: <input type="text" name="firstName" value="<%= contactToModify.getFirstName() %>" required><br>
        Nom: <input type="text" name="name" value="<%= contactToModify.getName() %>" required><br>
        Téléphone: <input type="text" name="telephone" value="<%= contactToModify.getTelephone() %>" required><br>
        Compétence favorite: <input type="text" name="favoriteSkill" value="<%= contactToModify.getFavoriteSkill() %>" required><br>
        <button type="submit">Modifier</button> <!-- Bouton pour soumettre le formulaire -->
    </form>
</body>
</html>
