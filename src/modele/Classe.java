/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Isabelle
 */
public class Classe {
	private int id_classe;
	private String nom_classe;
	private int id_ecole;
	private int id_niveau;
	private int id_annee;

	public Classe() {
		this.id_classe = 0;
		this.nom_classe = null;
		this.id_ecole = 0;
		this.set_niveau(0);
		this.id_annee = 0;
	}

	public Classe(int id_classe, String nom_classe, int id_ecole,int id_niveau, int id_annee) {
		this.id_classe = id_classe;
		this.nom_classe = nom_classe;
		this.id_ecole = id_ecole;
		this.set_niveau(id_niveau);
		this.id_annee = id_annee;

	}

	public void setId_classe(int id_classe) {
		this.id_classe = id_classe;
	}

	public void setNom_Classe(String nom_classe) {
		this.nom_classe = nom_classe;
	}

	public void setId_ecole(int id_ecole) {
		this.id_ecole = id_ecole;
	}

	public void setId_annee(int id_annee) {
		this.id_annee = id_annee;

	}

	public int getId_Classe() {
		return this.id_classe;
	}

	public String getNom_Classe() {
		return this.nom_classe;
	}

	public int getId_ecole() {
		return this.id_ecole;
	}

	public int getId_annee() {
		return this.id_annee;
	}
	
	public int get_niveau() {
		return id_niveau;
	}

	public void set_niveau(int id_niveau) {
		this.id_niveau = id_niveau;
	}

	public void set_data(int idc,String nom,int ide,int ida) {
		this.id_classe = idc;
		this.nom_classe = nom;
		this.id_ecole = ide;
		this.id_annee = ida;
		
	}

	public void display() {
		System.out.println("L'id de la classe est :" + id_classe);
		System.out.println("Le nom de la classe est :" + nom_classe);
	}
}
