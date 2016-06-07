/**
 * 
 */
package model.entities;

/**
 * @author GaBi
 * @since 05.05.2016
 * @version v 1.0
 */
public class Vegetables {
	private int id;
    private String name;
    private int kcalPer100g;
	private int weight;
    private int classificationId;

	/**
	 * 
	 */
	public Vegetables() {
		
	}

	/**
	 * @param id
	 * @param name
	 * @param kcalPer100g
	 * @param weight
	 * @param classificationId
	 */
	public Vegetables(int id, String name, int kcalPer100g, int weight, int classificationId) {
		super();
		this.id = id;
		this.name = name;
		this.kcalPer100g = kcalPer100g;
		this.weight = weight;
		this.classificationId = classificationId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vegetables [id=" + id + ", name=" + name + ", kcalPer100g=" + kcalPer100g + ", "
				+ "weight=" + weight + ", classification_id=" + classificationId + "]";
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

	/**
	 * @return the kcalPer100g
	 */
	public int getKcalPer100g() {
		return kcalPer100g;
	}

	/**
	 * @param kcalPer100g the kcalPer100g to set
	 */
	public void setKcalPer100g(int kcalPer100g) {
		this.kcalPer100g = kcalPer100g;
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
	 * @return the classificationId
	 */
	public int getClassificationId() {
		return classificationId;
	}

	/**
	 * @param classificationId the classificationId to set
	 */
	public void setClassificationId(int classificationId) {
		this.classificationId = classificationId;
	}

}
