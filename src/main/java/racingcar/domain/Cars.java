package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

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
		return sb.append("\n").toString();
	}
}
