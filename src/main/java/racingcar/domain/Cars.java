package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import utils.NumberGenerator;

public class Cars {
	private final List<Car> cars;

	public Cars(List<String> carNames) {
		validateCarNames(carNames);
		this.cars = carNames.stream()
			.map(Car::new)
			.collect(Collectors.toList());
	}

	private void validateCarNames(List<String> carNames) {
		if (carNames == null || carNames.isEmpty()) {
			throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
		}
	}

	public void moveAll(NumberGenerator numberGenerator) {
		cars.forEach(car -> car.move(numberGenerator.generate()));
	}

	public List<Car> getCars() {
		return new ArrayList<>(cars);
	}

	public List<String> getWinners() {
		int maxPosition = getMaxPosition();
		return getWinnerNames(maxPosition);
	}

	private int getMaxPosition() {
		return cars.stream()
			.mapToInt(Car::getPosition)
			.max()
			.orElse(0);
	}

	private List<String> getWinnerNames(int maxPosition) {
		return cars.stream()
			.filter(car -> car.getPosition() == maxPosition)
			.map(Car::getName)
			.collect(Collectors.toList());
	}
}
