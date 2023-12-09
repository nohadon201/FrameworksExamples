package GonzaloMendezPol_ExamenSpringModelB_M5_UF2.Model;
import javax.persistence.*;

@Entity
@Table(name="Pokemon")
public class Pokemon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdPokemon")
	private int IdPokemon;
	@Column(name="TipusPokemon")
	private TipusPokemon TipusPokemon;
	@Column(name="NomPokemon")
	private String Nom;
	@Column(name="CandyPokemon")
	private int CandyPokemon;
	@Column(name="EvolucionatPokemon")
	private boolean EvolucionatPokemon;
	
	/**
	 * Relacions
	 */
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="IdPokemonEvolucionat")
	private Pokemon IdPokemonEvolucionat;

	public TipusPokemon getTipusPokemon() {
		return TipusPokemon;
	}

	public void setTipusPokemon(TipusPokemon tipusPokemon) {
		TipusPokemon = tipusPokemon;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public int getCandyPokemon() {
		return CandyPokemon;
	}

	public void setCandyPokemon(int candyPokemon) {
		CandyPokemon = candyPokemon;
	}

	@Override
	public String toString() {
		return "Pokemon [IdPokemon=" + IdPokemon + ", TipusPokemon=" + TipusPokemon + ", Nom=" + Nom + ", CandyPokemon="
				+ CandyPokemon + ", EvolucionatPokemon=" + EvolucionatPokemon + ", IdPokemonEvolucionat="
				+ IdPokemonEvolucionat + "]";
	}

	public boolean isEvolucionatPokemon() {
		return EvolucionatPokemon;
	}

	public void setEvolucionatPokemon(boolean evolucionatPokemon) {
		EvolucionatPokemon = evolucionatPokemon;
	}

	public Pokemon getIdPokemonEvolucionat() {
		return IdPokemonEvolucionat;
	}

	public void setIdPokemonEvolucionat(Pokemon idPokemonEvolucionat) {
		IdPokemonEvolucionat = idPokemonEvolucionat;
	}

	public int getIdPokemon() {
		return IdPokemon;
	}
	
}
