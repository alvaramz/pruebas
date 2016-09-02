/*
 * Proporciona métodos para el tratamiento de datos numéricos.
 */
package utilitarios;

/**
 * Proporciona métodos para el tratamiento de números.
 * @author Ing. Adrián Alvarado Ramírez. 2016.
 */
public class NumericoUtil {

    public static boolean isNumero(String valor){
        if(valor != null){

            try{
                Integer.parseInt(valor);
                return true;
            }catch(Exception e){
                return false;
            }

        }

        return false;
    }

}
