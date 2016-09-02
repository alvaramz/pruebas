package accesobd;

import db.HibernateUtil;
import entidades.AdmSistema;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utilitarios.Respuesta;

/**
 * Funciones de acceso a los datos de los sistemas(aplicaciones).
 *
 * @author Ing. Adrián Alvarado Ramírez. 2016.
 */
public class AccesoSistemas {

    public List<AdmSistema> obtenerSistemas() {
        List<AdmSistema> listaSistemas = null;
        Session sesion;
        sesion = HibernateUtil.getSessionFactory().openSession();

        try {

            Query q = sesion.createQuery("from AdmSistema");

            listaSistemas = (List<AdmSistema>) q.list();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        sesion.close();

        return listaSistemas;
    }

    public AdmSistema obtenerSistema(int id) {
        AdmSistema sistema = null;
        Session sesion;
        sesion = HibernateUtil.getSessionFactory().openSession();

        try {

            Query q = sesion.createQuery("from AdmSistema where ID=:id");
            q.setParameter("id", id);

            sistema = (AdmSistema) q.uniqueResult();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        sesion.close();
        return sistema;
    }

    public Respuesta actualizarSistema(AdmSistema sistema) {
        return null;
    }

}
