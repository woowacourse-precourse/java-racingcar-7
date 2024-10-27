package racingcar.domain.car;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
	private static final String ERROR_DUPLICATE_CAR_NAME = "중복된 차 이름은 등록할 수 없습니다.";
	private final List<Car> cars;

	private Cars(List<Car> cars) {
		validateDuplicateCarNames(cars);
		this.cars = cars;
	}

	public static Cars from(List<String> names) {
		List<Car> cars = names.stream()
			.map(Car::from)
			.toList();
		return new Cars(cars);
	}

	public int getCarsCount() {
		return cars.size();
	}

	public void moveAll(List<Integer> randomNumbers) {
		Iterator<Integer> iterator = randomNumbers.iterator();
		cars.forEach(car -> car.move(iterator.next()));
	}

	public List<CarStatus> getStatus() {
		return cars.stream()
			.map(car -> CarStatus.of(car.getName(), car.getMoveDistance()))
			.toList();
	}

	public List<String> getWinners() {
		int maxDistance = cars.stream()
			.mapToInt(Car::getMoveDistance)
			.max()
			.orElse(0);

		return cars.stream()
			.filter(car -> car.getMoveDistance() == maxDistance)
			.map(Car::getName)
			.toList();
	}

	private void validateDuplicateCarNames(List<Car> cars) {
		Set<String> carNameSet = cars.stream()
			.map(Car::getName)
			.collect(Collectors.toSet());

		if (carNameSet.size() != cars.size()) {
			throw new IllegalArgumentException(ERROR_DUPLICATE_CAR_NAME);
		}
	}
}
