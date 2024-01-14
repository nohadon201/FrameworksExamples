package PrimeraPart;

public class MonstreDAO extends GenericDAO<Monstre, Integer> {
	private static MonstreDAO monstreDAO;
	private MonstreDAO() {
		
	}
	public static MonstreDAO getInstance() {
		if(monstreDAO==null) {
			monstreDAO= new MonstreDAO();
		}
		return monstreDAO;
	}
}
