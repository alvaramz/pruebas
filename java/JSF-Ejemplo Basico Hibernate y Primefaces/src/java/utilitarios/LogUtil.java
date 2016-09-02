/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author Ing. Adrián Alvarado Ramírez. 2016.
 */
public class LogUtil {

    private final static String NOMBRE_LOG = "bitacora_principal";
    private final static Logger logger = Logger.getLogger(NOMBRE_LOG);


    public static void log(Level nivel,String mensaje){
        logger.log(nivel, mensaje);
    }

}
