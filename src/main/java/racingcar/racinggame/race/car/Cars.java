package racingcar.racinggame.race.car;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {

	private static final int SINGLE_CAR_COUNT = 1;
	private static final String DUPLICATION_CAR_NAME_ERROR_MESSAGE = "중복된 자동차 이름이 존재합니다.";
	private static final String NOT_EQUALS_CARS_COUNT_AND_RANDOM_VALUES_COUNT_ERROR_MESSAGE = "랜덤 값과 자동차의 개수가 일치하지 않습니다.";
	private static final String SINGLE_CAR_ERROR_MESSAGE = "2대 이상의 차량이 필요합니다.";

	private final List<Car> cars;

	private Cars(List<String> carNames) {
		validateCarNames(carNames);

		this.cars = carNames.stream()
			.map(Car::create)
			.toList();
	}

	public static Cars create(List<String> carNames) {
		return new Cars(carNames);
	}

	private void validateCarNames(List<String> carNames) {
		validateSingleCar(carNames);
		validateDuplicateCarName(carNames);
	}

	private void validateSingleCar(List<String> carNames) {
		if (carNames.size() <= SINGLE_CAR_COUNT) {
			throw new IllegalArgumentException(SINGLE_CAR_ERROR_MESSAGE);
		}
	}

	private void validateDuplicateCarName(List<String> carNames) {
		Set<String> carNamesSet = new HashSet<>(carNames);

		if (carNamesSet.size() != carNames.size()) {
			throw new IllegalArgumentException(DUPLICATION_CAR_NAME_ERROR_MESSAGE);
		}
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

	public List<String> getWinners() {
		return cars.stream()
			.filter(car -> car.isFurthestIn(cars))
			.map(Car::getName)
			.toList();
	}

	public int getCarCount() {
		return cars.size();
	}

	public List<Car> getCars() {
		return cars;
	}
}
