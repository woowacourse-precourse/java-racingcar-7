package racingcar;

import static racingcar.view.InputPrefix.INPUT_RACE_COUNT_PREFIX;
import static racingcar.view.InputPrefix.INPUT_REQUEST_PREFIX;
import static racingcar.view.OutputPrefix.RACE_RESULT_RESPONSE_PREFIX;
import static racingcar.view.OutputPrefix.WINNER_LIST_RESULT_RESPONSE_PREFIX;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.CarNameParser;
import racingcar.domain.Race;
import racingcar.domain.RaceResultParser;
import racingcar.domain.RandomNumberGenerator;
import racingcar.exception.InvalidInputException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarRaceGameSystem {

	private final InputView inputView;
	private final OutputView outputView;
	private final CarNameParser carNameParser;
	private final RaceResultParser raceResultParser;

	private final RandomNumberGenerator randomNumberGenerator;

	public CarRaceGameSystem() {
		inputView = new InputView();
		outputView = new OutputView();
		carNameParser = new CarNameParser();
		raceResultParser = new RaceResultParser();
		randomNumberGenerator = new RandomNumberGenerator();
	}

	public void run() {
		List<String> carNames = carNameParser.parse(getCarNamesInput());
		Integer raceCount = Integer.parseInt(getRaceCount());
		outputView.printMessage(RACE_RESULT_RESPONSE_PREFIX.getMessage());
		initRace(carNames, raceCount, randomNumberGenerator);
	}

	private void initRace(List<String> carNames, Integer raceCount, RandomNumberGenerator randomNumberGenerator) {
		List<Car> cars = carNames.stream().map(Car::new).toList();
		Race race = new Race(cars, raceCount, randomNumberGenerator);
		IntStream.range(0, raceCount).forEach(i -> {
			race.proceedRound();
			raceResultParser.displayRoundProgress(cars);
		});
		if (race.isRaceFinished(raceCount)) {
			outputView.printMessage(WINNER_LIST_RESULT_RESPONSE_PREFIX, raceResultParser.getWinnersName(cars));
		}
	}

	public String getCarNamesInput() {
		return getUserInput(() -> {
			outputView.printMessage(INPUT_REQUEST_PREFIX.getMessage());
			return inputView.readConsole();
		});
	}

	public String getRaceCount() {
		return getUserInput(() -> {
			outputView.printMessage(INPUT_RACE_COUNT_PREFIX.getMessage());
			return inputView.readConsole();
		});
	}

	public <T> T getUserInput(Supplier<T> inputReader) throws InvalidInputException {
		try {
			return inputReader.get();
		} catch (IllegalArgumentException e) {
			throw new InvalidInputException(e.getMessage());
		}
	}
}
