package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNames {
	private final List<CarName> carNames;

	private CarNames(List<CarName> carNames) {
		this.carNames = carNames;
	}

	public static CarNames from(String input) {
		String[] names = input.split(",");
		List<CarName> carNames = Arrays.stream(names)
			.map(String::trim)
			.map(CarName::new)
			.collect(Collectors.toList());
		return new CarNames(carNames);
	}
}
