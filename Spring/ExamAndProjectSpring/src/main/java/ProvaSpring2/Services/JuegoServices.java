package ProvaSpring2.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProvaSpring2.Model.Juego;
import ProvaSpring2.Repositoris.JuegoRepository;

@Service
public class JuegoServices {
	@Autowired
	JuegoRepository repository;
	public Juego findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public List<Juego> findAll() {
		return repository.findAll();
	}

	public void delete(Integer id) {

		repository.deleteById(id);
	}

	public Juego insertar(Juego j) {
		return repository.save(j);
	}

	public Juego editar(Juego j) {
		return repository.save(j);
	}
}
