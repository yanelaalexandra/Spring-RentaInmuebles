package com.renta.model;

public class Admin {
	
	private int id_admin;
	private String cod_admin;
	private String pas_admin;
	private String nom_admin;
	
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getId_admin() {
		return id_admin;
	}
	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}
	
	
	public String getCod_admin() {
		return cod_admin;
	}


	public void setCod_admin(String cod_admin) {
		this.cod_admin = cod_admin;
	}

	public String getPas_admin() {
		return pas_admin;
	}
	public void setPas_admin(String pas_admin) {
		this.pas_admin = pas_admin;
	}
	public String getNom_admin() {
		return nom_admin;
	}
	public void setNom_admin(String nom_admin) {
		this.nom_admin = nom_admin;
	}
	
	@Override
	public String toString() {
		return "Admin [id_admin=" + id_admin + ", cod_admin=" + cod_admin + ", pas_admin=" + pas_admin + ", nom_admin="
				+ nom_admin + "]";
	}
	
	
			
}
