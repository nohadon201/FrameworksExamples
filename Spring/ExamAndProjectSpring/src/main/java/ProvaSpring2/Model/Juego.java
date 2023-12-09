package ProvaSpring2.Model;

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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name="Juego")
@Transactional
public class Juego implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="JUG_ID")
    private int juegoId;
	
	@Column(name="NOMBRE")
    private String nombre;
    
    @Column(name="EDAD")
    private Integer edad;
    
    @Column(name="PRECIO")
    private Integer precio;
    // @JsonBackReference aquesta anotació és del fill
    // i és per indicar que no call veure informació del fill sobretot la que es repeteixi.
    // Això em serveix perquè el JSON pot queda niuat i fallar perquè una repetició infinita de dades.
    // És a dir, primer veig Jugador, després videojoc, després un altre cop jugador i així fins que peta.
    @ManyToMany(cascade=CascadeType.ALL, mappedBy="juegos",fetch = FetchType.EAGER)
    @JsonBackReference
    Set <Jugador> jugadores = new HashSet<Jugador>();

	public Juego() {
		super();
	}

	public Juego(String nombre, Integer edad, Integer precio) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.precio = precio;
	}

	public int getJuegoId() {
		return juegoId;
	}

	public void setJuegoId(int juegoId) {
		this.juegoId = juegoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Set<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	@Override
	public String toString() {
		return "Juego [juegoId=" + juegoId + ", nombre=" + nombre + ", edad=" + edad + ", precio=" + precio
				+ ", jugadores=" + jugadores + "]";
	}
    
    
}
