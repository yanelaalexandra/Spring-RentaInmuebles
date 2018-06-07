package com.renta.dao;

import java.io.IOException;
import java.util.List;

import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.model.Inmueble;

public interface InmuebleDAO {
	
	
	//Listar TODOS Inmuebles
	List<Inmueble> findAllInmuebles() throws DAOException, EmptyResultException, IOException;
	
	
	

	Inmueble findInmueble(int idinmueble) throws DAOException, EmptyResultException;

	void create(String direccion, String coordenadas, String imagen, String descripcion, String tipo_costo, double costo, String capacidad_max, String tipo_inmueble, int estado, int usuarios_idusuarios, int ranking_idranking, String latitud, String longitud) throws DAOException;

	void delete(int idinmueble) throws DAOException;

	void update(String direccion, String coordenadas, String imagen, String descripcion, String tipo_costo, double costo, String capacidad_max, String tipo_inmueble, int estado, String latitud, String longitud) throws DAOException;

	Inmueble findInmuebleByDireccion(String direccion) throws DAOException, EmptyResultException;
	
	
	
	


	
	
	//Inmueble findEmployeeByLogin(String login) throws DAOException, EmptyResultException;


	//List<Inmueble> findEmployeesByName(String name) throws DAOException, EmptyResultException;

}
