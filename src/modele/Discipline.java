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
public class Discipline {

	private int id_discipline;
	private String nom_discipline;

	public Discipline() {
		this.id_discipline = 0;
		this.nom_discipline = null;
	}

	public Discipline(int id_discipline, String nom_discipline) {
		this.id_discipline = id_discipline;
		this.nom_discipline = nom_discipline;
	}

	public void setId_discipline(int id_discipline) {
		this.id_discipline = id_discipline;
	}

	public void setNom_discipline(String nom_discipline) {
		this.nom_discipline = nom_discipline;
	}

	public int getId_discipline() {
		return this.id_discipline;
	}

	public String getNom_discipline() {
		return this.nom_discipline;
	}
	
	public void set_data(int idd,String nom) {
		this.id_discipline = idd;
		this.nom_discipline = nom;
	}

	public void display() {
		System.out.println("L'id discipline est :" + id_discipline);
		System.out.println("Le nom de la discipline est :" + nom_discipline);
	}
}
