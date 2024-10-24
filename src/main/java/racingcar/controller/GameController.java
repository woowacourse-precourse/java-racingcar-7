package racingcar.controller;

import java.util.stream.IntStream;

import racingcar.domain.car.Cars;
import racingcar.domain.name.Names;
import racingcar.domain.racingGame.RacingGameCount;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;

public class GameController {

	public void run() {
		Names carNames = InputView.inputCarNames();
		Cars cars = Cars.from(carNames.getNames());
		RacingGameCount count = InputView.inputRaceCount();

		processRacingGame(cars, count);
	}

	private void processRacingGame(Cars cars, RacingGameCount gameCount) {
		RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
		IntStream.range(0, gameCount.getCount())
			.forEach(racingGame -> processEachRacingGame(cars, randomNumberGenerator));
	}

	private void processEachRacingGame(Cars cars, RandomNumberGenerator randomNumberGenerator) {
		cars.getCars().forEach(car -> {
			car.processGame(randomNumberGenerator);
		});
	}

}
