package racingcar.view;

import racingcar.domain.car.Car;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

	private static final String POSITION_MARKER = "-";
	private static final String SEPARATOR = " : ";
	private static final String RESULT_PREFIX = "실행 결과";
	private static final String WINNER_PREFIX = "최종 우승자";
	private static final String COMMA = ", ";

	public void printResult() {
		System.out.println(RESULT_PREFIX);
	}

	public void printCurrentPositions(List<Car> cars) {
		StringBuilder positions = new StringBuilder();
		for (Car car : cars) {
			positions.append(car.getName())
				.append(SEPARATOR)
				.append(POSITION_MARKER.repeat(car.getPosition()))
				.append('\n');
		}
		System.out.println(positions);
	}

	public void printWinners(List<Car> winners) {
		StringBuilder winnersBuilder = new StringBuilder();

		String winnerNames = winners.stream()
			.map(Car::getName)
			.collect(Collectors.joining(COMMA));

		winnersBuilder.append(WINNER_PREFIX)
			.append(SEPARATOR)
			.append(winnerNames);
		System.out.print(winnersBuilder);
	}
}