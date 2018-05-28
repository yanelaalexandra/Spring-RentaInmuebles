package com.renta.ws;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.model.Inmueble;
import com.renta.services.InmuebleService;

@RestController
public class EmployeeRestController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);

	@Autowired
	private InmuebleService inmuebleService;

	/**
	 * 
	 * @return
	 */
	@GetMapping("/emp")
	public ResponseEntity<List<Inmueble>> list() {

		List<Inmueble> list = null;

		try {
			list = inmuebleService.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		if (list == null || list.isEmpty())
			return new ResponseEntity<List<Inmueble>>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<List<Inmueble>>(list, HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(path = "/emp/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Inmueble> getInmueble(@PathVariable("idinmueble") int idinmueble) {
		Inmueble inm = null;

		try {
			inm = inmuebleService.find(idinmueble);
			logger.info(inm.toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		if (inm == null)
			return new ResponseEntity<Inmueble>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Inmueble>(inm, HttpStatus.OK);

	}


	/**
	 * 
	 * @param id
	 * @param emp
	 * @return
	 */
	@PutMapping("/emp/{idinmueble}")
	public ResponseEntity<Inmueble> updateEmp(@PathVariable("idinmueble") int idinmueble, @RequestBody Inmueble inm) {

		logger.info("Updating Inmueble " + idinmueble);

		Inmueble currentEmp = null;
		try {
			currentEmp = inmuebleService.find(idinmueble);

			if (currentEmp == null) {
				logger.info("Inmueble with id " + idinmueble + " not found");
				return new ResponseEntity<Inmueble>(HttpStatus.NOT_FOUND);
			}

			currentEmp.setDireccion(inm.getDireccion());
			currentEmp.setCoordenadas(inm.getCoordenadas());

			inmuebleService.update(currentEmp.getDireccion(), currentEmp.getCoordenadas(), currentEmp.getImagen(), currentEmp.getDescripcion(), currentEmp.getTipo_costo(), currentEmp.getCosto(), currentEmp.getCapacidad_max(), currentEmp.getTipo_inmueble(), currentEmp.getEstado(), currentEmp.getLatitud(), currentEmp.getLongitud());
			

		} catch (DAOException | EmptyResultException e) {
			logger.error(e.getMessage());
		}
		
		return new ResponseEntity<Inmueble>(currentEmp, HttpStatus.OK);

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/emp/{idinmueble}")
	public ResponseEntity<Inmueble> deleteEmp(@PathVariable("idinmueble") int idinmueble) {
		logger.info("Fetching & Deleting Inmueble with id " + idinmueble);

		Inmueble inm;
		try {
			inm = inmuebleService.find(idinmueble);
			
			if (inm == null) {
				logger.info("Unable to delete. Inmueble with id " + idinmueble + " not found");
				return new ResponseEntity<Inmueble>(HttpStatus.NOT_FOUND);
			}

			inmuebleService.delete(inm.getIdinmueble());
			
		} catch (DAOException | EmptyResultException e) {

			logger.error(e.getMessage());
		}

		return new ResponseEntity<Inmueble>(HttpStatus.NO_CONTENT);
	}


}
