package com.example.tp_poo.models;

import java.sql.Time;
import java.util.*;

public class Orthophoniste {
 private String nom;
 private String prenom;
 private String email;
 private String mdp;
 private String adresse;
 private String numero_Tel;

 public Orthophoniste(String nom, String prenom, String email, String mdp, String adresse, String numero_Tel) {
  this.nom = nom;
  this.prenom = prenom;
  this.email = email;
  this.mdp = mdp;
  this.adresse = adresse;
  this.numero_Tel = numero_Tel;
 }

 public void creerCompte() {
  //utiliser le constructeur et la fonctionalité de la serialization
 }

 public void seConnecter() {
  //utiliser la fonctionalité de la deserialization
 }

 public void programmerRendezVous() {
  Date date1 = new Date();
  Time heure1 = new Time(12, 0, 0);

//  Date date2 = new Date();
//  Time heure2 = new Time(15, 0, 0);
//
//  Date date3 = new Date();
//  Time heure3 = new Time(20, 0, 0);
  //  RendezVous rendezVous2 = new SeanceSuivi(date2,heure2, Deroulement.ENPRESENTIEL );
//  RendezVous rendezVous3 = new Atelier(date3 , heure3 , " thematique atelier 1");


// verifier lheure et la date avant de  creer un rendez vous
  RendezVous rendezVous1 = new Consultation(TypePatient.ENFANT, date1, heure1);

 }

 public void redigerObservation(RendezVous rendezVous) {
  rendezVous.setObservation("observation qui resume le deroulement de la seance");
 }

 public void connaitrePatient() {
  Date dateNaissance1 = new Date();
  Patient p1 = new Enfant("nom1", "prenom1", dateNaissance1, "lieuNaissance1", "adresse1", "classeEtude1", "numeroMere_Tel2", "numeroMere_Tel2");
 }

 public void faireBO(Patient patient) {//collecter les informations sur le patient ( on est dans le premier Bo)

  ArrayList<QuestionAnamnese> listQuestionsAnamnese1 = new ArrayList<QuestionAnamnese>();
  Anamnese anamnese1 = new AnamneseEnfant(listQuestionsAnamnese1); // si cetait un adulte on passe son histoire de maladie en parametre


  Set<QuestionQcm> listQuestionsQcm = new HashSet<QuestionQcm>();
  Test test1 = new TestQcm(listQuestionsQcm, "nom test 1", "observation orthophoniste 1");

  Set<QuestionQcu> listQuestionsQcu = new HashSet<QuestionQcu>();
  Test test2 = new TestQcu(listQuestionsQcu, "nom test 2", "observation orthophoniste 2");

  Set<QuestionRpsLibres> listQuestionsrpslibres = new HashSet<QuestionRpsLibres>();
  Test test3 = new TestRpsLibres(listQuestionsrpslibres, "nom test 3", "observation orthophoniste 3");

  ArrayList<Exercice> listExercices = new ArrayList<Exercice>();
  Test test4 = new TestExerices("nom test 3", "observation orthophoniste 3", listExercices);


  ArrayList<Test> tests = new ArrayList<Test>();
  tests.add(test1);
  tests.add(test2);
  tests.add(test3);
  tests.add(test4);
  EpreuveClinique epreuveClinique1 = new EpreuveClinique("observation epreuve clinique 1", tests);

  ArrayList<EpreuveClinique> listEpreuvesCliniques1 = new ArrayList<EpreuveClinique>();
  listEpreuvesCliniques1.add(epreuveClinique1);

  Trouble trouble1 = new Trouble("nom trouble 1", TroubleCategries.DEGLUTITION);
  Trouble trouble2 = new Trouble("nom trouble 2", TroubleCategries.COGNITIFS);
  Trouble trouble3 = new Trouble("nom trouble 3", TroubleCategries.NEURO_DEVELOPPEMENTAUX);
  ArrayList<Trouble> listtroubles1 = new ArrayList<Trouble>();
  listtroubles1.add(trouble1);
  listtroubles1.add(trouble2);
  listtroubles1.add(trouble3);
  Diagnostic diagnostic1 = new Diagnostic(listtroubles1);
  ProjetTherapeutique projetTherapeutique1 = new ProjetTherapeutique("texte demarche therapeutique 1");
  Bo bo1 = new Bo(patient, anamnese1, listEpreuvesCliniques1, diagnostic1, projetTherapeutique1);
 }

 public QuestionQcm creerQuestionQCM(String questionEnonce, int scoreQuestion, List<String> listpropositions, List<String> listReponsesPatient, List<String> listReponsesJustes) {
  return new QuestionQcm(questionEnonce, scoreQuestion, listpropositions, listReponsesPatient, listReponsesJustes);
  // ListQuestionsQcm.add(qcm1);
 };

 public QuestionQcu creerQuestionQcu(String questionEnonce, int scoreQuestion, List<String> listpropositions, String ReponsesPatient, String ReponseJuste) {
  return new QuestionQcu(questionEnonce, scoreQuestion, listpropositions, ReponsesPatient, ReponseJuste);
  // ListQuestionsQcu.add(qcu1);
 };

 public QuestionRpsLibres creerQuestionRpsLibre(String questionEnonce, int scoreQuestion, String reponsePatientLibre) {
  return new QuestionRpsLibres(questionEnonce, scoreQuestion, reponsePatientLibre);
  // ListQuestionsRpsLibre.add(qRpsLibre);
 };

 public Exercice creerExercice(String nomExo, String consigneExo, String nomMaterielExo) {
  return new Exercice(nomExo, consigneExo, nomMaterielExo);
 };

 public TestQcm creerTestQcm(Set<QuestionQcm> listQuestionsQcm, String nom, String orthogonisteObservation) {
  return new TestQcm(listQuestionsQcm, nom, orthogonisteObservation);
 }; // observation ne doit pas etre dans le constructeur

 public TestQcu creerTestQcu(Set<QuestionQcu> listQuestionsQcu, String nom, String orthogonisteObservation) {
  return new TestQcu(listQuestionsQcu, nom, orthogonisteObservation);
 };

 public TestRpsLibres creerTestRpsLibres(Set<QuestionRpsLibres> listQuestionsRpsLibres, String nom, String orthogonisteObservation) {
  return new TestRpsLibres(listQuestionsRpsLibres, nom, orthogonisteObservation);
 };

 public TestExerices creerTestExercices(ArrayList<Exercice> listExercices, String nom, String orthogonisteObservation) {
  return new TestExerices(nom, orthogonisteObservation, listExercices);
 };

 public EpreuveClinique creerEpreuveClinique(String observation, ArrayList<Test> tests) {
  return new EpreuveClinique(observation, tests);
 };

 public Diagnostic creerDiagnostic(ArrayList<Trouble> troubles) {
  return new Diagnostic(troubles);
 };

 public ProjetTherapeutique creerProjetTherapeutique(String texte) {
  return new ProjetTherapeutique(texte);
  //
 }
 public Anamnese creerAnamneseEnfant(ArrayList<QuestionAnamnese> listQuestions){
  return new AnamneseEnfant(listQuestions);
 }
 public Anamnese creerAnamneseadulte(String histoireMaladie){
  return new AnamneseAdulte(histoireMaladie);
 }
}