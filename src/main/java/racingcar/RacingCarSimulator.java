package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarSimulator {
	private List<String> carNames;
	private long iterationCount;
	private List<Long> carPosition;

	public RacingCarSimulator() {
		carNames = null;
		iterationCount = 0;
		carPosition = null;
	}

	public void run() {
		carNames = inputCarName();
		iterationCount = inputIterationCount();

		initCarPosition();
		simulate();
		printWinner();
	}

	private List<String> inputCarName() {
		OutputView.promptForCarName();
		String input = Console.readLine();
		return StringParser.parseCarNames(input);
	}

	private long inputIterationCount() {
		OutputView.promptForIterationCount();
		String input = Console.readLine();
		return StringParser.parsePositiveNumber(input);
	}

	private void initCarPosition() {
		carPosition = new ArrayList<>(carNames.stream().map(name -> 0L).toList());
	}

	private void simulate() {
		OutputView.printResultTitle();
		for (int i = 0; i < iterationCount; i++) {
			simulateOneCycle();
			OutputView.printResultData(carNames, carPosition);
		}
	}

	private void simulateOneCycle() {
		for (int carIndex = 0; carIndex < carNames.size(); carIndex++) {
			if (canMoveCar()) {
				moveCar(carIndex);
			}
		}
	}

	public boolean canMoveCar() {
		return pickNumberInRange(0, 9) >= 4;
	}

	private void moveCar(int carIndex) {
		carPosition.set(carIndex, carPosition.get(carIndex) + 1);
	}

	private void printWinner() {
		List<String> winners = getWinners(carNames, carPosition);
		OutputView.printWinners(winners);
	}

	public List<String> getWinners(List<String> carNames, List<Long> carPosition) {
		long maxPosition = Collections.max(carPosition);

		List<String> winners = new ArrayList<>();
		for (int i = 0; i < carNames.size(); i++) {
			if (carPosition.get(i) == maxPosition) {
				winners.add(carNames.get(i));
			}
		}

		return winners;
	}
}
