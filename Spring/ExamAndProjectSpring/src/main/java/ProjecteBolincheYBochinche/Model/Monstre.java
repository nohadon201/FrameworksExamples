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
@Table(name = "Monstre")
@Transactional
public class Monstre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdMonstre")
	private int IdMonstre;

	@Column(name = "NomMonstre")
	private String NomMonstre;

	@Column(name = "NumeroVidesMonstre")
	private int NumeroVidesMonstre;

	@Column(name = "NumeroPuntsVictoriaMonstre")
	private int NumeroPuntsVictoriaMonstre;

	@Column(name = "EnergiaMonstre")
	private int EnergiaMonstre;

	@Column(name = "Tokio")
	private boolean Tokio;

	@Column(name = "Eliminat")
	private boolean Eliminat;
	
	@Column(name="Jugable")
	private boolean Jugable;
	
	@Column(name="DescripcioCartaPoder")
	private String descripcioCartaPoder;
	
	@Column(name="CostCartaPoder")
	private int CostCartaPoder;
	
	@Column(name="CartaPoder")
	private CartesPoder nomCarta;

	/**
	 * RELATIONS
	 */
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="IdMonstre")
	private Monstre monstreCarta;
	
	public void setMonstreCarta(Monstre monstreCarta) {
		this.monstreCarta = monstreCarta;
	}

	public void setMonstre(Monstre monstre) {
		this.monstre = monstre;
	}

	@OneToOne(cascade=CascadeType.PERSIST, mappedBy = "monstreCarta")
	private Monstre monstre;
	
	@ManyToOne
	@JoinColumn(name = "IdPartida")
	private Partida IdPartida;

	@ManyToOne
	@JoinColumn(name = "IdJugador")
	private Jugador IdJugador;

	public String getNomMonstre() {
		return NomMonstre;
	}

	public boolean isJugable() {
		return Jugable;
	}

	public void setJugable(boolean jugable) {
		Jugable = jugable;
	}

	public String getDescripcioCartaPoder() {
		return descripcioCartaPoder;
	}

	public void setDescripcioCartaPoder(String descripcioCartaPoder) {
		this.descripcioCartaPoder = descripcioCartaPoder;
	}

	public int getCostCartaPoder() {
		return CostCartaPoder;
	}

	public void setCostCartaPoder(int costCartaPoder) {
		CostCartaPoder = costCartaPoder;
	}

	public CartesPoder getNomCarta() {
		return nomCarta;
	}

	public void setNomCarta(CartesPoder nomCarta) {
		this.nomCarta = nomCarta;
	}

	public Monstre getMonstreCarta() {
		return monstreCarta;
	}

	public Monstre getMonstre() {
		return monstre;
	}

	public Partida getIdPartida() {
		return IdPartida;
	}

	public Jugador getIdJugador() {
		return IdJugador;
	}

	public void setNomMonstre(String nomMonstre) {
		NomMonstre = nomMonstre;
	}

	public int getNumeroVidesMonstre() {
		return NumeroVidesMonstre;
	}

	public void setNumeroVidesMonstre(int numeroVidesMonstre) {
		NumeroVidesMonstre = numeroVidesMonstre;
	}

	public int getNumeroPuntsVictoriaMonstre() {
		return NumeroPuntsVictoriaMonstre;
	}

	public void setNumeroPuntsVictoriaMonstre(int numeroPuntsVictoriaMonstre) {
		NumeroPuntsVictoriaMonstre = numeroPuntsVictoriaMonstre;
	}

	public int getEnergiaMonstre() {
		return EnergiaMonstre;
	}

	public void setEnergiaMonstre(int energiaMonstre) {
		EnergiaMonstre = energiaMonstre;
	}

	public boolean isTokio() {
		return Tokio;
	}

	public void setTokio(boolean tokio) {
		Tokio = tokio;
	}

	public Partida getPartida() {
		return IdPartida;
	}

	public void setPartida(Partida partida) {
		this.IdPartida = partida;
	}

	public Jugador getJugador() {
		return IdJugador;
	}

	public void setJugador(Jugador jugador) {
		this.IdJugador = jugador;
	}

	public int getIdMonstre() {
		return IdMonstre;
	}

	public boolean isEliminat() {
		return Eliminat;
	}

	public void setEliminat(boolean eliminat) {
		Eliminat = eliminat;
	}

}
