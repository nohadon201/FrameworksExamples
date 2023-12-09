package ambDAO;

import model.Color;
import model.Propietat;

public class ColorDao extends GenericDao<Color, Integer> implements IColorDao{

	@Override
	public boolean ComprovarColor(Propietat p) {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
//	public boolean ComprovarColor(Propietat p) {
//		Color c = p.getColor();
//		Jugador j = p.getPropietari();
//		boolean flag = true;
//		for (Propietat p : c.getPropietats()) {
//			if(!p.getPropietari().equals(j)) {
//				flag=false;
//			}
//		}
//		return flag;
//	}
	
}
