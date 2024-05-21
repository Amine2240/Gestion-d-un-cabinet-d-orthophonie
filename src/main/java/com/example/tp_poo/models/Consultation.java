package com.example.tp_poo.models;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Consultation extends RendezVous {

public Consultation(TypePatient typePatient , LocalDate date , LocalTime heureDebut  , Patient patient){ // ou bien entrer le patient et voir son type avec typeof
    super(date , heureDebut  , patient);
    if (typePatient == TypePatient.ENFANT){
        super.duree =  Duration.ofMinutes(150);
    }else {
        super.duree = Duration.ofMinutes(90);
    }

}
@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Consultation consultation = (Consultation) obj;
        return this.date.equals(consultation.date) && this.heureDebut.equals(consultation.heureDebut) && this.patient.equals(consultation.patient);
    }
    @Override
public int hashCode() {
        return date.hashCode() + heureDebut.hashCode() + patient.hashCode();
    }
}
