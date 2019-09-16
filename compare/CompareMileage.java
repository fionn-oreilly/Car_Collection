package compare;

import car.*;
import java.util.Comparator;

/**
 * Sorts Car objects by mileage
 * @author fionn
 */
public class CompareMileage implements Comparator<Car> {

	public int compare(Car car1, Car car2) {
		return car1.getMileage() - car2.getMileage();
	 }
}
