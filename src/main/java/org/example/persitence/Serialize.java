package org.example.persitence;

import org.example.model.Marketplace;

import java.beans.XMLEncoder;
import java.io.*;

public class Serialize {


    /**
     * Metodo que serializa un objeto en xml
     */
    public static void serialize(String ruta) {

        Object objeto = Marketplace.getInstance();
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(ruta, true);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            objectOutputStream.writeObject(objeto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            objectOutputStream.close();
            bufferedOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public static Marketplace deserializar(String ruta){
        Object objeto = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(ruta);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
            objeto = objectInputStream.readObject();

            objectInputStream.close();
            bufferedInputStream.close();
            fileInputStream.close();

        }catch (Exception ignored) {

        }

        return (Marketplace) objeto;
    }

}
