package modele;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import jdbcv2018.Connexion;
import jdbcv2018.Controleur;

public class initialize_all extends Controleur{
	
	public void initialize () {
		try {
			Connexion c = new Connexion("connection","root","");
			System.out.println("connection réussie");
			
			String[] tab = {"trimestre","anneescolaire","personne","ecole","classe","inscription",
					"discipline","evaluation","bulletin","detailbulletin","enseignement","niveau"};
			
			for (String t : tab) {
				String phrase = "select * from "+ t;
//				System.out.println(phrase);
				
				ArrayList<String> liste = new ArrayList<String>();
				liste = execut(phrase,c);
				
				if(t=="trimestre") { initialize_tab_trimestre(liste);}
				
				if(t=="anneescolaire") {initialize_tab_annee(liste);}
	
				if(t=="personne") { initialize_tab_personne(liste);}
				
				if(t=="ecole") { initialize_ecole(liste); }
				
				if(t=="classe") { initialize_tab_classe(liste); }
	
				if(t=="inscription") { initialize_tab_inscription(liste); }
	
				if(t=="discipline") {initialize_tab_discipline(liste);}
				
				if(t=="evaluation") { initialize_tab_evaluation(liste);}
				
				if(t=="bulletin") { initialize_tab_bulletin(liste);}
				
				if(t=="detailbulletin") { initialize_tab_dbulletin(liste); }
				
				if(t=="enseignement") { initialize_tab_enseignement(liste); }
				
				if(t=="niveau") { initialize_tab_niveau(liste); }
			
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialize_tab_annee( ArrayList<String> liste ) {
    	int i=0;
		for(String data : liste ) {
			data = data.substring(0, data.length() - 1);
			data = data + ", ";
			String[] info = data.split(",");
			
			int annee = Integer.parseInt(info[0]);
			int t1 = Integer.parseInt(info[1]);
			int t2 = Integer.parseInt(info[2]);
			int t3 = Integer.parseInt(info[3]);

			Trimestre tri1 = new Trimestre();
			Trimestre tri2 = new Trimestre();
			Trimestre tri3 = new Trimestre();
			
			for(Entry<Integer, Trimestre> entry : tab_trimestre.entrySet()) {
				Integer key = entry.getKey();
				Trimestre value = entry.getValue();
				
			    if(value.getId()==t1) { tri1 = tab_trimestre.get(key);}
			    else if(value.getId()==t2 ) { tri2 = tab_trimestre.get(key);}
			    else if(value.getId()==t3 ) { tri3 = tab_trimestre.get(key);}
			}
			
			AnneeScolaire annsco = new AnneeScolaire(annee,tri1,tri2,tri3);
			tab_annee.put(i, annsco);
			i++;
		}
    }
    
    public static void initialize_tab_trimestre ( ArrayList<String> liste ){
    	int i=0;
		for (String data : liste ) {
			data = data.substring(0, data.length() - 1);
			data = data + ", ";
			String[] info = data.split(",");
			
			int id_trimestre = Integer.parseInt(info[0]);
			int numero = Integer.parseInt(info[1]);
			String debut = info[2];
			String fin = info[3];
			int id_annee = Integer.parseInt(info[4]);
			
			Trimestre tri = new Trimestre(id_trimestre,numero,debut,fin,id_annee);
			tab_trimestre.put(i, tri);
			i++;
		}
    }

    public static void initialize_tab_personne ( ArrayList<String> liste ) {
    	int i=0;
    	for (String data : liste ) {
    		data = data.substring(0, data.length() - 1);
			data = data + ", ";
			String[] info = data.split(",");
			
			
			int id_personne= Integer.parseInt(info[0]);;
			String nom_personne= info[1] ;
			String prenom_personne= info[2];
			Boolean type = true;
			if(Integer.parseInt(info[3])==0) {type = false;}
			
			Personne per = new Personne(id_personne,nom_personne,prenom_personne,type);
			tab_personne.put(i, per);
			i++;
    	}
    }
    
    public static void initialize_ecole ( ArrayList<String> liste ) {
    	for (String data : liste ) {
    		data = data.substring(0, data.length() - 1);
			data = data + ", ";
			String[] info = data.split(",");
			
			ecole.set_data(Integer.parseInt(info[0]), info[1]);
//			ecole.display();
    	}
    }
    
    public static void initialize_tab_classe ( ArrayList<String> liste ) {
    	int i=0;
    	for (String data : liste ) {
    		data = data.substring(0, data.length() - 1);
			data = data + ", ";
			String[] info = data.split(",");
			
			int id_classe = Integer.parseInt(info[0]);
			String nom_classe = info[1];
			int id_ecole = Integer.parseInt(info[2]);
			int id_niveau = Integer.parseInt(info[3]);
			int id_annee = Integer.parseInt(info[4]);
			
			Classe classe = new Classe(id_classe,nom_classe,id_ecole,id_niveau,id_annee);
			tab_classe.put(i, classe);
			i++;
			
    	}
    }
    
    public static void initialize_tab_inscription ( ArrayList<String> liste ) {
    	int i=0;
    	for (String data : liste ) {
    		data = data.substring(0, data.length() - 1);
			data = data + ", ";
			String[] info = data.split(",");
			
			int id_inscription = Integer.parseInt(info[0]);
			int id_classe = Integer.parseInt(info[1]);
			int id = Integer.parseInt(info[2]);
			
			Inscription inscription = new Inscription(id_inscription,id_classe,id);
			tab_inscription.put(i, inscription);
			i++;
			
    	}
    }
    
    public static void initialize_tab_evaluation ( ArrayList<String> liste ) {
    	int i=0;
    	for (String data : liste ) {
    		data = data.substring(0, data.length() - 1);
			data = data + ", ";
			String[] info = data.split(",");
			
			int id_e = Integer.parseInt(info[0]);
			double note = Double.parseDouble(info[1]);
			String app = info[2];
			int id_db = Integer.parseInt(info[3]);
			int id_p = Integer.parseInt(info[4]);
			int id_dis = Integer.parseInt(info[5]);
			
			Evaluation eval = new Evaluation(id_e, id_db, note, app, id_p,id_dis);
			tab_evaluation.put(i, eval);
			i++;
    	}
    }
    
    public static void initialize_tab_discipline ( ArrayList<String> liste ) {
    	int i=0;
    	for (String data : liste ) {
    		data = data.substring(0, data.length() - 1);
			data = data + ", ";
			String[] info = data.split(",");
			
			int id_dis = Integer.parseInt(info[0]);
			String nom_dis = info[1];
			
			Discipline dis = new Discipline(id_dis,nom_dis);
			tab_discipline.put(i,dis);
			i++;
    	}
    }
    
    public static void initialize_tab_dbulletin( ArrayList<String> liste ) {
    	int i=0;
    	for (String data : liste ) {
    		data = data.substring(0, data.length() - 1);
			data = data + ", ";
			String[] info = data.split(",");
			
			int id_db = Integer.parseInt(info[0]);
			String appg = info[1];
			int id_t = Integer.parseInt(info[2]);
			int id_ens = Integer.parseInt(info[3]);
			
			DetailBulletin db = new DetailBulletin(id_db,id_t,id_ens,appg);
			tab_dbulletin.put(i,db);
			i++;
    	}
    }
    
    public static void initialize_tab_bulletin ( ArrayList<String> liste ) {
    	int i=0;
    	for (String data : liste ) {
    		data = data.substring(0, data.length() - 1);
			data = data + ", ";
			String[] info = data.split(",");
			
			int id = Integer.parseInt(info[0]);
			int id_t = Integer.parseInt(info[1]);
			int id_inscr = Integer.parseInt(info[2]);
			String appg = info[3];
			
			Bulletin b = new Bulletin (id,id_t,id_inscr,appg);
			tab_bulletin.put(i, b);
			i++;
    	}
    }
    
    public static void initialize_tab_enseignement ( ArrayList<String> liste ) {
    	int i=0;
    	for (String data : liste ) {
    		data = data.substring(0, data.length() - 1);
			data = data + ", ";
			String[] info = data.split(",");
			
			int id_e = Integer.parseInt(info[0]);
			int id_c = Integer.parseInt(info[1]);
			int id_d = Integer.parseInt(info[2]);
			int id_p = Integer.parseInt(info[3]);
			
			Enseignement e = new Enseignement(id_e,id_c,id_d,id_p);
			tab_enseignement.put(i, e);
			i++;
    	}
    }
    
    public static void initialize_tab_niveau( ArrayList<String> liste ) {
    	int i=0;
    	for (String data : liste ) {
    		data = data.substring(0, data.length() - 1);
			data = data + ", ";
			String[] info = data.split(",");
			
			int id_n = Integer.parseInt(info[0]);
			String nom = info[1];
			
			Niveau n = new Niveau(id_n,nom);
			tab_niveau.put(i, n);
			i++;
    	}
    }
    
}
