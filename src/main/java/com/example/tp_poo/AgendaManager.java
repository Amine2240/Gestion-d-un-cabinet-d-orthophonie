package com.example.tp_poo;

import com.example.tp_poo.models.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AgendaManager implements Serializable {
    private static AgendaManager instance;
    PatientDataManager patientDataManager;
    private AgendaManager( ) {
       //this.patientDataManager = PatientDataManager.getInstance();

      getPatientDataManager();

    }
    public static AgendaManager getInstance() {
        if (instance == null) {

            instance = new AgendaManager();
            //instance = OrthophonisteManager.getOrthophoniste().getAgendaManager();
        }
        return instance;
    }
//    public static void setInstance(AgendaManager instance) {
//        AgendaManager.instance = instance;
//    }

    public PatientDataManager getPatientDataManager() {
        if (patientDataManager == null) {
           patientDataManager = PatientDataManager.getInstance();
            //patientDataManager = OrthophonisteManager.getOrthophoniste().getPatientDataManager();
        }
        return patientDataManager;
    }
    public void setPatientDataManager(PatientDataManager patientDataManager) {
        this.patientDataManager = patientDataManager;
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


        Consultation c1 = new Consultation(TypePatient.ADULTE , rendezVousdate1 , time1 , getPatientDataManager().pp1);
        Consultation c2 = new Consultation(TypePatient.ENFANT , rendezVousdate2 , time4  , getPatientDataManager().pp2);
        Consultation c3 = new Consultation(TypePatient.ADULTE , rendezVousdate3 , time2  , getPatientDataManager().pp3);
        Consultation c4 = new Consultation(TypePatient.ENFANT , rendezVousdate4 , time1  , getPatientDataManager().pp4);

        // ces consultations ne seront pas ajoutés à la liste des consultations car ils sont considérées comme faites
        Consultation c5 = new Consultation(TypePatient.ADULTE , rendezVousdate1 , time2 , getPatientDataManager().p1);
        Consultation c6 = new Consultation(TypePatient.ENFANT , rendezVousdate2 , time3  , getPatientDataManager().p2);
        Consultation c7 = new Consultation(TypePatient.ADULTE , rendezVousdate3 , time4  , getPatientDataManager().p3);
        Consultation c8 = new Consultation(TypePatient.ENFANT , rendezVousdate4 , time5  , getPatientDataManager().p4);

   ArrayList<Consultation> consultations = new ArrayList<>(List.of(c1, c2, c3, c4 )) ;
    //private Set<Consultation> consultationSet = new HashSet<>(consultations);

    // Create adulte objects with real data
    // p1 a fait une consultation (c5) et 2 seance de suivi (s11 et s111) et programme une autre seance de suivi (s1)
   SeanceSuivi s1 = new SeanceSuivi(rendezVousdate1 , time4  , Deroulement.ENPRESENTIEL , getPatientDataManager().p1);
   SeanceSuivi s11 = new SeanceSuivi(rendezVousdate1 , time5  , Deroulement.ENPRESENTIEL , getPatientDataManager().p1);
    SeanceSuivi s111 = new SeanceSuivi(rendezVousdate2 , time5  , Deroulement.ENPRESENTIEL , getPatientDataManager().p1);
    // p2 a fait une consultation (c6) et une seance de suivi (s2) et programme une autre seance de suivi (s2)
   SeanceSuivi s2 = new SeanceSuivi(rendezVousdate2 , time7  , Deroulement.ENLIGNE, getPatientDataManager().p2);
    SeanceSuivi s22 = new SeanceSuivi(rendezVousdate1 , time3  , Deroulement.ENPRESENTIEL , getPatientDataManager().p1);
   SeanceSuivi s3 = new SeanceSuivi(rendezVousdate3 , time1  , Deroulement.ENPRESENTIEL, getPatientDataManager().p3);
   SeanceSuivi s4 = new SeanceSuivi(rendezVousdate4 , time3  , Deroulement.ENLIGNE, getPatientDataManager().p4);
   SeanceSuivi s5 = new SeanceSuivi(rendezVousdate1 , time6  , Deroulement.ENPRESENTIEL , getPatientDataManager().a1);
    SeanceSuivi s6 = new SeanceSuivi(rendezVousdate2 , time6  , Deroulement.ENLIGNE, getPatientDataManager().a2);
    SeanceSuivi s7 = new SeanceSuivi(rendezVousdate3 , time5  , Deroulement.ENPRESENTIEL, getPatientDataManager().a3);
    SeanceSuivi s8 = new SeanceSuivi(rendezVousdate4 , time2  , Deroulement.ENLIGNE, getPatientDataManager().a4);
   ArrayList<SeanceSuivi> seancesSuivis = new ArrayList<>(List.of(s1, s2, s3, s4 , s5 , s6   , s7 , s8));

   ArrayList<RendezVous> rendezVousList = new ArrayList<>(List.of(c1, c2, c3, c4 ,c5,c6,c7,c8, s1 , s2 , s3 , s4 , s5 , s6   , s7 , s8 , s11 , s111, s22));

   Agenda agenda = new Agenda(rendezVousList);


//   public Patient patient(Patient patient){
//
//       if (patientDataManager == null){
//           System.out.println("patientDataManager is null");
//           return new Adulte("ffff", "fffff", LocalDate.now(), "Berlin", "101 Pine St", "master", "professeur", "0541177916");
//       }
//       return patient;
//   }
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

//    public PatientDataManager getPatientDataManager() {
//        return patientDataManager;
//    }

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
    public void remplirlistRendezVousPatient(DossierPatient dossierPatient) {

        ArrayList<RendezVous> rendezVousPatient = new ArrayList<>();
        for (RendezVous rendezVous : rendezVousList) {
            if (rendezVous.getPatient().getNom().equals(dossierPatient.getPatient().getNom()) && rendezVous.getPatient().getPrenom().equals(dossierPatient.getPatient().getPrenom())) {
                rendezVousPatient.add(rendezVous);

            }
        }
        dossierPatient.setListRdvous(rendezVousPatient);

    }
}
