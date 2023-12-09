package ambDAO;

import model.Almohada;

public interface IAlmohadaDao  {
	
	String getSaborFromID(Integer id);
	
	void subemeElPrecioUnDiezPorciento(Integer id);

}
