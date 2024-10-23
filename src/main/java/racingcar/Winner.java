package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {

	public static List<Car> winners = new ArrayList<Car>();

	public static int findMaxDistance(List<Car> cars) {
		int maxDistance = 0;

		for (Car car : cars) {
			if (car.distance > maxDistance) {
				maxDistance = car.distance;
			}
		}
		return maxDistance;
	}

	public static List<Car> contain(List<Car> cars) {
		int maxDistance = findMaxDistance(cars);

		for (Car car : cars) {
			if (maxDistance == car.distance) {
				winners.add(car);
			}
		}
		return winners;
	}

	public static String makeList() {
		String winnerList = "";

		int i = 0;
		for (Car car : winners) {
			winnerList += car.name;
			if (i < winners.size() - 1) {
				winnerList += ", ";
			}
			i++;
		}
		return winnerList;
	}
}
