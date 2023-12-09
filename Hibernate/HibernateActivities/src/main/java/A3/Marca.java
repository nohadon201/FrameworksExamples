package A3;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "Marca")
public class Marca {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdMarca")
	private int IdMarca;
	@Column(name = "NomMarca")
	private String NomMarca;
	@Column(name = "AnyMarca")
	private int AnyMarca;
	@ManyToMany(cascade = { CascadeType.ALL }, mappedBy = "marques")
	private Set<Component> components = new HashSet<Component>();
	@ManyToOne
	@JoinColumn(name = "IdTenda")
	private Tenda tenda;

	public int getIdMarca() {
		return IdMarca;
	}

	public void setIdMarca(int idMarca) {
		IdMarca = idMarca;
	}
	public Marca() {}
	public Marca(int idMarca, String nomMarca, int anyMarca) {
		super();
		NomMarca = nomMarca;
		AnyMarca = anyMarca;
	}

	public String getNomMarca() {
		return NomMarca;
	}

	public void setNomMarca(String nomMarca) {
		NomMarca = nomMarca;
	}

	public int getAnyMarca() {
		return AnyMarca;
	}

	public void setAnyMarca(int anyMarca) {
		AnyMarca = anyMarca;
	}

	public Set<Component> getComponents() {
		return components;
	}

	public void setComponents(Set<Component> components) {
		this.components = components;
	}

	public Tenda getTenda() {
		return tenda;
	}

	public void setTenda(Tenda tenda) {
		this.tenda = tenda;
	}
}
