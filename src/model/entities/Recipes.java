package model.entities;

/**
 * @author GaBi
 * @since 05.05.2016
 * @version v 1.0
 */
public class Recipes {
	private int id;
	private int kcal;
	private int weight;
    private String description;
    
	/**
	 * 
	 */
    public Recipes(){
    	
    }
    
	/**
	 * @param id
	 * @param kcal
	 * @param weight
	 * @param description
	 */
	public Recipes(int id, int kcal, int weight, String description) {
		super();
		this.id = id;
		this.kcal = kcal;
		this.weight = weight;
		this.description = description;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Recipes [id=" + id + ", kcal=" + kcal + ", weight=" + weight + ", "
				+ "description=" + description + "]";
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
	 * @return the kcal
	 */
	public int getKcal() {
		return kcal;
	}
	/**
	 * @param kcal the kcal to set
	 */
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

    
}
