package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Cars {
	private List<Car> carList;
	private int movingStandard = 4;
	private String delim = "-";

	public Cars(String[] names) {
		Set<String> isDuplicated = new HashSet<>();
		carList = new ArrayList<>();
		for (String name : names) {
			if(!isDuplicated.add(name)){
				throw new IllegalArgumentException("차량 이름은 중복될 수 없습니다.");
			}
			carList.add(Car.fromCarName(name));
		}
	}

	public String startRound(Supplier<Integer> numberSupplier) {
		StringBuilder sb = new StringBuilder();
		for (Car car : carList) {
			car.moveIfSatisfyStandard(numberSupplier, movingStandard);
			sb.append(car.showStatus(delim));
		}
		return sb.toString();
	}

	public String getWinner() {
		int max = getHighestScore();
		return carList.stream()
			.filter(car -> car.getScore() == max)
			.map(Car::getName)
			.collect(Collectors.joining(", "));
	}

	private Integer getHighestScore() {
		return carList.stream()
			.map(Car::getScore)
			.max(Integer::compare)
			.orElse(0);
	}
}
