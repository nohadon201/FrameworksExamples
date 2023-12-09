package A3;

import java.util.List;

public class AdreçaDAO extends GenericDAO<Adreça, Integer> {
	private static AdreçaDAO adreçaDAO;
	
	private AdreçaDAO() {
		super();
	}

	public static AdreçaDAO getInstance() {
		if (adreçaDAO == null) {
			adreçaDAO = new AdreçaDAO();
		}
		return adreçaDAO;
	}
}
