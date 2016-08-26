package beans;


import entidades.PmCurso;
import java.io.Serializable;
import java.util.Base64;
import org.primefaces.model.UploadedFile;


/**
 * Backing Bean para la el mantenimiento de un curso. En este caso, se muestra
 * únicamente la funcionalidad para cargar una imágen binaria y una imágen
 * codificada en base64. Se omite el resto de la funcionalidad.
 *
 * @author Ing. Adrián Alvarado Ramírez.
 * UCR.
 */
@ManagedBean
public class ConfigurarCursoBean implements Serializable {

    private PmCurso curso;


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
     * En el caso de Mysql 5.7 en ubuntu 16.04, esta directiva está en el archivo
     * /etc/mysql/mysql.conf.d/mysqld.cnf, pero ya está configurada en 16M
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

               // Se obtiene la extensión (sin el punto) y se guarda en una variable denominada extension.

               //AccesoCurso accesoCurso = new AccesoCurso();
               curso.setImagen("data:image/" + extension + ";base64," + Base64.getEncoder().encodeToString(imagenArchivo.getContents()));

        }
    }


}
