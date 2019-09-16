package compare;

import car.Car;
import java.util.Comparator;

/**
 * Sorts Car objects by manufacture year
 * @author fionn
 *
 */
public class CompareYear implements Comparator<Car> {

	public int compare(Car car1, Car car2) {
		return car1.getManu_year() - car2.getManu_year();
	 }

}
