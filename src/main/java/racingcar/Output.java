package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Output {

	public static final String RESULT_MESSAGE = "\n실행 결과";

	public static void printOneMoveResult(List<Car> cars) {
		for (Car car : cars) {
			System.out.printf("%s : ", car.getName());
			System.out.printf("%s", "-".repeat(car.getMoveCounter()));
			System.out.println();
		}
	}

	public static void printWinner(int maxMoveCounter, List<Car> cars) {
		List<String> winners = cars.stream()
			.filter(car -> car.getMoveCounter() == maxMoveCounter)
			.map(Car::getName)
			.collect(Collectors.toList());

		System.out.printf("최종 우승자 : %s%n", String.join(",", winners));
	}
}
