package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class Output {

	public static void printCurrentCarsStatus(List<Car> cars) {
		System.out.println("실행 결과");

		cars.forEach(Output::printCurrentCarStatus);
		System.out.println();
	}

	public static void printWinners(List<Car> cars) {
		List<String> winnerNames = cars.stream().map(Car::getName).toList();
		String winnerString = String.join(", ", winnerNames);

		System.out.println("최종 우승자" + winnerString);
	}

	private static void printCurrentCarStatus(Car car) {
		StringBuilder positionString = new StringBuilder();
		for (int i = 0; i < car.getPosition(); i++) {
			positionString.append("-");
		}

		System.out.println(car.getName() + " : " + positionString);
	}

	public static void printRequestCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
	}

	public static void printRequestTurnCount() {
		System.out.println("시도할 횟수는 몇 회인가요?");
	}
}
