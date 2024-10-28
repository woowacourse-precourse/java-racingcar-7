package racingcar.domain;

import racingcar.io.InputProcessor;
import racingcar.validator.InputValidator;
import racingcar.utils.RandomNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
	private final InputProcessor inputProcessor;
	private final InputValidator inputValidator;
	private final RandomNumberGenerator randomNumberGenerator;

	public RacingGame(InputProcessor inputProcessor) {
		this.inputProcessor = inputProcessor;
		this.inputValidator = new InputValidator();
		this.randomNumberGenerator = new RandomNumberGenerator();
	}

	public void start() {
		Cars cars = createCars();
		int trials = getTrials();

		System.out.println("\n실행 결과");
		for (int i = 0; i < trials; i++) {
			race(cars);
			printRaceStatus(cars);
		}

		announceWinners(cars);
	}

	private Cars createCars() {
		String input = inputProcessor.getInputCarName();
		inputValidator.validateInput(input);
		
		List<String> carNames = Arrays.asList(input.split(","));
		inputValidator.validateCarNames(carNames);

		List<Car> carList = carNames.stream()
			.map(Car::new)
			.collect(Collectors.toList());

		return new Cars(carList);
	}

	private int getTrials() {
		String input = inputProcessor.getInputTrialNum();
		return inputValidator.validateAndParseTrials(input);
	}

	private void race(Cars cars) {
		cars.moveAll(randomNumberGenerator);
	}

	private void printRaceStatus(Cars cars) {
		List<String> positions = cars.getCurrentPositions();
		positions.forEach(System.out::println);
		System.out.println();
	}

	private void announceWinners(Cars cars) {
		List<String> winners = cars.getWinners();
		System.out.println("최종 우승자 : " + String.join(", ", winners));
	}
}
