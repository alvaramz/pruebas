
package utilitarios;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ing. Adrián Alvarado Ramírez. 2016.
 */
public class SesionUtil {

    public static Object cargarObjeto(String name){
        HttpSession sess = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return sess.getAttribute(name);
    }

    public static void guardarObjeto(Object obj, String name){
        HttpSession sess = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        sess.setAttribute(name, obj);
    }

    public static void eliminarObjeto(String name){
       HttpSession sess = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
       sess.removeAttribute(name);
    }
}
