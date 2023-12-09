package ProjecteBolincheYBochinche.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjecteBolincheYBochinche.Repositories.JugadorRepository;
import ProvaSpring2.Model.Jugador;
import ProvaSpring2.Repositoris.JuegoRepository;

@Service
public class JugadorService {
	@Autowired
	JugadorRepository repository;
	
	public Jugador findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public List<Jugador> findAll() {
		return repository.findAll();
	}

	public void delete(Integer id) {

		repository.deleteById(id);
	}

	public Jugador insertar(Jugador j) {
		return repository.save(j);
	}

	public Jugador editar(Jugador j) {
		return repository.save(j);
	}
	
	public List<Jugador> findByApellidosIgnoreCase(String apellidos){
		return repository.findByApellidosIgnoreCase(apellidos);
	}
	
	public List<Jugador> findByApellidosOrderByNombreAsc(String apellidos){
		return repository.findByApellidosOrderByNombreAsc(apellidos);
	}
	
	public List<Jugador> findByApellidosOrderByNombreDesc(String apellidos){
		return repository.findByApellidosOrderByNombreDesc(apellidos);
	}
	public List<Jugador> jugadorEntacao(int saldo){
		return repository.findBySaldoGreaterThanEqual(saldo);
	}
	
	public List<Jugador> jugadorEntacao2 (int saldo){
		return repository.buscarJugadorEntacao(saldo);
	}
}
