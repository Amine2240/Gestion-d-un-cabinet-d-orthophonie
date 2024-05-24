package com.example.tp_poo;

import com.example.tp_poo.models.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AgendaManager {
    private static AgendaManager instance;
    public static AgendaManager getInstance() {
        if (instance == null) {
            instance = new AgendaManager();
        }
        return instance;
    }
    LocalDate rendezVousdate1 = LocalDate.of(2024, 1, 1);
    LocalDate rendezVousdate2 = LocalDate.of(2024, 2, 2);
    LocalDate rendezVousdate3 = LocalDate.of(2024, 3, 3);
    LocalDate rendezVousdate4 = LocalDate.of(2024, 4, 4);

    LocalTime time1 = LocalTime.of(8, 0);
    LocalTime time2 = LocalTime.of(9, 30);
    LocalTime time3 = LocalTime.of(11,0 );
    LocalTime time4 = LocalTime.of(13, 0);
    LocalTime time5 = LocalTime.of(15, 30);
    LocalTime time6 = LocalTime.of(18, 0);
    LocalTime time7 = LocalTime.of(19, 0);
    LocalTime time8 = LocalTime.of(21, 0);

    PatientDataManager patientDataManager = PatientDataManager.getInstance();
        Consultation c1 = new Consultation(TypePatient.ADULTE , rendezVousdate1 , time1 , patientDataManager.pp1);
        Consultation c2 = new Consultation(TypePatient.ENFANT , rendezVousdate2 , time4  , patientDataManager.pp2);
        Consultation c3 = new Consultation(TypePatient.ADULTE , rendezVousdate3 , time2  , patientDataManager.pp3);
        Consultation c4 = new Consultation(TypePatient.ENFANT , rendezVousdate4 , time5  , patientDataManager.pp4);

   ArrayList<Consultation> consultations = new ArrayList<>(List.of(c1, c2, c3, c4 )) ;
    //private Set<Consultation> consultationSet = new HashSet<>(consultations);

    // Create adulte objects with real data
   SeanceSuivi s1 = new SeanceSuivi(rendezVousdate1 , time6  , Deroulement.ENPRESENTIEL , patientDataManager.p1);
   SeanceSuivi s2 = new SeanceSuivi(rendezVousdate2 , time7  , Deroulement.ENLIGNE, patientDataManager.p2);
   SeanceSuivi s3 = new SeanceSuivi(rendezVousdate3 , time8  , Deroulement.ENPRESENTIEL, patientDataManager.p3);
   SeanceSuivi s4 = new SeanceSuivi(rendezVousdate4 , time3  , Deroulement.ENLIGNE, patientDataManager.p4);
   ArrayList<SeanceSuivi> seancesSuivis = new ArrayList<>(List.of(s1, s2, s3, s4)) ;

   ArrayList<RendezVous> rendezVousList = new ArrayList<>(List.of(c1, c2, c3, c4 , s1 , s2 , s3 , s4 ));

   Agenda agenda = new Agenda((ArrayList<RendezVous>) rendezVousList);

    public Agenda getAgenda() {
        return agenda;
    }

    public ArrayList<Consultation> getConsultations() {
        return consultations;
    }

    public ArrayList<SeanceSuivi> getSeancesSuivis() {
        return seancesSuivis;
    }

    public ArrayList<RendezVous> getRendezVousList() {
        return rendezVousList;
    }

    public PatientDataManager getPatientDataManager() {
        return patientDataManager;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public void setConsultations(ArrayList<Consultation> consultations) {
        this.consultations = consultations;
    }

    public void setRendezVousList(ArrayList<RendezVous> rendezVousList) {
        this.rendezVousList = rendezVousList;
    }
    public void setSeancesSuivis(ArrayList<SeanceSuivi> seancesSuivis) {
        this.seancesSuivis = seancesSuivis;
    }
}
