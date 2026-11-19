# Scrum – Gestion des étudiants

## 1. Description du projet

Ce projet consiste à développer une application de gestion des étudiants dans le cadre d'un travail d'équipe utilisant la méthodologie Agile Scrum.

## 2. Technologies utilisées

- Java 21
- Spring Boot
- Maven Wrapper
- JUnit
- Docker

## 3. Prérequis

Avant de commencer, installer :

- Java JDK 21
- Git
- Docker (facultatif pour une exécution locale sans conteneur)

Le projet utilise Maven Wrapper (`mvnw` et `mvnw.cmd`). Il n'est donc pas nécessaire d'installer Maven séparément.

## 4. Récupération du projet

Cloner le dépôt :

```bash
git clone https://github.com/nexoraTnD/Scrum-.git
```

Accéder au dossier du backend :

```bash
cd Scrum-/backend/gestion-etudiants/gestion-etudiants
```

## 5. Vérification de Java

```bash
java -version
```

La version utilisée pour le projet est Java 21.

## 6. Compilation du projet

Sous Windows :

```bash
.\mvnw.cmd clean compile
```

Sous Linux / macOS :

```bash
./mvnw clean compile
```

## 7. Exécution des tests

Sous Windows :

```bash
.\mvnw.cmd clean verify
```

Sous Linux / macOS :

```bash
./mvnw clean verify
```

Cette commande compile le projet et exécute les tests automatisés.

Une exécution réussie affiche `BUILD SUCCESS`.

## 8. Lancement de l'application

Sous Windows :

```bash
.\mvnw.cmd spring-boot:run
```

Sous Linux / macOS :

```bash
./mvnw spring-boot:run
```

L'application est accessible à l'adresse :

http://localhost:8080

## 9. Construction de l'image Docker

Se placer dans le dossier contenant le Dockerfile :

```bash
cd backend/gestion-etudiants/gestion-etudiants
```

Générer le JAR :

```bash
.\mvnw.cmd clean verify
```

Construire l'image Docker :

```bash
docker build -t gestion-etudiants:latest .
```

Le fichier `.dockerignore` exclut les fichiers inutiles et les informations sensibles du contexte Docker.

## 10. Lancement du conteneur Docker

```bash
docker run -d --name gestion-etudiants -p 8080:8080 gestion-etudiants:latest
```

Vérifier les conteneurs :

```bash
docker ps
```

Afficher les logs :

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

## 11. Gestion des secrets

Les mots de passe, fichiers `.env`, clés privées et certificats ne doivent pas être ajoutés au dépôt Git ni intégrés dans l'image Docker.

Le fichier `.dockerignore` permet d'exclure les fichiers sensibles du contexte de construction Docker.

Les secrets nécessaires doivent être fournis séparément au moment de l'exécution.

## 12. Équipe de développement

- Anwar
- Sara
- Chaima

## 13. Méthodologie de travail

Le projet est réalisé selon la méthodologie Agile Scrum. Le développement est organisé en sprints avec des branches feature et des Pull Requests vers `develop`.

## 14. Workflow Git

- `main` : version stable.
- `develop` : branche d'intégration.
- `feature/*` : branches dédiées aux développements.

Chaque Pull Request doit être examinée par un autre membre de l'équipe avant son intégration.
