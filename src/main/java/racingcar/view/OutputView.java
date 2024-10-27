package racingcar.view;

import racingcar.domain.car.Car;
import java.util.List;

public class OutputView {

	private static final String POSITION_SEPARATOR = " : ";
	private static final String POSITION_MARKER = "-";

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

}