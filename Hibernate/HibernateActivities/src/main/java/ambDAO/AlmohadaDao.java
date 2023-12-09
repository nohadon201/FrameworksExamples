package ambDAO;

import model.Almohada;

public class AlmohadaDao extends GenericDao<Almohada, Integer> implements IAlmohadaDao{

	@Override
	public String getSaborFromID(Integer id) {
		return this.get(id).getSabor();
	}

	@Override
	public void subemeElPrecioUnDiezPorciento(Integer id) {
		Almohada a = this.get(id);
		a.setPrecio(a.getPrecio()*1.1f);
		this.saveOrUpdate(a);
	}
	
	
	
	

}
