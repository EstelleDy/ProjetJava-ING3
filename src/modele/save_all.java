package modele;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import jdbcv2018.Connexion;
import jdbcv2018.Controleur;

public class save_all extends Controleur{
	
	public void save () {
			
			System.out.println("connection réussie");
			
			String[] tab = {"trimestre","anneescolaire","personne","ecole","classe","inscription",
					"discipline","evaluation","bulletin","detailbulletin","enseignement","niveau"};
			
			for (String t : tab) {
				
				if(t=="trimestre") { execut_delete(t); save_tab_trimestre();}
				
				if(t=="anneescolaire") {execut_delete(t); save_tab_annee();}
	
				if(t=="personne") { execut_delete(t); save_tab_personne();}
				
				if(t=="ecole") { execut_delete(t); save_ecole(); }
				
				if(t=="classe") { execut_delete(t); save_tab_classe(); }
	
				if(t=="inscription") { execut_delete(t); save_tab_inscription(); }
	
				if(t=="discipline") {execut_delete(t); save_tab_discipline();}
				
				if(t=="evaluation") { execut_delete(t); save_tab_evaluation();}
				
				if(t=="bulletin") { execut_delete(t); save_tab_bulletin();}
				
				if(t=="detailbulletin") { execut_delete(t); save_tab_dbulletin(); }
				
				if(t=="enseignement") { execut_delete(t); save_tab_enseignement(); }
				
				if(t=="niveau") { execut_delete(t); save_tab_niveau(); }
			
			}
			
		
	}
	
	private void save_tab_niveau() {
		String liste = "INSERT INTO `niveau` (`id_niveau`, `nom_niveau`) VALUES ";
		for(Map.Entry<Integer, Niveau> entry : tab_niveau.entrySet()) {
			Niveau value = entry.getValue();
			 
			int id_n =  value.getId_niveau();
			String nom = value.getNom_niveau();
			
			 liste += "( '" + id_n + "', '" + nom + "'),"; 
		 }
		 liste = liste.substring(0, liste.length() - 1);
			
		 execut_update(liste);
		
	}

	private void save_tab_enseignement() {
		String liste = "INSERT INTO `enseignement` (`id_enseignement`, `id_classe`, `id_discipline`, `id_p`) VALUES ";
		for(Map.Entry<Integer, Enseignement> entry : tab_enseignement.entrySet()) {
			Enseignement value = entry.getValue();
			 
			int id_e = value.getId_enseignement();
			int id_c = value.get_id_classe();
			int id_d = value.get_id_discipline();
			int id_p = value.get_id();
			
			 liste += "( '" + id_e + "', '" + id_c + "', '" + id_d + "', '" + id_p + "'),"; 
		 }
		 liste = liste.substring(0, liste.length() - 1);
			
		 execut_update(liste);
		
	}

	private void save_tab_dbulletin() {
		String liste = "INSERT INTO `detailbulletin` (`id_detailBulletin`, `appreciation_b`, `id_bulletin`, `id_enseignement`) VALUES ";
		for(Map.Entry<Integer, DetailBulletin> entry : tab_dbulletin.entrySet()) {
			DetailBulletin value = entry.getValue();
			 
			int id_db = value.getId_detailBulletin();
			String appg = value.getAppreciationB();
			int id_b = value.getId_bulletin();
			int id_ens = value.getId_enseignement();
			
			 liste += "( '" + id_db + "', '" + appg + "', '" + id_b + "', '" + id_ens + "'),"; 
		 }
		 liste = liste.substring(0, liste.length() - 1);
			
		 execut_update(liste);
		
	}

	private void save_tab_bulletin() {
		String liste = "INSERT INTO `bulletin` (`id`, `id_trim`, `id_inscr`, `app_g`) VALUES ";
		for(Map.Entry<Integer, Bulletin> entry : tab_bulletin.entrySet()) {
			Bulletin value = entry.getValue();
			 
			int id = value.getId();
			int id_t = value.getId_trim();
			int id_inscr = value.getId_insc();
			String appg = value.getAppreciation();
			
			 liste += "( '" + id + "', '" + id_t + "', '" + id_inscr + "', '" + appg + "'),"; 
		 }
		 liste = liste.substring(0, liste.length() - 1);
			
		 execut_update(liste);
		
	}

	private void save_tab_evaluation() {
		
		String liste = "INSERT INTO `evaluation` (`id_evaluation`, `note`, `appreciation_e`, `id_db`, `id_p`, `id_discipline`) VALUES ";
		for(Map.Entry<Integer, Evaluation> entry : tab_evaluation.entrySet()) {
			Evaluation value = entry.getValue();
			 
			int id_e = value.getId_evaluation();
			double note = value.getNote();
			String app = value.getAppreciation_e();
			int id_db = value.getId_db();
			int id_p = value.getId_personne();
			int id_dis = value.getId_discipline();
			
			 liste += "( '" + id_e + "', '" + note + "', '" + app + "', '" + id_db + "', '" + id_p + "', '" + id_dis + "'),"; 
		 }
		 liste = liste.substring(0, liste.length() - 1);
			
		 execut_update(liste);
	}

