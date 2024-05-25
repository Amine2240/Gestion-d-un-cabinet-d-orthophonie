package com.example.tp_poo;

import com.example.tp_poo.models.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientDataManager {
    private static PatientDataManager instance;
private    AgendaManager agendaManager;
    private PatientDataManager() {
//        this.agendaManager = AgendaManager.getInstance();

    }

    public static synchronized PatientDataManager getInstance() {
        if (instance == null) {
            instance = new PatientDataManager();
            //AgendaManager.getInstance().setPatientDataManager(instance);
//            instance.initializeData();
        }
        return instance;
    }
//    public AgendaManager getAgendaManager() {
//        if (agendaManager == null) {
//            agendaManager = AgendaManager.getInstance();
//            instance.initializeData();
//        }
//        return agendaManager;
//    }

//    public void setAgendaManager(AgendaManager agendaManager) {
////        this.agendaManager = agendaManager;
//    }

    LocalDate date1 = LocalDate.of(2000, 1, 1);
    LocalDate date2 = LocalDate.of(2001, 2, 2);
    LocalDate date3 = LocalDate.of(2002, 3, 3);
    LocalDate date4 = LocalDate.of(2003, 4, 4);

    Enfant p1 = new Enfant("kadoum", "amine", date1, "Paris", "123 Main St", "Primary", "0552484650", "0541177916");
    Enfant p2 = new Enfant("lattari", "alenas", date2, "London", "456 Elm St", "Secondary", "0552484650", "0541177916");
    Enfant p3 = new Enfant("nemamcha", "oussama", date3, "New York", "789 Oak St", "Primary", "0552484650", "0541177916");
    Enfant p4 = new Enfant("khiali", "imad", date4, "Berlin", "101 Pine St", "Secondary", "0552484650", "0541177916");

    Adulte a1 = new Adulte("kadoum", "kamel", date1, "Paris", "123 Main St", "doctorat", "architecte", "0541177916");
    Adulte a2 = new Adulte("boudraa", "mourad", date2, "London", "456 Elm St", "liscence", "medecin", "0541177916");
    Adulte a3 = new Adulte("aouni", "djamel", date3, "New York", "789 Oak St", "bacallauriat", "ingenieur", "0541177916");
    Adulte a4 = new Adulte("Emily", "Brown", date4, "Berlin", "101 Pine St", "master", "professeur", "0541177916");

    Adulte pp1 = new Adulte("becharai", "khalil", 25);
    Enfant pp2 = new Enfant("allag", "yacine", 10);
    Adulte pp3 = new Adulte("bougussa", "wail", 35);
    Enfant pp4 = new Enfant("rabia", "manil", 13);



//    ArrayList<DossierPatient> dossierPatients = new ArrayList<>(List.of(dossierPatientp1, dossierPatientp2, dossierPatientp3, dossierPatientp4, dossierPatienta1, dossierPatienta2, dossierPatienta3, dossierPatienta4));
//    ArrayList<Patient> listPatientsComplet = new ArrayList<>(List.of(p1, p2, p3, p4, a1, a2, a3, a4));
//    ArrayList<Patient> listPatientsIncomplet = new ArrayList<>(List.of(pp1, pp2, pp3, pp4));
    private List<Patient> patientsIncomplet;
    private List<Patient> patientsComplet;
    private List<DossierPatient> dossierPatients;

    TestsEtAnamnesesController testsEtAnamnesesController = new TestsEtAnamnesesController();
    AnamneseEnfant testAnamnese1 =  testsEtAnamnesesController.testAnamnese1;
    TestQcu testqcu1 = (TestQcu) testsEtAnamnesesController.testqcu1;
    TestQcm testqcm1 = (TestQcm) testsEtAnamnesesController.testqcm1;
    TestRpsLibres testRpsLibres1 = (TestRpsLibres) testsEtAnamnesesController.testRpsLibres1;
    TestExerices testExerices1 =  testsEtAnamnesesController.testExerices1;
    ArrayList<Test> listTests = new ArrayList<>(List.of(testqcu1, testqcm1, testRpsLibres1, testExerices1));


    EpreuveClinique epreuveClinique = new EpreuveClinique("epreuve clinique observation 1 "  ,listTests);
    ArrayList<EpreuveClinique> listEpreuvesCliniques = new ArrayList<>(List.of(epreuveClinique));
    Trouble trouble1 = new Trouble("nom trouble", TroubleCategries.NEURO_DEVELOPPEMENTAUX);
    ArrayList<Trouble> troubles = new ArrayList<>(List.of(trouble1));
    Diagnostic diagnostic1 = new Diagnostic(troubles);
    ProjetTherapeutique projetTherapeutique1 = new ProjetTherapeutique("projet therapeutique 1");
    Bo bo1 = new Bo( p1,testAnamnese1, listEpreuvesCliniques, diagnostic1, projetTherapeutique1);


    EpreuveClinique epreuveClinique11 = new EpreuveClinique("epreuve clinique observation 11 "  ,listTests);
    ArrayList<EpreuveClinique> listEpreuvesCliniques11 = new ArrayList<>(List.of(epreuveClinique11));
    Trouble trouble11 = new Trouble("nom trouble 11 ", TroubleCategries.COGNITIFS);
    ArrayList<Trouble> troubles11 = new ArrayList<>(List.of(trouble11));
    Diagnostic diagnostic11 = new Diagnostic(troubles11);
    ProjetTherapeutique projetTherapeutique11 = new ProjetTherapeutique("projet therapeutique 11");
    Bo bo11 = new Bo( p1, listEpreuvesCliniques11, diagnostic11, projetTherapeutique11);


    EpreuveClinique epreuveClinique111 = new EpreuveClinique("epreuve clinique observation 111 "  ,listTests);
    ArrayList<EpreuveClinique> listEpreuvesCliniques111 = new ArrayList<>(List.of(epreuveClinique111));
    Trouble trouble111 = new Trouble("nom trouble 111 ", TroubleCategries.COGNITIFS);
    ArrayList<Trouble> troubles111 = new ArrayList<>(List.of(trouble111));
    Diagnostic diagnostic111 = new Diagnostic(troubles111);
    ProjetTherapeutique projetTherapeutique111 = new ProjetTherapeutique("projet therapeutique 111");
    Bo bo111 = new Bo( p1, listEpreuvesCliniques111, diagnostic111, projetTherapeutique111);

    ArrayList<Bo> listBosp1 = new ArrayList<>(List.of(bo1 ,bo11, bo111));

    Objectif objectif1 = new Objectif(" nom Objectif 1", CategoriesObjectif.COURT_TERME);
    Objectif objectif2 = new Objectif(" nom Objectif 2", CategoriesObjectif.LONG_TERME);
    Objectif objectif3 = new Objectif(" nom Objectif 3", CategoriesObjectif.COURT_TERME);
    ArrayList<Objectif> listObjectifs11 = new ArrayList<>(List.of(objectif1, objectif2, objectif3));
    FicheSuivi ficheSuivi11 = new FicheSuivi(listObjectifs11);

    Objectif objectif11 = new Objectif(" nom Objectif 11", CategoriesObjectif.COURT_TERME);
    Objectif objectif12 = new Objectif(" nom Objectif 12", CategoriesObjectif.LONG_TERME);
    Objectif objectif13 = new Objectif(" nom Objectif 13", CategoriesObjectif.COURT_TERME);
    ArrayList<Objectif> listObjectifs111 = new ArrayList<>(List.of(objectif11, objectif12, objectif13));
    FicheSuivi ficheSuivi111 = new FicheSuivi(listObjectifs111);

    ArrayList<FicheSuivi> listFicheSuivisp1 = new ArrayList<>(List.of(ficheSuivi11, ficheSuivi111));

    EpreuveClinique epreuveClinique2 = new EpreuveClinique("epreuve clinique observation 2 "  ,listTests);
    ArrayList<EpreuveClinique> listEpreuvesCliniques2 = new ArrayList<>(List.of(epreuveClinique2));
    Trouble trouble2 = new Trouble("nom trouble 2", TroubleCategries.DEGLUTITION);
    ArrayList<Trouble> troubles2 = new ArrayList<>(List.of(trouble2));
    Diagnostic diagnostic2 = new Diagnostic(troubles2);
    ProjetTherapeutique projetTherapeutique2 = new ProjetTherapeutique("projet therapeutique 2");
    Bo bo2 = new Bo( p2,testAnamnese1, listEpreuvesCliniques2, diagnostic2, projetTherapeutique2);

    EpreuveClinique epreuveClinique22 = new EpreuveClinique("epreuve clinique observation 22 "  ,listTests);
    ArrayList<EpreuveClinique> listEpreuvesCliniques22 = new ArrayList<>(List.of(epreuveClinique22));
    Trouble trouble22 = new Trouble("nom trouble 22", TroubleCategries.DEGLUTITION);
    ArrayList<Trouble> troubles22 = new ArrayList<>(List.of(trouble22));
    Diagnostic diagnostic22 = new Diagnostic(troubles22);
    ProjetTherapeutique projetTherapeutique22 = new ProjetTherapeutique("projet therapeutique 22");
    Bo bo22 = new Bo( p2, listEpreuvesCliniques22, diagnostic22, projetTherapeutique22);

    ArrayList<Bo> listBosp2 = new ArrayList<>(List.of(bo2 , bo22));

    Objectif objectif21 = new Objectif(" nom Objectif 21", CategoriesObjectif.COURT_TERME);
    Objectif objectif22 = new Objectif(" nom Objectif 22", CategoriesObjectif.LONG_TERME);
    Objectif objectif23 = new Objectif(" nom Objectif 23", CategoriesObjectif.COURT_TERME);
    ArrayList<Objectif> listObjectifs2 = new ArrayList<>(List.of(objectif21, objectif22, objectif23));
    FicheSuivi ficheSuivi2 = new FicheSuivi(listObjectifs2);

    ArrayList<FicheSuivi> listFicheSuivisp2 = new ArrayList<>(List.of(ficheSuivi2));

    EpreuveClinique epreuveClinique3 = new EpreuveClinique("epreuve clinique observation 3 "  ,listTests);
    ArrayList<EpreuveClinique> listEpreuvesCliniques3 = new ArrayList<>(List.of(epreuveClinique3));
    Trouble trouble3 = new Trouble("nom trouble 3", TroubleCategries.DEGLUTITION);
    ArrayList<Trouble> troubles3 = new ArrayList<>(List.of(trouble3));
    Diagnostic diagnostic3 = new Diagnostic(troubles3);
    ProjetTherapeutique projetTherapeutique3 = new ProjetTherapeutique("projet therapeutique 3");
    Bo bo3 = new Bo( p3,testAnamnese1, listEpreuvesCliniques3, diagnostic3, projetTherapeutique3);

    ArrayList<Bo> listBosp3 = new ArrayList<>(List.of(bo3));

    ArrayList<FicheSuivi> listFicheSuivisp3 = new ArrayList<>();

    EpreuveClinique epreuveClinique4 = new EpreuveClinique("epreuve clinique observation 4 "  ,listTests);
    ArrayList<EpreuveClinique> listEpreuvesCliniques4 = new ArrayList<>(List.of(epreuveClinique4));
    Trouble trouble4 = new Trouble("nom trouble 4", TroubleCategries.DEGLUTITION);
    ArrayList<Trouble> troubles4 = new ArrayList<>(List.of(trouble4));
    Diagnostic diagnostic4 = new Diagnostic(troubles4);
    ProjetTherapeutique projetTherapeutique4 = new ProjetTherapeutique("projet therapeutique 4");
    Bo bo4 = new Bo( p4,testAnamnese1, listEpreuvesCliniques4, diagnostic4, projetTherapeutique4);

    ArrayList<Bo> listBosp4 = new ArrayList<>(List.of(bo4));

    ArrayList<FicheSuivi> listFicheSuivisp4 = new ArrayList<>();

    EpreuveClinique epreuveCliniquea1 = new EpreuveClinique("epreuve clinique observation a1 "  ,listTests);
    ArrayList<EpreuveClinique> listEpreuvesCliniquesa1 = new ArrayList<>(List.of(epreuveCliniquea1));
    Trouble troublea1 = new Trouble("nom trouble a1", TroubleCategries.DEGLUTITION);
    ArrayList<Trouble> troublesa1 = new ArrayList<>(List.of(troublea1));
    Diagnostic diagnostica1 = new Diagnostic(troublesa1);
    ProjetTherapeutique projetTherapeutiquea1 = new ProjetTherapeutique("projet therapeutique a1");
    Bo boa1 = new Bo( a1,testAnamnese1, listEpreuvesCliniquesa1, diagnostica1, projetTherapeutiquea1);

    ArrayList<Bo> listBosa1 = new ArrayList<>(List.of(boa1));

    ArrayList<FicheSuivi> listFicheSuivisa1 = new ArrayList<>();

    EpreuveClinique epreuveCliniquea2 = new EpreuveClinique("epreuve clinique observation a2 "  ,listTests);
    ArrayList<EpreuveClinique> listEpreuvesCliniquesa2 = new ArrayList<>(List.of(epreuveCliniquea2));
    Trouble troublea2 = new Trouble("nom trouble a2", TroubleCategries.DEGLUTITION);
    ArrayList<Trouble> troublesa2 = new ArrayList<>(List.of(troublea2));
    Diagnostic diagnostica2 = new Diagnostic(troublesa2);
    ProjetTherapeutique projetTherapeutiquea2 = new ProjetTherapeutique("projet therapeutique a2");
    Bo boa2 = new Bo( a2,testAnamnese1, listEpreuvesCliniquesa2, diagnostica2, projetTherapeutiquea2);

    ArrayList<Bo> listBosa2 = new ArrayList<>(List.of(boa2));

    ArrayList<FicheSuivi> listFicheSuivisa2 = new ArrayList<>();

    EpreuveClinique epreuveCliniquea3 = new EpreuveClinique("epreuve clinique observation a3 "  ,listTests);
    ArrayList<EpreuveClinique> listEpreuvesCliniquesa3 = new ArrayList<>(List.of(epreuveCliniquea3));
    Trouble troublea3 = new Trouble("nom trouble a3", TroubleCategries.DEGLUTITION);
    ArrayList<Trouble> troublesa3 = new ArrayList<>(List.of(troublea3));
    Diagnostic diagnostica3 = new Diagnostic(troublesa3);
    ProjetTherapeutique projetTherapeutiquea3 = new ProjetTherapeutique("projet therapeutique a3");
    Bo boa3 = new Bo( a3,testAnamnese1, listEpreuvesCliniquesa3, diagnostica3, projetTherapeutiquea3);

    ArrayList<Bo> listBosa3 = new ArrayList<>(List.of(boa3));

    ArrayList<FicheSuivi> listFicheSuivisa3 = new ArrayList<>();

    EpreuveClinique epreuveCliniquea4 = new EpreuveClinique("epreuve clinique observation a4 "  ,listTests);
    ArrayList<EpreuveClinique> listEpreuvesCliniquesa4 = new ArrayList<>(List.of(epreuveCliniquea4));
    Trouble troublea4 = new Trouble("nom trouble a4", TroubleCategries.DEGLUTITION);
    ArrayList<Trouble> troublesa4 = new ArrayList<>(List.of(troublea4));
    Diagnostic diagnostica4 = new Diagnostic(troublesa4);
    ProjetTherapeutique projetTherapeutiquea4 = new ProjetTherapeutique("projet therapeutique a4");
    Bo boa4 = new Bo( a4,testAnamnese1, listEpreuvesCliniquesa4, diagnostica4, projetTherapeutiquea4);

    ArrayList<Bo> listBosa4 = new ArrayList<>(List.of(boa4));

    ArrayList<FicheSuivi> listFicheSuivisa4 = new ArrayList<>();

    DossierPatient dossierPatientp1;
    DossierPatient dossierPatientp2;
    DossierPatient dossierPatientp3;
    DossierPatient dossierPatientp4;
    DossierPatient dossierPatienta1;
    DossierPatient dossierPatienta2;
    DossierPatient dossierPatienta3;
    DossierPatient dossierPatienta4;

    public void initializeData(AgendaManager agendaManager) {
        //setAgendaManager(AgendaManager.getInstance());
         dossierPatientp1 = new DossierPatient(p1, listBosp1, null, listFicheSuivisp1);
         dossierPatientp2 = new DossierPatient(p2, listBosp2, null, listFicheSuivisp2);
         dossierPatientp3 = new DossierPatient(p3, listBosp3, null, listFicheSuivisp3);
         dossierPatientp4 = new DossierPatient(p4, listBosp4, null, listFicheSuivisp4);
         dossierPatienta1 = new DossierPatient(a1, listBosa1, null, listFicheSuivisa1);
         dossierPatienta2 = new DossierPatient(a2, listBosa2, null, listFicheSuivisa2);
         dossierPatienta3 = new DossierPatient(a3, listBosa3, null, listFicheSuivisa3);
         dossierPatienta4 = new DossierPatient(a4, listBosa4, null, listFicheSuivisa4);

        agendaManager.remplirlistRendezVousPatient(dossierPatientp1);
        agendaManager.remplirlistRendezVousPatient(dossierPatientp2);
        agendaManager.remplirlistRendezVousPatient(dossierPatientp3);
        agendaManager.remplirlistRendezVousPatient(dossierPatientp4);
        agendaManager.remplirlistRendezVousPatient(dossierPatienta1);
        agendaManager.remplirlistRendezVousPatient(dossierPatienta2);
        agendaManager.remplirlistRendezVousPatient(dossierPatienta3);
        agendaManager.remplirlistRendezVousPatient(dossierPatienta4);


//        dossierPatients = new ArrayList<>(List.of(dossierPatientp1, dossierPatientp2, dossierPatientp3, dossierPatientp4, dossierPatienta1, dossierPatienta2, dossierPatienta3, dossierPatienta4));
//        patientsComplet = new ArrayList<>(List.of(p1, p2, p3, p4, a1, a2, a3, a4));
//        patientsIncomplet = new ArrayList<>(List.of(pp1, pp2, pp3, pp4));
        dossierPatients = getDossiersPatients();
        patientsComplet = getPatientsComplet();
        patientsIncomplet = getPatientsIncomplet();

    }




    // Add methods to access and modify patient data
    public List<Patient> getPatientsIncomplet() {
        if (patientsIncomplet == null) {
            patientsIncomplet = new ArrayList<>(List.of(pp1, pp2, pp3, pp4));
        }
        return patientsIncomplet;
    }

    public void setPatientsIncomplet(List<Patient> patientsIncomplet) {
        this.patientsIncomplet = patientsIncomplet;
    }
    public List<Patient> getPatientsComplet() {
        if (patientsComplet == null) {
            patientsComplet = new ArrayList<>(List.of(p1, p2, p3, p4, a1, a2, a3, a4));
        }
        return patientsComplet;
    }
    public void setPatientsComplet(List<Patient> patientsComplet) {
        if (patientsComplet == null) {
            patientsComplet = new ArrayList<>(List.of(p1, p2, p3, p4, a1, a2, a3, a4));
        }
        this.patientsComplet = patientsComplet;
    }
    public List<DossierPatient> getDossiersPatients() {
        if (dossierPatients == null) {
            dossierPatients = new ArrayList<>(List.of(dossierPatientp1, dossierPatientp2, dossierPatientp3, dossierPatientp4, dossierPatienta1, dossierPatienta2, dossierPatienta3, dossierPatienta4)); ;
        }
        return dossierPatients;
    }
    public void setDossierPatient(List<DossierPatient> dossierPatients) {
        this.dossierPatients = dossierPatients;
    }
    public void addPatient(Patient patient) {
        patientsComplet.add(patient);
    }

    public void setDossierToPatients(){
        for (int i = 0; i < patientsComplet.size(); i++) {
            System.out.println("dossierPatients.get(i) = " + dossierPatients.get(i).getPatient().getNom());
            System.out.println("patientsComplet.get(i) = " + patientsComplet.get(i).getNom());
            patientsComplet.get(i).setDossierPatient(dossierPatients.get(i));

        }
//        for (Patient patient : patientsIncomplet) {
//            patient.setDossierPatient();
//        }
    }
    public void addDossierPatient(DossierPatient dossierPatient) {
        dossierPatients.add(dossierPatient);

    }

    // Sim
}
