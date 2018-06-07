package com.renta.maper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.renta.model.Admin;


public class AdminMapper implements RowMapper<Admin> {

	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		Admin adm = new Admin();
		adm.setId_admin(rs.getInt("id_admin"));
		adm.setCod_admin(rs.getString("cod_admin"));
		adm.setNom_admin(rs.getString("nom_admin"));
		adm.setPas_admin(rs.getString("pas_admin"));
		
		return adm;
	}

}
