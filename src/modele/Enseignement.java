/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

public class Enseignement {
	private int id_enseignement;
	private int id_classe;
	private int id_discipline;
	private int id;

	public Enseignement() {
		this.id_enseignement = 0;
		this.id_classe = 0;
		this.id_discipline = 0;
		this.id = 0;
	}

	public Enseignement(int id_enseignement, int id_classe, int id_discipline, int id) {
		this.id_enseignement = id_enseignement;
		this.id_classe = id_classe;
		this.id_discipline = id_discipline;
		this.id = id;
	}

	public void setId_enseignement(int id_enseignement) {
		this.id_enseignement = id_enseignement;
	}

	public void set_classe(int classe) {
		this.id_classe = classe;
	}

	public void set_discipline(int discipline) {
		this.id_discipline = discipline;
	}

	public void set_id(int id) {
		this.id = id;
	}

	public int getId_enseignement() {
		return this.id_enseignement;
	}

	public int get_id() {
		return this.id;
	}

	public int get_id_classe() {
		return this.id_classe;
	}

	public int get_id_discipline() {
		return this.id_discipline;
	}
	
	public void set_data(int ide,int idc,int idd,int id) {
		this.id_enseignement = ide;
		this.id_classe = idc;
		this.id_discipline = idd;
		this.id = id;
	}
}
