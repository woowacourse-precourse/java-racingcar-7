package racingcar;

import static racingcar.OutputPrefix.DISPLAY_NAME_FORMAT;
import static racingcar.OutputPrefix.DISPLAY_WINNER_FORMAT;

import java.util.List;
import racingcar.domain.Car;

public class RaceResultParser {

	public void displayRoundProgress(List<Car> cars) {
		cars.forEach(this::displayCarPosition);
	}

	public void displayWinners(List<String> winnerNames) {
		String joinedWinners = String.join(", ", winnerNames);
		System.out.printf(DISPLAY_WINNER_FORMAT.getMessage(), joinedWinners);
	}

	private void displayCarPosition(Car car) {
		System.out.printf((DISPLAY_NAME_FORMAT) + "%n", car.getName(), "-".repeat(Math.max(0, car.getPosition())));
	}
}
