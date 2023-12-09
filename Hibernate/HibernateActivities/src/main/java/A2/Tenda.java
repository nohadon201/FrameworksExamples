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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "Tenda")
public class Tenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Tenda")
	private int id;
	@Column(name = "nom_Tenda")
	private String nom;
	@Column(name = "actiu_Tenda")
	private boolean actiu;
	@OneToMany(mappedBy = "tenda", cascade = CascadeType.ALL)
	private Set<Marca> marques = new HashSet<Marca>();
	@OneToMany(mappedBy = "tenda", cascade = CascadeType.ALL)
	private Set<Component> components = new HashSet<Component>();
	@OneToOne(cascade = { CascadeType.PERSIST }, mappedBy = "t")
	@JoinColumn(name = "IdAdreça")
	private Adreça adreça;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public Tenda(int id, String nom, boolean actiu) {
		super();
		this.nom = nom;
		this.actiu = actiu;
		
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isActiu() {
		return actiu;
	}

	public void setActiu(boolean actiu) {
		this.actiu = actiu;
	}

	public Set<Marca> getMarques() {
		return marques;
	}

	public void setMarques(Set<Marca> marques) {
		this.marques = marques;
	}

	public Set<Component> getComponents() {
		return components;
	}

	public void setComponents(Set<Component> components) {
		this.components = components;
	}

	public Adreça getAdreça() {
		return adreça;
	}

	public void setAdreça(Adreça adreça) {
		this.adreça = adreça;
	}

}
