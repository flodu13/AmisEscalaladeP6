# Les amis de l'escalade - P6
Création d'un site communautaire autour de l'escalade

**Prerequis**
--------------
Apache Maven 3.6.3

PostgreSQL 12

Tomcat V9.0

**Déploiement**
---------------
Cloner le projet sous GitHub

Importer le projet dans l'IDE ( projet dÃ©veloppÃ© avec Eclipse)

Compiler via maven avec la commande mvn clean compile

Le fichier war est généré dans le repertoire target

Créer une base de donnÃ©es nommé AmisEscaladeP6 sous postgreSQL

Utiliser le script du dump pour créer les tables puis le script du jeu de donnees pour remplir les tables de la base de donnée
 
Demarrer le serveur tomcat sur l'IDE puis copier le fichier war de l'application depuis le dossier target dans le dossier webapps du répertoire Tomcat, puis lancer le serveur Tomcat

Puis se rendre via le navigateur sur l'adresse http://localhost:8090/AmisEscaladeP6-webapp/Accueil