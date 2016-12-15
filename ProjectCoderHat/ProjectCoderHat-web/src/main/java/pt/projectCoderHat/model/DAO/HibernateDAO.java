/*
 * 
 */
package pt.projectCoderHat.model.DAO;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Antonio Rodrigues
 * @param <E>
 * 
 */
public class HibernateDAO<E> implements HibernateInter<E>, Serializable{
    
    private static final long serial = 1L;
    
    private Class<E> classe;
    private Session session;        
    
    /**
     * 
     * @param classe
     * @param session 
     */
    public HibernateDAO(Class<E> classe, Session session) {
        super();
        this.classe = classe;
        this.session = session;
    }
    /**
     * 
     * @param entity 
     */
    @Override
    public void save(E entity) {
        session.save(entity);
    }
    /**
     * 
     * @param entity 
     */
    @Override
    public void update(E entity) {
       session.update(entity);
    }
    /**
     * 
     * @param entity 
     */
    @Override
    public void remove(E entity) {
       session.delete(entity);
    }
    /**
     * 
     * @param entity 
     */
    @Override
    public void merge(E entity) {
        session.merge(entity);
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    @Override
    public E getEntry(Serializable id) {
        return (E) session.get(classe, id);
    }

    /**
     * 
     * @return 
     */
    @Override
    public List<E> getEntities() {
       return (List<E>) session.createCriteria(classe).list();
    }
    
}
