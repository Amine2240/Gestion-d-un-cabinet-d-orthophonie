package com.example.tp_poo.models;

import java.sql.Time;
import java.time.Duration;
import java.util.Date;

public class Consultation extends RendezVous {

public Consultation(TypePatient typePatient , Date date , Time heure){ // ou bien entrer le patient et voir son type avec typeof
    super(date , heure );
    if (typePatient == TypePatient.ENFANT){
        super.duree =  Duration.ofMinutes(120);
    }else {
        super.duree = Duration.ofMinutes(90);
    }

}
}
