package model.dao;

import model.dao.mysql.MysqlDaoFactory;

/**
 * @author GaBi
 * @since 05.05.2016
 * @version v 1.0
 */
public abstract class DaoFactory {

    public abstract ClassificationDao createClassificationDao();
    public abstract RecipesDao createRecipesDao();
    public abstract VegetablesDao createVegetablesDao();
    public abstract RecipesHasVegetablesDao createRecipesHasVegetablesDao();

    public static DaoFactory getInstance(){
        return new MysqlDaoFactory();
    }
}
