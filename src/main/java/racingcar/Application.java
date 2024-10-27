package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
	public static void main(String[] args) {

		Input input = new Input();

		Car[] cars = input.readNames();
		int attemptNumber = input.readAttemptNumber();

		int maxMoveCounter = 0;
		for (int i = 0; i < attemptNumber; i++) {
			maxMoveCounter = findMaxCounter(cars);

			System.out.println("\n실행 결과");
			printResult(cars);
		}

		printWinner(maxMoveCounter, cars);
	}

	public static int findMaxCounter(Car[] cars) {

		int maxMoveCounter = 0;

		for (Car car : cars) {
			int moveCounter = car.move();
			maxMoveCounter = Math.max(moveCounter, maxMoveCounter);
		}

		return maxMoveCounter;
	}

	public static void printResult(Car[] cars) {

		for (Car car : cars) {
			System.out.printf("%s : ", car.getName());
			System.out.printf("%s", "-".repeat(car.getMoveCounter()));
			System.out.println();
		}
	}

	public static void printWinner(int maxMove, Car[] cars) {

		List<String> winners = Arrays.stream(cars)
			.filter(car -> car.getMoveCounter() == maxMove)
			.map(Car::getName)
			.collect(Collectors.toList());

		System.out.printf("최종 우승자 : %s", String.join(",", winners));
	}
}
