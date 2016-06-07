package model.dao;

import java.util.List;

import model.entities.Vegetables;

/**
 * @author GaBi
 * @since 05.05.2016
 * @version v 1.0
 */
public interface VegetablesDao extends GenericDao<Vegetables> {

	List<Vegetables> findByClassificationID(int classificationID);
}
