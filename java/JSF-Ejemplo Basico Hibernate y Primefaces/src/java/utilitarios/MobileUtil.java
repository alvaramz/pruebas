package utilitarios;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ing. Adrián Alvarado Ramírez. 2016.
 */
public class MobileUtil {

    private static final String claves[] = {"android", "iphone", "mobile"};

    public static boolean isMobile() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String userAgent = request.getHeader("user-agent");
        String acceptHeader = request.getHeader("accept");

        UAgentInfo uagentinfo = new UAgentInfo(userAgent, acceptHeader);


        return uagentinfo.detectTierIphone();
    }

}
