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
public class DetailBulletin {
	private int id_detailBulletin;
	private int id_bulletin;
	private int id_enseignement;
	private String appreciation_b;

	public DetailBulletin() {
		this.id_detailBulletin = 0;
		this.id_bulletin = 0;
		this.id_enseignement = 0;
		this.appreciation_b = null;

	}

	public DetailBulletin(int id_detailBulletin, int id_bulletin, int id_enseignement, String appreciation_b) {
		this.id_detailBulletin = id_detailBulletin;
		this.id_bulletin = id_bulletin;
		this.id_enseignement = id_enseignement;
		this.appreciation_b = appreciation_b;

	}

	public void setId_detailBulletin(int id_bulletin) {
		this.id_detailBulletin = id_detailBulletin;
	}

	public void setAppreciationB(String appreciation_b) {
		this.appreciation_b = appreciation_b;
	}

	public int getId_detailBulletin() {
		return this.id_detailBulletin;
	}

	public int getId_bulletin() {
		return this.id_bulletin;
	}

	public String getAppreciationB() {
		return this.appreciation_b;
	}

	public int getId_enseignement() {
		return id_enseignement;
	}

	public void set_data(int iddb, int idb, int ide, String app) {
		this.id_detailBulletin = iddb;
		this.id_bulletin = idb;
		this.id_enseignement = ide;
		this.appreciation_b = app;
	}

	public void display() {
		System.out.println("L'id du bulletin est:" + id_detailBulletin);
		System.out.println("L' appr�ciation est :" + appreciation_b);

	}

	public void add_notes(Personne p1, Personne p2, String note, String appreciation_e) {
		// p1 est le professeur, p2 l'élève
		// verification que c'est un professeur qui met la note à l'eleve
		if (p1.getType() == false && p2.getType() == true) {

		}
	}
}
