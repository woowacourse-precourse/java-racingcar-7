package racingcar;

import java.util.List;
import racingcar.domain.Car;

public class RaceResultParser {

	public void displayRoundProgress(List<Car> cars) {
		cars.forEach(this::getCarPositionBar);
	}

	public String getWinnersName(List<Car> winnerCars) {
		List<String> winnerNames = winnerCars.stream()
				.map(Car::getName)
				.toList();
		return String.join(", ", winnerNames);
	}

	private void getCarPositionBar(Car car) {
		System.out.println("-".repeat(Math.max(0, car.getPosition())));
	}
}
