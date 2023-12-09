package A2;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Component")
public class Component {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdComponent")
	private int IdComponent;
	@Column(name = "NomComponent")
	private String nom;
	@Column(name = "DescripcioComponent")
	private String Descripcio;
	@Column(name = "QuantitatComponent")
	private int Quantitat;
	@ManyToOne
	@JoinColumn(name = "id_Tenda")
	private Tenda tenda;

	@ManyToMany(cascade = { CascadeType.REFRESH })
	@JoinTable(name = "MarquesComponent", joinColumns = { @JoinColumn(name = "IdComponent") }, inverseJoinColumns = {
			@JoinColumn(name = "IdMarca") })
	private Set<Marca> marques = new HashSet<Marca>();

	public Component(int idComponent, String nom, String descripcio, int quantitat) {
		super();
		this.nom = nom;
		Descripcio = descripcio;
		Quantitat = quantitat;
	}

	public int getIdComponent() {
		return IdComponent;
	}

	public void setIdComponent(int idComponent) {
		IdComponent = idComponent;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescripcio() {
		return Descripcio;
	}

	public void setDescripcio(String descripcio) {
		Descripcio = descripcio;
	}

	public int getQuantitat() {
		return Quantitat;
	}

	public void setQuantitat(int quantitat) {
		Quantitat = quantitat;
	}

	public Tenda getTenda() {
		return tenda;
	}

	public void setTenda(Tenda tenda) {
		this.tenda = tenda;
	}

	public Set<Marca> getMarques() {
		return marques;
	}

	public void setMarques(Set<Marca> marques) {
		this.marques = marques;
	}
}
