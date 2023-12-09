package A3;

public class MarcaDAO extends GenericDAO<Marca, Integer> {
private static MarcaDAO marcaDAO;
	
	private MarcaDAO() {
		super();
	}

	public static MarcaDAO getInstance() {
		if (marcaDAO == null) {
			marcaDAO = new MarcaDAO();
		}
		return marcaDAO;
	}
}
