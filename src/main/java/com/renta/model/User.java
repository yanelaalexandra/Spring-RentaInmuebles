package com.renta.model;

public class User {
	
	String username;
	String password;
	int idusuario;
	String nombre;
	String apellido;
	String correo;
	String genero;
	String tipo_documento;
	String descripcion;
	int numero_documento;
	int telefono;
	String foto;
	
	
	
	
	public User(String username, String password, int idusuario, String nombre, String apellido, String correo,
			String genero, String tipo_documento, String descripcion, int numero_documento, int telefono, String foto) {
		super();
		this.username = username;
		this.password = password;
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.genero = genero;
		this.tipo_documento = tipo_documento;
		this.descripcion = descripcion;
		this.numero_documento = numero_documento;
		this.telefono = telefono;
		this.foto = foto;
	}




	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", idusuario=" + idusuario + ", nombre="
				+ nombre + ", apellido=" + apellido + ", correo=" + correo + ", genero=" + genero + ", tipo_documento="
				+ tipo_documento + ", descripcion=" + descripcion + ", numero_documento=" + numero_documento
				+ ", telefono=" + telefono + ", foto=" + foto + "]";
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public int getIdusuario() {
		return idusuario;
	}




	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellido() {
		return apellido;
	}




	public void setApellido(String apellido) {
		this.apellido = apellido;
	}




	public String getCorreo() {
		return correo;
	}




	public void setCorreo(String correo) {
		this.correo = correo;
	}




	public String getGenero() {
		return genero;
	}




	public void setGenero(String genero) {
		this.genero = genero;
	}




	public String getTipo_documento() {
		return tipo_documento;
	}




	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	public int getNumero_documento() {
		return numero_documento;
	}




	public void setNumero_documento(int numero_documento) {
		this.numero_documento = numero_documento;
	}




	public int getTelefono() {
		return telefono;
	}




	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}




	public String getFoto() {
		return foto;
	}




	public void setFoto(String foto) {
		this.foto = foto;
	}




	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	
	}
