package com.renta.services;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renta.controller.InmuebleController;
import com.renta.dao.InmuebleDAO;
import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.model.Inmueble;

@Service
public class InmuebleServiceImpl implements InmuebleService {

	private static final Logger logger = LoggerFactory.getLogger(InmuebleServiceImpl.class);

	@Autowired
	private InmuebleDAO inmuebleDAO;

	public Inmueble find(int idinmueble) throws DAOException, EmptyResultException, IOException {

		Inmueble inm = inmuebleDAO.findInmueble(idinmueble);

		return inm;
	}

	public List<Inmueble> findAll() throws DAOException, EmptyResultException, IOException {

		List<Inmueble> inm = inmuebleDAO.findAllInmuebles();

		return inm;
	}

	public void update(String direccion, String coordenadas, String imagen, String descripcion, String tipo_costo,
			double costo, String capacidad_max, String tipo_inmueble, int estado, String latitud, String longitud)
			throws DAOException {

		inmuebleDAO.update(direccion, coordenadas, imagen, descripcion, tipo_costo, costo, capacidad_max, tipo_inmueble, estado, latitud, longitud);
		
	}


	public void delete(int idinmueble) throws DAOException, IOException {
		// TODO Auto-generated method stub
		inmuebleDAO.delete(idinmueble);
		
	}

	public void create(String direccion, String coordenadas, String imagen, String descripcion, String tipo_costo,
			double costo, String capacidad_max, String tipo_inmueble, int estado, int usuarios_idusuarios,
			int ranking_idranking, String latitud, String longitud) throws DAOException {
		
		inmuebleDAO.create(direccion, coordenadas, imagen, descripcion, tipo_costo, costo, capacidad_max, tipo_inmueble, estado, usuarios_idusuarios, ranking_idranking, latitud, longitud);
	}

	@Override
	public Inmueble findByDireccion(String direccion) throws DAOException, EmptyResultException {
		// TODO Auto-generated method stub
		return inmuebleDAO.findInmuebleByDireccion(direccion);
	}



}
