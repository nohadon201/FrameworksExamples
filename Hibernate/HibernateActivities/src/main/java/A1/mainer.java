package A1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class mainer {
	static Departament departament;
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
			
			Departament departament = new Departament();
			departament.setNom("Departamento de Marqueting");
			departament.setNomCapDepartament("Alfonso");
			departament.setNumero_persones(69);
			departament.setTelefon("696969690");
			session.saveOrUpdate(departament);
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
