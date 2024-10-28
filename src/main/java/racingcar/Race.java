package racingcar;

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

	public List<Car> findAllWinner() {
		Integer maxPosition = cars.stream()
				.mapToInt(Car::getPosition)
				.max()
				.orElseThrow(() -> new IllegalArgumentException("경주에 참여한 자동차가 없습니다."));
		return cars.stream()
				.filter(car -> car.getPosition().equals(maxPosition))
				.toList();
	}

	public Integer getRound() {
		return round;
	}

	public boolean isRaceFinished(Integer roundLimit) {
		return round >= roundLimit;
	}

	private void increaseCurrentRound() {
		round += 1;
	}
}
