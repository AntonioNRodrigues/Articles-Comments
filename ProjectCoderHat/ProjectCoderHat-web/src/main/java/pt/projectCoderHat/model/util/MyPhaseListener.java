/*
 */
package pt.projectCoderHat.model.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author Antonio Rodrigues
 */
public class MyPhaseListener implements PhaseListener {

    @Override
    public void beforePhase(PhaseEvent event) {
        System.out.printf("MyPhaseListener: afterPhase %s", event.getPhaseId());
        if (event.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {
            SessionFactory sessionFactory = MyHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            
            session.beginTransaction();
            
            MyFacesContext.setRequestSession(session);
        }
    }

    @Override
    public void afterPhase(PhaseEvent event) {
        System.out.printf("MyPhaseListener: beforePhase %s", event.getPhaseId());
        if (event.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            Session session = MyFacesContext.getRequestSession();
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } finally {
                session.close();
            }
        }
    }
    
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}
