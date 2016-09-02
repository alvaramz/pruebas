
import accesobd.AccesoSistemas;
import entidades.AdmSistema;
import java.util.List;

/**
 * Clase donde se prueba el listado de datos de la base de datos.
 * @author Adrián Alvarado Ramírez.
 */
public class TestAccesoDatos {

    public static void main(String args[]) {
        probarObtenerSistemas();
    }

    private static void probarObtenerSistemas() {
        System.out.println("------------ Probando obtener sistemas --------------------------------");
        AccesoSistemas accesoSistemas = new AccesoSistemas();
        List<AdmSistema> sistemas = accesoSistemas.obtenerSistemas();

        for (AdmSistema sistema : sistemas) {
            System.out.printf("Sistema: %s, descripción:%s\n",sistema.getNombre(), sistema.getDescripcion());
        }
        System.out.println("----------------- Fin obtener sistemas --------------------------------");
    }

}
