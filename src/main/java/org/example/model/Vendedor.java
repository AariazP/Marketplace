package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

@Setter
@Getter
public class Vendedor implements Serializable {


    private String nombre;
    private String apellido;
    private String user;
    private String password;
    private ArrayList<Vendedor> vendedores;
    private ArrayList<Chat> chats;
    private ArrayList<Solicitud> solicitudes;

    public Vendedor(String nombre, String apellido, String user, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.user = user;
        this.password = password;
        vendedores = new ArrayList<>();
        chats = new ArrayList<>();
        solicitudes = new ArrayList<>();
    }


    public boolean compararUser(String user) {
        return this.user.equals(user);
    }

    public boolean compararPassword(String password) {
        return this.user.equals(password);
    }

    public void addVendedorAmigo(Vendedor vendedor) {
        vendedores.add(vendedor);
    }
}
