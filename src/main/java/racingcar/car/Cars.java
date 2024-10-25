package racingcar.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private List<Car> cars = new ArrayList<>();
	public Cars(String carNames) {
		String[] carNameArray = carNames.split(",");
		for (String carName : carNameArray) {
			cars.add(new Car(carName));
		}
	}

	public void raceStart() {
		for (Car car : cars) {
			car.execute();
			car.printResult();
		}
	}

	private int getMaxLocation() {
		return cars.stream()
			.mapToInt(Car::getLocation)
			.max()
			.orElse(0);
	}

	public void printWinner(){
		System.out.print("최종 우승자 : ");
		int maxLocation = getMaxLocation();
		String winners = cars.stream()
			.filter(car -> car.getLocation() == maxLocation)
			.map(Car::getName)
			.collect(Collectors.joining(", "));
		System.out.println(winners);
	}
}
