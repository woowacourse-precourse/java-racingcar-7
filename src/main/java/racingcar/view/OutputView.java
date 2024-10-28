package racingcar.view;

import java.util.List;

import racingcar.domain.Car;

public class OutputView {
	public void printGameStart() {
		System.out.println("\n실행 결과");
	}

	public void printRaceProgress(List<Car> cars) {
		cars.forEach(this::printCarStatus);
		System.out.println();
	}

	private void printCarStatus(Car car) {
		StringBuilder progress = new StringBuilder();
		progress.append(car.getName())
			.append(" : ")
			.append("-".repeat(car.getPosition()));
		System.out.println(progress);
	}

	public void printWinners(List<String> winners) {
		System.out.println("최종 우승자 : " + String.join(", ", winners));
	}
}
