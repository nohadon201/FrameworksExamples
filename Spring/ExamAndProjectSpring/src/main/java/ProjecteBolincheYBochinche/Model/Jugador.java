package ProjecteBolincheYBochinche.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name="Jugador")
@Transactional
public class Jugador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdJugador")
	private int IdJugador;
	
	@Column(name="NomJugador")
	private String NomJugador;
	
	@Column(name="CognomJugador")
	private String CognomJugador;
	
	/**
	 * RELATIONS
	 */
	
	@OneToMany(mappedBy = "IdJugador", cascade = CascadeType.ALL)
	private Set<Monstre> monstres = new HashSet<Monstre>();

	public String getNomJugador() {
		return NomJugador;
	}

	public void setNomJugador(String nomJugador) {
		NomJugador = nomJugador;
	}

	public String getCognomJugador() {
		return CognomJugador;
	}

	public void setCognomJugador(String cognomJugador) {
		CognomJugador = cognomJugador;
	}

	public Set<Monstre> getMonstres() {
		return monstres;
	}

	public int getIdJugador() {
		return IdJugador;
	}
	
}
	
