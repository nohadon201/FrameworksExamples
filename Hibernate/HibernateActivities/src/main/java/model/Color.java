package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "color")
public class Color {
	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id_color")
		private int id;
		
		@Column(name="nombre")
		private String nombre;
		
		@Column(name="r")
		private int r;
		@Column(name="g")
		private int g;
		@Column(name="b")
		private int b;
		
		@ManyToMany(cascade = { CascadeType.ALL })
	    @JoinTable(
	        name = "color_almohada", 
	        joinColumns = { @JoinColumn(name = "color_id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "almohada_id") }
	    )
		private Set<Almohada> almohadas;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getR() {
			return r;
		}

		public void setR(int r) {
			this.r = r;
		}

		public int getG() {
			return g;
		}

		public void setG(int g) {
			this.g = g;
		}

		public int getB() {
			return b;
		}

		public void setB(int b) {
			this.b = b;
		}

		public Set<Almohada> getAlmohadas() {
			return almohadas;
		}

		public void setAlmohadas(Set<Almohada> almohadas) {
			this.almohadas = almohadas;
		}
		
		
		
		

}
