package A3;

public class TendaDAO extends GenericDAO<Tenda, Integer> {
private static TendaDAO tendaDAO;
	
	private TendaDAO() {
		super();
	}

	public static TendaDAO getInstance() {
		if (tendaDAO == null) {
			tendaDAO = new TendaDAO();
		}
		return tendaDAO;
	}
}
