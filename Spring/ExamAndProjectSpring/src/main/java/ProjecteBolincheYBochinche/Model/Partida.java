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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
@Table(name = "Partida")
@Transactional
public class Partida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdPartida")
	private int IdPartida;

	@Column(name = "Torn")
	private int Torn;

	@Column(name = "NumeroJugadorsAssociats")
	private int numeroJugadorsAssociats;
	/**
	 * RELATIONS
	 * 
	 */

	@OneToMany(mappedBy = "IdPartida", cascade = CascadeType.ALL)
	private Set<Monstre> monstres = new HashSet<Monstre>();

	public int getIdPartida() {
		return IdPartida;
	}

	public void setIdPartida(int idPartida) {
		IdPartida = idPartida;
	}

	public int getTorn() {
		return Torn;
	}

	public void setTorn(int torn) {
		Torn = torn;
	}

	public Set<Monstre> getMonstres() {
		return monstres;
	}

	public int getNumeroJugadorsAssociats() {
		return numeroJugadorsAssociats;
	}

	public void setNumeroJugadorsAssociats(int numeroJugadorsAssociats) {
		this.numeroJugadorsAssociats = numeroJugadorsAssociats;
	}
}
