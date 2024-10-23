package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
	private List<Car> cars = new ArrayList<>();
	public Cars(String carNames) {
		String[] carNameArray = carNames.split(",");
		for (String carName : carNameArray) {
			cars.add(new Car(carName));
		}
	}
}
