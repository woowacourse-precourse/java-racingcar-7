package racingcar.controller;

import java.util.List;

import racingcar.domain.AttemptCount;
import racingcar.domain.Car;
import racingcar.domain.Race;
import racingcar.parser.CarNameInputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
	private final InputView inputView;
	private final OutputView outputView;

	public RacingController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
	}

	public void run() {
		String carNameInput = readCarNameInput();
		List<String> carNames = parseCarNameInput(carNameInput);
		Race race = createRace(carNames);

		AttemptCount attemptCount = readAttemptCountInput();

		printRaceResult(attemptCount.getAttemptCount(), race);
		printWinners(race);
	}

	private String readCarNameInput() {
		outputView.promptCarName();

		return inputView.readCarNameInput();
	}

	private List<String> parseCarNameInput(String carNameInput) {
		CarNameInputParser carNameInputParser = new CarNameInputParser();

		return carNameInputParser.parseInput(carNameInput);
	}

	private Race createRace(List<String> carNames) {
		List<Car> cars = carNames.stream()
			.map(Car::new)
			.toList();

		return new Race(cars);
	}

	private AttemptCount readAttemptCountInput() {
		outputView.promptAttemptCount();
		int attemptCountInput = inputView.readAttemptCountInput();

		return new AttemptCount(attemptCountInput);
	}

	private void printRaceResult(int attemptCount, Race race) {
		outputView.printNewLine();
		outputView.printRaceResultPrompt();
		for (int i = 0; i < attemptCount; i++) {
			race.moveEachCars();
			outputView.printRaceResult(race.findRaceStatus());
			outputView.printNewLine();
		}
	}

	private void printWinners(Race race) {
		outputView.printWinners(race.selectWinners());
	}
}
