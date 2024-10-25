package racingcar.service;

import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Judgment {

	public int getRandomNumber() {
		return 0;
	}

	public boolean judgmentCarNameDuplicate(List<String> carsName) {
		return carsName.size() != carsName.stream().distinct().count();
	}

	public boolean judgmentCarNameLength(String carName) {
		return true;
	}

}
