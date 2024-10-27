package racingcar.view;

import racingcar.domain.car.Car;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

	private static final String POSITION_SEPARATOR = " : ";
	private static final String POSITION_MARKER = "-";
	private static final String WINNER_PREFIX = "최종 우승자";
	private static final String COMMA = ", ";

	public void printCurrentPositions(List<Car> cars) {
		StringBuilder positions = new StringBuilder();
		for (Car car : cars) {
			positions.append(car.getName())
				.append(POSITION_SEPARATOR)
				.append(POSITION_MARKER.repeat(car.getPosition()))
				.append('\n');
		}
		positions.append('\n');
		System.out.println(positions);
	}

	public void printWinners(List<Car> winners) {
		String winnerNames = winners.stream()
			.map(Car::getName)
			.collect(Collectors.joining(COMMA));
		System.out.println(WINNER_PREFIX + winnerNames);
	}
}