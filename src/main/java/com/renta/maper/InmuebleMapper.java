package com.renta.maper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.renta.model.Inmueble;

public class InmuebleMapper implements RowMapper<Inmueble>{

	public Inmueble mapRow(ResultSet rs, int rowNum) throws SQLException {
		Inmueble inm = new Inmueble();
		inm.setIdinmueble(rs.getInt("idinmueble"));
		inm.setDireccion(rs.getString("direccion"));
		inm.setCoordenadas(rs.getString("coordenadas"));
		inm.setImagen(rs.getString("imagen"));
		inm.setDescripcion(rs.getString("descripcion"));
		inm.setTipo_costo(rs.getString("tipo_costo"));
		inm.setCosto(rs.getDouble("costo"));
		inm.setCapacidad_max(rs.getString("capacidad_max"));
		inm.setTipo_inmueble(rs.getString("tipo_inmueble"));
		inm.setEstado(rs.getInt("estado"));
		inm.setUsuarios_idusuarios(rs.getInt("usuarios_idusuarios"));
		inm.setRanking_idranking(rs.getInt("ranking_idranking"));
		inm.setLatitud(rs.getString("latitud"));
		inm.setLongitud(rs.getString("longitud"));
		return inm;
	}
}
