package pruebadraggable;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JTextField;

/**
 *
 * @author Ing. Adrián Alvarado Ramírez.
 */
public class TextoDraggable extends JTextField {

    // Este se mantiene sin cambios.
    private int xOriginal;
    // Este es el y en que se encuentra en un momento dado;
    private int y;
    // Permite guardar la posición y del click del ratón con respecto a la pantalla, y sirve como referencia para el movimiento.
    private int yRaton;

    public TextoDraggable() {
        inicializarEventos();
        actualizarPosicion();
    }

    public TextoDraggable(String texto) {
        this();
        setText(texto);
    }

    private void actualizarPosicion() {
        xOriginal = getX();
        y = getY(); // Se inicia el y con la posición actual.
    }

    private void inicializarEventos() {
        addMouseListener(new ManejadorRaton());
        addMouseMotionListener(new MovimientoRaton());
    }

    private class ManejadorRaton implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {
           
        }

    }

    private class MovimientoRaton implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            int cambioY = y + e.getY();
            
            // Hay que reajustar y eliminar la pos del control.
            cambioY -= yRaton;
            setText("y del componente =>" + y + "Y del ratón => "+ e.getY() + " y del ratón on screen => " + e.getYOnScreen());

            setLocation(xOriginal, cambioY);           
            actualizarPosicion();
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

}
