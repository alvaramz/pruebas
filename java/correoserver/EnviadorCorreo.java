

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * Desarrollado por Ing. Adrián Alvarado Ramírez.
 *
 * Clase que provee la funcionalidad para el envío de correo electrónico.
 */
public class EnviadorCorreo {

    /**
     * Se utiliza para almacenar un mensaje generado durante el envío del
     * correo. Este atributo es de solo lectura.
     */
    private String mensaje;
    private String mensajeError;

    private String host;
    private String usuario;
    private String password;

    private int puerto;
    private boolean isGmail;

    public EnviadorCorreo(boolean usarSMTPGmail) {
        init(usarSMTPGmail);
    }

    /**
     *
     * Inicialización por defecto del módulo de correo. Se utilizan los datos de
     * la cuenta de notificaciones.fe
     *
     */
    private void init(boolean usarSMTPGmail) {
        if (usarSMTPGmail) {
            host = "smtp.googlemail.com";
            usuario = "<usuario de smtp>";
            password = "<la contraseña>";
            puerto = 465;
            isGmail = true;
        } else {
            host = "<otro host smtp>";
            usuario = "<el usuario>";
            password = "<la contraseña>";
            puerto = 25;
            isGmail = false;
        }
    }

    /**
     * Envía un correo electrónico. Utiliza el API JavaMail, disponible en:
     * <a href="https://java.net/projects/javamail/pages/Home">https://java.net/projects/javamail/pages/Home</a>
     *
     * Se puede enviar un correo utilizando el servidor de Gmail, u otro.
     *
     * @param destinatario
     * @param asunto
     * @param mensaje
     * @return
     */
    public boolean enviarCorreoE(String destinatario, String asunto, String mensaje) {
        boolean resultado = false;

        HtmlEmail email = new HtmlEmail();
        email.setHostName(host);
        email.setSmtpPort(puerto);
        email.setAuthenticator(new DefaultAuthenticator(usuario, password));

        if(isGmail){
            email.setSSLOnConnect(true);
        }else{
            email.setStartTLSEnabled(true);
        }

        try {
            email.setFrom(usuario + "@<dominio>");
            email.setSubject(asunto);
            email.setHtmlMsg(mensaje);
            email.addTo(destinatario);
            email.send();
            resultado = true;
        } catch (EmailException eme) {
            mensaje = "Ocurrió un error al hacer el envío de correo.";
            mensajeError = eme.toString();
        }

        return resultado;
    }

    public boolean testEnvioCorreo() {
        String mensajePrueba = null;

        if(isGmail){
            mensajePrueba = "<p>Esto es una prueba usando el SMTP de Gmail.</p>";
        }else{
            mensajePrueba = "<p>Esto es una prueba usando otro SMTP</p>";
        }

        String destinatarioPrueba = "<correo destinatario prueba>";

        return enviarCorreoE(destinatarioPrueba, "Asunto de prueba", mensajePrueba);
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the mensajeError
     */
    public String getMensajeError() {
        return mensajeError;
    }

}
