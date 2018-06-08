package com.renta.dao;

import java.io.IOException;
import java.util.List;

import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.model.Inmueble;
import com.renta.model.User;

public interface InmuebleDAO {
	
	
	//Listar TODOS Inmuebles
	List<Inmueble> findAllInmuebles() throws DAOException, EmptyResultException, IOException;
	
	//Listar Inmuebles por UserID
	List<Inmueble> findUserInmuebles(int idusuario) throws DAOException, EmptyResultException, IOException;
	
	//Detalles Inmuebles 
	Inmueble findInmueble(int idinmueble) throws DAOException, EmptyResultException, IOException;
	
	//Ver Propietario del Inmueble
	User findPropietario(int idinmueble) throws DAOException, EmptyResultException, IOException;
	
	
	
	
	
	
	
	
	

	void create(String direccion, String coordenadas, String imagen, String descripcion, String tipo_costo, double costo, String capacidad_max, String tipo_inmueble, int estado, int usuarios_idusuarios, int ranking_idranking, String latitud, String longitud) throws DAOException;

	void delete(int idinmueble) throws DAOException;

	void update(String direccion, String coordenadas, String imagen, String descripcion, String tipo_costo, double costo, String capacidad_max, String tipo_inmueble, int estado, String latitud, String longitud) throws DAOException;

	Inmueble findInmuebleByDireccion(String direccion) throws DAOException, EmptyResultException;
	
	
	
	
}
