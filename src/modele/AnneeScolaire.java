/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;

import jdbcv2018.Connexion;

/**
 *
 * @author Isabelle
 */
public class AnneeScolaire {
	private int id_anneeScolaire;
	private ArrayList<Trimestre> trim_annee = new ArrayList();

	public AnneeScolaire() {
		this.id_anneeScolaire = 0;
		this.trim_annee = null;
	}

	public AnneeScolaire(int id_anneeScolaire, Trimestre t1, Trimestre t2, Trimestre t3) {
		this.id_anneeScolaire = id_anneeScolaire;
		this.trim_annee.add(t1);
		this.trim_annee.add(t2);
		this.trim_annee.add(t3);

	}
	
	public int getAnnee() {
		return this.id_anneeScolaire;
	}
	
	public ArrayList<Trimestre> getTrimestre() {
		return this.trim_annee;
	}

	public void display() {
		System.out.println("Lid de l'annee scolaire est :" + id_anneeScolaire);
		this.trim_annee.get(0).display();
		this.trim_annee.get(1).display();
		this.trim_annee.get(2).display();
		System.out.println("\n");
	}
	
}
