package A3;

public class ComponentDAO extends GenericDAO<Component, Integer> {
private static ComponentDAO componentDAO;
	
	private ComponentDAO() {
		super();
	}

	public static ComponentDAO getInstance() {
		if (componentDAO == null) {
			componentDAO = new ComponentDAO();
		}
		return componentDAO;
	}
}
