# Gestion-d-un-cabinet-d-orthophonie
OrthophonieApp
OrthophonieApp est une application desktop développée en JavaFX pour aider les orthophonistes à évaluer et à traiter les troubles de la parole chez leurs patients. L'application permet de créer et de gérer des tests et exercices, de suivre les progrès des patients et de documenter les observations cliniques.

Table des Matières
Fonctionnalités
Installation
Utilisation
Structure du Projet
Contribuer
Licence
Fonctionnalités
Création et gestion de différents types de tests :
QCU (Questions à Choix Unique)
QCM (Questions à Choix Multiples)
Réponses Libres
Exercices pratiques
Documentation des observations cliniques
Suivi des réponses des patients et évaluation de leur performance
Interface utilisateur intuitive et facile à utiliser
Installation
Prérequis
Java Development Kit (JDK) 8 ou supérieur
Apache Maven
Étapes d'installation
Cloner le dépôt

bash
Copier le code
git clone https://github.com/Amine2240/Gestion-d-un-cabinet-d-orthophonie
cd OrthophonieApp
Construire le projet

Utilisez Maven pour compiler et construire le projet :

bash
Copier le code
mvn clean install
Exécuter l'application

Après la compilation, vous pouvez exécuter l'application en utilisant :

bash
Copier le code
mvn exec:java -Dexec.mainClass="com.votreutilisateur.orthophonieapp.Main"
Utilisation
Lancer l'application
Après avoir exécuté les commandes d'installation, l'application se lancera et vous verrez l'écran d'accueil.

Naviguer dans l'application
Tests QCU : Allez dans la section "Tests" et sélectionnez "QCU" pour créer ou gérer des tests à choix unique.
Tests QCM : Allez dans la section "Tests" et sélectionnez "QCM" pour créer ou gérer des tests à choix multiples.
Réponses Libres : Allez dans la section "Tests" et sélectionnez "Réponses Libres" pour créer ou gérer des tests à réponses libres.
Exercices : Allez dans la section "Exercices" pour créer ou gérer des exercices pratiques pour les patients.
Évaluer les réponses des patients
Après que le patient a complété un test, vous pouvez évaluer ses réponses en comparant les réponses choisies avec les réponses correctes fournies dans chaque test.

Structure du Projet
Voici un aperçu de la structure du projet :

css
Copier le code
OrthophonieApp/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/votreutilisateur/orthophonieapp/
│   │   │   │   ├── Main.java
│   │   │   │   ├── models/
│   │   │   │   │   ├── QuestionQcu.java
│   │   │   │   │   ├── QuestionQcm.java
│   │   │   │   │   ├── QuestionRpsLibres.java
│   │   │   │   │   ├── Exercice.java
│   │   │   │   │   ├── TestQcu.java
│   │   │   │   │   ├── TestQcm.java
│   │   │   │   │   ├── TestRpsLibres.java
│   │   │   │   │   ├── TestExerices.java
│   │   │   │   ├── views/
│   │   │   │   │   ├── MainView.java
│   │   │   │   │   ├── QcuView.java
│   │   │   │   │   ├── QcmView.java
│   │   │   │   │   ├── RpsLibresView.java
│   │   │   │   │   ├── ExerciceView.java
│   │   │   │   ├── controllers/
│   │   │   │   │   ├── MainController.java
│   │   │   │   │   ├── QcuController.java
│   │   │   │   │   ├── QcmController.java
│   │   │   │   │   ├── RpsLibresController.java
│   │   │   │   │   ├── ExerciceController.java
│   │   ├── resources/
│   │   │   ├── fxml/
│   │   │   │   ├── MainView.fxml
│   │   │   │   ├── QcuView.fxml
│   │   │   │   ├── QcmView.fxml
│   │   │   │   ├── RpsLibresView.fxml
│   │   │   │   ├── ExerciceView.fxml
├── pom.xml
├── README.md
Contribuer
Les contributions sont les bienvenues ! Voici comment vous pouvez aider :

Fork le projet
Créez une branche pour votre fonctionnalité (git checkout -b feature/AmazingFeature)
Commit vos modifications (git commit -m 'Add some AmazingFeature')
Push sur la branche (git push origin feature/AmazingFeature)
Ouvrez une Pull Request
