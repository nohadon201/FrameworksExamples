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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Jugador")
@Transactional
public class Jugador implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="JUG_ID")
    private int jugId;
    
    @Column(name="NOMBRE")
    private String nombre;
    
    @Column(name="APELLIDOS")
    private String apellidos;
    
    @Column(name="SALDO")
    private Integer saldo;
    
    //También valido -> cascade= CascadeType.Refresh
    @ManyToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name="JugadorJuego", joinColumns= {@JoinColumn(name="IdJugador")}, inverseJoinColumns= {@JoinColumn(name="IdJuego")})
    // @JsonBackReference aquesta anotació és del pare
    // i és per indicar que la informació del pare sí que és visible.
    @JsonManagedReference
    Set <Juego> juegos = new HashSet<Juego>();

	public Jugador() {
		super();
	}

	public Jugador(String nombre, String apellidos, Integer saldo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.saldo = saldo;
	}

	public int getJugId() {
		return jugId;
	}

	public void setJugId(int jugId) {
		this.jugId = jugId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getSaldo() {
		return saldo;
	}

	public void setSaldo(Integer saldo) {
		this.saldo = saldo;
	}

	public Set<Juego> getJuegos() {
		return juegos;
	}

	public void setJuegos(Set<Juego> juegos) {
		this.juegos = juegos;
	}

	@Override
	public String toString() {
		return "Jugador [jugId=" + jugId + ", nombre=" + nombre + ", apellidos=" + apellidos + ", saldo=" + saldo
				+ ", juegos=" + juegos + "]";
	}
    
    
    
    
}
