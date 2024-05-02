package com.example.tp_poo.models;

import java.util.ArrayList;

public class Diagnostic {
    protected ArrayList<Trouble> troublesPatient;
    public Diagnostic(ArrayList<Trouble> troublesPatient){
        this.troublesPatient = troublesPatient;
    }
}
