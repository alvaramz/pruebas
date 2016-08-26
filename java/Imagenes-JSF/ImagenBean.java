
package beans;

import entidades.PmCurso;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.imageio.ImageIO;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 * Bean para hacer el response la imágen. Este bean debe ser RequestScoped, de lo contrario,
 * falla.
 * @author Ing. Adrián Alvarado Ramírez.
 */
@ManagedBean
public class ImagenBean {

      public StreamedContent getPostr(PmCurso curso) throws IOException {
        if (curso != null && curso.getPoster() != null) {
            FacesContext context = FacesContext.getCurrentInstance();

            if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
                // Se está renderizando la vista, aún el navegador no pide la imagen.
                return new DefaultStreamedContent();
            } else {
                // El navegador está pidiendo la imagen
                return new DefaultStreamedContent(new ByteArrayInputStream(curso.getPoster()), "image/" + curso.getFormatoPoster());
            }
        } else {
            // Se dibuja una imágen, con el mensaje "No hay imagen del curso"
            BufferedImage bufferedImg = new BufferedImage(300, 200, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufferedImg.createGraphics();
            g.setPaint(new Color(250,250,250));
            g.fillRect(0, 0, bufferedImg.getWidth(), bufferedImg.getHeight());
            g.setColor(Color.BLACK);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g.setFont(new Font("Arial", Font.PLAIN, 24));
            g.drawString("No hay imagen del curso", 10, 100);
            g.setFont(new Font("Arial", Font.PLAIN, 10));
            g.drawString("Ingrese una imagen en el panel de administración", 10, 150);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(bufferedImg, "png", os);
            return new DefaultStreamedContent(new ByteArrayInputStream(os.toByteArray()), "image/png");
        }
    }

}
