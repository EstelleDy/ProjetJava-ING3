/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

public class Inscription {
	private int id_inscription;
	private int id_classe;
	private int id;

	public Inscription() {
		this.id_inscription = 0;
		this.id_classe = 0;
		this.id = 0;
	}

	public Inscription(int id_inscription, int id_classe, int id) {
		this.id_inscription = id_inscription;
		this.id_classe = id_classe;
		this.id = id;
	}

	public void setId_inscription(int id_inscription) {
		this.id_inscription = id_inscription;
	}

	public void setId_classe(int id_classe) {
		this.id_classe = id_classe;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_inscription() {
		return this.id_inscription;
	}

	public int getId_classe() {
		return this.id_classe;
	}

	public int getId() {
		return this.id;
	}
	
	public void set_data(int id_inscription, int id_classe, int id) {
		this.id_inscription = id_inscription;
		this.id_classe = id_classe;
		this.id = id;
	}
	
	public void display() {
		System.out.println("L'élève " + this.id + " est dans la classe " + this.id_classe);
		
	}

}
