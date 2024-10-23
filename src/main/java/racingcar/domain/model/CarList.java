package racingcar.domain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarList {

	private final List<Car> cars;

	public CarList() {
		cars = new ArrayList<>();
	}

	public int getCount() {
		return cars.size();
	}

	public Car getCar(int index) {
		if (index < 0 || index >= getCount()) {
			throw new IllegalArgumentException(ErrorMessage.CAR_LIST_INDEX_ERROR.getMessage());
		}
		return cars.get(index);
	}

	public void addCars(String[] names) {
		if (names == null || names.length == 0) {
			throw new IllegalArgumentException(ErrorMessage.CAR_LIST_EMPTY_ERROR.getMessage());
		}
		Arrays.stream(names).forEach(this::addCar);
	}

	private void addCar(String name) {
		cars.add(new Car(name));
	}

	public Optional<String> getWinner() {
		int highScore = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
		if (highScore == 0) {
			return Optional.empty();
		}
		return Optional.of(cars.stream()
			.filter(car -> car.getPosition() == highScore)
			.map(Car::getName)
			.collect(Collectors.joining(", ")));
	}

}
