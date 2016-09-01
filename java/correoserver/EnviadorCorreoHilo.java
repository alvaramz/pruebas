
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Desarrollado por Ing. Adrián Alvarado Ramírez.
 *
 * Procesa la conexión al socket, creando un hilero para liberar el proceso principal
 * para que pueda continuar recibiendo solicitudes.
 */
public class EnviadorCorreoHilo implements Runnable {

    private Socket cliente;

    public EnviadorCorreoHilo(Socket pCliente) {
        cliente = pCliente;
    }

    @Override
    public void run() {
        BufferedReader in = null;

        try {
            System.out.println("Iniciando envío de correo");
            in = new BufferedReader(
                    new InputStreamReader(cliente.getInputStream()));
            String destinatario = in.readLine();
            String asunto = in.readLine();
            String mensaje = in.readLine();

            System.out.println("Datos a enviar\n Destinatario:" + destinatario + "\nAsunto: " + asunto + "\nMensaje: " + mensaje);

            EnviadorCorreo enviador = new EnviadorCorreo(false);
            enviador.enviarCorreoE(destinatario, asunto, mensaje);
            PrintWriter out
                    = new PrintWriter(cliente.getOutputStream(), true);
            out.println("Correo enviado");


        } catch (IOException ioe) {
            System.out.println("Error leyendo el socket");
            System.out.println(ioe.toString());
        }
    }

}
