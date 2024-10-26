package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class Application {
	public static void main(String[] args) {

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carNames = Console.readLine();

		Car[] cars = separateNames(carNames);
		int n = cars.length;

		System.out.println("시도할 횟수는 몇 회인가요?");
		int m = validateNumber(Console.readLine());

		int maxMoveCounter = 0;
		for (int i = 0; i < m; i++) {
			maxMoveCounter = findMaxCounter(cars);

			System.out.println("\n실행 결과");
			printResult(cars);
		}

		printWinner(maxMoveCounter, cars);
	}

	public static Car[] separateNames(String carNames) throws IllegalArgumentException {

		String[] names = carNames.split(",");
		Car[] cars = new Car[names.length];

		for (int i = 0; i < names.length; i++) {
			cars[i] = new Car(names[i]);
		}

		return cars;
	}

	public static int validateNumber(String numStr) throws IllegalArgumentException {

		if (!numStr.matches("\\d+")) {
			throw new IllegalArgumentException("유효한 숫자가 아닙니다.");
		}

		int number = Integer.parseInt(numStr);
		if (number < 0) {
			throw new IllegalArgumentException("이동 횟수는 음수일 수 없습니다.");
		}

		return number;
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
