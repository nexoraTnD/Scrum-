
# Image de base : Java 21 JRE (uniquement pour exécuter l'application)
FROM eclipse-temurin:21-jre

# Dossier de travail à l'intérieur du conteneur
WORKDIR /app

# Copier le JAR Spring Boot dans le conteneur
COPY target/gestion-etudiants-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port utilisé par Spring Boot
EXPOSE 8080

# Commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]

