package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
@Getter
@Setter
public class Chat implements Serializable {

    private ArrayList<String> listaMensajes;
    private Vendedor vendedor1;
    private Vendedor vendedor2;

    public Chat(Vendedor vendedor1, Vendedor vendedor2) {
        this.vendedor1 = vendedor1;
        this.vendedor2 = vendedor2;
        listaMensajes = new ArrayList<>();
    }

    public boolean compareVendedor(Vendedor vendedorDestino) {

        return (vendedor1 != null && vendedor2 != null && (vendedor1.equals(vendedorDestino) || vendedor2.equals(vendedorDestino)));
    }

    public void addMensaje(String mensaje) {
        listaMensajes.add(mensaje);
    }

    @Override
    public String toString() {
        return "Chat{" +
                "listaMensajes=" + listaMensajes +
                ", vendedor1=" + vendedor1.getNombre() +
                ", vendedor2=" + vendedor2.getNombre() +
                '}';
    }
}
