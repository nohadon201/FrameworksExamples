package PrimeraPart;

public class Mainer {
	public static void main(String[] args) {
		Jugador jugador = new Jugador();
		jugador.setNomJugador("Pol");
		jugador.setCognomJugador("Gonzalo Méndez");
		
		Monstre monstre = new Monstre();
		monstre.setNomMonstre("Jose Antonio el Monstruo");
		monstre.setNumeroVidesMonstre(8);
		monstre.setTokio(false);
		monstre.setEnergiaMonstre(0);
		monstre.setNumeroPuntsVictoriaMonstre(0);
		monstre.setEliminat(false);
		
		Partida partida = new Partida();
		partida.setTorn(0);
		partida.setNumeroJugadorsAssociats(4);
		
		JugadorDAO.getInstance().Insert(jugador);
		PartidaDAO.getInstance().Insert(partida);
		MonstreDAO.getInstance().Insert(monstre);
		
		jugador.getMonstres().add(monstre);
		monstre.setJugador(jugador);
		partida.getMonstres().add(monstre);
		monstre.setPartida(partida);
		
		
		JugadorDAO.getInstance().Update(jugador);
		PartidaDAO.getInstance().Update(partida);
		
		MonstreDAO.getInstance().Update(monstre);
	}
}