	private void save_tab_discipline() {
		String liste = "INSERT INTO `discipline` (`id_discipline`, `nom_discipline`) VALUES ";
		for(Map.Entry<Integer, Discipline> entry : tab_discipline.entrySet()) {
			Discipline value = entry.getValue();
			 
			int id_dis = value.getId_discipline();
			String nom_dis = value.getNom_discipline();
			
			 liste += "( '" + id_dis + "', '" + nom_dis + "'),"; 
		 }
		 liste = liste.substring(0, liste.length() - 1);
			
		 execut_update(liste);
		
	}

	private void save_tab_inscription() {
		String liste = "INSERT INTO `inscription` (`id_inscription`, `id_classe`, `id_p`) VALUES ";
		for(Map.Entry<Integer, Inscription> entry : tab_inscription.entrySet()) {
			Inscription value = entry.getValue();
			 
			int id_inscription = value.getId_inscription();
			int id_classe = value.getId_classe();
			int id = value.getId();
			
			 liste += "( '" + id_inscription + "', '" + id_classe + "', '" + id + "'),"; 
		 }
		 liste = liste.substring(0, liste.length() - 1);
			
		 execut_update(liste);
		
	}

	private void save_tab_classe() {
		String liste = "INSERT INTO `classe` (`id_classe`, `nom_classe`, `id_ecole`, `id_niveau`, `id_annee`) VALUES ";
		 for(Map.Entry<Integer, Classe> entry : tab_classe.entrySet()) {
			 Classe value = entry.getValue();
			 
			 int id_classe = value.getId_Classe();
			 String nom_classe = value.getNom_Classe();
			 int id_ecole = value.getId_ecole();
			 int id_niveau = value.get_niveau();
			 int id_annee = value.getId_annee();
			
			 liste += "( '" + id_classe + "', '" + nom_classe + "', '" + id_ecole + "', '" + id_niveau + "', '" + id_annee + "'),"; 
		 }
		 liste = liste.substring(0, liste.length() - 1);
			
		 execut_update(liste);
		
	}

	private void save_ecole() {
		 String liste = "INSERT INTO `ecole` (`id_ecole`, `nom_ecole`) VALUES ( '" + ecole.getId_ecole()+ "', '" +ecole.getNom_ecole()+ "')";
		 execut_update(liste);
		 
		
	}

	private void save_tab_personne() {
		String liste = "INSERT INTO `personne` (`id_personne`, `nom_p`, `prenom_p`, `type`) VALUES ";
		 for(Map.Entry<Integer, Personne> entry : tab_personne.entrySet()) {
			 Personne value = entry.getValue();
			 
			 int id_personne = value.getId_personne();
			 String nom_personne = value.getNom_personne();
			 String prenom_personne = value.getPrenom_personne();
			 int type = 1;
			 if(value.getType() == false) { type = 0; }
			 
			 liste += "( '" + id_personne + "', '" + nom_personne + "', '" + prenom_personne + "', '" + type + "'),"; 
		 }
		 liste = liste.substring(0, liste.length() - 1);
			
		 execut_update(liste);
		
	}

	private void save_tab_annee() {
		 String liste = "INSERT INTO `anneescolaire` (`id_as`, `id_t1`, `id_t2`, `id_t3`) VALUES ";
		 for(Map.Entry<Integer, AnneeScolaire> entry : tab_annee.entrySet()) {
			 AnneeScolaire value = entry.getValue();
			 
			 int id_annee = value.getAnnee();
			 ArrayList<Trimestre> t = value.getTrimestre();
			 int t1 = t.get(0).getId();
			 int t2 = t.get(1).getId();
			 int t3 = t.get(2).getId();
			 
			 liste += "( '" + id_annee + "', '" + t1 + "', '" + t2 + "', '" + t3 + "'),"; 
		 }
		 liste = liste.substring(0, liste.length() - 1);
			
		 execut_update(liste);
	}

	private void save_tab_trimestre() {
		String liste = "INSERT INTO `trimestre` (`id_trimestre`, `numero`, `debut`, `fin`, `id_annee`) VALUES ";
		for(Map.Entry<Integer, Trimestre> entry : tab_trimestre.entrySet()) {
			Trimestre value = entry.getValue();
    		
    		int id_trimestre = value.getId();
    		int numero = value.getNumero();
    		String debut = value.getDebut();
    		String fin = value.getFin();
    		int id_annee = value.getId_annee();
    		
    		liste += "( '" + id_trimestre + "', '" + numero + "', '" + debut + "', '" + fin + "', '" + id_annee + "'),"; 
    		
    	}
		liste = liste.substring(0, liste.length() - 1);
		
		execut_update(liste);
		
	}

	public void execut_delete(String bdd) {
		Connexion c = null;
		try {
			c = new Connexion("connection","root","");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		String requete = "TRUNCATE " + bdd;
		try {
			c.executeUpdate(requete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void execut_update(String requete) {
		Connexion c = null;
		try {
			c = new Connexion("connection","root","");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			c.executeUpdate(requete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
