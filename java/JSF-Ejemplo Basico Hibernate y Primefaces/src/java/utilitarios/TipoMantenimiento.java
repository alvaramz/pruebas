
package utilitarios;

/**
 *
 * @author Ing. Adrián Alvarado Ramírez. 2016.
 */
public enum TipoMantenimiento {
    AGREGAR (1),
    MODIFICAR (2),
    ELIMINAR(3);

    private final int tipo;

    TipoMantenimiento(int pTipo){
        tipo = pTipo;
    }

    public int getTipo(){
        return tipo;
    }

}
