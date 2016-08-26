package beans;

import accesobd.AccesoCurso;
import accesobd.AccesoModalidad;
import accesobd.AccesoMoneda;
import converters.AdmMonedaConverter;
import converters.PmModalidadConverter;
import entidades.AdmMoneda;
import entidades.PmCurso;
import entidades.PmModalidad;
import java.io.Serializable;
import java.util.Base64;
import java.util.Collections;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.UploadedFile;
import utilitarios.ArchivoUtil;
import utilitarios.FacesUtil;
import utilitarios.Respuesta;
import utilitarios.SesionUtil;
import utilitarios.TipoMantenimiento;
import java.util.List;

/**
 * Backing Bean para la el mantenimiento de un curso. En este caso, se muestra
 * únicamente la funcionalidad para cargar una imágen binaria y una imágen
 * codificada en base64. Se omite el resto de la funcionalidad.
 *
 * @author Unidad de Tecnologías de Información, Decanato Facultad de Educación.
 * UCR.
 */
@ManagedBean
public class ConfigurarCursoBean implements Serializable {

    private PmCurso curso;
    private TipoMantenimiento tipo;
    private String etiquetaMantenimiento;
    private UploadedFile posterArchivo;
    private UploadedFile imagenArchivo;
    private List<PmModalidad> listaModalidades;
    private List<AdmMoneda> listaMonedas;
    private boolean renderizarCamposSeleccione;

    private AccesoModalidad accesoModalidad;

    public ConfigurarCursoBean() {



    /**
     * Carga el archivo correspondiente al poster, y lo almacena en el objeto curso.
     * Para permitir archivos grandes, es posible que se deba configurar
     * la base de datos para que soporte paquetes de comunicación grandes. En el
     * caso de MySQL, es necesario configurar el archivo my.ini (Windows) o
     * /etc/mysql/my.cnf en el caso de sistemas linux, con una línea como la
     * siguiente:
     *
     * max_allowed_packet = 10M
     *
     * Si el archivo my.ini (Windows) no existe y se utilizó el intalador MSI,
     * es probable que este archivo esté en la carpeta:
     * %PROGRAMDATA%\MySQL\MySQL Server X.Y.
     *
     * Recuerde reiniciar el servidor después de modificar el archivo de
     * configuración.
     */
    public void cargarPosterArchivo() {
        if (posterArchivo != null && !posterArchivo.getFileName().equals("")) {


                // El objeto de Primefaces, UploadedFile, tiene la función que
                // retorna el contenido del archivo en un arreglo de bytes.
                curso.setPoster(posterArchivo.getContents());
                curso.setFormatoPoster(extension);


        }
    }

    /**
     * Guarda la imágen pequeña del curso en el objeto correspondiente. Esta imagen es
     * una string, y corresponde a una codificación en base64 del contenido.
     */
    public void cargarImagenArchivo() {

               // Se obtiene la extensión (sin el punto) y se guarda en una variable denominada etension.

               //AccesoCurso accesoCurso = new AccesoCurso();
               curso.setImagen("data:image/" + extension + ";base64," + Base64.getEncoder().encodeToString(imagenArchivo.getContents()));

        }
    }


}
