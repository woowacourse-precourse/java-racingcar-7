package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
	private List<Car> carList;

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
}
