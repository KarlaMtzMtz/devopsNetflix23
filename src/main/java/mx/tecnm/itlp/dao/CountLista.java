package mx.tecnm.itlp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.tecnm.itlp.models.CantidadResponse;


public class CountLista  implements RowMapper<CantidadResponse>{
	@Override
	public CantidadResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		CantidadResponse mi_lista = new CantidadResponse();
		
		mi_lista.setCantidad(rs.getString("cantidad"));
		
		return mi_lista;

	}
}
