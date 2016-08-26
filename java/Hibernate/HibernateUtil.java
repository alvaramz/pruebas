package db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/*
     Machote de HibernateUtil probada en la versión 5.2.2 de Hibernate.
     Este código está basado en códigos de foros (particulamente stackoverflow)
     Se omite el loggeo del error en caso de darse una excepción al crear el
     objeto de tipo SessionFactory.

*/
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            // Por definición se configura el archivo hibernate.cfg.xml
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            try {
                sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            } catch (Exception e) {
                // Se destruye el objeto de tipo StandardServiceRegistry. El responsable
                // de destruir este objeto, en el flujo normal es el objeto de tipo
                // SessionFactory, pero como falló su creación, debe destruirse manualmente.
                StandardServiceRegistryBuilder.destroy(registry);
            }
        }

        return sessionFactory;

    }
}
