package racingcar;

import static racingcar.OutputPrefix.DISPLAY_NAME_FORMAT;
import static racingcar.OutputPrefix.DISPLAY_WINNER_FORMAT;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RandomNumberGenerator;

public class Race {
	private final List<Car> cars;
	private Integer round;
	private final RandomNumberGenerator randomNumberGenerator;

	public Race(List<Car> cars, Integer round, RandomNumberGenerator randomNumberGenerator) {
		this.cars = cars;
		this.round = round;
		this.randomNumberGenerator = randomNumberGenerator;
	}

	public void proceedRound() {
		cars.forEach(car -> car.moveByCondition(randomNumberGenerator.generateRandomNumber()));
		increaseCurrentRound();
	}

	public Integer getRound() {
		return round;
	}

	public boolean isRaceFinished(Long roundLimit) {
		return round >= roundLimit;
	}

	private void increaseCurrentRound() {
		round += 1;
	}

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
