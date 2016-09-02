/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import java.io.IOException;
import javax.faces.context.FacesContext;
import java.util.logging.Level;
import javax.faces.application.FacesMessage;

/**
 *
 * @author Ing. Adrián Alvarado Ramírez. 2016.
 */
public class FacesUtil {

    public static boolean cargarPagina(String pagina) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().dispatch(pagina);
            return true;
        } catch (IOException ioe) {
            LogUtil.log(Level.SEVERE, formatearMensajeErrorCargarPagina(pagina, ioe));
        }
        return false;
    }

    public static boolean redireccionarPagina(String pagina) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
            return true;
        } catch (IOException ioe) {
            LogUtil.log(Level.SEVERE, formatearMensajeErrorCargarPagina(pagina, ioe));
        }
        return false;
    }

    public static void cerrarSesion() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }

    public static void agregarMensaje(FacesMessage.Severity nivel, String mensaje) {
        FacesMessage message = new FacesMessage(nivel, mensaje, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public static void agregarMensajeError(String mensaje) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    private static String formatearMensajeErrorCargarPagina(String nombrePagina, String mensaje) {
        return String.format("Ha ocurrido un error al cargar la página %s, detalle:\n%s", nombrePagina, mensaje);
    }

    private static String formatearMensajeErrorCargarPagina(String nombrePagina, Exception e) {
        return String.format("Ha ocurrido un error al cargar la página %s, detalle:\n%s", nombrePagina, e.toString());
    }

}
