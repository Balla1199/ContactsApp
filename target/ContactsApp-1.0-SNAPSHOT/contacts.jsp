<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Contacts</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>Liste des Contacts</h1>
    <ul>
        <!-- Boucle sur la liste des contacts et affiche chaque contact -->
        <c:forEach var="contact" items="${contacts}">
            <li>
                ${contact.name} ${contact.firstName} - ${contact.telephone} - ${contact.favoriteSkill}
                <!-- Boutons de modification et de suppression -->
                <form action="contacts" method="post" style="display: inline;">
                    <input type="hidden" name="action" value="modify">
                    <input type="hidden" name="id" value="${contact.id}">
                    <button type="submit">Modifier</button>
                </form>
                <form action="contacts" method="post" style="display: inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${contact.id}">
                    <button type="submit">Supprimer</button>
                </form>
            </li>
        </c:forEach>
    </ul>

    <h2>Ajouter un nouveau contact</h2>
    <form action="contacts" method="post">
        Prénom: <input type="text" name="firstName" required><br>
        Nom: <input type="text" name="name" required><br>
        Téléphone: <input type="text" name="telephone" required><br>
        Compétence favorite: <input type="text" name="favoriteSkill" required><br>
        <button type="submit">Ajouter</button> <!-- Bouton pour soumettre le formulaire -->
    </form>
</body>
</html>
