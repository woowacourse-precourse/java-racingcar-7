package racingcar.model.service;

import java.util.List;
import java.util.stream.Collectors;

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
		Parse parse = new Parse(delimiter);
		List<Car> cars = parse.parseToCar(carNames);

		this.race = new Race(cars);
		this.attemptNumber = new AttemptNumber(attemptNumber);
	}

	public void runRace() {
		for (int i = 0; i < attemptNumber.getAttemptNumber(); i++) {
			race.raceOnce();
			OutputView.raceStatus(race.getCars());
		}
	}

	public List<String> getWinners() {
		return Winner.determineWinners(race.getCars()).stream()
			.map(Car::getName)
			.collect(Collectors.toList());
	}
}