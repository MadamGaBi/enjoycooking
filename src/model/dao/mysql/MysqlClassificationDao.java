package model.dao.mysql;

import model.dao.ClassificationDao;
import model.entities.Classification;

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
public class MysqlClassificationDao implements ClassificationDao {

    @Override
    public void create(Classification n) {

    }

    @Override
    public Classification find(int classification_id) {

        Classification found;    
        Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;

		try {

			// Get Connection and create Statement.
			connection = ConnectionPool.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM CLASSIFICATION where id =" + classification_id);
			
			while (resultSet.next()) {
                String name = resultSet.getString("name");
                int id = resultSet.getInt("id");
                found = new Classification(id, name);
                return found;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MysqlClassificationDao.find(classification_id) error.");
		} finally {
	
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					System.out.println("MysqlClassificationDao.find(classification_id) cannot close resultSet");
				}
			}

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("MysqlClassificationDao.find(classification_id) cannot close statement");
				}
			}
			
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("MysqlClassificationDao.find(classification_id) cannot close connection");
				}
			}
		}

		return null;
	}

    @Override
    public List<Classification> findAll() {
        List<Classification> list = new ArrayList<>();
        Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
        
		try {

			// Get Connection and create Statement.
			connection = ConnectionPool.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM CLASSIFICATION");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int id = resultSet.getInt("id");
                Classification n = new Classification(id, name);
                list.add(n);
            }
            
		} catch (SQLException e) {
			System.out.println("MysqlClassificationDao.findAll() error.");
		} finally {
	
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					System.out.println("MysqlClassificationDao.findAll() cannot close resultSet");
				}
			}

			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					System.out.println("MysqlClassificationDao.findAll() cannot close statement");
				}
			}
			
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("MysqlClassificationDao.findAll() cannot close connection");
				}
			}
		}
        return list;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Classification n) {

    }
}
