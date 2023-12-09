package ProjecteBolincheYBochinche.Services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProjecteBolincheYBochinche.Model.Monstre;
import ProjecteBolincheYBochinche.Model.Partida;
import ProjecteBolincheYBochinche.Repositories.MonstreRepository;
import ProjecteBolincheYBochinche.Repositories.PartidaRepository;

@Service
public class MonstreService {
	@Autowired
	MonstreRepository repository;

	public List<Monstre> trobarMonstreJugador(int IdJugador) {
		ArrayList<Monstre> monstres = (ArrayList<Monstre>) repository.findAll();
		ArrayList<Monstre> monstres2 = new ArrayList<Monstre>();
		for (Monstre monstre : monstres) {
			if(!monstre.isEliminat() && monstre.getJugador().getIdJugador()==IdJugador) {
				monstres2.add(monstre);
			}
		}
		return monstres2;
	}
	

	public boolean existsByTokio() {
		List<Monstre> monstres = ListMonstresVius();
		boolean ey = false;
		for (Monstre monstre : monstres) {
			if(monstre.isJugable() && monstre.isTokio()) {
				ey=true;
			}
		}
		return ey;
	}

	public void setMonstreTokioAleatori(int IdMonstre) {
		List<Monstre> monstres = ListMonstresVius();
		for (Monstre monstre : monstres) {
			if(monstre.isTokio()) {
				monstre.setTokio(false);
				repository.saveAndFlush(monstre);
			}
		}
		Random r = new Random();
		Monstre m = monstres.get(r.nextInt(monstres.size()-1));
		m.setTokio(true);
		repository.saveAndFlush(m);
		
	}

	public List<Monstre> ListMonstresVius() {
		ArrayList<Monstre> monstres = (ArrayList<Monstre>) repository.findAll();
		ArrayList<Monstre> monstres2 = new ArrayList<Monstre>();
		for (Monstre monstre : monstres) {
			if(!monstre.isEliminat() && monstre.isJugable()) {
				monstres2.add(monstre);
			}
		}
		return monstres2;
	}

	/**
	 * the adventure begins, they are always beside you, your nerdy best friends and
	 * the DM to guide you.
	 * 
	 * @return the result of dices
	 */
	public ArrayList<Daus> Roll() {
		Random r = new Random();
		ArrayList<Daus> dausValues = new ArrayList<Daus>();
		for (int i = 0; i < 6; i++) {
			dausValues.add(Daus.values()[r.nextInt(5)]);
		}
		return dausValues;
	}


	/**
	 * Solve the results of the dice
	 * 
	 * @param j the player
	 * @param m the monster to edit the values
	 */
	public void SolveRoll(int IdJugador, Monstre m) {
		ArrayList<Daus> resultats = Roll();
		LinkedHashMap<Daus, Integer> repeticions = new LinkedHashMap<>();
		for (Daus daus : resultats) {
			switch (daus) {
			case UN:
			case DOS:
			case TRES:
				repeticions.put(daus, repeticions.getOrDefault(daus, 0) + 1);
				break;
			case COR:
				m.setNumeroVidesMonstre(m.getNumeroVidesMonstre() + 1);
				break;
			case ENERGIA:
				m.setEnergiaMonstre(m.getEnergiaMonstre() + 1);
				break;
			case DANY:
				break;
			}
		}
		for (Map.Entry<Daus, Integer> entry : repeticions.entrySet()) {
			if (entry.getValue() >= 3) {
				switch (entry.getKey()) {
				case UN:
					m.setNumeroPuntsVictoriaMonstre(m.getNumeroPuntsVictoriaMonstre() + 1);
					m.setNumeroPuntsVictoriaMonstre(m.getNumeroPuntsVictoriaMonstre() + entry.getValue() - 3);
					break;
				case DOS:
					m.setNumeroPuntsVictoriaMonstre(m.getNumeroPuntsVictoriaMonstre() + 2);
					m.setNumeroPuntsVictoriaMonstre(m.getNumeroPuntsVictoriaMonstre() + entry.getValue() - 3);
					break;
				case TRES:
					m.setNumeroPuntsVictoriaMonstre(m.getNumeroPuntsVictoriaMonstre() + 3);
					m.setNumeroPuntsVictoriaMonstre(m.getNumeroPuntsVictoriaMonstre() + entry.getValue() - 3);
					break;
				}
			}
		}
		repository.saveAndFlush(m);
	}

