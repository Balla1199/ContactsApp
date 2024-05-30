package com.contactsapp.servlet;

import com.contactsapp.model.Contact;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ContactServlet", urlPatterns = {"/contacts"})
public class ContactServelet extends HttpServlet {

    private final List<Contact> contacts = new ArrayList<>();
    private int nextId = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("contacts", contacts);
        request.getRequestDispatcher("contacts.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "modify":
                    forwardToModifyForm(request, response);
                    break;
                case "update":
                    updateContact(request);
                    response.sendRedirect("contacts");
                    break;
                case "delete":
                    deleteContact(request);
                    response.sendRedirect("contacts");
                    break;
                default:
                    break;
            }
        } else {
            addContact(request);
            response.sendRedirect("contacts");
        }
    }

    private void addContact(HttpServletRequest request) {
        String name = request.getParameter("name");
        String firstName = request.getParameter("firstName");
        String telephone = request.getParameter("telephone");
        String favoriteSkill = request.getParameter("favoriteSkill");
        contacts.add(new Contact(nextId++, name, firstName, telephone, favoriteSkill));
    }

    private void forwardToModifyForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Contact contactToModify = findContactById(id);
        request.setAttribute("contactToModify", contactToModify);
        request.getRequestDispatcher("modify_contact.jsp").forward(request, response);
    }

    private Contact findContactById(int id) {
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                return contact;
            }
        }
        return null;
    }

    private void updateContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contact contactToUpdate = findContactById(id);
        if (contactToUpdate != null) {
            String name = request.getParameter("name");
            String firstName = request.getParameter("firstName");
            String telephone = request.getParameter("telephone");
            String favoriteSkill = request.getParameter("favoriteSkill");
            contactToUpdate.setName(name);
            contactToUpdate.setFirstName(firstName);
            contactToUpdate.setTelephone(telephone);
            contactToUpdate.setFavoriteSkill(favoriteSkill);
        }
    }

    private void deleteContact(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }
}
