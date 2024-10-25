package racingcar.io.domain;

import java.util.List;

public class Cars {

	private static final String NOT_EQUALS_CARS_COUNT_AND_RANDOM_VALUES_COUNT_ERROR_MESSAGE = "랜덤 값과 자동차의 개수가 일치하지 않습니다.";

	private final List<Car> cars;

	private Cars(List<Car> cars) {
		this.cars = cars;
	}

	public static Cars create(List<String> carNames) {

		List<Car> cars = carNames.stream()
			.map(Car::create)
			.toList();

		return new Cars(cars);
	}

	public void moveAll(List<Integer> randomValues) {

		validateRandomValuesCount(randomValues);

		for (int carSequence = 0; carSequence < cars.size(); carSequence++) {
			Car car = cars.get(carSequence);
			car.move(randomValues.get(carSequence));
		}
	}

	private void validateRandomValuesCount(List<Integer> randomValues) {
		if (randomValues.size() != cars.size()) {
			throw new IllegalStateException(NOT_EQUALS_CARS_COUNT_AND_RANDOM_VALUES_COUNT_ERROR_MESSAGE);
		}
	}

	public List<Car> getWinners() {
		return cars.stream()
			.filter(car -> car.isFurthestIn(cars))
			.toList();
	}

}
