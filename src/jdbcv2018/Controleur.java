/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcv2018;

	import java.sql.*; 
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Map;
	import java.util.Map.Entry;	
	import modele.AnneeScolaire;
	import modele.Bulletin;
	import modele.Classe;
	import modele.DetailBulletin;
	import modele.Discipline;
	import modele.Ecole;
	import modele.Enseignement;
	import modele.Evaluation;
	import modele.Inscription;
	import modele.Niveau;
	import modele.Personne;
	import modele.Trimestre;
import modele.initialize_all;
import modele.save_all;

/**
 *
 * Contrôle l'interrogation de la BDD dans la Fenetre
 *
 * @author segado
 */
public class Controleur {

    /**
     *
     * une methode principal (main) pour lancer l'application
     *
     * @param s
     */
     
    public static Map<Integer,AnneeScolaire> tab_annee = new HashMap<Integer,AnneeScolaire>();
	public static Map<Integer,Trimestre> tab_trimestre = new HashMap<Integer,Trimestre>();
	public static Map<Integer,Personne> tab_personne = new HashMap<Integer,Personne>();
    public static Ecole ecole = new Ecole();
    public static Map<Integer,Classe> tab_classe = new HashMap<Integer,Classe>();    
    public static Map<Integer,Inscription> tab_inscription = new HashMap<Integer,Inscription>();
    public static Map<Integer,Evaluation> tab_evaluation = new HashMap<Integer,Evaluation>();
    public static Map<Integer,Discipline> tab_discipline = new HashMap<Integer,Discipline>();
    public static Map<Integer,DetailBulletin> tab_dbulletin = new HashMap<Integer,DetailBulletin>();
    public static Map<Integer,Bulletin> tab_bulletin = new HashMap<Integer,Bulletin>();
    public static Map<Integer,Enseignement> tab_enseignement = new HashMap<Integer,Enseignement>();
    public static Map<Integer,Niveau> tab_niveau = new HashMap<Integer,Niveau>();

    
    public static void main(String[] s) {
    	
    	initialize_all i = new initialize_all();
    	i.initialize();
    	
//		for(Map.Entry<Integer, Classe> entry : tab_classe.entrySet()) {
//			Integer key = entry.getKey();
//			Classe value = entry.getValue();
//		    value.display();    
//		}
	
		//display_bulletin_of(1);
    	
    	save_all p = new save_all();
    	
    	
//		Trimestre t = new Trimestre(7, 1, "2017-07-01", "2017-12-01", 3);
//		tab_trimestre.put(10, t);
		
    	p.save();
		
		
    }
    
    public static ArrayList<String> execut (String t,Connexion c){
    	ArrayList<String> liste = new ArrayList<String>();
    	
    	ResultSet rset = c.getrset();
		java.sql.Statement stmt = c.getstmt();
		try {
			rset = stmt.executeQuery(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSetMetaData rsetmeta = c.getrsetm();
		try {
			rsetmeta = rset.getMetaData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// calcul du nombre de colonnes du resultat
        int nbColonne=0;
		try {
			nbColonne = rsetmeta.getColumnCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // creation d'une ArrayList de String

        // tant qu'il reste une ligne 
        try {
			while (rset.next()) {
			    String champs;
			    champs = rset.getString(1); // ajouter premier champ

			    // Concatener les champs de la ligne separes par ,
			    for (int i = 1; i < nbColonne; i++) {
			        champs = champs + "," + rset.getString(i + 1);
			    }

			    // ajouter un "\n" à la ligne des champs
			    champs = champs + "\n";

			    // ajouter les champs de la ligne dans l'ArrayList
			    liste.add(champs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return liste;
    	
    }

    public static void display_bulletin_of(int id_eleve) {
    	
    	for(Map.Entry<Integer, Bulletin> entry : tab_bulletin.entrySet()) {
    		Bulletin value = entry.getValue();
    		
    		if( value.getId_insc() == id_eleve) {
    			double moyenne = calcul_moyenne_bulletin(id_eleve);
    			String nom = value.get_nom(tab_personne);
    			value.display(moyenne,nom);
    		}
    	}
    }
    
    public static double calcul_moyenne_bulletin(int id_eleve) {
		double moyenne = 0;
    	for(Map.Entry<Integer, Bulletin> entry : tab_bulletin.entrySet()) {
    		Bulletin value = entry.getValue();
    		
    		if( value.getId_insc() == id_eleve) {
    			moyenne = calcul_moyenne_dbulletin( value.getId());
    		}
    	}
    	return moyenne;
    }
    
    public static double calcul_moyenne_dbulletin(int id_bulletin) {
    	double moyenne = 0;
		double i = 0;
    	for(Map.Entry<Integer, DetailBulletin> entry : tab_dbulletin.entrySet()) {
    		DetailBulletin value = entry.getValue();
    		
    		
    		if(value.getId_bulletin() == id_bulletin) {
//    			value.display();
    			moyenne += get_total_note(value.getId_detailBulletin());
    			i++;
    		}
    	}
    	return moyenne/i;
    }
    
    public static double get_total_note(int id_db) {
    	double moyenne = 0;
    	double i = 0;
    	for(Map.Entry<Integer, Evaluation> entry : tab_evaluation.entrySet()) {
    		Evaluation value = entry.getValue();
    		
    		
    		if(value.getId_db() == id_db) {
//    			System.out.println("\n "+ moyenne);
//    			value.display();
    			moyenne += value.getNote();
    			i++;
    		}
    		
		}
    	moyenne = moyenne/i;
//    	System.out.println("\n finnale : "+ moyenne);
    	
    	return moyenne;
	}
    
}


