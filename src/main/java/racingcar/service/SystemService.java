package racingcar.service;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SystemService {

	private final JudgmentCarName judgment = new JudgmentCarName();

	public List<Car> splitCarsString(String carsName) {
		return Arrays.stream(carsName.split(","))
				.map(String::trim)
				.map(this::generateCar)
				.collect(Collectors.toList());
	}

	private Car generateCar(String carName) {
		if(judgment.judgmentCarNameLength(carName)) {
			return new Car(carName);
		}

		throw new IllegalArgumentException();
	}

	public void printCarMovement(Car car) {
		System.out.print(car.getCarName() + " : ");

		for (int i = 0; i < car.getMovement(); i++) {
			System.out.print("-");
		}

		System.out.println();
	}

	private List<Car> getWinner(List<Car> cars) {
		return cars.stream()
				.filter(car -> car.getMovement() == findMaxMovement(cars))
				.collect(Collectors.toList());
	}

	private int findMaxMovement(List<Car> cars) {
		return cars.stream()
				.mapToInt(Car::getMovement)
				.max()
				.orElse(0);
	}

	public void printWinner(List<Car> cars) {
		String winner = getWinner(cars).stream()
				.map(Car::getCarName)
				.collect(Collectors.joining(", "));

		System.out.print("최종 우승자 : " + winner);
	}

}
