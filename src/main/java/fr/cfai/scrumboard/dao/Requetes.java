package fr.cfai.scrumboard.dao;

public class Requetes {

	public static final String TOUTES_LES_TACHES = "SELECT * FROM Tache";
	public static final String TOUS_LES_UTILISATEURS = "SELECT * FROM Utilisateur";
	public static final String TOUS_LES_TYPES_DE_TACHES = "SELECT * FROM TypeTache";
	public static final String TOUS_LES_HISTORIQUES = "SELECT * FROM Historique";
	public static final String TOUTES_LES_COLONNES = "SELECT * FROM Colonne";

	public static final String TACHE_PAR_ID = "SELECT * FROM Tache WHERE Id=?";
	public static final String UTILISATEUR_PAR_ID = "SELECT * FROM Utilisateur WHERE Id=?";
	public static final String TYPE_TACHE_PAR_ID = "SELECT * FROM TypeTache WHERE Id=?";
	public static final String HISTORIQUE_PAR_ID = "SELECT * FROM Historique WHERE Id=?";
	public static final String TOUS_LES_HISTORIQUES_PAR_TACHE = "SELECT * FROM Historique WHERE Id_Tache=?";
	public static final String COLONNE_PAR_ID = "SELECT * FROM Colonne WHERE Id=?";
	public static final String RECUPERER_UTILISATEUR = "SELECT * FROM Utilisateur WHERE Email=? AND MotDePasse=?";
	
	public static final String AJOUT_TACHE = "INSERT INTO Tache (Libelle, DateCreation, Id_Utilisateur, Id_TypeTache, Id_Colonne) VALUES (?, ?, ?, ?, ?)";
	public static final String AJOUT_UTILISATEUR = "INSERT INTO Utilisateur (Pseudo, Nom, Prenom, Email, MotDePasse, Administrateur) VALUES (?,?,?,?,?,?)";
	public static final String AJOUT_TYPETACHE = "INSERT INTO TypeTache (Nom, Correspondance) VALUES (?,?)";
	public static final String AJOUT_HISTORIQUE = "INSERT INTO Historique (DateDebut, Id_Tache, Id_Colonne) VALUES (?,?,?)";
	public static final String AJOUT_COLONNE = "INSERT INTO Colonne (Libelle) VALUES (?)";
	
	public static final String UPDATE_UTILISATEUR = "UPDATE Utilisateur SET Nom=?, Prenom=?, Email=?, MotDePasse=? WHERE Id=?)";
	public static final String UPDATE_TACHE = "UPDATE Tache SET Id_Colonne=? WHERE Id=?";
	public static final String UPDATE_TYPE_TACHE = "UPDATE TypeTache SET Nom=?, Correspondance=? WHERE Id=?)";
	
	public static final String SUPPRESSION_TACHE = "DELETE FROM Tache WHERE Id=?";
	public static final String SUPPRESSION_UTILISATEUR = "DELETE FROM Utilisateur WHERE Id=?";
	public static final String SUPPRESSION_TYPE_TACHE = "DELETE FROM TypeTache WHERE Id=?";
	public static final String SUPPRESSION_HISTORIQUE = "DELETE FROM Historique WHERE Id=?";
	public static final String SUPPRESSION_COLONNE = "DELETE FROM Colonne WHERE Id=?";
    	
}
