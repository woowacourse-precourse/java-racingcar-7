package racingcar;

import java.util.List;

public class RaceManager {
	private final IoHandler ioHandler;
	private final RandomNumberProvider randomNumberProvider;

	private RaceManager(IoHandler ioHandler, RandomNumberProvider randomNumberProvider) {
		this.ioHandler = ioHandler;
		this.randomNumberProvider = randomNumberProvider;
	}

	public static RaceManager of(IoHandler ioHandler, RandomNumberProvider randomNumberProvider) {
		return new RaceManager(ioHandler, randomNumberProvider);
	}

	public void run() {
		RaceInfo raceInfo = ioHandler.handleRaceInfoForIo();
		Cars cars = Cars.from(raceInfo.getCarNames());
		int gameCount = 0;

		ioHandler.showResult();
		while (gameCount < raceInfo.getAttemptCount()) {
			List<Integer> randomNumbers = randomNumberProvider.generateRandomNumbers(cars.getCarsCount());
			cars.moveAll(randomNumbers);
			ioHandler.showGameStatus(cars);
			gameCount++;
		}

		List<String> winners = cars.getWinners();
		ioHandler.showWinners(winners);
	}
}
