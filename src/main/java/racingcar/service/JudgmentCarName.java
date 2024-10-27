package racingcar.service;

import java.util.List;

public class JudgmentCarName {

	public boolean judgmentCarNameDuplicate(List<String> carsName) {
		return carsName.size() != carsName.stream().distinct().count();
	}

	public boolean judgmentCarNameLength(String carName) {
		return carName.length() < 6 && !carName.isEmpty();
	}

}
