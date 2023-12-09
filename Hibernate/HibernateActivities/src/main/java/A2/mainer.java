package A2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class mainer {
	static Session session;
	static SessionFactory sessionFactory;
	static ServiceRegistry serviceRegistry;

	public static synchronized SessionFactory getSessionFactory() {
		if (sessionFactory == null) {

			// exception handling omitted for brevityaa

			serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

			sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		}
		return sessionFactory;
	}

	public static void main(String[] args) {
		try {
			session = getSessionFactory().openSession();
			session.beginTransaction();
			
			Tenda t = new Tenda(0, "PcCOmponentes", true);
			Adreça add = new Adreça("Coruña", 69, "AAAA", "EYYY", "Comunitat Autonoma", "Provincia");
			Marca marca = new Marca(69, "Raper",1969);
			Marca marca2 = new Marca(69, "Marca Lbareda",1900);
			Component component1 = new Component(69, "COmponent ª", "Pues es un componente que añsdkfljañsdkflja, sí", 69);
			Component component2 = new Component(69, "COmponent ª 2", "Pues es un componente que añsdkfljañsdkflja x2, sí x2", 69);
			
			session.saveOrUpdate(t);
			session.saveOrUpdate(add);
			session.saveOrUpdate(marca);
			session.saveOrUpdate(marca2);
			session.saveOrUpdate(component1);
			session.saveOrUpdate(component2);
			
			session.getTransaction().commit();
			session.beginTransaction();
			
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
			session.saveOrUpdate(t);
			session.saveOrUpdate(add);
			session.saveOrUpdate(marca);
			session.saveOrUpdate(marca2);
			session.saveOrUpdate(component1);
			session.saveOrUpdate(component2);
			
			session.getTransaction().commit();
			
			
			
		} catch (Exception sqlException) {
			sqlException.printStackTrace();
			if (null != session.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
