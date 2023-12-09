package ProjecteBolincheYBochinche.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ProvaSpring2.Model.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador,Integer>{
	
	List<Jugador> findByApellidosIgnoreCase(String Ape1);
	List<Jugador> findByNombreAndApellidosAllIgnoreCase(String nombre, String apellidos);
	
	List<Jugador> findByApellidosOrderByNombreAsc(String apellidos);
	List<Jugador> findByApellidosOrderByNombreDesc(String apellidos);
	
	List<Jugador> findBySaldoGreaterThanEqual(int saldo);
	@Query("Select j from Jugador j where saldo >= :saldo")
	List<Jugador> buscarJugadorEntacao(@Param("saldo") int saldo);
}
