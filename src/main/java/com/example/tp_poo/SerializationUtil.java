package com.example.tp_poo;

import com.example.tp_poo.models.Orthophoniste;

import java.io.*;

public class SerializationUtil {
    private static final String FILE_NAME = "orthophoniste.ser";
    private static final String FILE_PATH = System.getProperty("user.home") + File.separator + FILE_NAME;

    public static void serializeOrthophoniste(Orthophoniste orthophoniste) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(orthophoniste);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Orthophoniste deserializeOrthophoniste() {
        File file = new File(FILE_PATH);
        if (!file.exists() || file.length() == 0) {
            // Return a new Orthophoniste if the file does not exist or is empty
            return new Orthophoniste();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Orthophoniste) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
