package com.example.tp_poo;

import com.example.tp_poo.models.Orthophoniste;

public class OrthophonisteManager {
    private static Orthophoniste orthophoniste;

    public static void loadOrthophoniste() {
        orthophoniste = SerializationUtil.deserializeOrthophoniste();
    }

    public static Orthophoniste getOrthophoniste() {
        return orthophoniste;
    }

    public static void saveOrthophoniste() {
        SerializationUtil.serializeOrthophoniste(orthophoniste);
    }
}
