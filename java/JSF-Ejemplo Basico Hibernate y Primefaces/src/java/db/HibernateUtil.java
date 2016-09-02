package db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.jboss.logging.Logger;

/**
 * En Glassfish 4.1, es necesario sustuir la biblioteca  jboss-logging.jar por la que
 * viene en Hibernate, pues la que está por defecto en los módulos no es compatible (no 
 * contiene la función debugf), por lo que falla al crear el SessionFactory.
 * 
 * sudo cp <rutalibs>/hibernate-release-5.2.2.Final/lib/required/jboss-logging-3.3.0.Final.jar <ruta glassfish>/modules/
*/
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            // A SessionFactory is set up once for an application!
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() // configures settings from hibernate.cfg.xml
                    .build();
            try {
                sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            } catch (Exception e) {
                // Se destruye el registro, pues debe eliminarse por el SessionFactory, pero que en este
                // caso no se creó.
                StandardServiceRegistryBuilder.destroy(registry);
                //System.out.println(e.toString());
                Logger.getLogger(HibernateUtil.class).log(Logger.Level.FATAL, e);
            }
        }

        return sessionFactory;

    }
}
