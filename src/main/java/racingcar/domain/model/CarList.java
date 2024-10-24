package racingcar.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import racingcar.common.util.ErrorMessage;
import racingcar.common.util.RandomNumberGenerator;

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

	public List<RaceStatus> getRaceStatus() {
		return cars.stream().map(Car::toStatus).toList();
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public void moveAll(RandomNumberGenerator randomNumberGenerator) {
		cars.forEach(car -> car.moveForward(randomNumberGenerator));
	}

	public Optional<String> getWinners() {
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
