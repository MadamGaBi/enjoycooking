package model.dao;

import java.util.List;

/**
 * @author GaBi
 * @since 05.05.2016
 * @version v 1.0
 */
public interface GenericDao<T> {

    void create ( T n );
    T find(int id);
    List<T> findAll();
    void delete(int id);
    void update( T n );
}
