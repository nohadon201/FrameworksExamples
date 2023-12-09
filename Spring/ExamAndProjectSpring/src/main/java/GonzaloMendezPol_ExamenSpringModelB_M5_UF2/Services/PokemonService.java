package GonzaloMendezPol_ExamenSpringModelB_M5_UF2.Services;

import java.util.List;

import GonzaloMendezPol_ExamenSpringModelB_M5_UF2.Model.Pokemon;
import GonzaloMendezPol_ExamenSpringModelB_M5_UF2.Repositories.PokemonRepository;
import ProvaSpring2.Model.Jugador;

public class PokemonService {
	PokemonRepository repository;
	public Pokemon findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	public List<Pokemon> findAll() {
		return repository.findAll();
	}

	public void delete(Integer id) {

		repository.deleteById(id);
	}

	public Pokemon insertar(Pokemon j) {
		return repository.save(j);
	}

	public Pokemon editar(Pokemon j) {
		return repository.save(j);
	}
	
	

}
