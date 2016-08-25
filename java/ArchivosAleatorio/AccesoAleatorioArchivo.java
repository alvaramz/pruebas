/**
* AccesoAleatorio.java.
*
* Contiene un ejemplo de acceso no-secuencial, también llamado acceso aleatorio a un archivo de texto.
* Hace una comparación de la lectura de un archivo UTF-8, y una manera de reslver el problema de la
* codificacion de UTF-8 que puede usar 1, 2 o más bytes por caracter según el rango.
*
* Elaborado por Adrián Alvarado Ramírez
*
*/

import java.io.RandomAccessFile;
import java.io.File;

import java.lang.IllegalArgumentException;
import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.io.EOFException;
import java.io.IOException;

public class AccesoAleatorioArchivo{

    public static void main(String args[]){
        String nombreArchivo = "prueba.txt";
        File archivo = new File("prueba.txt");

        // Se pregunta si el archivo existe.
        if(archivo.exists()){

            try{
              // Crea el objeto de tipo RandomAccessFile que abre el archivo,
              // en este caso en modo de lectura y escritura.
              // Esta clase brinda acceso a bajo y mediano nivel, en el sentido de que
              // se puede trabajar a nivel de bytes, pero también tiene funciones para trabajar
              // a tipos de datos primitivos e incluso a nivel de String.
              RandomAccessFile raf = new RandomAccessFile(archivo, "rw");

              // En este caso se prueba con un archivo codificado en UTF-8 que tiene las siguientes 4 líneas:
              // Sí, esto
              // es álgo
              // único
              // prueba

              // Se muestran las primeras cuatro letras y el cambio de línea, se leen en byte
              for(int i = 0; i < 5; i++){
                int letra = raf.read();
                System.out.printf("Byte[%d] => %d\n",i,letra);
              }

              System.out.println("\n==============================================");
              // Se muestran las primeras cuatro letras y el cambio de línea, se muestran como si fueran chars:
              // Se vuelve a la posición 0.
              raf.seek(0);
              for(int i = 0; i < 5; i++){
                int letra = raf.read();
                System.out.printf("Letra[%d] => %c\n",i,letra);
              }

              // Observese la salida de este programa:
              // Esta ilustra el tema de la codificación de archivos,
              // por si tienes que lidiar con eso. Resulta que el caracter 'í'
              // ocupa 2 bytes, por eso sale abajo un caracter errado y un espacio vacío.
              // Si vas a trabajar con caracteres, tienes que crear un archivo usando
              // la funcionalidad writeChar, que introduce caracteres en dos bytes.
              // Byte[0] => 83
              // Byte[1] => 195
              // Byte[2] => 173
              // Byte[3] => 44
              // Byte[4] => 32
              //
              // ==============================================
              // Letra[0] => S
              // Letra[1] => Ã
              // Letra[2] => ­
              // Letra[3] => ,
              // Letra[4] =>
              raf.close(); // Se cierra el archivo.
              System.out.println("\n====================Con el otro archivo=========================");
              // Escribiendo un archivo para luego leerlo.
              String nombreArchivo2 = "prueba2.txt";
              File archivo2 = new File(nombreArchivo2);
              RandomAccessFile raf2 = new RandomAccessFile(archivo2,"rw"); // Modo de lectura y escritura (No hay modo de solo escritura)
              String hileraAEscribir = "Sí, esto\nes álgo\núnico\nprueba";
              for(char caracter : hileraAEscribir.toCharArray()){
                raf2.writeChar(caracter);
              }

              raf2.close();

              // Ahora se lee este nuevo archivo, reutilizo la variable raf.
              raf = new RandomAccessFile(nombreArchivo2, "r"); // Modo de solo lectura.
              // Se muestran las primeras cuatro letras y el cambio de línea, se muestran como si fueran chars:
              for(int i = 0; i < 5; i++){
                char letra = raf.readChar();
                System.out.printf("Letra[%d] => %c\n",i,letra);
              }
              // Ahora sí, en la salida se muestra la lectura de 5 caracteres (incluyendo el espacio en blanco)
              // Letra[0] => S
              // Letra[1] => í
              // Letra[2] => ,
              // Letra[3] =>
              // Letra[4] => e
              System.out.println("\n==============================================");
              // Ahora, si se quere leer, por ejemplo, la última línea, se puede mover con el seek a
              // esa posición, pero observe que cada caracter son dos bytes, por lo que la posición
              // de la letra 'p' es 46
              raf.seek(46);
              for(int i = 0; i < 5; i++){
                char letra = raf.readChar();
                System.out.printf("Letra[%d] => %c\n",i,letra);
              }

              // La salida en este caso es:
              // Letra[0] => p
              // Letra[1] => r
              // Letra[2] => u
              // Letra[3] => e
              // Letra[4] => b

              raf.close(); // Se cierra el archivo.


            }catch(IllegalArgumentException iae){
              System.out.println("Error al intentar abrir el archivo, no tiene permisos de lectura o escritura");
              System.out.println(iae.toString());
            }catch(FileNotFoundException fne){
              System.out.println("No existe el archivo");
              System.out.println(fne.toString());
            }catch(SecurityException se){
              System.out.println("Se ha denegado el acceso de lectura por permisos");
              System.out.println(se.toString());
            }catch(EOFException eof){
              System.out.println("Se alcanzó el fin del archivo leyendo");
              System.out.println(eof.toString());
            }catch(IOException ioe){
              System.out.println("Error de entrada/salida. Este error se prenta en los métodos read y write");
              System.out.println(ioe.toString());
            }
        }else{
            System.out.printf("No se ha podido cargar el archivo \"%s\"\n", nombreArchivo);
        }
    }

}
