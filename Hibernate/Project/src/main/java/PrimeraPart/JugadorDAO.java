package PrimeraPart;

public class JugadorDAO extends GenericDAO<Jugador, Integer> {
	private static JugadorDAO jugadorDAO;
	private JugadorDAO() {
		
	}
	public static JugadorDAO getInstance() {
		if(jugadorDAO==null) {
			jugadorDAO= new JugadorDAO();
		}
		return jugadorDAO;
	}
}
