package A2;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Adreça")
public class Adreça {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdAdreça")
	private int IdAdreça;
	@Column(name = "CarrerAdreça")
	private String CarrerAdreça;
	@Column(name = "CodiPostalAdreça")
	private int CodiPostalAdreça;
	@Column(name = "CiutatAdreça")
	private String CiutatAdreça;
	@Column(name = "ComarcaAdreça")
	private String ComarcaAdreça;
	@Column(name = "ComunitatAutonomaAdreça")
	private String ComunitatAutonomaAdreça;
	@Column(name = "Provincia")
	private String Provincia;
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="IdTenda")
	private Tenda t;

	public int getIdAdreça() {
		return IdAdreça;
	}

	public void setIdAdreça(int idAdreça) {
		IdAdreça = idAdreça;
	}

	public String getCarrerAdreça() {
		return CarrerAdreça;
	}

	public void setCarrerAdreça(String carrerAdreça) {
		CarrerAdreça = carrerAdreça;
	}

	public int getCodiPostalAdreça() {
		return CodiPostalAdreça;
	}

	public Adreça(String carrerAdreça, int codiPostalAdreça, String ciutatAdreça, String comarcaAdreça,
			String comunitatAutonomaAdreça, String provincia) {
		super();
		CarrerAdreça = carrerAdreça;
		CodiPostalAdreça = codiPostalAdreça;
		CiutatAdreça = ciutatAdreça;
		ComarcaAdreça = comarcaAdreça;
		ComunitatAutonomaAdreça = comunitatAutonomaAdreça;
		Provincia = provincia;
	}

	public void setCodiPostalAdreça(int codiPostalAdreça) {
		CodiPostalAdreça = codiPostalAdreça;
	}

	public String getCiutatAdreça() {
		return CiutatAdreça;
	}

	public void setCiutatAdreça(String ciutatAdreça) {
		CiutatAdreça = ciutatAdreça;
	}

	public String getComarcaAdreça() {
		return ComarcaAdreça;
	}

	public void setComarcaAdreça(String comarcaAdreça) {
		ComarcaAdreça = comarcaAdreça;
	}

	public String getComunitatAutonomaAdreça() {
		return ComunitatAutonomaAdreça;
	}

	public void setComunitatAutonomaAdreça(String comunitatAutonomaAdreça) {
		ComunitatAutonomaAdreça = comunitatAutonomaAdreça;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	public Tenda getT() {
		return t;
	}

	public void setT(Tenda t) {
		this.t = t;
	}
}
