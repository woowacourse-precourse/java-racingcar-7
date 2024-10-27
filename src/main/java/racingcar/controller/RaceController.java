package racingcar.controller;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.car.Car;
import racingcar.domain.car.RandomMoveStrategy;
import racingcar.domain.race.Race;
import racingcar.domain.race.RaceResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
	private final InputView inputView;
	private final OutputView outputView;

	public RaceController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void startRace() {
		List<String> carNames = inputView.getCarNames();
		int raceCount = inputView.getRaceCount();
		List<Car> cars = createCars(carNames);

		Race race = new Race(cars, raceCount);
		outputView.printResult();
		for (int i = 0; i < raceCount; i++) {
			race.moveCars();
			outputView.printCurrentPositions(cars);
		}

		RaceResult raceResult = new RaceResult(cars);

		List<Car> winners = raceResult.getWinners();
		outputView.printWinners(winners);
	}

	private List<Car> createCars(List<String> carNames) {
		List<Car> cars = new ArrayList<>();

		for (String name : carNames) {
			Car car = new Car(name.trim(), new RandomMoveStrategy());
			cars.add(car);
		}
		return cars;
	}
}
