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
public class Trimestre {
	private int id_trimestre;
	private int numero;
	private String debut;
	private String fin;
	private int id_annee;

	public Trimestre() {
		this.id_trimestre = 0;
		this.numero = 0;
		this.debut = null;
		this.fin = null;
		this.id_annee = 0;
	}

	public Trimestre(int id_trimestre, int numero, String debut, String fin, int id_annee) {
		this.id_trimestre = id_trimestre;
		this.numero = numero;
		this.debut = debut;
		this.fin = fin;
		this.id_annee = id_annee;

	}

	public void setId(int id) {
		this.id_trimestre = id;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setDebut(String debut) {
		this.debut = debut;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public int getId() {
		return this.id_trimestre;
	}

	public int getNumero() {
		return this.numero;
	}

	public String getDebut() {
		return this.debut;
	}

	public String getFin() {
		return this.fin;
	}

	public int getId_annee() {
		return this.id_annee;
	}

	public void display() {
		System.out.println("L'id du trimestre est :" + id_trimestre);
		System.out.println("Nous sommes le " + numero + "e du trimestre");
		System.out.println("Le debut est " + debut + " la fin est " + fin);
		System.out.println("\n");
	}
}
