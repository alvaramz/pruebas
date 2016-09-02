
package utilitarios;

/**
 *
 * @author Ing. Adrián Alvarado Ramírez. 2016.
 */
public class Respuesta {

    private boolean resultado;
    private String mensaje;
    private String mensajeError;

    public Respuesta(){
        resultado = false;
        mensaje = null;
        mensajeError = null;
    }

    public Respuesta(boolean pResultado){
        resultado = pResultado;
    }

    public Respuesta(boolean pResultado, String pMensaje){
        resultado = pResultado;
        mensaje = pMensaje;
    }

    public Respuesta(boolean pResultado, String pMensaje, String pMensajeError){
        resultado = pResultado;
        mensaje = pMensaje;
        mensajeError = pMensajeError;
    }

    /**
     * @return the resultado
     */
    public boolean isResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the mensajeError
     */
    public String getMensajeError() {
        return mensajeError;
    }

    /**
     * @param mensajeError the mensajeError to set
     */
    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

}
