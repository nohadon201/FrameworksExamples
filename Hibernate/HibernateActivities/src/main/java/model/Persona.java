package model;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_persona")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="edad")
	private int edad;
	
	@Column(name="altura")
	private float altura;
	
	//OneToMany. Aqui diem que volem el set (i per tant la taula), i quina variable ens farà referencia, es a dir, quina variable representa la clau foranea.
	//la variable s'ha de dir com la variable de JAVA, no com la columna de SQL
	@OneToMany(mappedBy = "propietario")
	private Set<Almohada> almohadas;
	

	
	public Set<Almohada> getAlmohadas() {
		return almohadas;
	}

	public void setAlmohadas(Set<Almohada> almohadas) {
		this.almohadas = almohadas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public int getId() {
		return id;
	}
	
	
}
