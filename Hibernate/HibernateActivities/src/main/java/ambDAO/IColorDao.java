package ambDAO;

import model.Color;
import model.Propietat;

public interface IColorDao extends IGenericDao<Color, Integer> {
	
	boolean ComprovarColor(Propietat p);

}
