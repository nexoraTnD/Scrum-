# Scrum – Gestion des étudiants

## Description du projet

Ce projet consiste à développer une application de gestion des étudiants dans le cadre d'un travail d'équipe utilisant la méthodologie Agile Scrum.

L'application a pour objectif de faciliter la gestion des étudiants à travers différentes fonctionnalités, tout en assurant une organisation claire, une maintenance facile et une évolution progressive du système.

## Technologies utilisées

- Java
- Maven
- JUnit (tests unitaires)

## Structure du projet

```text
Scrum/
└── backend/
    └── gestion-etudiants/
        └── gestion-etudiants/
```

## Installation et exécution

### Prérequis

- Java JDK
- Maven
- Git

### Cloner le repository

```bash
git clone https://github.com/nexoraTnD/Scrum.git
```

### Accéder au projet backend

```bash
cd backend/gestion-etudiants/gestion-etudiants
```

### Compiler et tester le projet

```bash
mvn clean install
```

### Lancer les tests

```bash
mvn test
```

## Équipe de développement

- Anwar
- Sara
- Chaima

## Méthodologie de travail

Le projet est réalisé selon la méthodologie Agile Scrum.
# Documentation technique – Gestion des étudiants

## 1. Prérequis

Avant de commencer, installer les outils suivants :

- **Java JDK 21** : pour compiler et exécuter l'application.
- **Git** : pour récupérer le projet.
- **Docker** : pour construire et exécuter l'application dans un conteneur (facultatif si l'on souhaite uniquement exécuter l'application localement).

Le projet utilise le Maven Wrapper (`mvnw` / `mvnw.cmd`). Il n'est donc pas nécessaire d'installer Maven séparément.

## 2. Récupération du projet

Cloner le dépôt GitHub :

```bash
git clone https://github.com/nexoraTnD/Scrum-.git
```

Accéder au dossier du backend :

```bash
cd Scrum-/backend/gestion-etudiants/gestion-etudiants
```

## 3. Vérification de Java

Vérifier que Java 21 est installé :

```bash
java -version
```

## 4. Compilation du projet

### Windows

```bash
.\mvnw.cmd clean compile
```

### Linux / macOS

```bash
./mvnw clean compile
```

## 5. Exécution des tests

Pour compiler le projet et exécuter les tests :

### Windows

```bash
.\mvnw.cmd clean verify
```

### Linux / macOS

```bash
./mvnw clean verify
```

La commande `verify` exécute les tests et vérifie le projet. Si tout se passe correctement, Maven affiche `BUILD SUCCESS`.

## 6. Lancement de l'application

### Windows

```bash
.\mvnw.cmd spring-boot:run
```

### Linux / macOS

```bash
./mvnw spring-boot:run
```

L'application Spring Boot démarre sur le port configuré dans le projet.

Par défaut, l'adresse locale est :

http://localhost:8080

## 7. Construction de l'image Docker

Se placer dans le dossier du backend contenant le Dockerfile :

```bash
cd backend/gestion-etudiants/gestion-etudiants
```

Compiler d'abord le projet afin de générer le fichier JAR :

```bash
.\mvnw.cmd clean verify
```

Construire ensuite l'image Docker :

```bash
docker build -t gestion-etudiants:latest .
```

Le fichier `.dockerignore` permet d'exclure du contexte Docker les fichiers inutiles et les informations sensibles.

## 8. Lancement du conteneur Docker

Démarrer le conteneur :

```bash
docker run -d --name gestion-etudiants -p 8080:8080 gestion-etudiants:latest
```

Vérifier les conteneurs actifs :

```bash
docker ps
```

Consulter les journaux :

```bash
docker logs gestion-etudiants
```

Arrêter le conteneur :

```bash
docker stop gestion-etudiants
```

Supprimer le conteneur :

```bash
docker rm gestion-etudiants
```

## 9. Gestion des informations sensibles

Les fichiers contenant des secrets ou des informations sensibles (mots de passe, fichiers `.env`, clés privées et certificats) ne doivent pas être inclus dans l'image Docker.

Le fichier `.dockerignore` définit les fichiers et dossiers exclus du contexte de construction Docker.

Les véritables secrets doivent être fournis séparément au moment de l'exécution et ne doivent jamais être enregistrés dans Git.

Le développement est organisé en sprints, avec une répartition des tâches entre les membres de l'équipe, un suivi de l'avancement et une intégration progressive des fonctionnalités.

## Gestion du versionnement

Le code source est hébergé sur GitHub. Git est utilisé pour le suivi des modifications et la collaboration entre les membres de l'équipe.
