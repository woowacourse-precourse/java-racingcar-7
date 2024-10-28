package racingcar.model.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingcar.model.domain.AttemptNumber;
import racingcar.model.domain.Car;
import racingcar.model.domain.Delimiter;
import racingcar.model.domain.Race;
import racingcar.model.domain.Winner;
import racingcar.model.util.Parse;
import racingcar.view.OutputView;

public class RaceService {
	private final Race race;
	private final AttemptNumber attemptNumber;

	public RaceService(Delimiter delimiter, String carNames, int attemptNumber) {
		List<Car> cars = getParseCar(delimiter, carNames);

		this.race = new Race(cars);
		this.attemptNumber = new AttemptNumber(attemptNumber);
	}

	private static List<Car> getParseCar(Delimiter delimiter, String carNames) {
		Parse parse = new Parse(delimiter);
		return parse.parseToCar(carNames);
	}

	public void runResult() {
		IntStream.range(0, attemptNumber.getAttemptNumber())
			.forEach(i -> {
				race.raceOnce();
				OutputView.runResult(race.getCars());
			});
	}

	public List<String> getWinners() {
		return Winner.determineWinners(race.getCars()).stream()
			.map(Car::getName)
			.collect(Collectors.toList());
	}
}