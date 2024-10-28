package racingcar.view;

import java.util.List;

import racingcar.model.domain.Car;

public class OutputView {
	public static void carName() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
	}

	public static void attemptNumber() {
		System.out.println("시도할 횟수는 몇 회인가요?");
	}

	public static void raceStatus(List<Car> cars) {
		cars
			.forEach(car -> System.out.println(car.getName() + " : " + "-".repeat(car.getPosition())));
		System.out.println();
	}

	public static void winners(List<String> winners) {
		System.out.println("최종 우승자 : " + String.join(", ", winners));
	}
}