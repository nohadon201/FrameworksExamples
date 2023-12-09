package model;

import java.util.Date;

import ambDAO.AlmohadaDao;

public class MainDAO {
	
	public static void main(String[] args) {
		
		
		AlmohadaDao ad = new AlmohadaDao();
		
		Almohada a = new Almohada("XL", "Dakimakura", "Bowser", true, "Blanco", 100, "uf", new Date());
		ad.saveOrUpdate(a);
		System.out.println(ad.get(1));
		System.out.println(ad.getSaborFromID(1));
		ad.subemeElPrecioUnDiezPorciento(1);
		System.out.println(ad.get(1));

		
		
		
	}

}
