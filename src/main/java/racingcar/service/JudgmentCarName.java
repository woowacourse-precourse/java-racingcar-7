package racingcar.service;

import static racingcar.common.Constants.LIMIT_NUMBER;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class JudgmentCarName {
	private static final JudgmentCarName INSTANCE = new JudgmentCarName();

	private JudgmentCarName() {}

	public boolean judgmentCarNameDuplicate(List<String> carsName) {
		return carsName.size() != carsName.stream().distinct().count();
	}

	public boolean judgmentCarNameLength(String carName) {
		return carName.length() < LIMIT_NUMBER && !carName.isEmpty();
	}

	public boolean duplicateCheck(List<Car> cars) {
		return judgmentCarNameDuplicate(cars.stream()
				.map(Car::getCarName)
				.collect(Collectors.toList()));
	}

	public static JudgmentCarName getInstance() {
		return INSTANCE;
	}

}
