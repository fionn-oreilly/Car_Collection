package car;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

import compare.CompareMakeModel;
import compare.CompareMileage;
import compare.CompareYear;
import gui.Main;
import javafx.scene.control.TextArea;
/**
 * Manages list of Car objects
 */
public class CarList {

	private ArrayList<Car> cars = new ArrayList();

	/**
	 * Adds to car to ArrayList and serialises ArrayList to file
	 * @param make
	 * @param model
	 * @param reg
	 * @param mileage
	 * @param manu_year
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void addCar(String make, String model, int reg, int mileage, int manu_year) throws IOException, ClassNotFoundException {

		Car car = new Car(make,model, reg, mileage, manu_year);
		FileOutputStream fileOut = new FileOutputStream("car.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		cars.add(car);
		out.writeObject(cars);
		out.close();
		fileOut.close();

	}

	/**
	 * Removes car from list and serialises new list.
	 * @param regNum
	 * @return true/false if object exists in list
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public boolean removeCar(int regNum) throws IOException, ClassNotFoundException {
		ArrayList<Car> cars = this.getList();

		boolean exists = false;
		for (int i=0;i<cars.size();i++) {
			if (cars.get(i).reg == regNum) {
				cars.remove(i);
				exists = true;
				break;
			}
		}

		FileOutputStream fileOut = new FileOutputStream("car.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(cars);
		out.close();
		fileOut.close();
		return exists;
	}

	public ArrayList<Car> getList() throws IOException, ClassNotFoundException {
		FileInputStream fileIn = new FileInputStream("car.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        ArrayList<Car> carList = (ArrayList) in.readObject();
        in.close();
        fileIn.close();
		return carList;
	}

	/**
	 * Displays list of cars to user
	 * @param sortBy
	 * @param TA
	 * @return TextArea with list of cars displayed
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public TextArea print(String sortBy, TextArea TA) throws IOException, ClassNotFoundException {
		ArrayList<Car> carList = this.getList();
		
		if (carList.isEmpty()) {
			TA.setText("List is empty.");
		} else {

	        if (sortBy == "MakeModel") {
	        	Collections.sort(carList, new CompareMakeModel());
	        } else if (sortBy == "Year") {
	        	Collections.sort(carList, new CompareYear());
	        } else {
	        	Collections.sort(carList, new CompareMileage());
	        }
	
	        String msg = "";
	        for (int i=0;i<carList.size();i++) {
	        		msg = msg.concat("Make: " + carList.get(i).getMake().toString() + "\t\tModel: " + carList.get(i).getModel().toString() + "\tReg: " +
	        				Integer.toString(carList.get(i).reg) + "\nMileage:" + Integer.toString(carList.get(i).getMileage()) +
	        					"\tManufacture year: " + Integer.toString(carList.get(i).getManu_year()) + "\n\n");
	
	        		System.out.println("Make: " + carList.get(i).getMake().toString() + "	Model: " + carList.get(i).getModel().toString() + "	Reg: " +
	        				Integer.toString(carList.get(i).reg) + "		\nMileage:" + Integer.toString(carList.get(i).getMileage()) +
	        					"	Manufacture year: " + Integer.toString(carList.get(i).getManu_year()) + "\n");
	        }
	        TA.setText(msg);
		}
        return TA;
	}
}
