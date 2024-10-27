package racingcar.domain.Car;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import racingcar.common.exception.ErrorMessages;

public class CarNames {
	private final List<CarName> carNames;

	private CarNames(List<CarName> carNames) {
		this.carNames = carNames;
	}

	public static CarNames from(String input) {
		validateNotBlank(input);
		String[] names = input.split(",");
		List<CarName> carNames = Arrays.stream(names)
			.peek(CarNames::validateNotBlank)
			.map(String::trim)
			.map(CarName::new)
			.collect(Collectors.toList());
		validateNoDuplicates(carNames);
		return new CarNames(carNames);
	}

	private static void validateNotBlank(String input) {
		if (input == null || input.isBlank() || input.endsWith(",")) {
			throw new IllegalArgumentException(ErrorMessages.BLANK_NOT_ALLOWE.getMessage());
		}
	}

	private static void validateNoDuplicates(List<CarName> carNames) {
		Set<CarName> uniqueNames = new HashSet<>(carNames);
		if (uniqueNames.size() != carNames.size()) {
			throw new IllegalArgumentException(ErrorMessages.DUPLICATED.getMessage());
		}
	}

	public List<Car> toCars() {
		return carNames.stream()
			.map(carName -> new Car(carName, new Distance()))
			.collect(Collectors.toList());
	}
}
