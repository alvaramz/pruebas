package entidades;

/**
 * Esta es la parte de la entidad donde se ejemplifican dos maneras
 * de almacenar una imagen en base de datos:
 * 1) como un arreglo de bytes[]
 * 2) como una String.
 * En el priemer caso, el campo de la base de datos (MySQL) es un longblob.
 * Para este primer caso, es necesario almacenar por aparte el formato, para
 * el momento de enviar la imágen en el request.
 * En el segundo caso, el campo de la base de datos es un longtext, codificada
 * en base64. Acá no es necesario almacenar el formato por aparte, pues va
 * dentro de la misma codificación.
 *
 * @author Ing. Adrián Alvarado Ramírez.
 */
public class PmCurso  implements java.io.Serializable {



     private String imagen;
     private byte[] poster;
     private String formatoPoster;

}
