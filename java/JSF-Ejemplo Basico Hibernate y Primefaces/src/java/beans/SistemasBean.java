/*
 * Backing bean para la página sistemas.xhtml.
 */
package beans;

import accesobd.AccesoSistemas;
import entidades.AdmSistema;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 * Esta clase proporciona un Backing Bean para la página web sistemas.xhtml.
 * Tiene como funcionalidad principal solictiar a la clase correspondiente de acceso
 * a datos la lista de sistemas.
 * @author Ing. Adrián Alvarado Ramírez <adrian.alvarado_r@ucr.ac.cr>. 2016.
 */
@ManagedBean
public class SistemasBean {

    private List<AdmSistema> listaSistemas;

    public SistemasBean(){
        listaSistemas = new AccesoSistemas().obtenerSistemas();
    }

    /**
     * @return the listaSistemas
     */
    public List<AdmSistema> getListaSistemas() {
        return listaSistemas;
    }

    /**
     * @param listaSistemas the listaSistemas to set
     */
    public void setListaSistemas(List<AdmSistema> listaSistemas) {
        this.listaSistemas = listaSistemas;
    }

}
