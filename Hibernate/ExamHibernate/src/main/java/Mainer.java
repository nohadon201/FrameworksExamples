
public class Mainer {
	public static void main(String[] args) {
		Pokemon p = new Pokemon();
		p.setNom("Charmonder");
		p.setTipusPokemon(TipusPokemon.GRASS);
		p.setEvolucionatPokemon(false);
		PokemonDAO.getInstance().Insert(p);
		
		Pokemon p2 = new Pokemon();
		p2.setNom("Mortadelo y Flipeton");
		p2.setTipusPokemon(TipusPokemon.GROUND);
		p2.setEvolucionatPokemon(true);
		PokemonDAO.getInstance().Insert(p2);
		
		Pokemon p3 = new Pokemon();
		p3.setNom("ChorizoPortuano");
		p3.setTipusPokemon(TipusPokemon.ICE);
		p3.setEvolucionatPokemon(false);
		PokemonDAO.getInstance().Insert(p3);
		
		Pokemon p4 = new Pokemon();
		p4.setNom("El furro ese");
		p4.setTipusPokemon(TipusPokemon.STEEL);
		p4.setEvolucionatPokemon(true);
		PokemonDAO.getInstance().Insert(p4);
		
		Pokemon p5 = new Pokemon();
		p5.setNom("VAPOREON HENTAI");
		p5.setTipusPokemon(TipusPokemon.STEEL);
		p5.setEvolucionatPokemon(false);
		PokemonDAO.getInstance().Insert(p5);
		
		Pokemon p6 = new Pokemon();
		p6.setNom("ª EL POKEMON");
		p6.setTipusPokemon(TipusPokemon.GROUND);
		p6.setEvolucionatPokemon(true);
		PokemonDAO.getInstance().Insert(p6);
		
		Pokemon p7 = new Pokemon();
		p7.setNom("NIAAAAAAAAAAAAAAAAA");
		p7.setTipusPokemon(TipusPokemon.ICE);
		p7.setEvolucionatPokemon(false);
		PokemonDAO.getInstance().Insert(p7);
		
		Pokemon p8 = new Pokemon();
		p8.setNom("Mikacho");
		p8.setTipusPokemon(TipusPokemon.STEEL);
		p8.setEvolucionatPokemon(true);
		PokemonDAO.getInstance().Insert(p8);
		
		Pokemon p9 = new Pokemon();
		p9.setNom("Mokacho");
		p9.setTipusPokemon(TipusPokemon.ICE);
		p9.setEvolucionatPokemon(true);
		PokemonDAO.getInstance().Insert(p9);
		
		Pokemon p10 = new Pokemon();
		p10.setNom("Pokacho");
		p10.setTipusPokemon(TipusPokemon.ICE);
		p10.setEvolucionatPokemon(true);
		PokemonDAO.getInstance().Insert(p10);
	
		
		/**
		 * ARA TOTES LES RELACIONS
		 */
		
		p.setIdPokemonEvolucionat(p2);
		p2.setIdPokemonEvolucionat(p);
		p3.setIdPokemonEvolucionat(p4);
		p5.setIdPokemonEvolucionat(p6);
		PokemonDAO.getInstance().Update(p);
		PokemonDAO.getInstance().Update(p2);
		PokemonDAO.getInstance().Update(p3);
		PokemonDAO.getInstance().Update(p5);
		
		PokemonDAO.getInstance().SumaCandy(p);
		PokemonDAO.getInstance().SumaCandy(p2);
		PokemonDAO.getInstance().SumaCandy(p3);
		PokemonDAO.getInstance().SumaCandy(p4);
		PokemonDAO.getInstance().SumaCandy(p5);
		PokemonDAO.getInstance().SumaCandy(p6);
		PokemonDAO.getInstance().SumaCandy(p7);
		PokemonDAO.getInstance().SumaCandy(p8);
		PokemonDAO.getInstance().SumaCandy(p9);
		PokemonDAO.getInstance().SumaCandy(p10);
		
	}
}
