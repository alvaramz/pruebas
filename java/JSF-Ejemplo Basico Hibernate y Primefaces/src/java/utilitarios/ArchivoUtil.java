
package utilitarios;

import java.util.ArrayList;

/**
 * Provee funcionalidad para el tratamiento de archivos.
 * @author Ing. Adrián Alvarado Ramírez. 2016.
 */
public class ArchivoUtil {

    public final static ArrayList<String> TIPOS_IMAGEN = new ArrayList();;
    static{
        TIPOS_IMAGEN.add("gif");
        TIPOS_IMAGEN.add("tif");
        TIPOS_IMAGEN.add("tiff");
        TIPOS_IMAGEN.add("png");
        TIPOS_IMAGEN.add("jpg");
        TIPOS_IMAGEN.add("jpeg");
    }

    /**
     * Retorna la extensión de un archivo. Para ello, busca la posición del último
     * punto y obtiene la sub-hilera correspondiente a partir la siguiente posición del punto y
     * hasta el final del nombre.
     * @param nombreArchivo
     * @return
     */
    public static String obtenerExtensionArchivo(String nombreArchivo){
        int posUltimoPunto = nombreArchivo.lastIndexOf(".");
        String extension = nombreArchivo.substring(posUltimoPunto + 1, nombreArchivo.length());
        return extension;
    }

    /**
     * Genera una String que contiene todos los tipos de imágen definidos en el ArrayList TIPOS_IMAGEN
     * @return String con los tipos de imágen.
     */
    public static String imprimirTiposImagen(){
        StringBuilder tipos = new StringBuilder();
        for(String tipo : TIPOS_IMAGEN){
            tipos.append(tipo);
            tipos.append(" ");
        }
        return tipos.toString();
    }

}
