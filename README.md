# Les amis de l'escalade - P6
Cr�ation d'un site communautaire autour de l'escalade

**Prerequis**
--------------
Apache Maven 3.6.3

PostgreSQL 12

Tomcat V9.0

**D�ploiement**
---------------
Cloner le projet sous GitHub

Importer le projet dans l'IDE ( projet développé avec Eclipse)

Compiler via maven avec la commande mvn clean compile

Le fichier war est g�n�r� dans le repertoire target

Cr�er une base de données nomm� AmisEscaladeP6 sous postgreSQL

Utiliser le script du dump pour cr�er les tables puis le script du jeu de donnees pour remplir les tables de la base de donn�e
 
Demarrer le serveur tomcat sur l'IDE puis copier le fichier war de l'application depuis le dossier target dans le dossier webapps du r�pertoire Tomcat, puis lancer le serveur Tomcat

Puis se rendre via le navigateur sur l'adresse http://localhost:8090/AmisEscaladeP6-webapp/Accueil