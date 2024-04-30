package com.example.tp_poo.models;

import java.time.Duration;

public class Consultation extends RendezVous {

public Consultation(TypePatient typePatient){
    if (typePatient == TypePatient.ENFANT){
        super.duree =  Duration.ofMinutes(120);
    }else {
        super.duree = Duration.ofMinutes(90);
    }

}
}
