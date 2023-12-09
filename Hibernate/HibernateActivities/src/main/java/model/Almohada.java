package model;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//anotacions

@Entity
@Table(name = "almohada")
public class Almohada {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_almohada")
	private int id;
	
	@Column(name="tamano")
	private String tamano;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="dibujo")
	private String dibujo;
	
	@Column(name="relleno")
	private boolean relleno;
	
	@Column(name="precio")
	private float precio;
	
	@Column(name="sabor")
	private String sabor;
	
	//ManyToOne. Aqu� declarem la clau foranea.
	//La clau foranea es una referencia a un objecte de classe del que es One
	//en el nostre cas, la classe Persona
	//a la columa no anir� l'objecte sencer, si no que anira la clau primaria
	//nullable false significa que mai pot ser null. per tant, tots els coixins hauran de tenir propietari
	@ManyToOne
	@JoinColumn(name="id_propietari", nullable=true)
	private Persona propietario;
	
	@ManyToMany(mappedBy = "almohadas")
	private Set<Color> colores;
	
	
	public Almohada() {
		super();

		this.colores = new HashSet<Color>();
	}



	public Almohada(String tamano, String tipo, String dibujo, boolean relleno, String color, float precio,
			String sabor, Date fechaAdquisicion) {
		super();
		this.tamano = tamano;
		this.tipo = tipo;
		this.dibujo = dibujo;
		this.relleno = relleno;
		this.precio = precio;
		this.sabor = sabor;
		this.fechaAdquisicion = fechaAdquisicion;
		this.colores = new HashSet<Color>();
	}
	
	
	
	public Set<Color> getColores() {
		return colores;
	}



	public void setColores(Set<Color> colores) {
		this.colores = colores;
	}



	@Column(name="fecha_adquisicion")
	private Date fechaAdquisicion;
	public int getId() {
		return id;
	}
	
	
	
	public Persona getPropietario() {
		return propietario;
	}



	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}



	public void setId(int id) {
		this.id = id;
	}
	public String getTamano() {
		return tamano;
	}
	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDibujo() {
		return dibujo;
	}
	public void setDibujo(String dibujo) {
		this.dibujo = dibujo;
	}
	public boolean isRelleno() {
		return relleno;
	}
	public void setRelleno(boolean relleno) {
		this.relleno = relleno;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getSabor() {
		return sabor;
	}
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	public Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}
	public void setFechaAdquisicion(Date fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}
	@Override
	public String toString() {
		return "Almohada [id=" + id + ", tama�o=" + tamano + ", tipo=" + tipo + ", dibujo=" + dibujo + ", relleno="
				+ relleno + "  precio=" + precio + ", sabor=" + sabor + ", fechaAdquisicion="
				+ fechaAdquisicion + "]";
	}
	
	

}
