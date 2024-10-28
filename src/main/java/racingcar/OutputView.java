package racingcar;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
	public static void displayRoundResult(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(car.displayPosition());
		}
		System.out.println();
	}

	public static void displayWinners(List<Car> cars) {
		int maxPosition = 0;
		for (Car car : cars) {
			if (car.getPosition() > maxPosition) {
				maxPosition = car.getPosition();
			}
		}

		List<String> winners = new ArrayList<>();
		for (Car car : cars) {
			if (car.getPosition() == maxPosition) {
				winners.add(car.getName());
			}
		}

		System.out.println("최종 우승자 : " + String.join(", ", winners));
	}
}
