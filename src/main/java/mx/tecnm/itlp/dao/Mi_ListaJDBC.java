package mx.tecnm.itlp.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD

import mx.tecnm.itlp.models.CantidadResponse;
=======
>>>>>>> 311e0f38791ee615ed2896da27460d49ce529eb5
import mx.tecnm.itlp.models.Mi_Lista;
import mx.tecnm.itlp.models.Mi_lista_response;
import mx.tecnm.itlp.models.Peliculas;



@Repository
public class Mi_ListaJDBC {

	@Autowired
	JdbcTemplate conexion;
	
	
	public void insertarLista(Mi_Lista ml) {
		String sql = "INSERT INTO mi_lista (id,fecha,perfiles_usuarios_id,peliculas_id) VALUES (?,?,?,?)";
		conexion.update(sql,ml.getId(),ml.getFecha(),ml.getPerfiles_usuarios_id(),ml.getPeliculas_id());
	}

	
	public List<Mi_lista_response> consultarLista(int id) {
		String sql = "SELECT p.titulo, p.sinopsis, p.productora, p.tamano_descarga"
				+"FROM peliculas AS p"
				+"JOIN mi_lista AS m ON m.perfiles_usuarios_id=?";
		return conexion.query(sql, new MiListaRM(),id );
	}
	
<<<<<<< HEAD
	public List<CantidadResponse> consultarCantidadPeliculas(int idperfilusuarios) {
		String sql = "SELECT COUNT(*) AS cantidad\r\n"
				+ "FROM mi_lista AS m \r\n"
				+ "JOIN peliculas AS p ON p.id=m.peliculas_id\r\n"
				+ "WHERE p.activo = 1 AND m.perfiles_usuarios_id=?\r\n"
				+ "\r\n"
				+ "";
		return conexion.query(sql, new CountLista(), idperfilusuarios);
	}
=======
	public void EliminarLista (int idperfilusuarios, int idpeliculas) {
		String sql="DELETE FROM mi_lista WHERE  perfiles_usuarios_id=? AND peliculas_id=?";
		conexion.update(sql,idperfilusuarios, idpeliculas);
	}
	
	
	// consulta general
	public List<Mi_lista_response> consultar(){
        String sql = "SELECT * FROM mi_lista;";
        return conexion.query(sql, new MiListaRM());
        
    }
>>>>>>> 311e0f38791ee615ed2896da27460d49ce529eb5

	
	
}
