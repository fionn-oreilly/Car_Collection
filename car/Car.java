package car;
/**
 * Controls Car objects
 */
public class Car implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String make; private String model; int reg; private int mileage; private int manu_year;

	public Car() {}
	
	/**
	 * Creates new Car object and assigns attributes
	 * @param make
	 * @param model
	 * @param reg
	 * @param mileage
	 * @param manu_year
	 */
	public Car(String make, String model, int reg, int mileage, int manu_year) {
		this.setMake(make);
		this.setModel(model);
		this.reg = reg;
		this.setMileage(mileage);
		this.setManu_year(manu_year);
	}
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}
	/**
	 * Get model
	 * @return
	 */
	public String getModel() {
		return model;
	}
	/**
	 * Set model
	 * @param model
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * Get Manufacture year
	 * @return
	 */
	public int getManu_year() {
		return manu_year;
	}
	/**
	 * Set Manufacture year
	 * @param manu_year
	 */
	public void setManu_year(int manu_year) {
		this.manu_year = manu_year;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}



}
