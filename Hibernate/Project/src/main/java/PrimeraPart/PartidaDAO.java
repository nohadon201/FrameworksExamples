package PrimeraPart;

public class PartidaDAO extends GenericDAO<Partida, Integer>{
	private static PartidaDAO partidaDAO;
	private PartidaDAO() {
		
	}
	public static PartidaDAO getInstance() {
		if(partidaDAO==null) {
			partidaDAO= new PartidaDAO();
		}
		return partidaDAO;
	}
}
