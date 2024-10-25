package racingcar.service;

import java.util.stream.IntStream;

import racingcar.domain.car.Cars;
import racingcar.domain.racingGame.RacingGameCount;
import racingcar.util.RandomNumberGenerator;

public class RacingGameService {
	public void processRacingGame(Cars cars, RacingGameCount gameCount) {
		IntStream.range(0, gameCount.getCount())
			.forEach(racingGame -> processEachRacingGame(cars, RandomNumberGenerator.generateRandomNumber()));
	}

	private void processEachRacingGame(Cars cars, int randomNumber) {
		cars.getCars().forEach(car -> {
			car.processGame(randomNumber);
		});

	}
}
