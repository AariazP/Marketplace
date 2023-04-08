package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@ToString
public class Marketplace implements Serializable {

    private static Marketplace instance;

    private ArrayList<Vendedor> vendedores;

    private Marketplace() {
        vendedores = new ArrayList<>();
    }

    public static Marketplace getInstance() {
        if (instance == null) {
            instance = new Marketplace();
        }
        return instance;
    }

    public static void setInstance(Marketplace marketplace) {
       getInstance();
        System.out.println("marketplace deserializado = " + marketplace);
       instance.setVendedores(marketplace.getVendedores());
    }


    public boolean login(String user, String password) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.compararUser(user) && vendedor.compararPassword(password)) return true;
        }
        return false;
    }

    public void addVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
    }

    public Vendedor getVendedor(String user, String password) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.compararUser(user) && vendedor.compararPassword(password)) return vendedor;
        }
        return null;
    }
}