	public ArrayList<Monstre> llistarMonstresViusContricants(int idMonstre) {
		ArrayList<Monstre> arr = (ArrayList<Monstre>) ListMonstresVius();
		ArrayList<Monstre> arr2 = new ArrayList<Monstre>();
		for (Monstre monstre : arr) {
			if(monstre.isJugable() && monstre.getIdMonstre()!= idMonstre) {
				arr2.add(monstre);
			}
		}
		return arr2;
		
	}

	public Monstre getMonstreTokio() {
		List<Monstre> monstres = ListMonstresVius();
		for (Monstre monstre : monstres) {
			if(!monstre.isEliminat() && monstre.isJugable()) {
				return monstre;
			}
		}
		return null;
	}

	public ArrayList<Monstre> listMonstresPoderLliures() {
		List<Monstre> m = repository.findAll();
		ArrayList<Monstre> monstres = new ArrayList<Monstre>();
		for (Monstre monstre : m) {
			if(!monstre.isJugable() && monstre.getMonstre()==null) {
				monstres.add(monstre);
			}
		}
		return monstres;
	}

	public void AlientoFlamigero() {

	}

	public void Mimetismo() {

	}

	public void RayoReductor() {

	}

	public void EscupidorVeneno() {

	}
	
	public void UtilitzarCartaPoder(Monstre m) {
		if(m.getMonstreCarta()!=null){
			switch(m.getMonstreCarta().getNomCarta()) {
			case AlientoFuego:
				AlientoFlamigero();
				break;
			case EscupidorVeneno:
				EscupidorVeneno();
				break;
			case Mimetismo:
				Mimetismo();
				break;
			case RayoReductor:
				RayoReductor();
				break;
			}
		}else {
			System.err.println("El monstre no té una carta");
		}
	}

	public void ActualitzarMonstresVius() {
		List<Monstre> monstres = ListMonstresVius();
		for (Monstre monstre : monstres) {
			if(!monstre.isEliminat() && monstre.getNumeroVidesMonstre()<=0) {
				monstre.setEliminat(true);
				repository.saveAndFlush(monstre);
			}
		}
	}

	public int CountMonstresVius() {
		return ListMonstresVius().size();
	}

	public Monstre monstreMaxPuntsVictoria() {
		List<Monstre> monstres = ListMonstresVius();
		int a = 0;
		Monstre maxm = new Monstre();
		for (Monstre monstre : monstres) {
			if(monstre.getNumeroPuntsVictoriaMonstre()>=a) {
				a=monstre.getNumeroPuntsVictoriaMonstre();
				maxm = monstre;
			}
		}
		return maxm;
		
	}

	public Monstre monstreViu() {
		if(ListMonstresVius().size()==1) {
			return ListMonstresVius().get(0);
		}
		return null;
	}
/**
	public void asignarTorn(int idPartida) {
		List<Monstre> list = ListMonstresVius();
		PartidaRepository par;
		Partida p = par.getById(idPartida);
		boolean b = false;
		int a = 0;
		for (Monstre monstre : list) {
			if (b) {
				p.setTorn(monstre.getIdMonstre());
				par.saveAndFlush(p);
				b = false;
				a++;
			} else if (p.getTorn() == monstre.getIdMonstre()) {
				b = true;
			}
		}
		if (a == 0) {
			p.setTorn(list.get(0).getIdMonstre());
			par.saveAndFlush(p);
		}
	}
	**/
}
