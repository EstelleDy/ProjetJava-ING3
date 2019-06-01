/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

/**
 *
 * @author Isabelle
 */
public class Personne {
	private int id_personne;
	private String nom_personne;
	private String prenom_personne;
	private boolean type;// true élève false prof
	private ArrayList<Evaluation> liste_notes = new ArrayList();// =null si prof

	public Personne() {
		this.id_personne = 0;
		this.nom_personne = null;
		this.prenom_personne = null;
		this.type = true;
		this.liste_notes = null;
	}

	public Personne(int id, String nom, String prenom, boolean type) {
		this.id_personne = id;
		this.nom_personne = nom;
		this.prenom_personne = prenom;
		this.type = type;
	}

	public void setId_personne(int id_personne) {
		this.id_personne = id_personne;
	}

	public void setNom_personne(String nom_personne) {
		this.nom_personne = nom_personne;
	}

	public void setPrenom_personne(String prenom_personne) {
		this.prenom_personne = prenom_personne;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public int getId_personne() {
		return this.id_personne;
	}

	public String getNom_personne() {
		return this.nom_personne;
	}

	public String getPrenom_personne() {
		return this.prenom_personne;
	}

	public boolean getType() {
		return this.type;
	}

	public void add_notes_liste(Evaluation e) {
		liste_notes.add(e);
	}

	public void remove_notes_liste(String nom, String prenom, int id_evaluation) {
		for (int i = 0; i < liste_notes.size(); i++) {

			if (liste_notes.get(i).getId_evaluation() == id_evaluation && (this.nom_personne.equals(nom))
					&& (this.prenom_personne.equals(prenom))) {
				liste_notes.remove(i);

			} else {
				System.out.println("Une des informations donnée est erronée, nous ne pouvons supprimer la note");
			}

		}
	}

	public void modify_notes_liste(String nom, String prenom, int id_evaluation, double note) {
		for (int i = 0; i < liste_notes.size(); i++) {

			if (liste_notes.get(i).getId_evaluation() == id_evaluation && (this.nom_personne.equals(nom))
					&& (this.prenom_personne.equals(prenom))) {
				liste_notes.get(i).setNote(note);

			} else {
				System.out.println("Une des informations donnée est erronée, nous ne pouvons modifier la note");
			}

		}
	}
	
	public void display() {
		System.out.println("L'id de la personne est :" + this.id_personne);
		System.out.println("Il s'appelle " + this.nom_personne + " " + this.prenom_personne);
		System.out.println("\n");
	}

	public ArrayList<Evaluation> getListe() {
		return liste_notes;
	}
}
