package A3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class mainer {

	public static void main(String[] args) {
		

		Tenda t = new Tenda(0, "alñdksfjañdskfljasñdflksja", false);
		Adreça add = new Adreça("IIIIIIIIIIIIIIII", 70, "AAAA", "EYYY", "Comunitat Autonoma", "Provincia");
		Marca marca = new Marca(69, "RapSADFASDFSer", 1988);
		Marca marca2 = new Marca(69, "AAAAAAAAAAAAAA", 1800);
		Component component1 = new Component(69, "aaaaaaIIIIIIIIIIIIIaaaaaaaa ª", "PuASDLKFJASÑDFLKJSAFñsdkfljañsdkflja, sí", 9);
		Component component2 = new Component(69, "ÑLAKDSJFÑAKDSFmponent ª 2",
				"Pues es un componente que ASDFASDFAañsdkfljañsdkflja x2, sí x2", 6);
		
		AdreçaDAO.getInstance().Insert(add);
		TendaDAO.getInstance().Insert(t);
		MarcaDAO.getInstance().Insert(marca);
		MarcaDAO.getInstance().Insert(marca2);
		ComponentDAO.getInstance().Insert(component1);
		ComponentDAO.getInstance().Insert(component2);
		
		
		t.setAdreça(add);
		add.setT(t);
		marca.setTenda(t);
		marca2.setTenda(t);
		t.getMarques().add(marca);
		t.getMarques().add(marca2);
		component1.setTenda(t);
		component2.setTenda(t);
		t.getComponents().add(component1);
		t.getComponents().add(component2);
		component1.getMarques().add(marca);
		component1.getMarques().add(marca2);
		component2.getMarques().add(marca);
		
		AdreçaDAO.getInstance().Update(add);
		//TendaDAO.getInstance().Update(t);
		MarcaDAO.getInstance().Update(marca);
		MarcaDAO.getInstance().Update(marca2);
		//ComponentDAO.getInstance().Update(component1);
		//ComponentDAO.getInstance().Update(component2);
		
		
	}
}
