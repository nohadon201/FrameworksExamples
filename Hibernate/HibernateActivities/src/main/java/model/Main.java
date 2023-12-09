package model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

//aa
public class Main {

	static Almohada almohada;
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
		/// abrimos sesion. Eso se hace siempre
		try {

			session = getSessionFactory().openSession();

			// abrimos PRIMERA transaccion. Eso se hace siempre.
			session.beginTransaction();

			for (int i = 0; i < 7; i++) {
				Almohada a = new Almohada();
				a.setTipo("Dakimakura" + i);
				a.setDibujo("Bowser");
				a.setPrecio(100.0f);
				a.setRelleno(false);
				a.setTamano("XXXL");
				a.setSabor("Piña colada");
				a.setFechaAdquisicion(new Date());

				session.saveOrUpdate(a);
			}
			session.getTransaction().commit();
			
			session.beginTransaction();
			
			Persona kane = new Persona();
			kane.setNombre("Kane");
			kane.setAltura(1.80f);
			kane.setEdad(23);
			kane.setAlmohadas(new HashSet<Almohada>());
			session.saveOrUpdate(kane);
			

			
			Almohada almohada1 = session.get(Almohada.class, 1);
			almohada1.setDibujo("Rimuru la babosa");
			System.out.println(almohada1.getTipo());
			
			kane.getAlmohadas().add(almohada1);
			almohada1.setPropietario(kane);
			session.saveOrUpdate(almohada1);

			session.getTransaction().commit();
			
			session.getTransaction().begin();
			
			Almohada rimuru = session.get(Almohada.class, 1);
			System.out.println(rimuru.getPropietario().getEdad());
			
			session.getTransaction().commit();
			
			session.getTransaction().begin();
			
			//createquery, pots posar la query que vulguis
			List<Almohada> todasLasAlmohadas = session.createQuery("FROM Almohada").list();
			for (Almohada almohada : todasLasAlmohadas) {
				if(almohada.getDibujo().toLowerCase().contains("babosa")) {
					System.out.println("el propietario de rimuru la babosa es"+almohada.getPropietario().getNombre());
					almohada.getPropietario().setNombre(almohada.getPropietario().getNombre()+" el amante de las babosas");
					
					session.saveOrUpdate(almohada);
				}
			}
			
			
			
			
			session.getTransaction().commit();
			
			
			session.getTransaction().begin();
			Color c = new Color();
			c.setNombre("rojo");
			c.setR(255);
			c.setG(0);
			c.setB(0);
			c.setAlmohadas(new HashSet<Almohada>());
			Almohada otra = session.get(Almohada.class, 2);
			c.getAlmohadas().add(otra);
			otra.getColores().add(c);
			
			session.saveOrUpdate(c);
			session.saveOrUpdate(otra);
			session.getTransaction().commit();


			
			System.out.println("todo ha salido a pedir de Milhouse");
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
