package A1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Departament")
public class Departament {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_departament")
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="num_persones")
	private int numero_persones;
	
	@Column(name="telefon")
	private String telefon;

	@Column(name="nom_cap_departament")
	private String nomCapDepartament;

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getNumero_persones() {
		return numero_persones;
	}


	public void setNumero_persones(int numero_persones) {
		this.numero_persones = numero_persones;
	}


	public String getTelefon() {
		return telefon;
	}


	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}


	public String getNomCapDepartament() {
		return nomCapDepartament;
	}


	public void setNomCapDepartament(String nomDepartament) {
		this.nomCapDepartament = nomDepartament;
	}


}
