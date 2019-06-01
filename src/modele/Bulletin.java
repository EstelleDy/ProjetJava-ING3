/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.Map;

public class Bulletin {
	int id;
	int id_trim;
	int id_insc;
	String app_g; // appreciation gÃ©nÃ©rale

	public Bulletin() {
		this.id = 0;
		this.id_trim = 0;
		this.id_insc = 0;
		this.app_g = null;
	}

	public Bulletin(int id, int id_t, int id_i, String app_g) {
		this.id = id;
		this.id_trim = id_t;
		this.id_insc = id_i;
		this.app_g = app_g;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setId_trim(int id_trim) {
		this.id_trim = id_trim;
	}

	public void setId_insc(int id_insc) {
		this.id_insc = id_insc;
	}

	public void set_appreciation(String app) {
		this.app_g = app;
	}

	public int getId() {
		return id;
	}

	public int getId_trim() {
		return id_trim;
	}

	public int getId_insc() {
		return id_insc;
	}

	public String getAppreciation() {
		return app_g;
	}

	public void add_moyenne(int id_eleve) {

	}

	public void set_data(int id, int idt, int idin, String app) {
		this.id = id;
		this.id_trim = idt;
		this.id_insc = idin;
		this.app_g = app;
	}
	
	public String get_nom (Map<Integer,Personne> tab_personne) {
		for(Map.Entry<Integer, Personne> entry : tab_personne.entrySet()) {
			Personne value = entry.getValue();
    		
			if(value.getId_personne() == this.id_insc) {
				return value.getNom_personne();
			}
		}
		
		return null;
	}
	
	public void display(double moyenne,String nom) {
		System.out.println(" Bulletin du trimestre " + this.id_trim + " de " + nom);
		System.out.println(" Appreciation générale " + this.app_g);
		System.out.println(" La moyenne générale est de " + moyenne);
	}
}
