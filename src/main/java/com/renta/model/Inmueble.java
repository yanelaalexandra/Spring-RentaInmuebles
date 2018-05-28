package com.renta.model;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

public class Inmueble extends Credential {

	int idinmueble;

	@NotEmpty
	String direccion;

	@NotEmpty
	String coordenadas;
		
	String imagen;
	String descripcion;
	String tipo_costo;
	
	@Range(min = 1, max = 5000)
	double costo;

	String capacidad_max;
	String tipo_inmueble;
	int estado;
	int usuarios_idusuarios;
	int ranking_idranking;
	String latitud;
	String longitud;
	
	public Inmueble(int idinmueble, @NotEmpty String direccion, @NotEmpty String coordenadas, String imagen,
			String descripcion, String tipo_costo, @Range(min = 1, max = 5000) double costo, String capacidad_max,
			String tipo_inmueble, int estado, int usuarios_idusuarios, int ranking_idranking, String latitud,
			String longitud) {
		super();
		this.idinmueble = idinmueble;
		this.direccion = direccion;
		this.coordenadas = coordenadas;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.tipo_costo = tipo_costo;
		this.costo = costo;
		this.capacidad_max = capacidad_max;
		this.tipo_inmueble = tipo_inmueble;
		this.estado = estado;
		this.usuarios_idusuarios = usuarios_idusuarios;
		this.ranking_idranking = ranking_idranking;
		this.latitud = latitud;
		this.longitud = longitud;
	}
	public Inmueble() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdinmueble() {
		return idinmueble;
	}
	public void setIdinmueble(int idinmueble) {
		this.idinmueble = idinmueble;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipo_costo() {
		return tipo_costo;
	}
	public void setTipo_costo(String tipo_costo) {
		this.tipo_costo = tipo_costo;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public String getCapacidad_max() {
		return capacidad_max;
	}
	public void setCapacidad_max(String capacidad_max) {
		this.capacidad_max = capacidad_max;
	}
	public String getTipo_inmueble() {
		return tipo_inmueble;
	}
	public void setTipo_inmueble(String tipo_inmueble) {
		this.tipo_inmueble = tipo_inmueble;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getUsuarios_idusuarios() {
		return usuarios_idusuarios;
	}
	public void setUsuarios_idusuarios(int usuarios_idusuarios) {
		this.usuarios_idusuarios = usuarios_idusuarios;
	}
	public int getRanking_idranking() {
		return ranking_idranking;
	}
	public void setRanking_idranking(int ranking_idranking) {
		this.ranking_idranking = ranking_idranking;
	}
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	@Override
	public String toString() {
		return "Inmueble [idinmueble=" + idinmueble + ", direccion=" + direccion + ", coordenadas=" + coordenadas
				+ ", imagen=" + imagen + ", descripcion=" + descripcion + ", tipo_costo=" + tipo_costo + ", costo="
				+ costo + ", capacidad_max=" + capacidad_max + ", tipo_inmueble=" + tipo_inmueble + ", estado=" + estado
				+ ", usuarios_idusuarios=" + usuarios_idusuarios + ", ranking_idranking=" + ranking_idranking
				+ ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}

}
