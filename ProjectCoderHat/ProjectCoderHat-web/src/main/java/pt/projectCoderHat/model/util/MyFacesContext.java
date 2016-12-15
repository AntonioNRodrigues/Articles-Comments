/*
 */
package pt.projectCoderHat.model.util;

import org.hibernate.Session;
import javax.faces.context.FacesContext;

/**
 *
 * @author Antonio Rodrigues
 */
public class MyFacesContext {

    private static final String SESSION_HIBERNATE = "hibernate_session";

    public static void setRequestSession(Session session) {
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().
                put(SESSION_HIBERNATE, session);
    }

    public static Session getRequestSession() {
        return (Session) FacesContext.getCurrentInstance()
                .getExternalContext().getRequestMap().get(SESSION_HIBERNATE);
    }

}
