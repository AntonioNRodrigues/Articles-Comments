/**
 *
 * @author Antonio Rodrigues
 * @param <E>
 * 
 */
package pt.projectCoderHat.model.DAO;

import java.io.Serializable;
import java.util.List;

public interface HibernateInter<E> {

    void save(E entity);

    void update(E entity);

    void remove(E entity);

    void merge(E entity);
    
    E getEntry(Serializable id);

    List<E> getEntities();

}
