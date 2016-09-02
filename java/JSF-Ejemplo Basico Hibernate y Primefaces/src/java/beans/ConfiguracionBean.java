/*
 * Backing Bean para la página /mantenimiento/configuracion.xhtml.
 */
package beans;

import accesobd.AccesoSistemas;
import entidades.AdmSistema;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import utilitarios.FacesUtil;
import utilitarios.NumericoUtil;

/**
 *
 * Contiene los atributos y métodos para la página
 * /mantenimiento/configuracion.xhtml. Esta página provee la funcionalidad para
 * configurar un sistema.
 *
 * @author Ing. Adrián Alvarado Ramírez. 2016
 */
@ManagedBean
public class ConfiguracionBean {

    private AccesoSistemas accesoSistemas;

    /**
     * Identificador del sistema. Este dato se toma del parámetro enviado por la
     * URL.
     */
    private int idSistema;

    /**
     * Entidad correspondiente al sistema que se está dando mantenimiento.
     */
    private AdmSistema sistema;

    /**
     * Constructor del objeto de tipo ConfiguracionBean.
     */
    public ConfiguracionBean() {
        String idSistemaS = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("sis");

        if (idSistemaS != null && NumericoUtil.isNumero(idSistemaS)) {

            idSistema = Integer.parseInt(idSistemaS);

            accesoSistemas = new AccesoSistemas();
            sistema = accesoSistemas.obtenerSistema(idSistema);
        } else {
            FacesUtil.redireccionarPagina("../login.xhtml");
        }

    }

    /**
     * Almacena la configuración del sistema. Para eso, ejecuta la funcionalidad
     * de la capa de acceso a datos.
     */
    public void almacenar() {

    }

    /**
     * Identificador del sistema.
     *
     * @return the idSistema
     */
    public int getIdSistema() {
        return idSistema;
    }

    /**
     * Establece el identificador del sistema.
     *
     * @param idSistema the idSistema to set
     */
    public void setIdSistema(int idSistema) {
        this.idSistema = idSistema;
    }

    /**
     * @return the sistema
     */
    public AdmSistema getSistema() {
        return sistema;
    }

    /**
     * @param sistema the sistema to set
     */
    public void setSistema(AdmSistema sistema) {
        this.sistema = sistema;
    }

}
