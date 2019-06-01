/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

public class Ecole {
	private int id_ecole;
	private String nom_ecole;
	private ArrayList<Classe> liste_classe_ecole = new ArrayList();

	public Ecole() {
		this.id_ecole = 0;
		this.nom_ecole = null;
		this.liste_classe_ecole = null;
	}

	public Ecole(int id_ecole, String nom_ecole, ArrayList<Classe> liste) {
		this.id_ecole = id_ecole;
		this.nom_ecole = nom_ecole;
		this.liste_classe_ecole = liste;
	}

	public void setId_ecole(int id_ecole) {
		this.id_ecole = id_ecole;
	}

	public void setNom_ecole(String nom_ecole) {
		this.nom_ecole = nom_ecole;
	}

	public void setListe_ecole(ArrayList<Classe> liste_classe_ecole) {
		this.liste_classe_ecole = liste_classe_ecole;
	}

	public int getId_ecole() {
		return this.id_ecole;
	}

	public String getNom_ecole() {
		return this.nom_ecole;
	}

	public ArrayList<Classe> getListe_ecole() {
		return this.liste_classe_ecole;
	}
	
	public void set_data(int id, String nom) {
		this.id_ecole = id;
		this.nom_ecole = nom;
	}

	public void display() {
		System.out.println("Le nom de l'ecole est :" + nom_ecole);
		for (int i = 0; i < liste_classe_ecole.size(); i++) {
			liste_classe_ecole.get(i).display();
		}
	}
}
