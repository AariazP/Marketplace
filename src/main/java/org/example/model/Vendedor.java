package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    private static int idAux = 0;
    private int id;

    public Vendedor(String nombre, String apellido, String user, String password) {
        id = ++idAux;
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



    public boolean compareId(int id) {
        return this.id == id;
    }

    public void addMensaje(String mensaje, Vendedor vendedorDestino) {

        for (Chat chat : chats) {
            if (chat.compareVendedor(vendedorDestino)) {
                chat.addMensaje(mensaje);
                return;
            }
        }

        if(this.equals(vendedorDestino)) System.out.println(" Son los mismos " );
        Chat chat = new Chat(this, vendedorDestino);
        chat.addMensaje(mensaje);
        chats.add(chat);
    }

    public ArrayList<String> getMensajes(Vendedor vendedorActivo) {
        for (Chat chat : chats) {
            if (chat.compareVendedor(vendedorActivo)) {
                return chat.getListaMensajes();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", vendedores=" + vendedores.get(0).getNombre() +
                ", chats=" + chats +
                ", solicitudes=" + solicitudes +
                ", id=" + id +
                '}';
    }

    public Vendedor getVendedor(int obtenerID) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.compareId(obtenerID)) return vendedor;
        }
        return null;
    }
}
