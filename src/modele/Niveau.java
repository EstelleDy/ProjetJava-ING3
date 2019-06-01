/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modele;

import java.util.HashMap;
import java.util.Iterator;

import java.util.Map;

/**
 *
 * @author Isabelle
 */
public class Niveau {
	private int id_niveau;
	private String nom_niveau;

	public Niveau() {
		this.setId_niveau(0);
		this.setNom_niveau(null);
	}
	
	public Niveau(int id, String nom) {
		this.setId_niveau(id);
		this.setNom_niveau(nom);
	}

	public int getId_niveau() {
		return id_niveau;
	}

	public void setId_niveau(int id_niveau) {
		this.id_niveau = id_niveau;
	}

	public String getNom_niveau() {
		return nom_niveau;
	}

	public void setNom_niveau(String nom_niveau) {
		this.nom_niveau = nom_niveau;
	}
}
