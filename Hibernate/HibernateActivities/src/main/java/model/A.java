package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AT")
public class A {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_A")
	private int id;
	
	@Column(name="cosaA")
	private String cosaA;
	
	@Column(name="cosaB")
	private String cosaB;
	
	@ManyToOne
	@JoinColumn(name="id_padre", nullable=true)
	private A padre;
	
	@OneToMany(mappedBy = "padre")
	private Set<A> hijos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCosaA() {
		return cosaA;
	}

	public void setCosaA(String cosaA) {
		this.cosaA = cosaA;
	}

	public String getCosaB() {
		return cosaB;
	}

	public void setCosaB(String cosaB) {
		this.cosaB = cosaB;
	}

	public A getPadre() {
		return padre;
	}

	public void setPadre(A padre) {
		this.padre = padre;
	}

	public Set<A> getHijos() {
		return hijos;
	}

	public void setHijos(Set<A> hijos) {
		this.hijos = hijos;
	}

	public A(String cosaA, String cosaB) {
		super();
		this.id = id;
		this.cosaA = cosaA;
		this.cosaB = cosaB;
		this.hijos = new HashSet<A>();
		
	}
	
	
	
	
}
