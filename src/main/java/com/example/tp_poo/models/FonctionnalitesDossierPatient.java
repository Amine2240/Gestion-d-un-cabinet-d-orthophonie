package com.example.tp_poo.models;

public interface FonctionnalitesDossierPatient {
    public void consulterDossierPatient(DossierPatient dossierPatient);
    public void consulterObservation(RendezVous rendezVous);
    public void consulterCompteRenduTests(EpreuveClinique epreuveClinique);//orthogonisteObservation // on va voir si elle reste ici ou pas
    public void consulterBOsDossierPatient(DossierPatient dossierPatient);
    public void consulterFichesSuiviDossierPatient(DossierPatient dossierPatient);
    public void afficherCourbe(FicheSuivi ficheSuivi);
}
