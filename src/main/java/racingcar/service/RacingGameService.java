package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import racingcar.domain.car.Cars;
import racingcar.domain.racingGame.RacingGameCount;
import racingcar.domain.racingGame.RacingRecord;
import racingcar.util.RandomNumberGenerator;

public class RacingGameService {
	public List<RacingRecord> processRacingGame(Cars cars, RacingGameCount gameCount) {
		List<RacingRecord> records = new ArrayList<>();
		IntStream.range(0, gameCount.getCount())
			.forEach(racingGame -> {
				RacingRecord record = processEachRacingGame(cars, RandomNumberGenerator.generateRandomNumber());
				records.add(record);
			});
		return records;
	}

	private RacingRecord processEachRacingGame(Cars cars, int randomNumber) {
		cars.getCars().forEach(car -> {
			car.processGame(randomNumber);
		});
		return new RacingRecord(cars);

	}
}
