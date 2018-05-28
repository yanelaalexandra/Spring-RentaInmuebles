package com.renta.services;

import java.util.List;

import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.model.Inmueble;

public interface InmuebleService {
	
	Inmueble find(int idinmueble) throws DAOException, EmptyResultException;

	List<Inmueble> findAll() 
			throws DAOException, EmptyResultException;

	void update(String direccion, String coordenadas, String imagen, String descripcion, String tipo_costo, double costo, String capacidad_max, String tipo_inmueble, int estado, String latitud, String longitud)
			throws DAOException;

	void delete(int idinmueble) throws DAOException;

	void create(String direccion, String coordenadas, String imagen, String descripcion, String tipo_costo, double costo, String capacidad_max, String tipo_inmueble, int estado, int usuarios_idusuarios, int ranking_idranking, String latitud, String longitud) throws DAOException;

	Inmueble findByDireccion(String direccion) throws DAOException, EmptyResultException;
}
