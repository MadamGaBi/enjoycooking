package model.dao.mysql;

import model.dao.DaoFactory;
import model.dao.ClassificationDao;
import model.dao.RecipesDao;
import model.dao.VegetablesDao;
import model.dao.RecipesHasVegetablesDao;

/**
 * @author GaBi
 * @since 05.05.2016
 * @version v 1.0
 */
public class MysqlDaoFactory extends DaoFactory {

    @Override
    public ClassificationDao createClassificationDao() {
        return new MysqlClassificationDao();
    }

    @Override
    public RecipesDao createRecipesDao() {
        return new MysqlRecipesDao();
    }

    @Override
    public VegetablesDao createVegetablesDao() {
        return new MysqlVegetablesDao();
    }
    
    @Override
    public RecipesHasVegetablesDao createRecipesHasVegetablesDao() {
        return new MysqlRecipesHasVegetablesDao();
    }
}
