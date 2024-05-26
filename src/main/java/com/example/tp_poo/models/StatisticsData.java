package com.example.tp_poo.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class StatisticsData {
    private static final IntegerProperty A = new SimpleIntegerProperty(3);
    private static final IntegerProperty B = new SimpleIntegerProperty(4);
    private static final IntegerProperty C = new SimpleIntegerProperty(5);

    public static IntegerProperty aProperty() {
        return A;
    }

    public static IntegerProperty bProperty() {
        return B;
    }

    public static IntegerProperty cProperty() {
        return C;
    }

    public static int getA() {
        return A.get();
    }

    public static void setA(int a) {
        A.set(a);
    }

    public static int getB() {
        return B.get();
    }

    public static void setB(int b) {
        B.set(b);
    }

    public static int getC() {
        return C.get();
    }

    public static void setC(int c) {
        C.set(c);
    }
}
