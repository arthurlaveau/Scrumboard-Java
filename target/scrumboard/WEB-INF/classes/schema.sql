#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Utilisateur
#------------------------------------------------------------

CREATE TABLE Utilisateur(
        Id             Int  Auto_increment  NOT NULL ,
        Pseudo         Varchar (50) NOT NULL ,
        Nom            Varchar (50) NOT NULL ,
        Prenom         Varchar (50) NOT NULL ,
        Email          Varchar (50) NOT NULL ,
        MotDePasse     Varchar (50) NOT NULL ,
        Administrateur Bool NOT NULL
	,CONSTRAINT Utilisateur_PK PRIMARY KEY (Id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Colonne
#------------------------------------------------------------

CREATE TABLE Colonne(
        Id      Int  Auto_increment  NOT NULL ,
        Libelle Varchar (50) NOT NULL
	,CONSTRAINT Colonne_PK PRIMARY KEY (Id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: TypeTache
#------------------------------------------------------------

CREATE TABLE TypeTache(
        Id             Int  Auto_increment  NOT NULL ,
        Nom            Varchar (50) NOT NULL ,
        Correspondance Varchar (50) NOT NULL
	,CONSTRAINT TypeTache_PK PRIMARY KEY (Id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Tache
#------------------------------------------------------------

CREATE TABLE Tache(
        Id             Int  Auto_increment  NOT NULL ,
        Libelle        Varchar (50) NOT NULL ,
        DateCreation   Date NOT NULL ,
        Id_Utilisateur Int ,
        Id_TypeTache   Int ,
        Id_Colonne     Int
	,CONSTRAINT Tache_PK PRIMARY KEY (Id)

	,CONSTRAINT Tache_Utilisateur_FK FOREIGN KEY (Id_Utilisateur) REFERENCES Utilisateur(Id)
	,CONSTRAINT Tache_TypeTache0_FK FOREIGN KEY (Id_TypeTache) REFERENCES TypeTache(Id)
	,CONSTRAINT Tache_Colonne1_FK FOREIGN KEY (Id_Colonne) REFERENCES Colonne(Id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Historique
#------------------------------------------------------------

CREATE TABLE Historique(
        Id         Int  Auto_increment  NOT NULL ,
        DateDebut  Date NOT NULL ,
        Id_Tache   Int ,
        Id_Colonne Int
	,CONSTRAINT Historique_PK PRIMARY KEY (Id)

	,CONSTRAINT Historique_Tache_FK FOREIGN KEY (Id_Tache) REFERENCES Tache(Id)
	,CONSTRAINT Historique_Colonne0_FK FOREIGN KEY (Id_Colonne) REFERENCES Colonne(Id)
)ENGINE=InnoDB;

