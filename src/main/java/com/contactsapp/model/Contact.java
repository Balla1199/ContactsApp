package com.contactsapp.model;

// Classe représentant un contact avec un nom, prénom, téléphone, une compétence favorite et un identifiant
public class Contact {
    private int id; // Identifiant du contact
    private String name; // Nom du contact
    private String firstName; // Prénom du contact
    private String telephone; // Téléphone du contact
    private String favoriteSkill; // Compétence favorite du contact

    // Constructeur par défaut (nécessaire pour éviter l'erreur)
    public Contact() {
    }

    // Constructeur de la classe Contact avec des paramètres
    public Contact(int id, String name, String firstName, String telephone, String favoriteSkill) {
        this.id = id;
        this.name = name;
        this.firstName = firstName;
        this.telephone = telephone;
        this.favoriteSkill = favoriteSkill;
    }

    // Getter pour l'identifiant
    public int getId() {
        return id;
    }

    // Setter pour l'identifiant
    public void setId(int id) {
        this.id = id;
    }

    // Getter pour le nom
    public String getName() {
        return name;
    }

    // Setter pour le nom
    public void setName(String name) {
        this.name = name;
    }

    // Getter pour le prénom
    public String getFirstName() {
        return firstName;
    }

    // Setter pour le prénom
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter pour le téléphone
    public String getTelephone() {
        return telephone;
    }

    // Setter pour le téléphone
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    // Getter pour la compétence favorite
    public String getFavoriteSkill() {
        return favoriteSkill;
    }

    // Setter pour la compétence favorite
    public void setFavoriteSkill(String favoriteSkill) {
        this.favoriteSkill = favoriteSkill;
    }
}
