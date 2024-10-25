package racingcar.service;

import java.util.List;
import java.util.stream.IntStream;

import racingcar.domain.car.Cars;
import racingcar.domain.racingGame.RacingGameCount;
import racingcar.domain.racingGame.RacingRecord;
import racingcar.domain.racingGame.RacingSnapshot;

public class RacingGameService {
	public List<RacingRecord> processRacingGame(Cars cars, RacingGameCount gameCount) {
		return IntStream.range(0, gameCount.getCount())
			.mapToObj(racingGame -> new RacingRecord(processEachRacingGame(cars, new RandomNumberGenerator())))
			.toList();
	}

	private List<RacingSnapshot> processEachRacingGame(Cars cars, RandomNumberGenerator randomNumberGenerator) {
		return cars.getRacingCars().stream()
			.map(car -> {
				car.processGame(randomNumberGenerator.generateRandomNumber());
				return new RacingSnapshot(car);
			}).toList();

	}
}
