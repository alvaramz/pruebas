
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Desarrollado por el Ing. Adrián Alvarado Ramírez.
 *
 * Abre un socket para recibir un mensaje que se enviará por correo electrónico.
 */
public class CorreoServer {

    private static final int PUERTO = 8092;
    private static final int TIEMPO = 7000;

    /**
     * Método principal.
     *
     * @param args Parámetros de línea de comandos.
     */
    public static void main(String[] args) throws InterruptedException {
        ServerSocket servidor = null;

        try {
            servidor = new ServerSocket(PUERTO);
        } catch (IOException ioe) {
            System.out.println("Error al abrir el socket.");
            System.out.println(ioe.toString());
            System.exit(1);
        }

        while (true) {

            try {
               new EnviadorCorreoHilo(servidor.accept()).run();

            } catch (IOException ioe) {
                System.out.println("Error al leer el socket servidor");
                System.out.println(ioe.toString());
            }
            Thread.sleep(TIEMPO);
        }

    }

}
