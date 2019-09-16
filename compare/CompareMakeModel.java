package compare;

import car.*;
import java.util.Comparator;
/**
 * Sorts Car objects by make and model
 */
public class CompareMakeModel implements Comparator<Car> {

	 public int compare(Car car1, Car car2) {
		 if (car1.getMake().compareTo(car2.getMake()) != 0) {
	        return car1.getMake().compareTo(car2.getMake());
	    } else {
	    	return car1.getModel().compareTo(car2.getModel());
	    }
	 }
}
