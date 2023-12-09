import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

public class PokemonDAO extends GenericDAO<Pokemon, Integer> {
	private static PokemonDAO pokemonDAO;

	private PokemonDAO() {

	}

	public static PokemonDAO getInstance() {
		if (pokemonDAO == null) {
			pokemonDAO = new PokemonDAO();
		}
		return pokemonDAO;
	}

	public List<Pokemon> llistarTotsElsPokemon() {
		return this.findAll();
	}

	public void MostrarEvolucionsPokemon() {
		ArrayList<Pokemon> arr = (ArrayList<Pokemon>) this.findAll();
		for (Pokemon pokemon : arr) {
			if (pokemon.getIdPokemonEvolucionat() != null) {
				System.out.println();
				System.out.println("El pokemon: " + pokemon.getNom() + " té la evolució: "
						+ pokemon.getIdPokemonEvolucionat().getNom());
				System.out.println(
						pokemon.getIdPokemon() + "  ----->  " + pokemon.getIdPokemonEvolucionat().getIdPokemon());
				System.out.println();
			}
		}
	}

	public void SumaCandy(Pokemon IdPokemon) {
		switch (IdPokemon.getTipusPokemon()) {
		case GRASS:
			IdPokemon.setCandyPokemon(IdPokemon.getCandyPokemon()+25);
			this.Update(IdPokemon);
			break;
		case GROUND:
			IdPokemon.setCandyPokemon(IdPokemon.getCandyPokemon()+30);
			this.Update(IdPokemon);
			break;
		case ICE:
			IdPokemon.setCandyPokemon(IdPokemon.getCandyPokemon()+15);
			this.Update(IdPokemon);
			break;
		case STEEL:
			IdPokemon.setCandyPokemon(IdPokemon.getCandyPokemon()+10);
			this.Update(IdPokemon);
			break;
		default:
			System.err.println("Tu eres tonto");
			break;
		}
		System.out.println("S'ha actualitzat el Pokemon: "+IdPokemon.getNom()+" ara té "+IdPokemon.getCandyPokemon());
		//System.out.println(IdPokemon.toString());
	}
}
