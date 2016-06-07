package model.entities;

import java.util.Collection;

/**
 * @author GaBi
 * @since 05.05.2016
 * @version v 1.0
 */
public class Classification {
	private int id;
    private String name;
    private Collection<Vegetables> vegetablesCollection;
	/**
	 * 
	 */
    public Classification(){
    	
    }
    
	/**
	 * @return the vegetablesCollection
	 */
	public Collection<Vegetables> getVegetablesCollection() {
		
		return vegetablesCollection;
	}

	/**
	 * @param vegetablesCollection the vegetablesCollection to set
	 */
	public void setVegetablesCollection(Collection<Vegetables> vegetablesCollection) {
		this.vegetablesCollection = vegetablesCollection;
	}

	/**
	 * @param id
	 */
	public Classification(int id) {
		this.id = id;
	}


	/**
	 * @param id
	 * @param name
	 */
	public Classification(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Classification [id=" + id + ", name=" + name + "]";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
}
