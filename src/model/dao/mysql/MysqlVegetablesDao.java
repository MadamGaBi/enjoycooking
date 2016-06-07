package model.dao.mysql;

import model.dao.VegetablesDao;
import model.entities.Vegetables;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * @author GaBi
 * @since 05.05.2016
 * @version v 1.0
 */
public class MysqlVegetablesDao implements VegetablesDao {
    @Override
    public void create(Vegetables n) {

    }

    @Override
    public Vegetables find(int vegetableId) {
    	Vegetables vegetable = null;
        Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
        
		try {
			// Get Connection and create Statement.
			connection = ConnectionPool.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM vegetables");

			while (resultSet.next()) {
                String name = resultSet.getString("name");
                int id = resultSet.getInt("id");
                int weight = resultSet.getInt("weight");
                int kcalPer100g = resultSet.getInt("kcalPer100g");
                int classification_id = resultSet.getInt("classification_id");
                if (id == vegetableId) {
                	vegetable = new Vegetables(id, name, weight, kcalPer100g, classification_id);
                }
            }      
        }catch (Exception e){
        	System.out.println("MysqlVegetablesDao.find(vegetableId) error.");
            e.printStackTrace();
        } finally {
	
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					System.out.println("MysqlVegetablesDao.find(vegetableId) cannot close resultSet");
				}
			}

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("MysqlVegetablesDao.find(vegetableId) cannot close statement");
				}
			}
			
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("MysqlVegetablesDao.find(vegetableId) cannot close connection");
				}
			}
		}
        return vegetable;
    }
   

    @Override
    public List<Vegetables> findAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Vegetables n) {

    }
    
    @Override
    public List<Vegetables> findByClassificationID(int classificationID){
    	
    	List<Vegetables> list = new ArrayList<>();
        Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
        
		try {
			// Get Connection and create Statement.
			connection = ConnectionPool.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM vegetables");

			while (resultSet.next()) {
                String name = resultSet.getString("name");
                int id = resultSet.getInt("id");
                int weight = resultSet.getInt("weight");
                int kcalPer100g = resultSet.getInt("kcalPer100g");
                int classification_id = resultSet.getInt("classification_id");
                if (classification_id == classificationID) {
                	Vegetables n = new Vegetables(id, name, weight, kcalPer100g, classification_id);
                	list.add(n);
                }
            }      
        }catch (Exception e){
        	System.out.println("MysqlVegetablesDao.findByClassificationID(classification_id) error.");
            e.printStackTrace();
        } finally {
	
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					System.out.println("MysqlVegetablesDao.findByClassificationID(classification_id) cannot close resultSet");
				}
			}

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("MysqlVegetablesDao.findByClassificationID(classification_id) cannot close statement");
				}
			}
			
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("MysqlVegetablesDao.findByClassificationID(classification_id) cannot close connection");
				}
			}
		}
        return list;
    }
}
